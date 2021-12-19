package com.example.HastaneRandevuSistemi.takvimsaat

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class takvim(val doktorid:Int ?=0, val buttonindex:Int?=0,val click:Boolean=false){}