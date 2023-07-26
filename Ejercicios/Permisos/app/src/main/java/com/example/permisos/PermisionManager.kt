package com.example.permisos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class PermisionManager {


    fun checkPermision(activity: Activity, permision: String, requestCode : Int, intent: Intent){
            //1.- Si el permiso esta concedido
            //2.- Si el usuario ya lo ha rechazado
            //  2.1.- Si lo ha rechazado mostrar popup con el mensaje
            //  2.2.- Si el usuario es la primera vez, se le mostrara el popup permiso
            // 3.- Si ha dado el permiso ya


            //1.- Si el permiso esta concedido
            if (ContextCompat.checkSelfPermission
                    (activity, permision)
                != PackageManager.PERMISSION_GRANTED){

                //2.- Si el usuario ya lo ha rechazado
                if (ActivityCompat.shouldShowRequestPermissionRationale
                        (activity, permision)) {
                    //  2.1.- Si lo ha rechazado mostrar popup con el mensaje
                    ActivityCompat.requestPermissions(activity,
                        arrayOf(permision),requestCode)
                } else {
                    //  2.2.- Si el usuario es la primera vez, se le mostrara el popup permiso
                    ActivityCompat.requestPermissions(activity,
                        arrayOf(permision),requestCode)
                }
            } else {
                activity.startActivity(intent)
            }
    }
}