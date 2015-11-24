package br.com.kenuiapps.jumper.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.kenuiapps.jumper.R;
import br.com.kenuiapps.jumper.engine.Game;
import br.com.kenuiapps.jumper.util.Constantes;


public class MainActivity extends Activity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String personagemSelecionado = getIntent().getExtras().getString(Constantes.PERSONAGEM_SELECIONADO);

        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        game = new Game(this,personagemSelecionado);
        container.addView(game);

    }

    @Override
    protected void onResume() {
        super.onResume();
        game.inicia();
        new Thread(game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.pausa();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
