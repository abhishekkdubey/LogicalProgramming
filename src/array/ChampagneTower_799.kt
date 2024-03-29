package array



/**
 * 799. Champagne Tower
 *
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
 *
 *Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
 *
 *For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
 *
 *
 *
 *Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
 *
 *
 *
 *Example 1:
 *
 *Input: poured = 1, query_row = 1, query_glass = 1
 *Output: 0.00000
 *Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
 *Example 2:
 *
 *Input: poured = 2, query_row = 1, query_glass = 1
 *Output: 0.50000
 *Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
 *Example 3:
 *
 *Input: poured = 100000009, query_row = 33, query_glass = 17
 *Output: 1.00000
 *
 *
 *Constraints:
 *
 *0 <= poured <= 109
 *0 <= query_glass <= query_row < 100
 */
class ChampagneTower_799 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ChampagneTower_799().champagneTower(1, 1, 1))
            println(ChampagneTower_799().champagneTower(2, 1, 1))
            println(ChampagneTower_799().champagneTower(1, 3, 2))
            println(ChampagneTower_799().champagneTower(16, 4, 0))
            println(ChampagneTower_799().champagneTower1(16, 4, 0))
//            println(ChampagneTower_799().champagneTower(11, 4, 4))
//            println(ChampagneTower_799().champagneTower(11, 4, 2))
            println(ChampagneTower_799().champagneTower(180, 33, 17))
            println(ChampagneTower_799().champagneTower1(180, 33, 17))
        }
    }


    /**
     * Here the formulation become like if poured 7 glass shampagne then
     *
     *                                   16           --> Row 1, can hold only one glass
     *                            [(16-1)/2 , (16-1)/2]
     *                            [   7.5  ,   7.5  ]     --> Row 2, now every glass can hold max 1 glass
     *               [(7.5-1)/2,  [(7.5-1)/2 +(7.5-1)/2],    (7.5-1)/2]
     *               [  3.25   ,        3.25+3.25       ,       3.25  ]
     *               [  3.25   ,            6.5         ,       3.25  ]
     *   [(3.25-1)/2,   (3.25-1)/2+(6.5-1)/2,  (6.5-1)/2+(3.25-1)/2,       (3.25-1)/2]
     *   [1.125,            3.875,                  3.875,                  1.125 ]
     *
     *
     *   So the formula has been creatred as
     *
     *                          n
     *                [ (n-1)/2           ,           (n-1)/2 ] if result of this row is {k, k}
     *       [((n-1)/2-1)/2, ((n-1)/2-1)/2+((n-1)/2-1)/2, ((n-1)/2-1)/2] e.g { (k-1)/2, (k-1)/2+(k-1)/2, (k-1)/2} if result ={l , m, l}
     *       [(l-1)/2 ,     (l-1)/2+(m-1)/2,       (m-1)/2+(l-1)/2,         (l-1)/2]
     *
     */
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {


        if (poured==0){
            return 0.0
        }

        val listRow = mutableListOf<Double>()
        listRow.add(poured.toDouble())

        var row = query_row
        while (row>0){
            val nextRow = mutableListOf<Double>()
            //Taken max from 0 or previoud (prevRowFirstIndex-1)/2
            nextRow.add(maxOf((listRow[0] - 1.0) / 2.toDouble(), 0.0))

            for (i in 1..listRow.lastIndex){
                val sum = (listRow[i-1] - 1.0) / 2.toDouble() +(listRow[i] - 1.0) / 2.toDouble()
                nextRow.add(maxOf(sum, 0.0))
            }
            nextRow.add(maxOf((listRow[0] - 1.0) / 2.toDouble(), 0.0))
            listRow.clear()
            listRow.addAll(nextRow)
            row--
        }

        return minOf(1.0, listRow[query_glass])
    }

    fun champagneTower1(poured: Int, query_row: Int, query_glass: Int): Double {
        if (0 == poured) return 0.0
        var prevRow = ArrayList(listOf(poured.toDouble()))

        var queryRow = query_row
        while (queryRow-- > 0) {
            val currentRow = ArrayList<Double>()
            val champagneInEnds = maxOf(0.0, (prevRow[0] - 1) / 2) // min champagne can be 0
            currentRow.add(champagneInEnds) // first glass
            for (i in 1 until prevRow.size) currentRow.add(
                maxOf(0.0, (prevRow[i - 1] - 1) / 2) +  // flow from top-left glass
                        maxOf(0.0, (prevRow[i] - 1) / 2)
            ) // flow from top-right glass
            currentRow.add(champagneInEnds) // last glass
            prevRow = currentRow
        }
        return minOf(1.0, prevRow[query_glass])
    }

}