package subtask1

import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate
import java.util.*

class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        val sdf = SimpleDateFormat("d MMMM, EEEE", Locale("ru"))
        val dataStr = "$day $month $year"
        val formatter = SimpleDateFormat("d M yyyy")
        if (!isDateValid(day, month, year)) {
            return "Такого дня не существует"
        } else {
            val date = formatter.parse(dataStr)
            val dayOfTheWeek = sdf.format(date)
            return dayOfTheWeek
        }
    }

    fun isDateValid(day: String, month: String, year: String): Boolean {
        var dateIsValid = true
        try {
            LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch (e: DateTimeException) {
            dateIsValid = false
        }
        return dateIsValid
    }
}

