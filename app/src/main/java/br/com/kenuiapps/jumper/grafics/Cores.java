package br.com.kenuiapps.jumper.grafics;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by daniel on 18/04/15.
 */
public class Cores {


    private static Paint corVerde;
    private static float corBranca;

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

    public static Paint getCorDaPontuacao() {
        Paint branco= new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5, 0xFF000000);
        return branco;
    }
}
