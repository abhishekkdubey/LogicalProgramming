package array

import java.util.regex.Pattern

class TestRegex {
    companion object{
        @JvmStatic
        fun main(args: Array<String>)
        {
            val  pattern = Pattern.compile("^[A-Z][a-z]*(([,.] |[ '-])[A-Za-z][a-z]*)*(\\.?)\$", Pattern.CASE_INSENSITIVE); // Match regex against input
//            println(pattern.matcher("Mathias d'Arras").matches())
//            println(pattern.matcher("MaRtin LuTher King, Jr.").matches())
//            println(pattern.matcher("Hector Sausage-Hausen").matches())
//            println(pattern.matcher("Ai Wong").matches())
//            println(pattern.matcher("Kate Wu").matches())
//            println(pattern.matcher("").matches())
            println(TestRegex().isValidMobile("(987) 654 3219"))
            println(TestRegex().isValidMobile("(987)-654-3219"))
            println(TestRegex().isValidMobile("987 654 3219"))
            println(TestRegex().isValidMobile("987-654-3219"))
            println(TestRegex().isValidMobile("(987) 654 321"))
            println(TestRegex().isValidMobile("(987) 654 32192"))
            println(TestRegex().isValidMobile("(987) 654 321943"))
        }
    }

    fun isValidMobile(number: String): Boolean
    {
        val pattern = ("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}\$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}\$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}\$")
        return Pattern.compile(pattern).matcher(number).matches()
    }
}