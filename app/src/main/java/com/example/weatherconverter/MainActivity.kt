package com.example.weatherconverter

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.weatherconverter.databinding.ActivityMainBinding
import java.text.DecimalFormat
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "Tag method"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG,"I am on create state")
    }
    fun btnClick(view: View){
        val df = DecimalFormat("#.##")
        val inputCelsius = binding.enterCelsius.text.toString()
        val inputFahrenheit = binding.enterFahrenheit.text.toString()
        var result: String
        if(inputCelsius.isNotEmpty()) {
            result = df.format((inputCelsius.toDouble() * 9 / 5) + 32)
            binding.enterFahrenheit.setText(result)
        }

        if(inputFahrenheit.isNotEmpty() && !inputCelsius.isNotEmpty()){
            result = df.format((inputFahrenheit.toDouble()-32) * 5/9)
            binding.enterCelsius.setText(result)
        }
    }

}

