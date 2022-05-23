package com.example.general


class SamplePlayground {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val st1 = "Test"
            val st2 = String("Test".toCharArray())

            println(System.identityHashCode(st1))
            println(System.identityHashCode(st2))
            println(st1 ==st2)
            println(st1.equals(st2))

        }
    }


    fun foldOperation() {
        println(listOf(1, 2, 3, 4).fold(10) { sum, element -> sum + element })
    }

    fun reduceOperation() {
        println(listOf(1, 2, 3, 4).reduce { sum, element -> sum + element })
    }


}
