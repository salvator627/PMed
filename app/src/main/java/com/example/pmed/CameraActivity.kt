package com.example.pmed


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_camera.*


class CameraActivity : AppCompatActivity() {

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        btn_gallery.setOnClickListener {
            pickImageGallery()
        }

        btn_camera.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),100)
        }else{
            btn_camera.isEnabled = true
        }

        btn_camera.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,101)
        }

    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101){
            var picture : Bitmap? = data?.getParcelableExtra("data")
            imageView9.setImageBitmap(picture)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            btn_camera.isEnabled = false

        }
    }
}