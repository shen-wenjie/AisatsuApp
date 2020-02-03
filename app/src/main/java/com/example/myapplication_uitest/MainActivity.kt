package com.example.myapplication_uitest

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParsePosition
import java.util.*


class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.text = "ボタン"
        button1.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    //2:00 ~ 9:59 では「おはよう」
    //10:00 ~ 17:59 では「こんにちは」
    //18:00 ~ 1:59 では「こんばんは」
    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")


                var t1:Int = 2
                var t2:Int = 10
                var t3:Int = 18

                var tnow = "$hour".toInt()

                if(tnow >= t1 && tnow< t2){
                    textView.setText("おはよう")
                }else if(tnow >= t2 && tnow< t3)
                {
                    textView.setText("こんにちは")
                }
                else
                {
                    textView.setText("こんばんは")
                }
                //textView.setText("$hour:$minute")
            },
            13, 0, true).show()




    }

}

