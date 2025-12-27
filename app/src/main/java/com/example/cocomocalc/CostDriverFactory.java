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

    public static List<CostDriver> createCocomo2ScaleFactors() {
        List<CostDriver> list = new ArrayList<>();

        // PREC: Precedentedness (Наличие прецедента)
        list.add(new CostDriver(
                "PREC",
                "Наличие прецедента",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 6.20),
                        new CostDriverLevel("Низкий", 4.96),
                        new CostDriverLevel("Средний", 3.72),
                        new CostDriverLevel("Высокий", 2.48),
                        new CostDriverLevel("Очень высокий", 1.24),
                        new CostDriverLevel("Экстра высокий", 0.00)
                )
        ));

        // FLEX: Development Flexibility (Гибкость процесса)
        list.add(new CostDriver(
                "FLEX",
                "Гибкость процесса",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 5.07),
                        new CostDriverLevel("Низкий", 4.05),
                        new CostDriverLevel("Средний", 3.04),
                        new CostDriverLevel("Высокий", 2.03),
                        new CostDriverLevel("Очень высокий", 1.01),
                        new CostDriverLevel("Экстра высокий", 0.00)
                )
        ));

        // RESL: Architecture / Risk Resolution (Разрешение рисков)
        list.add(new CostDriver(
                "RESL",
                "Разрешение рисков",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 7.07),
                        new CostDriverLevel("Низкий", 5.65),
                        new CostDriverLevel("Средний", 4.24),
                        new CostDriverLevel("Высокий", 2.83),
                        new CostDriverLevel("Очень высокий", 1.41),
                        new CostDriverLevel("Экстра высокий", 0.00)
                )
        ));

        // TEAM: Team Cohesion (Сплоченность команды)
        list.add(new CostDriver(
                "TEAM",
                "Сплоченность команды",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 5.48),
                        new CostDriverLevel("Низкий", 4.38),
                        new CostDriverLevel("Средний", 3.29),
                        new CostDriverLevel("Высокий", 2.19),
                        new CostDriverLevel("Очень высокий", 1.10),
                        new CostDriverLevel("Экстра высокий", 0.00)
                )
        ));

        // PMAT: Process Maturity (Зрелость процессов)
        list.add(new CostDriver("PMAT", "Зрелость процессов",
                Arrays.asList(
                        new CostDriverLevel("Очень низкий", 7.80),
                        new CostDriverLevel("Низкий", 6.24),
                        new CostDriverLevel("Средний", 4.68),
                        new CostDriverLevel("Высокий", 3.12),
                        new CostDriverLevel("Очень высокий", 1.56),
                        new CostDriverLevel("Экстра высокий", 0.00)
                )
        ));

        return list;
    }


    public static List<CostDriver> createCocomo2EffortMultipliers() {
        List<CostDriver> list = new ArrayList<>();

        // --- PRODUCT FACTORS ---

        list.add(new CostDriver("RELY", "Требуемая надежность", Arrays.asList(
                new CostDriverLevel("Очень низкий", 0.82),
                new CostDriverLevel("Низкий", 0.92),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.10),
                new CostDriverLevel("Очень высокий", 1.26)
        )));

        list.add(new CostDriver("DATA", "Размер базы данных", Arrays.asList(
                new CostDriverLevel("Низкий", 0.90),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.14),
                new CostDriverLevel("Очень высокий", 1.28)
        )));

        list.add(new CostDriver("CPLX", "Сложность продукта", Arrays.asList(
                new CostDriverLevel("Очень низкий", 0.73),
                new CostDriverLevel("Низкий", 0.87),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.17),
                new CostDriverLevel("Очень высокий", 1.34),
                new CostDriverLevel("Экстра высокий", 1.74)
        )));

        list.add(new CostDriver("RUSE", "Повторное использование", Arrays.asList(
                new CostDriverLevel("Низкий", 0.95),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.07),
                new CostDriverLevel("Очень высокий", 1.15),
                new CostDriverLevel("Экстра высокий", 1.24)
        )));

        list.add(new CostDriver("DOCU", "Документирование", Arrays.asList(
                new CostDriverLevel("Очень низкий", 0.81),
                new CostDriverLevel("Низкий", 0.91),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.11),
                new CostDriverLevel("Очень высокий", 1.23)
        )));

        // --- PLATFORM FACTORS ---

        list.add(new CostDriver("TIME", "Ограничения времени выполнения", Arrays.asList(
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.11),
                new CostDriverLevel("Очень высокий", 1.29),
                new CostDriverLevel("Экстра высокий", 1.63)
        )));

        list.add(new CostDriver("STOR", "Ограничения памяти", Arrays.asList(
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.05),
                new CostDriverLevel("Очень высокий", 1.17),
                new CostDriverLevel("Экстра высокий", 1.46)
        )));

        list.add(new CostDriver("PVOL", "Изменчивость платформы", Arrays.asList(
                new CostDriverLevel("Низкий", 0.87),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.15),
                new CostDriverLevel("Очень высокий", 1.30)
        )));

        // --- PERSONNEL FACTORS ---

        list.add(new CostDriver("ACAP", "Способности аналитика", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.42),
                new CostDriverLevel("Низкий", 1.19),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.85),
                new CostDriverLevel("Очень высокий", 0.71)
        )));

        list.add(new CostDriver("PCAP", "Способности программиста", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.34),
                new CostDriverLevel("Низкий", 1.15),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.88),
                new CostDriverLevel("Очень высокий", 0.76)
        )));

        list.add(new CostDriver("PCON", "Непрерывность персонала", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.29),
                new CostDriverLevel("Низкий", 1.12),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.90),
                new CostDriverLevel("Очень высокий", 0.81)
        )));

        list.add(new CostDriver("AEXP", "Опыт работы с приложениями", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.22),
                new CostDriverLevel("Низкий", 1.10),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.88),
                new CostDriverLevel("Очень высокий", 0.81)
        )));

        list.add(new CostDriver("PEXP", "Опыт работы с платформой", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.19),
                new CostDriverLevel("Низкий", 1.09),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.91),
                new CostDriverLevel("Очень высокий", 0.85)
        )));

        list.add(new CostDriver("LTEX", "Опыт использования языков/инструментов", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.20),
                new CostDriverLevel("Низкий", 1.09),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.91),
                new CostDriverLevel("Очень высокий", 0.84)
        )));

        // --- PROJECT FACTORS ---

        list.add(new CostDriver("TOOL", "Использование программных инструментов", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.17),
                new CostDriverLevel("Низкий", 1.09),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.90),
                new CostDriverLevel("Очень высокий", 0.78)
        )));

        list.add(new CostDriver("SITE", "Многоофисная разработка", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.22),
                new CostDriverLevel("Низкий", 1.09),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 0.93),
                new CostDriverLevel("Очень высокий", 0.86),
                new CostDriverLevel("Экстра высокий", 0.80)
        )));

        list.add(new CostDriver("SCED", "Требуемый график разработки", Arrays.asList(
                new CostDriverLevel("Очень низкий", 1.43),
                new CostDriverLevel("Низкий", 1.14),
                new CostDriverLevel("Средний", 1.00),
                new CostDriverLevel("Высокий", 1.00),
                new CostDriverLevel("Очень высокий", 1.00)
        )));

        return list;
    }
}
