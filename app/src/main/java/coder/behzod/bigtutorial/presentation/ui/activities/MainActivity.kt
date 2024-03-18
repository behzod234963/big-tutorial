package coder.behzod.bigtutorial.presentation.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import coder.behzod.bigtutorial.R
import coder.behzod.data.models.GetUserModel
import coder.behzod.data.models.SaveUserModel
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase()
    private val saveUserNameUseCase = coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initViews()
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        val tvGetData:TextView = findViewById(R.id.tvGetData)
        val btnGetData:Button = findViewById(R.id.btnGetData)
        val etSaveData:EditText = findViewById(R.id.etSaveData)
        val btnSaveData:Button = findViewById(R.id.btnSaveData)

        btnGetData.setOnClickListener {
            val getData: coder.behzod.data.models.GetUserModel = getUserNameUseCase.execute()
            tvGetData.text = "${getData.firstName} ${getData.lastName}"
        }
        btnSaveData.setOnClickListener {
            val text = etSaveData.text.toString()
            val saveName = coder.behzod.data.models.SaveUserModel(text)
            val result = saveUserNameUseCase.execute(saveName)
            tvGetData.text = "Save result = $result"
        }
    }
}