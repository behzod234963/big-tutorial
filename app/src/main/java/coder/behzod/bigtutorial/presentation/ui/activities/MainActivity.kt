package coder.behzod.bigtutorial.presentation.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coder.behzod.bigtutorial.R
import coder.behzod.bigtutorial.factory.MainViewModelFactory
import coder.behzod.bigtutorial.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(this)
        )[MainViewModel::class.java]
        initViews()
    }

    @SuppressLint("SetTextI18n")
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