package ru.spiridonov.repair.data.network

import ru.spiridonov.repair.domain.Repair

object RepairApi {
    val repairs = listOf(
        Repair(
            1,
            "Замена экрана",
            "Замена поврежденного экрана на новый",
            5000,
            "https://example.com/images/screen-replacement.jpg",
            "Смартфоны",
            false
        ),
        Repair(
            2,
            "Замена аккумулятора",
            "Замена изношенного аккумулятора на новый",
            3000,
            "https://example.com/images/battery-replacement.jpg",
            "Смартфоны",
            true
        ),
        Repair(
            3,
            "Ремонт материнской платы",
            "Восстановление материнской платы после неисправности",
            8000,
            "https://example.com/images/motherboard-repair.jpg",
            "Ноутбуки",
            false
        ),
        Repair(
            4,
            "Замена клавиатуры",
            "Замена поврежденной клавиатуры на новую",
            4000,
            "https://example.com/images/keyboard-replacement.jpg",
            "Ноутбуки",
            true
        ),
        Repair(
            5,
            "Замена дисплея",
            "Замена поврежденного дисплея на новый",
            6000,
            "https://example.com/images/display-replacement.jpg",
            "Планшеты",
            false
        ),
        Repair(
            6,
            "Замена кнопки питания",
            "Замена поврежденной кнопки питания на новую",
            2000,
            "https://example.com/images/power-button-replacement.jpg",
            "Ноутбуки",
            false
        ),
        Repair(
            7,
            "Замена камеры",
            "Замена поврежденной камеры на новую",
            3500,
            "https://example.com/images/camera-replacement.jpg",
            "Смартфоны",
            true
        ),
        Repair(
            8,
            "Ремонт разъема питания",
            "Восстановление разъема питания после повреждения",
            4500,
            "https://example.com/images/power-jack-repair.jpg",
            "Ноутбуки",
            false
        ),
        Repair(
            9,
            "Ремонт зарядного порта",
            "Восстановление зарядного порта после повреждения",
            3500,
            "https://example.com/images/charging-port-repair.jpg",
            "Смартфоны",
            false
        ),
        Repair(
            10,
            "Замена корпуса",
            "Замена поврежденного корпуса на новый",
            4500,
            "https://example.com/images/case-replacement.jpg",
            "Смартфоны",
            true
        )
    )
}