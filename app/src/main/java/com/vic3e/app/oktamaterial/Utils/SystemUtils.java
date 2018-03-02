package com.vic3e.app.oktamaterial.Utils;

import android.content.res.Resources;

/**
 * Created by Victory on 3/2/2018.
 */

public class SystemUtils {
    public static int getScreenOrientation() {
        return Resources.getSystem().getConfiguration().orientation;
    }
}
