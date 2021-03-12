package com.example.logical

import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

object DateUtility {


    @JvmStatic
    fun main(args: Array<String>) {


        println(getBreachReportDate("2020-08-04T14:00:23Z"))

//        val input = "2015-06-27T13:16:37.363Z"
//        val zone: DateTimeZone = DateTimeZone.UTC //  Or: DateTimeZone.forID( "America/Montreal" ) ;
//
//        val dateTime = DateTime(input, zone)

    }


    private fun getMonthYearUTC(date: String): String {
        val parser = SimpleDateFormat(GLOBAL_TIME_ZONE_FORMAT_0)
        val formatter = SimpleDateFormat(MONTH_YEAR_ONLY)
        val d = parser.parse(date)
        return if (d != null) {
            formatter.format(d)
        } else {
            ""
        }
    }

    private fun getMonthYear(date: String): String {
        return if (!date.isNullOrBlank()) {
            val parser = SimpleDateFormat(DATE_TIME_FORMAT)
            val formatter = SimpleDateFormat(MONTH_YEAR_ONLY)
            val d = parser.parse(date)
            if (d != null) {
                formatter.format(d)
            } else {
                ""
            }
        } else {
            ""
        }
    }

    fun getBreachReportDate(date: String): String {
        return if (date.contains("T")) {
            "reported".plus(" " + getMonthYearUTC(date))
        } else {
            if (date.isNotEmpty()) {
                "reported_text".plus(" " + getMonthYear(date))
            } else {
                ""
            }
        }
    }

}

const val GLOBAL_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val GLOBAL_TIME_ZONE_FORMAT_0 = "yyyy-MM-dd'T'HH:mm:ss"
const val MONTH_YEAR_ONLY = "MMMM yyyy"
const val DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss"
