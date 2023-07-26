package com.example.apirest

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL

class HTTPUtils {

    fun getTest(){
        val url = URL("http://192.168.3.227:8080/test")
        val httpURLConnection = url.openConnection() as HttpURLConnection

        httpURLConnection.requestMethod = "GET"
        httpURLConnection.setRequestProperty(
           "Accept", "application/json"
        )
        httpURLConnection.doInput = true
        //httpURLConnection.doOutput = true

        val responseCode = httpURLConnection.responseCode

        if (responseCode == HttpURLConnection.HTTP_OK) {
            val response = httpURLConnection.inputStream.bufferedReader().use {
                it.readText()
            }
            Log.d("HTTP", response)
        }
    }
}