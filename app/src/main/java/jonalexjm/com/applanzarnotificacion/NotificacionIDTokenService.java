package jonalexjm.com.applanzarnotificacion;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * Esta clase nos permite obtener el token asociado a cada dispositivo
 */
public class NotificacionIDTokenService extends FirebaseInstanceIdService {

    private static final String TAG = "FIREBASE_TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }
    private void enviarTokenRegistro(String token){
        Log.d(TAG, token);

    }
}
