package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnsec = findViewById<Button>(R.id.button2)
        val ttext = findViewById<TextView>(R.id.textView4)

        val bundle = intent.getBundleExtra("key")
        val phnum = bundle?.getString("name", "")
        val adults = bundle?.getInt("adults", 0)
        val children = bundle?.getInt("children", 0)
        val needChildSeat = bundle?.getBoolean("needChildSeat", false)
        val needChildUtensils = bundle?.getBoolean("needChildUtensils", false)

        var aba ="";
        if(needChildSeat==true&&needChildUtensils==true){
            aba = "需要兒童椅、兒童餐具";
        }
        if(needChildSeat==true&&needChildUtensils==false){
            aba = "需要兒童椅";
        }
        if(needChildSeat==false&&needChildUtensils==true){
            aba = "需要兒童餐具";
        }
        if(needChildSeat==false&&needChildUtensils==false){
            aba = "";
        }
        val displayText = "訂位號碼: $phnum\n" +
                "訂位人數: $adults" +"大"+
                "$children" +"小\n"+
                "$aba\n"

        ttext.text = displayText


        btnsec.setOnClickListener{
            var mainintent = Intent(this,MainActivity::class.java)
            startActivity(mainintent);
        }
    }
}