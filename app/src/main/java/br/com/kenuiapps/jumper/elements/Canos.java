package br.com.kenuiapps.jumper.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import br.com.kenuiapps.jumper.grafics.Tela;

/**
 * Created by daniel on 20/04/15.
 */
public class Canos {


    private static final double QTD_DE_CANOS = 5;
    private static final int POSICAO_INICIAL = 400;
    private static final int DISTANCIA_ENTRE_CANOS = 200;
    private List<Cano> canos = new ArrayList<>();

    public Canos(Tela tela) {
        int posicao = POSICAO_INICIAL;

        for (int i = 0; i < QTD_DE_CANOS; i++) {

            posicao += DISTANCIA_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao);
            canos.add(cano);
        }

    }

    public void desenhaNo(Canvas canvas) {

        for (Cano cano: canos){
            cano.desenhaNo(canvas);
        }
    }

    public void move() {

        for (Cano cano: canos){
            cano.move();
        }

    }
}
