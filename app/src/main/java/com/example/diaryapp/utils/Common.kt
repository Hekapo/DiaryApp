package com.example.diaryapp.utils

import java.sql.Timestamp

object Common {
    fun tsToString(ts: Timestamp): String {
        val s = ts.toString()
        val time = s.split(" ")[1].split(".")[0]
        val hours = time.split(":")[0]
        val min = time.split(":")[1]
        return "$hours:$min"
    }

}
