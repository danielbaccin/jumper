package br.com.kenuiapps.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.kenuiapps.jumper.grafics.Cores;

/**
 * Created by daniel on 18/04/15.
 */
public class Passaro {

    private static final float X = 100;
    private static final float RAIO = 100;
    private static final Paint COR_VERMELHA = Cores.getCorVermelha();

    private float altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, COR_VERMELHA);
    }

    /* altura 0 representa o topo da tela */
    public void cai() {
        this.altura += 5;
    }

    public void pula() {
        this.altura -= 150;
    }
}
