package br.com.kenuiapps.jumper.grafics;

import android.graphics.Paint;

/**
 * Created by daniel on 18/04/15.
 */
public class Cores {


    private static Paint corVerde;

    public static Paint getCorVermelha() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getCorVerde() {
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);
        return paint;
    }
}
