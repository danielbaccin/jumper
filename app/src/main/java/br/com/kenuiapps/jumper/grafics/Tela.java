package br.com.kenuiapps.jumper.grafics;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by daniel on 18/04/15.
 */
public class Tela {

    private final DisplayMetrics metrics;

    public Tela(Context context) {
        WindowManager windowsManage = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = windowsManage.getDefaultDisplay();
        metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
    }

    public int getAltura(){
       return metrics.heightPixels;
    }
}
