package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textnum = findViewById<EditText>(R.id.editTextTextPersonName2)
        val spnnum = findViewById<Spinner>(R.id.spinner)
        val spnnum2 = findViewById<Spinner>(R.id.spinner2)
        val adapter = ArrayAdapter.createFromResource(this,R.array.number,android.R.layout.simple_spinner_dropdown_item)
        val chkbox = findViewById<CheckBox>(R.id.checkBox)
        val chkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val button = findViewById<Button>(R.id.button)

        spnnum.adapter = adapter;
        spnnum2.adapter = adapter;
        var adultsCount = 0
        var childrenCount = 0

        spnnum.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val num = resources.getStringArray(R.array.number)
                if(p2 > 0) {
                    adultsCount = num[p2].toInt()
                    // 更新顯示或執行其他操作
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spnnum2.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val num = resources.getStringArray(R.array.number)
                if(p2 > 0) {
                    childrenCount = num[p2].toInt()
                    // 更新顯示或執行其他操作
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        button.setOnClickListener{
            val phnum = textnum.text.toString()
            val bundle = Bundle().apply {
                putString("name", phnum)
                putInt("adults", adultsCount)
                putInt("children", childrenCount)
                putBoolean("needChildSeat", chkbox.isChecked)
                putBoolean("needChildUtensils", chkbox2.isChecked)
            }

            Log.e("MainActivity", "Reservation Number: $phnum")
            Log.e("MainActivity", "Adults: $adultsCount")
            Log.e("MainActivity", "Children: $childrenCount")
            Log.e("MainActivity", "Need Child Seat: ${chkbox.isChecked}")
            Log.e("MainActivity", "Need Child Utensils: ${chkbox2.isChecked}")

            val secondIntent = Intent(this, MainActivity2::class.java).apply {
                putExtra("key", bundle)
            }

            startActivity(secondIntent)
        }

    }
}
