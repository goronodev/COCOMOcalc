package com.example.cocomocalc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCocomoModel;
    private Spinner spinnerProjectType;
    private EditText etKloc;
    private Button btnCalculate;
    private TextView tvResult;
    private LinearLayout layoutCostDrivers;
    private LinearLayout layoutScaleFactors;
    private RecyclerView rvScaleFactors;
    private List<CostDriver> scaleFactorsList = new ArrayList<>();


    private final List<CostDriver> allCostDrivers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initSpinners();
        initCostDrivers();
        initListeners();
        toggleCostDriversVisibility(false);
    }

    private void initViews() {
        spinnerCocomoModel = findViewById(R.id.spinnerModel);
        spinnerProjectType = findViewById(R.id.spinnerProjectType);
        etKloc = findViewById(R.id.etKloc);
        btnCalculate = findViewById(R.id.btnCalculate);
        layoutCostDrivers = findViewById(R.id.layoutCostDrivers);
        tvResult = findViewById(R.id.tvResult);
        layoutScaleFactors = findViewById(R.id.layoutScaleFactors);
        rvScaleFactors = findViewById(R.id.rvScaleFactors);
        rvScaleFactors.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initSpinners() {

        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{
                        "Basic COCOMO",
                        "Intermediate COCOMO",
                        "COCOMO II (Post-Arch)"
                }
        );
        modelAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerCocomoModel.setAdapter(modelAdapter);

        // Project type spinner
        ArrayAdapter<String> projectTypeAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new String[]{
                        "Распространённый",
                        "Полузависимый",
                        "Встроенный"
                }
        );
        projectTypeAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerProjectType.setAdapter(projectTypeAdapter);
    }

    private void initCostDrivers() {

        RecyclerView rvProduct = findViewById(R.id.rvProductAttributes);
        RecyclerView rvHardware = findViewById(R.id.rvHardwareAttributes);
        RecyclerView rvPersonnel = findViewById(R.id.rvPersonnelAttributes);
        RecyclerView rvProject = findViewById(R.id.rvProjectAttributes);

        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        rvHardware.setLayoutManager(new LinearLayoutManager(this));
        rvPersonnel.setLayoutManager(new LinearLayoutManager(this));
        rvProject.setLayoutManager(new LinearLayoutManager(this));

        List<CostDriver> product =
                CostDriverFactory.createProductAttributes();
        List<CostDriver> hardware =
                CostDriverFactory.createHardwareAttributes();
        List<CostDriver> personnel =
                CostDriverFactory.createPersonnelAttributes();
        List<CostDriver> project =
                CostDriverFactory.createProjectAttributes();

        rvProduct.setAdapter(new CostDriverAdapter(product));
        rvHardware.setAdapter(new CostDriverAdapter(hardware));
        rvPersonnel.setAdapter(new CostDriverAdapter(personnel));
        rvProject.setAdapter(new CostDriverAdapter(project));

        allCostDrivers.clear();
        allCostDrivers.addAll(product);
        allCostDrivers.addAll(hardware);
        allCostDrivers.addAll(personnel);
        allCostDrivers.addAll(project);
    }

    private void initListeners() {

        spinnerCocomoModel.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        boolean isIntermediate = position == 1;
                        //spinnerProjectType.setEnabled(!isIntermediate);
                        toggleCostDriversVisibility(isIntermediate);
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {}
                }
        );

        btnCalculate.setOnClickListener(v -> calculate());
    }


    private void calculate() {

        if (etKloc.getText().toString().isEmpty()) {
            tvResult.setText("Введите размер проекта (KLOC)");
            return;
        }

        double kloc = Double.parseDouble(etKloc.getText().toString());

        boolean isIntermediate =
                spinnerCocomoModel.getSelectedItemPosition() == 1;

        ProjectType projectType = getSelectedProjectType();

        CocomoResult result;

        if (isIntermediate) {
            double eaf = calculateEAF();

            result = CocomoIntermediateCalc.calculate(
                    kloc,
                    projectType,
                    eaf
            );

        } else {
            result = CocomoBasicCalc.calculate(
                    kloc,
                    projectType
            );
        }

        tvResult.setText(
                String.format(
                        "Трудоёмкость: %.2f чел.-мес.\n" +
                                "Срок разработки: %.2f мес.\n" +
                                "Численность команды: %.2f чел.",
                        result.effort,
                        result.time,
                        result.people
                )
        );
    }

    private ProjectType getSelectedProjectType() {

        switch (spinnerProjectType.getSelectedItemPosition()) {
            case 0:
                return ProjectType.ORGANIC;
            case 1:
                return ProjectType.SEMI_DETACHED;
            case 2:
                return ProjectType.EMBEDDED;
            default:
                return ProjectType.SEMI_DETACHED;
        }
    }


    private double calculateEAF() {
        double eaf = 1.0;
        for (CostDriver d : allCostDrivers) {
            eaf *= d.getSelectedValue();
        }
        return eaf;
    }

    private void toggleCostDriversVisibility(boolean visible) {
        layoutCostDrivers.setVisibility(
                visible ? View.VISIBLE : View.GONE
        );
    }
}

