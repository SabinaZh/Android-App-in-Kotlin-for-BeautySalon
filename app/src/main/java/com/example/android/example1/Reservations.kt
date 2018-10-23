package com.example.android.example1

/**
 * Created by Android on 13.12.2017.
 */
class Reservations (val id:String,val yourname:String, val telefon:String, val procedure:String,
                    val day:String, val hour:String, val notes:String) {

    constructor():this("","","","","","",""){}
}