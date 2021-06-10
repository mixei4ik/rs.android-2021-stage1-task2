package subtask3

import java.text.SimpleDateFormat
import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            Int::class -> return doInt(blockA)
            String::class -> return doString(blockA)
            LocalDate::class -> return doLocalDate(blockA)
        }
        return ""
    }

    private fun doLocalDate(blockA: Array<*>): Any {
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        var maxDate = LocalDate.MIN
        for (i in blockA.indices) {
            if (blockA[i] is LocalDate && maxDate < blockA[i] as LocalDate?) maxDate =
                blockA[i] as LocalDate?
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val maxDateSdf = sdf.parse(maxDate.toString())
        return formatter.format(maxDateSdf)
    }

    private fun doString(blockA: Array<*>): Any {
        var string = ""
        for (i in blockA.indices) {
            if (blockA[i] is String) string += blockA[i].toString()
        }
        return string
    }

    fun doInt(blockA: Array<*>): Any {
        var sum = 0
        for (i in blockA.indices) {
            if (blockA[i] is Int) sum += blockA[i].toString().toInt()
        }
        return sum
    }
}



