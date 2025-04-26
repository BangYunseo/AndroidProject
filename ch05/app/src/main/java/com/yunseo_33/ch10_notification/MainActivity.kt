package com.yunseo_33.ch10_notification

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yunseo_33.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datePicker = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                Log.d("Yunseo", "YEAR : $year, month : ${month + 1}, dayOfMonth : $dayOfMonth")
            }
        }, 2024, 4, 16)

        binding.datePicker.setOnClickListener{ datePicker.show() }

        val timePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                Log.d("Yunseo", "time : $hourOfDay, minute : $minute")
            }
        }, 15, 0, true)

        binding.timePicker.setOnClickListener{ timePicker.show() }

        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if(dialog == DialogInterface.BUTTON_POSITIVE){
                    Log.d("Yunseo", "positive button clicked")
                } else if(which == DialogInterface.BUTTON_NEGATIVE) {
                    Log.d("Yunseo", "negative button clicked")
                }
            }
        }

        val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
        AlertDialog.Builder(this).run {
            setTitle("item test")
            setIcon(android.R.drawable.ic_dialog_info)
            setItems(items, object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, p1: Int){
                    Log.d("Yunseo", "선택한 과일 : ${items[p1]}")
                }
            })
            setPositiveButton("닫기", null)
            show()
        }

        @RequiresApi(Build.VERSION_CODES.R)
        fun showToast(){
            val toast = Toast.makeText(this, "종료하려면 한 번 더 누르세요.", Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("Yunseo", "toast hidden")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("Yunseo", "toast hidden")
                    }
                })
            toast.show()
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}