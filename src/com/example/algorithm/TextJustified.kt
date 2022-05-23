package com.example.algorithm

class TextJustified {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(
                TextJustified().testJustified(
                    mutableListOf(
                        "this",
                        "is",
                        "an",
                        "example",
                        "of",
                        "text",
                        "justification"
                    ), 16
                )
            )
        }
    }


    fun testJustified(words: MutableList<String>, l: Int): MutableList<String> {
        val lines = mutableListOf<String>()
        var index = 0

        while (index < words.size) {

            var count = words[index].length
            var last = index + 1

            while (last < words.size) {
                if (words[last].length + count + 1 > l) break
                count += words[last].length + 1
                last++
            }

            var line = ""
            val diff = last - index - 1

            if (last == words.size || diff == 0) {
                for (i in index until last) {
                    line = line.plus(words[i]).plus(" ")
                }
                line.trim()

                for (i in line.length until l) {
                    line = line.plus(" ")

                }
            } else {
                val space = (l - count) / diff
                val reminder = (l - count) % diff

                for (i in index until last) {
                    line = line.plus(words[i])

                    if (i < last - 1) {
                        val limit = space + if (i - index < reminder) 1 else 0
                        for (j in 0..limit) {
                            line = line.plus(" ")
                        }
                    }
                }
            }
            lines.add(line)
            index = last
        }

        return lines
    }

}