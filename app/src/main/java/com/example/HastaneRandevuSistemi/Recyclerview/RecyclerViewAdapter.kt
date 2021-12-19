package com.example.HastaneRandevuSistemi.Recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.HastaneRandevuSistemi.Login.LoginFragmentDirections
import com.example.HastaneRandevuSistemi.R
import com.example.HastaneRandevuSistemi.Sınıf.doktors
import com.example.HastaneRandevuSistemi.takvimsaat.TakvimSaatAyarlamasi

class RecyclerViewAdapter( val mContext: Context, val bolum1 :ArrayList<doktors>) :
    RecyclerView.Adapter<RecyclerViewAdapter.bolumsayisi>()  {


    class bolumsayisi (itemView : View):RecyclerView.ViewHolder(itemView){

        var image :ImageView =itemView.findViewById(R.id.imageView)

    val uzman :TextView=itemView.findViewById(R.id.uzman)
        val cardVieww :CardView =itemView.findViewById(R.id.cardView)


    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bolumsayisi {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)

        return bolumsayisi(itemView)
    }

    override fun onBindViewHolder(holder: bolumsayisi, position: Int) {
     val bolumlist = bolum1.get(position)
        holder.image.setImageResource(mContext.resources.getIdentifier(bolumlist.imageee,"drawable",mContext.packageName))
        holder.uzman.text=bolumlist.doktoradi

        holder.cardVieww.setOnClickListener{
            val intent =Intent(mContext, TakvimSaatAyarlamasi::class.java)

           intent.putExtra("doktorId",bolumlist.doktorId)
            intent.putExtra("doktoradi",bolumlist.doktoradi)
            intent.putExtra("doktorimage",bolumlist.imageee)
            mContext.startActivity(intent)



        }

        }

     override fun getItemCount(): Int {
         return bolum1.size
     }


 }









