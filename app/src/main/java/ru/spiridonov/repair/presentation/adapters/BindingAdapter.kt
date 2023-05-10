package ru.spiridonov.repair.presentation.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import ru.spiridonov.repair.R
import ru.spiridonov.repair.domain.WorkStage
import ru.spiridonov.repair.domain.WorkStage.*

@BindingAdapter("errorInput")
fun bindErrorInput(textInputLayout: TextInputLayout, isError: Boolean) {
    val message =
        if (isError) textInputLayout.context.getString(R.string.error_input_name) else null
    textInputLayout.error = message
}

@BindingAdapter("welcomeUser")
fun textWelcomeUser(textView: TextView, text: String?) {
    textView.text = String.format(textView.context.resources.getString(R.string.welcome), text)
}

@BindingAdapter("setPrice")
fun textSetPrice(textView: TextView, text: Int) {
    textView.text = String.format(textView.context.resources.getString(R.string.price), text)
}

@BindingAdapter("setIsPaid")
fun textSetIsPaid(textView: TextView, isPaid: Boolean) {
    val resources = textView.context.resources
    val color = resources.getColor(if (isPaid) R.color.green else R.color.red, null)
    textView.text = if (isPaid) "Оплачено" else "Не оплачено"
    textView.setTextColor(color)
}

@BindingAdapter("setWorkStage")
fun textSetWorkStage(textView: TextView, workStage: WorkStage) {
    textView.text = when (workStage) {
        DIAGNOSTICS -> "Диагностика"
        REPAIR -> "Ремонт"
        TESTING -> "Тестирование"
        DELIVERY -> "Доставка"
        PAYMENT -> "Оплата"
        COMPLETED -> "Завершено"
    }
}