package com.example.myapplication

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.EditText
import android.widget.ImageSwitcher
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sil(num: Int): Long {
        return if (num <= 1) 1
        else num * sil(num - 1)
    }

    class MainActivity : AppCompatActivity() {

        private val GoW = intArrayOf(
            R.drawable.kratos,
            R.drawable.connor, R.drawable.jeff
        )
        private var index = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val imgSwitcher = findViewById<ImageSwitcher>(R.id.obrazek)

            imgSwitcher?.setFactory({
                val imgView = ImageView(applicationContext)
                imgView.scaleType = ImageView.ScaleType.FIT_CENTER
                imgView.setPadding(8, 8, 8, 8)
                imgView
            })
            imgSwitcher?.setImageResource(GoW[index])

            val imgIn = AnimationUtils.loadAnimation(
                this, android.R.anim.slide_in_left
            )
            imgSwitcher?.inAnimation = imgIn

            val imgOut = AnimationUtils.loadAnimation(
                this, android.R.anim.slide_out_right
            )
            imgSwitcher?.outAnimation = imgOut

            val prev = findViewById<Button>(R.id.poprzednie)
            prev.setOnClickListener {
                index = if (index - 1 >= 0) index - 1 else 2
                imgSwitcher?.setImageResource(GoW[index])
            }


            }
        }
    }
