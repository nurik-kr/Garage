package kg.nurik.garage.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class TimeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        Log.d("_______broad", "sms")
        Toast.makeText(context,"YAHOOOOO",Toast.LENGTH_LONG).show()
    }
}