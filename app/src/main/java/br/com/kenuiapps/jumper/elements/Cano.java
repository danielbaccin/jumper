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
 * Created by daniel on 19/04/15.
 */
public class Cano {


    private static final Paint VERDE = Cores.getCorVerde();
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;
    private Context context;

    private int alturaDoCanoInferior;
    private Tela tela;
    private int posicao;
    private int alturaDoCanoSuperior;


    public Cano(Tela tela, int posicao, Context context) {

        this.tela = tela;
        this.posicao = posicao;
        this.context = context;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoInferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoSuperior, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperior(canvas);
        desenhaCanoInferior(canvas);
    }

    private void desenhaCanoInferior(Canvas canvas) {
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
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

    public boolean temColisaoHorizontal(Passaro passaro) {
        return this.posicao < passaro.X + passaro.RAIO;
    }

    public boolean temColisaoVertical(Passaro passaro) {
        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }
}
