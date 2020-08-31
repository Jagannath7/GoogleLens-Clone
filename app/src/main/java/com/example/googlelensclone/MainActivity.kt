package com.example.googlelensclone

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic val REQ_CODE = 123
        @JvmStatic val EXTRA_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener {
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePhotoIntent, REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){


        if(requestCode == REQ_CODE){
            val bitmap = data?.extras?.get(EXTRA_DATA) as Bitmap
            img.setImageBitmap(bitmap)
            return
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}