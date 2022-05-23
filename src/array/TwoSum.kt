package array

class TwoSum {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(TwoSum().twoSum(arr = intArrayOf(2, 7, 11, 15, 5, 6, 3), start = 0, end = 6, target = 9))
//            println(TwoSum().titleToNumber("A"))
//            println(TwoSum().titleToNumber("AB"))
//            println(TwoSum().titleToNumber("ZY"))
//            println(TwoSum().titleToNumber(""))
        }
    }

//    fun titleToNumber(s: String): Int {
//        return if (s.isEmpty()) 0 else s[s.length - 1] - 'A' + 1 + 26 * titleToNumber(s.substring(0, s.length - 1))
//    }

//    fun titleToNumber(columnTitle: String): Int {
//        return if (columnTitle.isNullOrBlank()){
//            0
//        }else{
//            return (columnTitle[columnTitle.lastIndex]-'A')+1+(26 * titleToNumber(columnTitle.substring(0, columnTitle.lastIndex)))
//        }
//    }

    fun twoSum(arr: IntArray, start: Int, end: Int, target: Int): Set<Pair<Int, Int>> {
        arr.sort()
        val result = HashSet<Pair<Int, Int>>()

        var s = start
        var e = end

        while (s < e) {
            if ((s > 1 && arr[s] == arr[s - 1])) {
                s++
                continue
            }

            if (e < arr.lastIndex && arr[e] == arr[e + 1]) {
                e--
                continue
            }
            val t = arr[s] + arr[e]
            if (t == target) {
                result.add(Pair(arr[s], arr[e]))
                s++
                e--
            } else if (t < target) {
                s++
            } else {
                e--
            }
        }
        return result

    }
}









fun threeSum(nums: IntArray): List<List<Int>> {

    val result= HashSet<ArrayList<Int>>()

    for(i in 0..nums.lastIndex){

        val remSum = twoSum(nums, i+1, nums.lastIndex, -nums[i])

        for(sum in remSum){
            val subRes = ArrayList<Int>()
            subRes.add(nums[i])
            subRes.add(sum.first)
            subRes.add(sum.second)
            result.add(subRes)
        }
    }

    return result.toList()

}

























fun twoSum(arr: IntArray, start: Int, end: Int, target: Int) : List<Pair<Int, Int>>{

    var s = start
    var e = end

    val result = ArrayList<Pair<Int, Int>>()

    while(s < e){
        if(s > start && arr[s] == arr[s - 1]) {
            s++
            continue
        }

        if(e < end && arr[e]==arr[e+1]) {
            e--
            continue
        }

        val sum = arr[s]+arr[e]

        if(sum == target) {
            result.add(Pair(arr[s], arr[e]))
            e--
            s++
        } else if(sum < target) {
            s++
        } else {
            e--
        }
    }
    return result
}




























