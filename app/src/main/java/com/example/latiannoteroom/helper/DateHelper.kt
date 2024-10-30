package com.example.latiannoteroom.helper

import android.icu.text.SimpleDateFormat
import java.sql.Date
import java.util.Locale

object DateHelper {
    fun getCurrentDate(): String{
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val date = java.util.Date()
        return dateFormat.format(date)
    }
}