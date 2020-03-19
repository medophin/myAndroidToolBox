package com.onemanworkshop.com.myapplicationlambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    suspend fun failedConcurrentSum(): Int = coroutineScope {
        val one = async<Int> {
            delay(1000L) // Emulates very long computation
            3
        }
        val two = async<Int> {
            delay(5000L) // Emulates very long computation
            2
        }
        one.await() + two.await()
    }

    //    var callback: (() -> String)? = null
    private suspend fun apiFire(): String {
        Log.d("debug", "do some job 1sec\n")
        delay(1000L)
        return "api json return\n"
    }

    private suspend fun bleDataBack(): String {
        Log.d("debug", "do ble 1 sec\n")
        delay(1000L)
        return "ble data return\n"
    }


    var job: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myresult = ""
        job?.cancel()
        job = null
        job = CoroutineScope(Dispatchers.IO + Job()).launch {
            myresult = apiFire() + bleDataBack()
            Log.d("debug", "$myresult")
            Log.d("debug", "${failedConcurrentSum()}")
        }



    }
}
