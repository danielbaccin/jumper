package br.com.kenuiapps.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.kenuiapps.jumper.grafics.Cores;
import br.com.kenuiapps.jumper.grafics.Tela;

/**
 * Created by daniel on 18/04/15.
 */
public class Passaro {

    public static final float X = 100;
    public static final float RAIO = 100;
    private static final Paint COR_VERMELHA = Cores.getCorVermelha();

    private float altura;
    private Tela tela;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, COR_VERMELHA);
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
