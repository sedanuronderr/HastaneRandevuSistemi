package com.example.HastaneRandevuSistemi.takvimsaat

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.example.HastaneRandevuSistemi.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_blank.*



class BlankFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var buttons: List<Button>
lateinit var   database:DatabaseReference
lateinit var takvimlist :MutableList<takvim>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
       val db = Firebase.database
        database = db.getReference("users")
        val bundle = arguments
        val doktorIdd = bundle!!.getInt("doktorId")
        val butonid = bundle.getString("tarihbutton")
        takvimlist= mutableListOf()

        buttons = listOf(randevubutton1, randevubutton2,randevubutton3,randevubutton4,randevubutton5,randevubutton6,randevubutton7,
            randevubutton8,randevubutton9)

        buttons.forEachIndexed { index, button ->
            val no = button.text

    button.setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View?) {

            val ad = AlertDialog.Builder(context)
            ad.setTitle("Randevu Al")
            ad.setMessage("${no} saatinde randevu almak istiyor musunuz?")
            ad.setPositiveButton("Evet") { dialogInterface, i ->
                Toast.makeText(context, "Randevu Alındı", Toast.LENGTH_SHORT).show()
                button.isClickable = false
                val takvimm = takvim(doktorIdd, index, false)


                database.child(auth.currentUser!!.uid).child(doktorIdd!!.toString()).child(butonid!!)
                    .setValue(takvimm)


            }
            ad.setNegativeButton("Hayır") { dialogInterface, i ->
                Toast.makeText(context, "Randevu iptal edildi", Toast.LENGTH_SHORT).show()
            }
            ad.create().show()
        }

    })

        }
       database.child(auth.currentUser!!.uid).child(doktorIdd!!.toString()).child(butonid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


    val post = snapshot.getValue<takvim>()
    Log.e("id"," ${post?.buttonindex.toString()}")
    Log.e("ids", post?.click.toString())
          buttons.forEachIndexed { index, button ->

                   if (index == post?.buttonindex) {
                       button.setBackgroundColor(Color.MAGENTA)
                        button.isEnabled=false
                   }

          }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("hata",error.toException().toString())
            }


        })

/*database.child(auth.currentUser!!.uid).child(butonid!!).get().addOnSuccessListener {

            Log.e("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }

*/
    }





}