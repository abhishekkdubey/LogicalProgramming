package com.example.general


class PrimeNumberAfterPwithSumS {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            PrimeNumberAfterPwithSumS().allPrime(4, 54, 3)
            PrimeNumberAfterPwithSumS().allPrime(3, 23, 2)
        }
    }

    // vector to store prime
    // and N primes whose sum
    // equals given S
    var set = ArrayList<Int>()
    var prime = ArrayList<Int>()


    // function to evaluate
    // all possible N primes
    // whose sum equals S
    fun primeSum(total: Int, N: Int, S: Int, index: Int) {
        // if total equals S
        // And total is reached
        // using N primes
        if (total == S && set.size == N) {
            // display the N primes
            display()
            return
        }

        // if total is greater
        // than S or if index
        // has reached last
        // element
        // or if set size reached to maximum or greater than maximum
        if (total > S || index == prime.size || set.size >= N) return

        // add prime.get(index)
        // to set vector
        set.add(prime[index])

        // include the (index)th
        // prime to total
        primeSum(total + prime[index], N, S, index + 1)
        // remove element
        // from set vector
        set.removeAt(set.size - 1)

        // exclude (index)th prime
        primeSum(total, N, S, index + 1)
    }

    // function to generate
    // all primes
    fun allPrime(N: Int, S: Int, P: Int) {
        // all primes less
        // than S itself
        for (i in P + 1..S) {
            // if i is prime add
            // it to prime vector
            if (isPrime(i)) prime.add(i)
        }

        // if primes are
        // less than N
        if (prime.size < N) return
        primeSum(0, N, S, 0)
    }


    // function to check
    // prime number
    fun isPrime(x: Int): Boolean {
        // square root of x
        val sqroot = Math.sqrt(x.toDouble()).toInt()

        // since 1 is not
        // prime number
        if (x == 1) return false

        // if any factor is
        // found return false
        for (i in 2..sqroot) if (x % i == 0) return false

        // no factor found
        return true
    }

    // function to display N
    // primes whose sum equals S
    fun display() {
        val length = set.size
        for (i in 0 until length) print(set[i].toString() + " ")
        println()
    }

}