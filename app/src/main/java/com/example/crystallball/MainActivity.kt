package com.example.crystallball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crystallball.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Math.random

class MainActivity : AppCompatActivity() {

    var delayValue = 2L
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.predict.setOnClickListener {
            for (count in 0..(4..8).random()){
                MainScope().launch {
                    for(angle in 0..89) {
                        delay(delayValue)
                        binding.predict.rotationX += 1
                    }
                    binding.predict.text = ""
                    for(angle in 0..179) {
                        delay(delayValue)
                        binding.predict.rotationX += 1
                    }
                    binding.predict.text = getPrediction()
                    for(angle in 0..89) {
                        delay(delayValue)
                        binding.predict.rotationX += 1
                    }
                }
            }
        }
    }


    private fun getPrediction(): String {
        return resources.getStringArray(R.array.random_predictions)[randomNumber()]
    }

    private fun randomNumber(): Int {
        val size = resources.getStringArray(R.array.random_predictions).size - 1
        return (0..size).random()
    }

}