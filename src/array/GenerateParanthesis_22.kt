package array


class GenerateParanthesis_22 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            println(GenerateParanthesis_22().generateParenthesis(3))
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) {

            //no possible combinations, return empty list
            return ArrayList()
        }
        if (n == 1) {

            //only one possible combination i.e. (), return as positive base result
            val br: MutableList<String> = ArrayList()
            br.add("()")
            return br
        }

        //get the result of smaller problem
        val rr = generateParenthesis(n - 1)

        //since new combinations may include duplicates, use a set to store new combination
        val mr =  mutableSetOf<String>()

        //for each combination from smaller problem, add a new set of parentheses at each possible position
        for (s in rr) {
            for (i in s.indices) {
                val ns = s.substring(0, i) + "()" + s.substring(i)
                mr.add(ns)
            }
        }
        return mr.toList()
    }
}