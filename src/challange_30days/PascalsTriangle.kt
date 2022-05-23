package challange_30days

/**
 * 118. Pascal's Triangle
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
class PascalsTriangle {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(PascalsTriangle().generate(1))
            println(PascalsTriangle().generate(2))
            println(PascalsTriangle().generate(3))
            println(PascalsTriangle().generate(5))
            println(PascalsTriangle().generate(30))
        }
    }


    /**
     * To Generate Pascals Triangle,
     *
     * We have to head to the approach for getting the previous row value to generate next row.
     *
     * And we know the base case for first row will be always [[1]]
     *
     * So to generate the nest row's first and last element, We need to just add the previous row's index 0's value
     *
     * for rest all value which comes in between for row will be sum of previous row's sum of pair like (0, 1) index sum for current index 1, (1, 2) index sum for current index 2 as so on
     *
     * Let's jump to the solution.
     */
    fun generate(numRows: Int): List<List<Int>> {


        //Taken a result List
        val result = ArrayList<List<Int>>()

        //add the first row value
        result.add(listOf(1))

        //start a loop from 2nd row to last row, as first row has been added in previous line
        for (i in 2 .. numRows) {
            //Grab the last row which will be required for generating current row i
            val last = result.last()

            //Created a new row
            val list = mutableListOf<Int>()
            //Store first value of current row
            list.add(last[0])
            //Generate the 2nd value to 2nd last value of current row.
            for (j in 1..last.lastIndex) {
                list.add(last[j - 1] + last[j])
            }
            //Store last value of current row
            list.add(last[0])
            result.add(list)
        }

        return result
    }

}