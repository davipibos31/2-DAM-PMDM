package com.example.shared

import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Permision{

    companion object {
        const val camCod = 1234
        const val galCod = 12345

        fun checkForPermission(activity: Activity, permission: String, requestCode: Int): Int {
            var haspermission = 0
            val permissionResult = ContextCompat.checkSelfPermission(activity, permission)
            if (permissionResult != PackageManager.PERMISSION_GRANTED) {
                if(ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)){
                    ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode)
                } else {
                    haspermission = 1
                }
            } else {
               haspermission = 2
            }
            return haspermission
        }

        fun onAlertDialog(activity: Activity) {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Permisos denegados")
            builder.setMessage("Por favor activa los permisos")
            builder.setNeutralButton("OK") { _, _ -> }
            builder.show()
        }
    }
}