package br.com.kenuiapps.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.kenuiapps.jumper.grafics.Cores;
import br.com.kenuiapps.jumper.grafics.Tela;

/**
 * Created by daniel on 19/04/15.
 */
public class Cano {


    private static final Paint VERDE = Cores.getCorVerde();
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;

    private float alturaDoCanoInferior;
    private Tela tela;
    private int posicao;
    private float alturaDoCanoSuperior;


    public Cano(Tela tela, int posicao) {

        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperior(canvas);
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
    }

    public void move() {
        posicao -= 5;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO  < 0;
    }

    public int getPosicao() {
        return posicao;
    }
}
