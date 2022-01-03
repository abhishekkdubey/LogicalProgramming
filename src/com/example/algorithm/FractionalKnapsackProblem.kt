package com.example.algorithm



data class KnapsackItem(val weight: Int, val value: Int, var ratio: Double = 0.0)

fun main() {


    val k1= KnapsackItem(6, 6)
    val k2= KnapsackItem(10, 2)
    val k3= KnapsackItem(3, 1)
    val k4= KnapsackItem(5, 8)
    val k5= KnapsackItem(1, 3)
    val k6= KnapsackItem(3, 5)
    println( FractionalKnapsackProblem().solution(10, arrayOf(k1, k2, k3, k4 ,k5, k6)))
}

class FractionalKnapsackProblem {



    fun solution(knapsackCapacity: Int, list: Array<KnapsackItem>): Double {

        var totalWeight = 0
        var totalValue = 0.0

        println("==========#1")
        list.forEach { println(it) }
        list.forEach { it.ratio = it.value.toDouble() / it.weight.toDouble() }

        println("==========#2")
        list.forEach { println(it) }
        println("==========#3")

        list.sortWith { o1, o2 ->
            if (o1.ratio < o2.ratio) {
                1
            } else {
                -1
            }
        }

        list.forEach { println(it) }


        for (item in list){
            if (totalWeight+item.weight<=knapsackCapacity){
                totalWeight+=item.weight
                totalValue+=item.value
            }else{
                val remainingWeight =  knapsackCapacity-totalWeight
                val remainingValue = item.ratio *remainingWeight
                totalWeight+=remainingWeight
                totalValue+=remainingValue
            }

            if (totalWeight==knapsackCapacity){
                break
            }
        }








        return totalValue


    }

}