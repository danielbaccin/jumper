package br.com.kenuiapps.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.kenuiapps.jumper.R;
import br.com.kenuiapps.jumper.grafics.Cores;
import br.com.kenuiapps.jumper.grafics.Tela;

/**
 * Created by daniel on 18/04/15.
 */
public class Passaro {

    public static final float X = 100; //centro da circunferencia
    public static final int RAIO = 80;
    private static final Paint COR_VERMELHA = Cores.getCorVermelha();

    private float altura;
    private Tela tela;
    private Bitmap passaro;

    public Passaro(Tela tela, Context context) {
        this.tela = tela;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        passaro = bp.createScaledBitmap(bp, RAIO * 2, RAIO * 2, false);
    }

    public void desenhaNo(Canvas canvas){

        //canvas.drawCircle(X, altura, RAIO, COR_VERMELHA);
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO,  null);
    }

    /* altura 0 representa o topo da tela */
    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao)
        this.altura += 5;
    }

    public void pula() {
        if(altura - RAIO > 0)
            this.altura -= 150;
    }

    public float getAltura() {
        return altura;
    }
}
