package com.example.HastaneRandevuSistemi.takvimsaat


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.HastaneRandevuSistemi.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_takvim_saat_ayarlamasi.*


class TakvimSaatAyarlamasi : AppCompatActivity() {
    private lateinit var button: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_takvim_saat_ayarlamasi)
     val bolum = intent.getIntExtra("doktorId",0)
        val db= FirebaseDatabase.getInstance()
        val   database = db.getReference("users")
        button = listOf(button1,button2,button3,button4,button5)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button.forEachIndexed { index, button ->
            button.setOnClickListener{

                val mFragmentManager = supportFragmentManager
                val mFragmentTransaction = mFragmentManager.beginTransaction()
                val mFragment = BlankFragment()
                val mBundle = Bundle()

                mBundle.putInt("doktorId",bolum)
                mBundle.putString("tarihbutton", index.toString())
                mFragment.arguments = mBundle

                mFragmentTransaction.add(R.id.fragmentContainerView2, mFragment).commit()
            }
        }


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


}