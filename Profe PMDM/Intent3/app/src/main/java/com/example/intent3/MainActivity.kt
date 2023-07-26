package com.example.intent3

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        btnWeb.setOnClickListener {
            openWeb("https://www.javiercarrasco.es")
        }

        btnPhone.setOnClickListener {
            call("tel:600020548")
        }

        btnCamera.setOnClickListener {
            val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            startActivity(intent)

            PermissionManager().checkPermission(
                this,
                Manifest.permission.CAMERA,
                1222,
                intent,
            )
        }
    }

    private fun call(tlf: String) {
        val callIntent = Intent(
            Intent.ACTION_CALL,
            Uri.parse(tlf)
        )

        PermissionManager().checkPermission(
            this,
            Manifest.permission.CALL_PHONE,
            1234,
            callIntent,
        )

    }

    private fun openWeb(url: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("DEBUG", "Hay un problema para encontrar un navegador.")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1234 -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    Log.d("DEBUG", "Permiso condedido!!")
                    val callIntent = Intent(
                        Intent.ACTION_CALL,
                        Uri.parse("tel:600020548")
                    )
                    startActivity(callIntent)
                } else {
                    Log.d("DEBUG", "Permiso cancelado!!")
                }
            }
        }
    }
}