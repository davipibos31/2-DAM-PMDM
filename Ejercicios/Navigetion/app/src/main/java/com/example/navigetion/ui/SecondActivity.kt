package com.example.navigetion.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.pets_items_activity.*
import kotlinx.android.synthetic.main.second_activity.*
import kotlinx.android.synthetic.main.second_activity.btnsalir


@Suppress("DEPRECATION")
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        iniVie()
        camVentListen()
        meterListen()
        sacFoto()
        gallistener()
    }

    private fun iniVie() { inSpClass() }

    private fun inSpClass() {

        ArrayAdapter.createFromResource(this, R.array.amor_array, android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            amor4.adapter = adapter
        }
    }

    private fun meterListen() {
        btnañadir2.setOnClickListener {

            Pets.add(Datos(nombre4.text.toString(), cientifico4.text.toString(), pelo4.text.toString(), clase4.text.toString(), amor4.selectedItem.toString(), fotoselec.drawable, enlace4.text.toString()))
            nombre4.text.clear()
            cientifico4.text.clear()
            pelo4.text.clear()
            clase4.text.clear()
            enlace4.text.clear()

            Toast.makeText(this@SecondActivity, "Nombre: " + nombre4.text.toString() + "Nombre cientifico: " + cientifico4.text.toString() + "Tipo de pelo: " + pelo4.text.toString() + "clase: " + clase4.text.toString() + "Amorosidad: " + amor4.selectedItem.toString() + "Foto Selecioanda " + "Enlace: " + enlace4.text.toString() , Toast.LENGTH_SHORT).show()
        }
    }

    private fun camVentListen() {

        btnsalir.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun sacFoto() {

        camara.setOnClickListener {
            val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))

            if (Permision.checkForPermission(this, Manifest.permission.CAMERA, Permision.camCod) == 2) {
                println("TIENE PERMISOS")
                if (intent.resolveActivity(packageManager) != null) {
                    startActivityForResult(intent, Permision.camCod)
                }
            } else if (Permision.checkForPermission(this, Manifest.permission.CAMERA, Permision.camCod) == 1) {
                Permision.onAlertDialog(this)
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            Permision.galCod -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivityForResult(intent, Permision.galCod)
                    }
                }
            }

            Permision.camCod -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivityForResult(intent, Permision.camCod)
                    }
                }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Permision.camCod && resultCode == RESULT_OK) {
            val thumbnail: Bitmap = data?.getParcelableExtra("data")!!
            fotoselec.setImageBitmap(thumbnail)
        }
        else if (requestCode == Permision.galCod && resultCode == RESULT_OK){
            val imageURI = data?.data
            fotoselec.setImageURI(imageURI)
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun gallistener() {

        galeria3.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            if (Permision.checkForPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE, Permision.galCod) == 2) {
                if (intent.resolveActivity(packageManager) != null) {
                    startActivityForResult(intent, Permision.galCod)
                }
            } else if (Permision.checkForPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE, Permision.galCod) == 1) {
                Permision.onAlertDialog(this)
            }
        }
    }
}