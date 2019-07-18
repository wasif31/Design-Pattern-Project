
package  com.example.addmovie.SingleResponsibility;

import android.content.Context;
import android.provider.Settings;

public class AirplaneMoodDetect {

    public static boolean isAirplaneModeOn(Context context) {

        return Settings.System.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

    }
}

