package br.com.kenuiapps.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.kenuiapps.jumper.R;
import br.com.kenuiapps.jumper.dao.JumperDao;
import br.com.kenuiapps.jumper.elements.Canos;
import br.com.kenuiapps.jumper.elements.GameOver;
import br.com.kenuiapps.jumper.elements.Passaro;
import br.com.kenuiapps.jumper.elements.Pontuacao;
import br.com.kenuiapps.jumper.grafics.Tela;

/**
 * Created by daniel on 18/04/15.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener{

    private boolean isRunnig;
    private SurfaceHolder holder = getHolder();

    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private Context context;
    private Som som;
    private String personagemSelecionado;
    private JumperDao dao;

    public Game(Context context, String personagemSelecionado) {
        super(context);
        this.context = context;
        this.personagemSelecionado = personagemSelecionado;
        this.dao = new JumperDao(context);

        tela = new Tela(context);
        inicializaELementos();
        setOnTouchListener(this);
    }

    private void inicializaELementos() {
        passaro = new Passaro(tela, context, personagemSelecionado);
        pontuacao = new Pontuacao();
        canos = new Canos(tela, pontuacao, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
        som = new Som(context);

    }

    @Override
    public void run() {
        while (isRunnig){
        if(!holder.getSurface().isValid()) {
            continue;
        }
            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);

            passaro.desenhaNo(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();
            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro, canos).temColisao()){
                som.tocaSom(Som.COLISAO);
                new GameOver(tela).desenhaNo(canvas);
                isRunnig =  false;
                pontuacao.setNome("daniel"); //deixar fixo por enquanto
                dao.salvaPontuacao(pontuacao);
            }

            holder.unlockCanvasAndPost(canvas);


        }
    }

    public void inicia() {
        isRunnig = true;
    }

    public void pausa() {
        isRunnig = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        passaro.pula();
        return false;
    }
}
