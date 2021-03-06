package info.kotako.Taaker.Service

import android.app.Application
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.app.NotificationCompat
import info.kotako.Taaker.R
import info.kotako.Taaker.View.MainActivity

class Notification : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        val pendingIntent: PendingIntent =
                PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), PendingIntent.FLAG_CANCEL_CURRENT)

        if (!intent.hasExtra("content")) return
        val msg = intent.getStringExtra("content") + " をする日です!😉"

        val notification: Notification = NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(msg)
                .setContentIntent(pendingIntent)
                .build()

        (context!!.getSystemService(Application.NOTIFICATION_SERVICE) as NotificationManager)
                .notify(R.string.app_name, notification)
    }
}
