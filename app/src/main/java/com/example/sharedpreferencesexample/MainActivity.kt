package com.example.sharedpreferencesexample

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //SheredPrefernes oyektini basda yaradaq.
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        //Interfeys elementlerini tapaq Kohne yolla
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val imageView = findViewById<ImageView>(R.id.imageView)


        //Evvel saxlamis deyeri oxuyaq ve Saxlayaq
        val savedName = sharedPreferences.getString("username", "Melumat Yoxdur")
        textViewResult.text = savedName

        //Duymede klik edildikde melumati yadda saxlayin
        btnSave.setOnClickListener {
            val name = editTextName.text.toString()

            if (name.isEmpty()) {
                textViewResult.text = "Xanani Bos buraxmayin"

            } else {

                //SheredPrefernese deyeri yazaq
                val editor = sharedPreferences.edit()
                editor.putString("username", name)
                editor.apply()

                // Yeni deyeri gosterek
                textViewResult.text = "Yeni Yazilan : $name"

            }
        }
        //Animasiya elave edek
        val animation = AnimationUtils.loadAnimation(this,R.anim.image_animation)
        imageView.startAnimation(animation)

    }
}
