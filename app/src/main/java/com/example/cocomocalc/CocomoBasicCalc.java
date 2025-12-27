package com.example.cocomocalc;

public class CocomoBasicCalc {
    public static CocomoResult calculate(double kloc, ProjectType type) {
        double a = 0, b = 0, c = 2.5, d = 0;

        switch (type) {
            case ORGANIC:
                a = 2.4; b = 1.05; d = 0.38;
                break;
            case SEMI_DETACHED:
                a = 3.0; b = 1.12; d = 0.35;
                break;
            case EMBEDDED:
                a = 3.6; b = 1.20; d = 0.32;
                break;
        }

        double effort = a * Math.pow(kloc, b);
        double time = c * Math.pow(effort, d);
        double people = effort / time;

        return new CocomoResult(effort, time, people);
    }
}
