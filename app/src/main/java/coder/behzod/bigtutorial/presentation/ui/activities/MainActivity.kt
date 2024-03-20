package coder.behzod.bigtutorial.presentation.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        initViews()

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(this)
        )[MainViewModel::class.java]
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        val tvGetData: TextView = findViewById(R.id.tvGetData)
        val btnGetData: Button = findViewById(R.id.btnGetData)
        val etSaveData: EditText = findViewById(R.id.etSaveData)
        val btnSaveData: Button = findViewById(R.id.btnSaveData)

        btnGetData.setOnClickListener {
            tvGetData.text = viewModel.load()
        }

        btnSaveData.setOnClickListener {
            val text = etSaveData.text.toString()
            val saveName = viewModel.save(text)
        }
    }
}