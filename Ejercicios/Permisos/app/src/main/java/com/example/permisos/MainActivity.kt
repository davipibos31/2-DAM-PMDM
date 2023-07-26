package com.example.permisos

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //llamamos a la funcion
        setListener()
    }

    private fun openCamera() {
        btnabrircamra.setOnClickListener {
            //1.- Si el permiso esta concedido
            //2.- Si el usuario ya lo ha rechazado
            //  2.1.- Si lo ha rechazado mostrar popup con el mensaje
            //  2.2.- Si el usuario es la primera vez, se le mostrara el popup permiso
            // 3.- Si ha dado el permiso ya


            //1.- Si el permiso esta concedido
            if (ContextCompat.checkSelfPermission
                    (this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
            ) {

                //2.- Si el usuario ya lo ha rechazado
                if (ActivityCompat.shouldShowRequestPermissionRationale
                        (this, Manifest.permission.CAMERA)
                ) {
                    //  2.1.- Si lo ha rechazado mostrar popup con el mensaje
                } else {
                    //  2.2.- Si el usuario es la primera vez, se le mostrara el popup permiso
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CAMERA), 12345
                    )
                }
            } else {
                val intent = Intent(
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                )
                startActivity(intent)
            }
        }
    }

    //funcion para llamar al navegador
    private fun setListener() {
        btnabrirweb.setOnClickListener {
            openWeb("https://www.javercarrasco.es")
        }
        btnllamada.setOnClickListener {
            callphone("tel:601275932")
        }
        btnabrircamra.setOnClickListener {
            openCamera()
        }
        btnSMS.setOnClickListener {
            sms()
        }
        btncorreo.setOnClickListener {
            correo()
        }

    }

    private fun openWeb(url: String) {
        btnabrirweb.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.javiercarrasco.es")
            )
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("DEBUG", "Hay un problema para encontrar un navegador.")
            }
        }
    }

    private fun callphone(url: String) {
        val callIntent = Intent(
            Intent.ACTION_CALL,
            Uri.parse("tel:601275932")
        )

        PermisionManager().checkPermision(
            this,
            Manifest.permission.CALL_PHONE, 1234, callIntent
        )

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
                    Log.d("DEBUG", "Permiso concedido!!")
                    val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:601275932"))
                    startActivity(callIntent)
                } else {
                    Log.d("DEBUG", "Permiso cancelado!!")
                }
            }
            12345 -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    Log.d("DEBUG", "Permiso concedido!!")
                    val intent = Intent(
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    )
                    startActivity(intent)
                } else {
                    Log.d("DEBUG", "Permiso cancelado!!")
                }
            }

        }
    }

    private fun sms() {
        btnSMS.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("smsto:" + 777666777)
            )

            intent.putExtra("sms_body", "Cuerpo del mensaje")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    private fun correo() {
        btncorreo.setOnClickListener {
            val TO = arrayOf("javier@javiercarrasco.es")
            val CC = arrayOf("")
            val intent = Intent(Intent.ACTION_SEND)

            intent.type = "text/html" // o también text/plain
            intent.putExtra(Intent.EXTRA_EMAIL, TO)
            intent.putExtra(Intent.EXTRA_CC, CC)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Envío de un email desde Kotlin")
            intent.putExtra(Intent.EXTRA_TEXT, "Esta es mi prueba de envío de un correo.")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Enviar correo..."))
            }
        }
    }

    private fun photo() {
        btncamararesultado.setOnClickListener {
            val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))

            PermisionManager().checkPermissionForResult(
                this, Manifest.permission.CAMERA,1245,intent,123,
            )

            }
        }
    }
}