package uk.co.jakelee.notificationinterceptor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import android.content.Intent
import android.app.PendingIntent
import android.content.Context
import kotlin.random.Random
import android.provider.Settings.Secure
import android.util.Log


class MainActivity : AppCompatActivity() {

    val currentNotifs = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNotification.setOnClickListener { addNotification() }
        removeNotification.setOnClickListener {  }
        checkListeners.setOnClickListener { checkListeners() }
        addListener.setOnClickListener { addListener() }
    }

    private fun addNotification() {
        val pi = PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), 0)
        val notification = NotificationCompat.Builder(this)
            .setTicker("Ticker text")
            .setSmallIcon(android.R.drawable.ic_menu_info_details)
            .setContentTitle("Content title")
            .setContentText("Content text")
            .setContentIntent(pi)
            .setAutoCancel(true)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = Random.nextInt()
        currentNotifs.add(notificationId)
        notificationManager.notify(notificationId, notification)
    }

    private fun checkListeners() {
        val enabledListeners = Secure.getString(contentResolver, "enabled_notification_listeners")
        Log.d("Listeners", "Size: ${enabledListeners.length}")
    }

    private fun addListener() {
        var enabledListeners = Secure.getString(contentResolver, "enabled_notification_listeners")
        Log.d("Listeners", "Size: ${enabledListeners.length}")

        Secure.putString(contentResolver, "enabled_notification_listeners",
            "$enabledListeners:uk.co.jakelee.notificationinterceptor/uk.co.jakelee.notificationinterceptor.NotificationListener"
        )

        enabledListeners = Secure.getString(contentResolver, "enabled_notification_listeners")
        Log.d("Listeners", "Size: ${enabledListeners.length}")
    }
}
