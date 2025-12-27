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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private Button btnCalculate;
    private Spinner spinnerModel;
    private Spinner spinnerProjectType;
    private EditText etKloc;
    private TextView tvResult;
    private LinearLayout layoutCostDrivers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etKloc = findViewById(R.id.etKloc);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        layoutCostDrivers = findViewById(R.id.layoutCostDrivers);
        spinnerModel = findViewById(R.id.spinnerModel);
        spinnerProjectType = findViewById(R.id.spinnerProjectType);

        ArrayAdapter<CharSequence> modelAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.cocomo_models,
                        android.R.layout.simple_spinner_item
                );
        modelAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinnerModel.setAdapter(modelAdapter);
        ArrayAdapter<CharSequence> projectTypeAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.project_types,
                        android.R.layout.simple_spinner_item
                );

        projectTypeAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerProjectType.setAdapter(projectTypeAdapter);

        spinnerModel.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view,
                                               int position,
                                               long id) {

                        if (position == 1) {
                            //disableProjectTypeSpinner();
                            layoutCostDrivers.setVisibility(View.VISIBLE);
                        } else {
                            //enableProjectTypeSpinner();
                            layoutCostDrivers.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });


        btnCalculate.setOnClickListener(v -> {
            double kloc = Double.parseDouble(etKloc.getText().toString());
            ProjectType type = ProjectType.ORGANIC;

            CocomoResult result =
                    CocomoBasicCalc.calculate(kloc, type);

        });

        btnCalculate.setOnClickListener(v -> {

            double kloc = Double.parseDouble(etKloc.getText().toString());

            String model = getSelectedModel();
            ProjectType type = getSelectedProjectType();

            CocomoResult result = null;

            if (model == "BASIC") {
                result = CocomoBasicCalc.calculate(kloc, type);
            } else {
                double eaf = calculateEAF();
                result = CocomoIntermediateCalc.calculate(kloc, type, eaf);
            }

            tvResult.setText(
                    "Трудоёмкость: " + String.format("%.2f", result.effort) + " чел-мес\n" +
                            "Сроки: " + String.format("%.2f", result.time) + " мес\n" +
                            "Команда: " + String.format("%.2f", result.people) + " чел"
            );
        });
    }


    ProjectType getSelectedProjectType() {
        int position = spinnerProjectType.getSelectedItemPosition();

        switch (position) {
            case 0:
                return ProjectType.ORGANIC;
            case 1:
                return ProjectType.SEMI_DETACHED;
            case 2:
                return ProjectType.EMBEDDED;
            default:
                return ProjectType.ORGANIC;
        }
    }
    String getSelectedModel() {
        int position = spinnerModel.getSelectedItemPosition();

        switch (position) {
            case 0:
                return "BASIC";
            case 1:
                return "INTERMEDIATE";
            default:
                return "BASIC";
        }
    }

   /* private double calculateEAF(List<CostDriver> drivers) {
        double eaf = 1.0;

        for (CostDriver driver : drivers) {
            eaf *= driver.getSelectedValue();
        }

        return eaf;
    }*/

}