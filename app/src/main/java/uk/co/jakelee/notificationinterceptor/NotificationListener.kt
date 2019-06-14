package uk.co.jakelee.notificationinterceptor

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class NotificationListener : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val a = sbn
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
        val b = sbn
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        val c = 10
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        val d = 10
    }

}