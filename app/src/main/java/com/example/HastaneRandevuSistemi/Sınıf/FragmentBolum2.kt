package com.example.HastaneRandevuSistemi.Sınıf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.HastaneRandevuSistemi.R
import com.example.HastaneRandevuSistemi.Recyclerview.RecyclerViewAdapter
import kotlinx.android.synthetic.main.bolum1.*
import kotlinx.android.synthetic.main.bolum1.recyclerView
import kotlinx.android.synthetic.main.bolum2.*

class FragmentBolum2 :Fragment() {

    private lateinit var bolumlerList:ArrayList<doktors>
    private lateinit var adapter: RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bolum2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(requireContext())

        val u1 = doktors(1,"doktor","Prof. Dr. Mehmet Yalçın","Randevu Al")
        val u2 = doktors(2,"doktor2","Uzman Dr. lale Baş","Randevu Al")
        val u3 = doktors(3,"doktor3","Dr. Emir Yağcı","Randevu Al")
        val u4 = doktors(4,"doktor4","Uzman Dr. Ayşe Bilir","Randevu Al")
        val u5 = doktors(5,"doktor5","Prof.Dr. Ali Göksu","Randevu Al")


        bolumlerList=ArrayList<doktors>()
        bolumlerList.add(u1)
        bolumlerList.add(u2)
        bolumlerList.add(u3)
        bolumlerList.add(u4)
        bolumlerList.add(u5)


        adapter= RecyclerViewAdapter(requireContext(),bolumlerList)
        recyclerView2.adapter=adapter
    }

}