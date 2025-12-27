package com.example.cocomocalc;

import java.util.List;

public class CostDriver {

    private final String code;          // RELY, CPLX, ACAP ...
    private final String name;          // Название атрибута
    private final List<CostDriverLevel> levels;

    private int selectedLevelIndex = 0;
    public CostDriver(String code,
                      String name,
                      List<CostDriverLevel> levels) {

        this.code = code;
        this.name = name;
        this.levels = levels;

        // По умолчанию выбираем "Средний" (Nominal = 1.00), если есть
        selectNominalIfExists();
    }

    private void selectNominalIfExists() {
        for (int i = 0; i < levels.size(); i++) {
            if (levels.get(i).getValue() == 1.00) {
                selectedLevelIndex = i;
                return;
            }
        }
        selectedLevelIndex = 0;
    }

    /* ===================== Getters ===================== */

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<CostDriverLevel> getLevels() {
        return levels;
    }

    public int getSelectedLevelIndex() {
        return selectedLevelIndex;
    }

    /* ===================== Logic ===================== */

    public void setSelectedLevelIndex(int index) {
        if (index >= 0 && index < levels.size()) {
            selectedLevelIndex = index;
        }
    }

    public double getSelectedValue() {
        return levels.get(selectedLevelIndex).getValue();
    }

    public String getSelectedLabel() {
        return levels.get(selectedLevelIndex).getLabel();
    }
}
