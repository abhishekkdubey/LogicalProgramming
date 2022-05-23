import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.io.File
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*

class TestJSONFormatting {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//
//            val inputStream: InputStream =
//                File("/Users/adubey2/Desktop/Abhishek/LogicProgramming/src/json.json").inputStream()
//            val JSON = inputStream.bufferedReader().use { it.readText() }
//
//            //formatJSONToCorrectPosition(JSON)
//            dateValidation()
//            println( TestJSONFormatting().countVowelStrings(2))
//            println(TestJSONFormatting().countVowelStrings(1))
//            println(TestJSONFormatting().countVowelStrings(33))


            var str = "UUUUUUUUUUUUUUUUU11UUUU"
            println(str.replace("[^\\d]".toRegex(), ""))

        }

        fun formatJSONToCorrectPosition(input: String) {

            val listStart = mutableListOf<Int>()

            val gson: Gson = GsonBuilder().create()

            val json = if (input.trim().startsWith("var")) {
                input.substring(input.indexOf('{')).trim()
            } else {
                input
            }
            val el: JsonElement = JsonParser().parse(json)
            val actualInput = gson.toJson(el)

            var index: Int = actualInput.indexOf("\"Tradeline\":{")

            while (index >= 0) {
                listStart.add(index)
                index = actualInput.indexOf("\"Tradeline\":{", index + 1)
            }

            println(listStart.toList())

            var stringWithEndFormatting = StringBuilder(actualInput)
            listStart.reverse()
            listStart.forEach {
                val start = stringWithEndFormatting.indexOf('}', it)
                stringWithEndFormatting = stringWithEndFormatting.replace(start, start + 1, "}]")
            }

            val finalJSON = stringWithEndFormatting.toString().replace("\"Tradeline\":{", "\"Tradeline\":[{")

            println(finalJSON)
        }


        fun dateValidation() {
            val displayDate = TestJSONFormatting().getDisplayDate(
                try {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
                    val parsedDate = dateFormat.parse("1999-08-29")
                    val calendar = Calendar.getInstance()
                    calendar.time = parsedDate
                    calendar.timeInMillis
                } catch (e: Exception) {
                    0L
                }
            )
            println(displayDate)
        }
    }


    fun getDisplayDate(time: Long): String {
        try {

            if (time == 0L) {
                return ""
            }
            val today = Calendar.getInstance()
            val yesterday = Calendar.getInstance()
            yesterday.add(Calendar.DATE, -1)
            val month = Calendar.getInstance()
            month.add(Calendar.MONTH, 1)
            val dateTime = Date(time)
            val calendar = Calendar.getInstance()
            calendar.time = dateTime
            calendar.add(Calendar.MONTH, 0)
            var timeFormat = "h:mm a"
            val timeFormatter = SimpleDateFormat(
                timeFormat,
                Locale.ROOT
            )
            return if (calendar[Calendar.YEAR] == today[Calendar.YEAR]
                && calendar[Calendar.DAY_OF_YEAR] == today[Calendar.DAY_OF_YEAR]
            ) {
                timeFormatter.format(dateTime)
            } else if (calendar[Calendar.YEAR] == yesterday[Calendar.YEAR]
                && calendar[Calendar.DAY_OF_YEAR] == yesterday[Calendar.DAY_OF_YEAR]
            ) {
                timeFormatter.format(
                    dateTime
                )
            } else {
                calendar.add(Calendar.MONTH, 1)
                if (calendar[Calendar.YEAR] == month[Calendar.YEAR] && calendar[Calendar.MONTH]
                    == month[Calendar.MONTH]
                ) {
                    "" + getDaysDifference(dateTime, Date())
                } else if (calendar[Calendar.YEAR] == month[Calendar.YEAR]) {
                    "" +
                            getMonthsDifference(dateTime, Date())
                } else {
                    "" + getYearsDifference(dateTime, Date())
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println(
                "CMDateUtil Error while parsing date for Credit Score: " + e.localizedMessage
            )
            return ""
        }

    }

    private fun getDaysDifference(fromDate: Date?, toDate: Date?): Int {
        return if (fromDate == null || toDate == null) 0 else ((toDate.time - fromDate.time) / (1000 * 60 * 60 * 24)).toInt()
    }

    private fun getMonthsDifference(fromDate: Date?, toDate: Date?): Int {
        if (toDate == null || fromDate == null) {
            return -1 //Error
        }
        val calendar = Calendar.getInstance()
        calendar.time = fromDate
        val nMonth1 = 12 * calendar[Calendar.YEAR] + calendar[Calendar.MONTH]
        calendar.time = toDate
        val nMonth2 = 12 * calendar[Calendar.YEAR] + calendar[Calendar.MONTH]
        return Math.abs(nMonth2 - nMonth1)
    }


    private fun getYearsDifference(fromDate: Date?, toDate: Date?): Int {
        val a = getCalendar(fromDate)
        val b = getCalendar(toDate)
        var diff = b[Calendar.YEAR] - a[Calendar.YEAR]
        if (a[Calendar.DAY_OF_YEAR] > b[Calendar.DAY_OF_YEAR]) {
            diff--
        }
        return diff
    }

    private fun getCalendar(date: Date?): Calendar {
        val cal = Calendar.getInstance(Locale.US)
        cal.time = date
        return cal
    }

    fun countVowelStrings(n: Int): Int {
        val arr = IntArray(5) { 1 }
        for (j in 1 until n) {
            increment(arr)
        }
        return arr.sum()
    }

    private fun increment(arr: IntArray) {
        arr[0] = arr.sum()
        arr[1] = arr.sum()-arr[0]
        arr[2] = arr.sum()-arr[0]-arr[1]
        arr[3] = arr.sum()-arr[0]-arr[1]-arr[2]
        arr[4] = arr.sum()-arr[0]-arr[1]-arr[2]-arr[3]
    }


}
