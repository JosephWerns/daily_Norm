package com.flexlogix.dailynorm.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.flexlogix.dailynorm.R
import com.flexlogix.dailynorm.utils.AlarmUtils
import com.flexlogix.dailynorm.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alarmToggle = binding.alarmToggle

        alarmToggle.setOnCheckedChangeListener { _, isChecked ->
            val toastMessage = if (isChecked) {
                AlarmUtils.setAlarm(this)
                "Daily Norm quotes has been turned on"
            } else {
                AlarmUtils.cancelAlarm(this)
                "Daily Norm quotes has been turned off"
            }
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
        }
    }
}

