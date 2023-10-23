package uz.ilhomjon.websokettest1.service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import uz.ilhomjon.websokettest1.utils.MyData

class MyForegroundService : Service() {
    private val handler = Handler()

    var i = 0

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Servisni doimiy qilish
        handler.postDelayed(runnable, 1000)

        // Bunday servisni to'xtatish qiyinroq bo'lsa, START_STICKY ko'rsatmasini qo'llash tavsiya etiladi
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        // Servisni o'zgartirishlarini to'xtatish
        stopForeground(true)
    }

    val runnable = object : Runnable{
        override fun run() {
            startForeground(1, MyData.createNotification(applicationContext, "Taxi narxi: ","sanoq $i"))
            MyData.liveData.postValue(i.toString())
            i++
            handler.postDelayed(this, 1000)
        }

    }
}