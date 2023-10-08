package com.example.latihanandroidstudio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var tvHistory:TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val Data:Intent? = result.data
            val returnString:String? = Data?.getStringExtra("History")
            tvHistory.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvHistory = findViewById(R.id.tv_History)
        etUsername = findViewById(R.id.edt_Username)
        etPassword = findViewById(R.id.edt_Password)

        val bundle = intent.extras
        if (bundle != null) {
            etUsername.setText(bundle.getString("Username"))
            etPassword.setText(bundle.getString("Password"))
        }

        val btnlogin: Button = findViewById(R.id.btn_Login)
        btnlogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_Login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User",User(etUsername.text.toString(),etPassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }


}