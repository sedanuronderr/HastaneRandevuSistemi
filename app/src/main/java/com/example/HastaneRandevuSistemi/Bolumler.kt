package com.example.HastaneRandevuSistemi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.HastaneRandevuSistemi.Login.LoginFragment
import com.example.HastaneRandevuSistemi.Login.LoginFragmentDirections
import com.example.HastaneRandevuSistemi.Sınıf.FragmentBolum1
import com.example.HastaneRandevuSistemi.Sınıf.FragmentBolum2
import com.example.HastaneRandevuSistemi.Sınıf.FragmentBolum3
import com.example.HastaneRandevuSistemi.takvimsaat.BlankFragment
import com.example.HastaneRandevuSistemi.takvimsaat.TakvimSaatAyarlamasi
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_bolumler.*


class Bolumler : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val fragmentList = ArrayList<Fragment>()
    private val baslikList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bolumler)
        auth = Firebase.auth

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fragmentList.add(FragmentBolum1())
        fragmentList.add(FragmentBolum2())
        fragmentList.add(FragmentBolum3())

        val adapter = MyviewPagerAdapter(this)
        viewpager2.adapter = adapter

        baslikList.add("Dahiliye")
        baslikList.add("Kardoyoloji")
        baslikList.add("Genel Cerrah")

        TabLayoutMediator(tabLayout, viewpager2) { tab, position ->
            tab.setText(baslikList[position])

        }.attach()

    }


    inner class MyviewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }


    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
          R.id.SignOut ->{


              val mFragment = LoginFragment()
              val fragment:Fragment?=
              supportFragmentManager.findFragmentByTag(LoginFragment::class.java.simpleName)
                  if(fragment !is LoginFragment){
                      supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,mFragment,LoginFragment::class.java.simpleName).commit()
                  }
          }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}


