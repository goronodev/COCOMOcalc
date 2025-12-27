package com.example.cocomocalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostDriverFactory {
    public static List<CostDriver> createProductAttributes() {

        List<CostDriver> list = new ArrayList<>();

        list.add(new CostDriver(
                "RELY",
                "Требуемая надежность ПО",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 0.75),
                        new CostDriverLevel("Низкий", 0.88),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.15),
                        new CostDriverLevel("Очень высокий", 1.40)
                )
        ));

        list.add(new CostDriver(
                "DATA",
                "Размер БД приложения",
                Arrays.asList(
                        new CostDriverLevel("Низкий", 0.94),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.08),
                        new CostDriverLevel("Очень высокий", 1.16)
                )
        ));

        list.add(new CostDriver(
                "CPLX",
                "Сложность продукта",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 0.70),
                        new CostDriverLevel("Низкий", 0.85),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.15),
                        new CostDriverLevel("Очень высокий", 1.30),
                        new CostDriverLevel("Критический", 1.65)
                )
        ));

        return list;
    }

    public static List<CostDriver> createHardwareAttributes() {

        List<CostDriver> list = new ArrayList<>();

        list.add(new CostDriver(
                "TIME",
                "Ограничения быстродействия",
                Arrays.asList(
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.11),
                        new CostDriverLevel("Очень высокий", 1.30),
                        new CostDriverLevel("Критический", 1.66)
                )
        ));

        list.add(new CostDriver(
                "STOR",
                "Ограничения памяти",
                Arrays.asList(
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.06),
                        new CostDriverLevel("Очень высокий", 1.21),
                        new CostDriverLevel("Критический", 1.56)
                )
        ));


        list.add(new CostDriver(
                "VIRT",
                "Неустойчивость окружения ВМ",
                Arrays.asList(
                        new CostDriverLevel("Низкий", 0.87),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.15),
                        new CostDriverLevel("Очень высокий", 1.30)
                )
        ));


        list.add(new CostDriver(
                "TURN",
                "Требуемое время восстановления",
                Arrays.asList(
                        new CostDriverLevel("Низкий", 0.87),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.07),
                        new CostDriverLevel("Очень высокий", 1.15)
                )
        ));

        return list;
    }

    public static List<CostDriver> createPersonnelAttributes() {

        List<CostDriver> list = new ArrayList<>();


        list.add(new CostDriver(
                "ACAP",
                "Аналитические способности",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.46),
                        new CostDriverLevel("Низкий", 1.19),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.86),
                        new CostDriverLevel("Очень высокий", 0.71)
                )
        ));


        list.add(new CostDriver(
                "AEXP",
                "Опыт разработки",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.29),
                        new CostDriverLevel("Низкий", 1.13),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.91),
                        new CostDriverLevel("Очень высокий", 0.82)
                )
        ));


        list.add(new CostDriver(
                "PCAP",
                "Способности к разработке ПО",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.42),
                        new CostDriverLevel("Низкий", 1.17),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.86),
                        new CostDriverLevel("Очень высокий", 0.70)
                )
        ));


        list.add(new CostDriver(
                "VEXP",
                "Опыт работы с ВМ",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.21),
                        new CostDriverLevel("Низкий", 1.10),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.90)
                )
        ));


        list.add(new CostDriver(
                "LEXP",
                "Опыт разработки на языках",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.14),
                        new CostDriverLevel("Низкий", 1.07),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.95)
                )
        ));

        return list;
    }

    public static List<CostDriver> createProjectAttributes() {

        List<CostDriver> list = new ArrayList<>();


        list.add(new CostDriver(
                "MODP",
                "Применение методов разработки ПО",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.24),
                        new CostDriverLevel("Низкий", 1.10),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.91),
                        new CostDriverLevel("Очень высокий", 0.82)
                )
        ));


        list.add(new CostDriver(
                "TOOL",
                "Использование инструментария",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.24),
                        new CostDriverLevel("Низкий", 1.10),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 0.91),
                        new CostDriverLevel("Очень высокий", 0.83)
                )
        ));


        list.add(new CostDriver(
                "SCED",
                "Требования соблюдения графика",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 1.23),
                        new CostDriverLevel("Низкий", 1.08),
                        new CostDriverLevel("Средний", 1.00),
                        new CostDriverLevel("Высокий", 1.04),
                        new CostDriverLevel("Очень высокий", 1.10)
                )
        ));

        return list;
    }

}
