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
    private TextView labelScaleFactors;
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
        labelScaleFactors = findViewById(R.id.labelScaleFactors);
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
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        boolean isBasic = position == 0;
                        boolean isIntermediate = position == 1;
                        boolean isCocomo2 = position == 2;

                        spinnerProjectType.setEnabled(!isCocomo2);

                        toggleCostDriversVisibility(isIntermediate || isCocomo2);

                        rvScaleFactors.setVisibility(isCocomo2 ? View.VISIBLE : View.GONE);
                        labelScaleFactors.setVisibility(isCocomo2 ? View.VISIBLE : View.GONE);

                        reloadCostDriversData(isCocomo2);
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
        ProjectType projectType = getSelectedProjectType();
        CocomoResult result = null;
        int selectedModelIndex = spinnerCocomoModel.getSelectedItemPosition();

        if (selectedModelIndex == 2) {
            double eaf = calculateEAF();

            result = Cocomo2Calc.calculate(
                    kloc,
                    scaleFactorsList,
                    eaf
            );

        }
        if (selectedModelIndex == 1) {
            double eaf = calculateEAF();

            result = CocomoIntermediateCalc.calculate(
                    kloc,
                    projectType,
                    eaf
            );

        }
        if (selectedModelIndex == 0){
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
    private void reloadCostDriversData(boolean isCocomo2) {
        allCostDrivers.clear();

        RecyclerView rvProduct = findViewById(R.id.rvProductAttributes);
        RecyclerView rvHardware = findViewById(R.id.rvHardwareAttributes);
        RecyclerView rvPersonnel = findViewById(R.id.rvPersonnelAttributes);
        RecyclerView rvProject = findViewById(R.id.rvProjectAttributes);



        if (isCocomo2) {

            scaleFactorsList.clear();
            scaleFactorsList.addAll(CostDriverFactory.createCocomo2ScaleFactors());

            if (rvScaleFactors.getAdapter() == null) {
                rvScaleFactors.setAdapter(new CostDriverAdapter(scaleFactorsList));
            } else {
                rvScaleFactors.getAdapter().notifyDataSetChanged();
            }
            List<CostDriver> c2Drivers = CostDriverFactory.createCocomo2EffortMultipliers();

            allCostDrivers.addAll(c2Drivers);

            List<CostDriver> productDrivers = new ArrayList<>(c2Drivers.subList(0, 5));   // RELY, DATA, CPLX, RUSE, DOCU
            List<CostDriver> platformDrivers = new ArrayList<>(c2Drivers.subList(5, 8));  // TIME, STOR, PVOL
            List<CostDriver> personnelDrivers = new ArrayList<>(c2Drivers.subList(8, 14)); // ACAP, PCAP, PCON, AEXP, PEXP, LTEX
            List<CostDriver> projectDrivers = new ArrayList<>(c2Drivers.subList(14, 17)); // TOOL, SITE, SCED

            rvProduct.setAdapter(new CostDriverAdapter(productDrivers));
            rvHardware.setAdapter(new CostDriverAdapter(platformDrivers));
            rvPersonnel.setAdapter(new CostDriverAdapter(personnelDrivers));
            rvProject.setAdapter(new CostDriverAdapter(projectDrivers));

            rvProduct.setVisibility(View.VISIBLE);
            rvHardware.setVisibility(View.VISIBLE);
            rvPersonnel.setVisibility(View.VISIBLE);
            rvProject.setVisibility(View.VISIBLE);

        } else {
            initCostDrivers();
            rvProduct.setVisibility(View.VISIBLE);
            rvHardware.setVisibility(View.VISIBLE);
            rvPersonnel.setVisibility(View.VISIBLE);
            rvProject.setVisibility(View.VISIBLE);
        }
    }
}

