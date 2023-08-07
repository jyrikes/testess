package com.example.myapplication.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class HttpHelper  {

    fun post(json:String) : String{
        val URL = "http://yrikes.pythonanywhere.com"
        val headerHttp = MediaType.parse("application/json; charset = uff-8")
        val client = OkHttpClient()

        val body = RequestBody.create(headerHttp,json)

        var request = Request.Builder().url(URL).post(body).build()

        val response = client.newCall(request).execute()
        return response.body().toString()
    }

}