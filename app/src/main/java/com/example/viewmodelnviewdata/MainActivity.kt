package com.example.viewmodelnviewdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)

//        tvCount.text = count.toString()
//        tvCount.text = viewModel.count.toString()
        viewModel.count.observe(this) {
            tvCount.text = it.toString()
        }

        btnCount.setOnClickListener {
//            ++count
            viewModel.updateCount()
//            tvCount.text = viewModel.count.toString()

        }
    }
}