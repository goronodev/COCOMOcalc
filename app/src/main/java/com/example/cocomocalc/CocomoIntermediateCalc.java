package com.example.cocomocalc;

public class CocomoIntermediateCalc {
    /**
     * Расчёт Intermediate COCOMO с учётом типа проекта
     *
     * @param kloc размер ПО (KLOC)
     * @param projectType тип проекта (Organic, Semi-detached, Embedded)
     * @param eaf Effort Adjustment Factor
     * @return результат расчёта
     */
    public static CocomoResult calculate(double kloc,
                                         ProjectType projectType,
                                         double eaf) {

        double a;
        double b;
        double d;
        switch (projectType) {
            case ORGANIC:
                a = 3.2;
                b = 1.05;
                d = 0.38;
                break;

            case SEMI_DETACHED:
                a = 3.0;
                b = 1.12;
                d = 0.35;
                break;

            case EMBEDDED:
                a = 2.8;
                b = 1.20;
                d = 0.32;
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown project type");
        }
        double c = 2.5;
        double effort = a * Math.pow(kloc, b) * eaf;
        double time = c * Math.pow(effort, d);
        double people = effort / time;
        return new CocomoResult(effort, time, people);
    }
}
