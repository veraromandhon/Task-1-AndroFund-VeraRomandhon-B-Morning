package com.example.latihanandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val Username =intent.getParcelableExtra<User>("User")?.Username
        val Password =intent.getParcelableExtra<User>("User")?.Password
        tv.text = "Username: $Username dan Password:$Password"

        val btnImplicit: Button = findViewById(R.id.btn_Implicit)
        btnImplicit.setOnClickListener(this)

        val btnFragment: Button = findViewById(R.id.btn_Fragment)
        btnFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_Implicit -> {
//                val message = "Ping!!!"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "Text/Plain"
//                startActivity(intent)
                val intent = Intent()
                intent.putExtra("History", "Anda Sudah Login")
                setResult(RESULT_OK,intent)
                finish()
            }
            R.id.btn_Fragment -> {
                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}