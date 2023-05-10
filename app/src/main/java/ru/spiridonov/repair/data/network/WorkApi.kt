package ru.spiridonov.repair.data.network

import ru.spiridonov.repair.domain.Work
import ru.spiridonov.repair.domain.WorkStage

object WorkApi {
    val works = listOf(
        Work(
            1,
            "Замена экрана на смартфоне",
            "Замена поврежденного экрана на новый",
            5000,
            "https://example.com/images/screen-replacement.jpg",
            "Смартфоны",
            WorkStage.DIAGNOSTICS,
            true
        ),
        Work(
            2,
            "Ремонт материнской платы на ноутбуке",
            "Восстановление материнской платы после неисправности",
            8000,
            "https://example.com/images/motherboard-repair.jpg",
            "Ноутбуки",
            WorkStage.REPAIR,
            false
        ),
        Work(
            3,
            "Замена дисплея на планшете",
            "Замена поврежденного дисплея на новый",
            6000,
            "https://example.com/images/display-replacement.jpg",
            "Планшеты",
            WorkStage.TESTING,
            true
        ),
        Work(
            4,
            "Ремонт разъема питания на ноутбуке",
            "Ремонт разъема питания на ноутбуке",
            4500,
            "https://example.com/images/power-jack-repair.jpg",
            "Ноутбуки",
            WorkStage.PAYMENT,
            true
        ),
        Work(
            5,
            "Замена стекла на смартфоне",
            "Замена поврежденного стекла на новое",
            3500,
            "https://example.com/images/glass-replacement.jpg",
            "Смартфоны",
            WorkStage.COMPLETED,
            true
        ),
        Work(
            6,
            "Ремонт жесткого диска на ноутбуке",
            "Ремонт жесткого диска на ноутбуке",
            7000,
            "https://example.com/images/hard-drive-repair.jpg",
            "Ноутбуки",
            WorkStage.DELIVERY,
            false
        ),
        Work(
            7,
            "Замена камеры на смартфоне",
            "Замена неисправной камеры на новую",
            2500,
            "https://example.com/images/camera-replacement.jpg",
            "Смартфоны",
            WorkStage.COMPLETED,
            true
        ),
        Work(
            8,
            "Ремонт системной платы на смартфоне",
            "Восстановление системной платы на смартфоне",
            5500,
            "https://example.com/images/mainboard-repair.jpg",
            "Смартфоны",
            WorkStage.DIAGNOSTICS,
            true
        )
    )
}