package com.example.cocomocalc;

import java.util.List;

public class Cocomo2Calc {

    private static final double A = 2.94;
    private static final double B = 0.91;
    private static final double C = 3.67;
    private static final double D = 0.28;


    public static CocomoResult calculate(double kloc, List<CostDriver> scaleFactors, double eaf) {

        double sumSF = 0.0;
        if (scaleFactors != null) {
            for (CostDriver sf : scaleFactors) {
                sumSF += sf.getSelectedValue();
            }
        }



        /* 2. Считаем произведение Effort Multipliers (EAF)
        double eaf = 1.0;
        if (effortMultipliers != null) {
            for (CostDriver em : effortMultipliers) {
                eaf *= em.getSelectedValue();
            }
        }*/

        double E = B + (0.01 * sumSF);
        // PM = A * (Size)^E * EAF
        double effort = A * Math.pow(kloc, E) * eaf;

        // 4. Расчет Времени (Schedule in Months)
        // TDEV = C * (PM)^F
        // где F = D + 0.2 * (E - 0.91)
        double F = D + (0.2 * (E - B));
        double time = C * Math.pow(effort, F);

        double people = (time > 0) ? (effort / time) : 0;

        return new CocomoResult(effort, time, people);
    }
}