package coder.behzod.bigtutorial.presentation.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coder.behzod.bigtutorial.R
import coder.behzod.bigtutorial.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

        val tvGetData: TextView = findViewById(R.id.tvGetData)
        val btnGetData: Button = findViewById(R.id.btnGetData)
        val etSaveData: EditText = findViewById(R.id.etSaveData)
        val btnSaveData: Button = findViewById(R.id.btnSaveData)

        viewModel.liveData.observe(this, Observer {
            tvGetData.text = it
        })

        btnGetData.setOnClickListener {
            viewModel.load()
        }

        btnSaveData.setOnClickListener {
            val text = etSaveData.text.toString()
            viewModel.save(text)
        }
    }
}