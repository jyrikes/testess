package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.http.HttpHelper
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao: Button = findViewById(R.id.bt)
        val user: User = User(10, 10)

        botao.setOnClickListener {
            val gson = Gson()
            val userJson = gson.toJson(user)

            // Chame a AsyncTask para realizar a chamada de rede em uma thread separada
           print( NetworkTask().execute(userJson))
        }
    }

    private inner class NetworkTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String): String {
            val userJson = params[0]

            // Realize a chamada de rede aqui usando o HttpHelper
            val http = HttpHelper()
            val response = http.post(userJson)

            return response
        }

        override fun onPostExecute(result: String) {
            // Trate a resposta da chamada de rede aqui
            // O resultado está na variável 'result'
        }
    }
}
