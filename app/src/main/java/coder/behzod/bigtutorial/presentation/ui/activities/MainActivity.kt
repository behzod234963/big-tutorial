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
import coder.behzod.bigtutorial.app.BigTutorialApp
import coder.behzod.bigtutorial.presentation.factory.MainViewModelFactory
import coder.behzod.bigtutorial.presentation.viewModel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory:MainViewModelFactory
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initViews()
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {

        (applicationContext as BigTutorialApp).appComponent.inject(this)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
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