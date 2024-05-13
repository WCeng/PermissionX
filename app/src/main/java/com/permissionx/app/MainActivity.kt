package com.permissionx.app

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.permissionx.wangchengdev.PermissionX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.makeCallBtn)
        button.setOnClickListener {
            PermissionX.request(
                this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA
            ) { allGranted, deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(
                        this,
                        "you denied $deniedList",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:10010")
        startActivity(intent)
    }
}