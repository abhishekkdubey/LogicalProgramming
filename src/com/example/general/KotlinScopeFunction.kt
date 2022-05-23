package com.example.general

class KotlinScopeFunction {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            KotlinScopeFunction().testLet()
            KotlinScopeFunction().testRun()
            KotlinScopeFunction().testWith()
            KotlinScopeFunction().testApply()
            KotlinScopeFunction().testAlso()

        }
    }


    fun testLet() {
        println("===============let=================")
        var pers: Person? = null
        pers = pers.let {
            println(it)
            Person("A", 1, "X")
        }
        println(pers)

        Person("Abhi", 30, "Bangalore").let {
            println(it)
            it.age++
            it.currentLocation = "Delhi"
            println(it)
        }
    }


    fun testRun() {
        println("===============run=================")

        var pers: Person? = null
        pers = pers.run {
            println(this)
            Person("A", 1, "X")
        }
        println(pers)

        Person("Abhi", 30, "Bangalore").run {
            println(this)
            age++
            currentLocation = "Delhi"
            println(this)
        }
    }


    fun testWith() {
        println("===============With=================")
        var pers: Person? = null
        pers = with(pers) {
            println(this)
            Person("A", 1, "X")
        }
        println(pers)

        with( Person("Abhi", 30, "Bangalore")){
            println(this)
            age++
            currentLocation = "Delhi"
            println(this)
        }

    }


    fun testApply() {
        println("===============apply=================")
        var pers: Person? = null
        pers = pers.apply {
            println(this)
        }
        println(pers)

        Person("Abhi", 30, "Bangalore").apply{
            println(this)
            age++
            currentLocation = "Delhi"
            println(this)
        }

    }

    fun testAlso() {
        println("===============also=================")
        var pers: Person? = null
        pers = pers.also {
            println(it)
        }
        println(pers)

        Person("Abhi", 30, "Bangalore").also{
            println(it)
            it.age++
            it.currentLocation = "Delhi"
            println(it)
        }


    }


    data class Person(var name: String, var age: Int, var currentLocation: String)

}