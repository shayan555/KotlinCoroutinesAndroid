package com.example.kotlincoroutinesandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Coroutines2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines2)

        val btnCodeRun = findViewById<Button>(R.id.btn_run_code)

        btnCodeRun.setOnClickListener()
        {
//            Thread.sleep(3000)
//            showMessage()   //Blocking call

            CoroutineScope(Dispatchers.Main.immediate).launch {
                delay(3000)
                showMessage()
            }
            //Suspending call
        }
    }

    fun showMessage(){
        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
    }
}