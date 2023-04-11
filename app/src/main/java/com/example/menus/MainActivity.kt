package com.example.menus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSms:Button
    lateinit var btnEmail:Button
    lateinit var btnCamera:Button
    lateinit var btnShare:Button
    lateinit var btnMpesa:Button
    lateinit var btnCall:Button
    lateinit var btnWeb:Button
    lateinit var btnMap:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCall = findViewById(R.id.call_btn)
        btnEmail = findViewById(R.id.email_btn)
        btnSms = findViewById(R.id.btn_sms)
        btnCamera = findViewById(R.id.btn_cam)
        btnShare = findViewById(R.id.share_btn)
        btnMpesa = findViewById(R.id.mpesa_btn)
        btnWeb = findViewById(R.id.web_btn)
        btnMap = findViewById(R.id.map_btn)


        btnSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0768301478")
            val intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body","Your ransaction was successful")
            startActivity(intent)

        }

        btnEmail.setOnClickListener {

            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "dufgvjdu@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir i was applying for a post at your company")
            startActivity(Intent.createChooser(emailIntent, "send email"))

        }
        btnCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        btnMpesa.setOnClickListener {
            val simToolkitIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolkitIntent?.let { startActivity(it) }
        }
    }
}