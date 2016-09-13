package jonalexjm.com.applanzarnotificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * se instancia desde androidManifest.xml ahi podemos configurar las funciones de notificacionIDTokenService y NotificacionService
 * Cse debe tener encuenta las librerias en gradle app y project.. tambien descargar el archivo que se coloca en el app
 */
public class NotificationService extends FirebaseMessagingService {

    public static final String TAG = "FIREBASE";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);// aqui seleccionamos que es el sonido por defecto para las notificaciones

        //este es la configuracion de la notificcion
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)// version NotificationCompat version 4
                .setSmallIcon(R.drawable.linux_client_48)
                .setContentTitle("Notificacion")
                .setContentText(remoteMessage.getNotification().getBody())//sirve para traer el mensaje remoto
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificacion.build());
    }
}
