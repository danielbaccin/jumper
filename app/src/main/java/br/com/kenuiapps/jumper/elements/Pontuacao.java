package br.com.kenuiapps.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.kenuiapps.jumper.grafics.Cores;

/**
 * Created by daniel on 23/04/15.
 */
public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);

    }

    public void aumenta() {
        pontos++;
    }
}
