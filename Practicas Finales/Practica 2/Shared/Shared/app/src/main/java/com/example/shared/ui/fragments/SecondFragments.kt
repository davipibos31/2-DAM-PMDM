package com.example.shared.ui.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.shared.*
import com.example.shared.ui.model.DBHelperApplication
import kotlinx.android.synthetic.main.principal_activity.*
import kotlinx.android.synthetic.main.principal_activity.view.*
import kotlinx.android.synthetic.main.second_activity.*
import kotlinx.android.synthetic.main.second_activity.view.*

@Suppress("DEPRECATION")
class SecondFragments : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.second_activity,
            container,
            false
        )
        meterListen(view)
        iniVie(view)
        sacFoto(view)
        gallistener(view)
        camVentListen(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        meterListen(view)
        iniVie(view)
        sacFoto(view)
        gallistener(view)
        camVentListen(view)
    }

    private fun iniVie(view: View) { inSpClass(view) }

    private fun inSpClass(view: View) {

        ArrayAdapter.createFromResource(requireContext(), R.array.amor_array, android.R.layout.simple_spinner_item).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.amor4.adapter = adapter
        }
    }

    private fun meterListen(view: View) {
        view.btnañadir2.setOnClickListener {

            Pets.add(Datos(view.nombre4.text.toString(), view.cientifico4.text.toString(), view.pelo4.text.toString(), view.clase4.text.toString(), view.amor4.selectedItem.toString(), view.fotoselec.drawable, view.enlace4.text.toString()))
            Pets.addV2(DatosV2(view.nombre4.text.toString(), view.cientifico4.text.toString(), view.pelo4.text.toString(), view.clase4.text.toString(), view.amor4.selectedItem.toString(), view.fotoselec.drawable.current.toString(), view.enlace4.text.toString()))

            DBHelperApplication.dataSource.addAmigo(view.nombre4.text.toString(), view.cientifico4.text.toString(), view.pelo4.text.toString(), view.clase4.text.toString(), view.amor4.selectedItem.toString(),view.fotoselec.drawable.current.toString(), view.enlace4.text.toString())


            Toast.makeText(requireActivity(), "Nombre: " + view.nombre4.text.toString() + "Nombre cientifico: " + view.cientifico4.text.toString() + "Tipo de pelo: " + view.pelo4.text.toString() + "clase: " + view.clase4.text.toString() + "Amorosidad: " + view.amor4.selectedItem.toString() + "Foto Selecionada " + "Enlace: " + view.enlace4.text.toString() , Toast.LENGTH_SHORT).show()

            view.nombre4.text.clear()
            view.cientifico4.text.clear()
            view.pelo4.text.clear()
            view.clase4.text.clear()
            view.enlace4.text.clear()
        }
    }

    private fun camVentListen(view: View) {

        view.btnsalir.setOnClickListener {
            val myIntent = Intent(requireContext(), requireActivity()::class.java)
            startActivity(myIntent)
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun sacFoto(view: View) {

        view.camara.setOnClickListener {
            val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            if (Permision.checkForPermission(requireContext() as Activity, Manifest.permission.CAMERA, Permision.camCod) == 2) {
                println("TIENE PERMISOS")
                //if (intent.resolveType(requireActivity()) != null) {
                    startActivityForResult(intent, Permision.camCod)
                //}
            } else if (Permision.checkForPermission(requireContext() as Activity, Manifest.permission.CAMERA, Permision.camCod) == 1) {
                Permision.onAlertDialog(requireActivity())
            }
        }
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("QueryPermissionsNeeded")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            Permision.galCod -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                    if (intent.resolveType(requireContext()) != null) {
                        startActivityForResult(intent, Permision.galCod)
                    }
                }
            }

            Permision.camCod -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                    if (intent.resolveType(requireContext()) != null) {
                        startActivityForResult(intent, Permision.camCod)
                    }
                }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Permision.camCod && resultCode == AppCompatActivity.RESULT_OK) {
            val thumbnail: Bitmap = data?.getParcelableExtra("data")!!
            fotoselec.setImageBitmap(thumbnail)
        }
        else if (requestCode == Permision.galCod && resultCode == AppCompatActivity.RESULT_OK){
            val imageURI = data?.data
            fotoselec.setImageURI(imageURI)
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun gallistener(view: View) {

        view.galeria3.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            if (Permision.checkForPermission(requireContext() as Activity, Manifest.permission.READ_EXTERNAL_STORAGE, Permision.galCod) == 2) {
                if (intent.resolveType(requireContext()) != null) {
                    startActivityForResult(intent, Permision.galCod)
                }
            } else if (Permision.checkForPermission(requireContext() as Activity, Manifest.permission.READ_EXTERNAL_STORAGE, Permision.galCod) == 1) {
                Permision.onAlertDialog(requireActivity())
            }
        }
    }
}