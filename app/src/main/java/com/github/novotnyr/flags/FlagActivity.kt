package com.github.novotnyr.flags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FlagActivity : AppCompatActivity() {
    lateinit var flagImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)

        flagImageView = findViewById(R.id.flagImageView)

        val flag = intent.extras!!.get("flag") as Flag
        flagImageView.setImageResource(flag.image)
    }
}