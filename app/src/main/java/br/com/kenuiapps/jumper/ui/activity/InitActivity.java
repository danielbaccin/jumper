package br.com.kenuiapps.jumper.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.kenuiapps.jumper.R;
import br.com.kenuiapps.jumper.dao.JumperDao;
import br.com.kenuiapps.jumper.elements.Pontuacao;
import br.com.kenuiapps.jumper.util.Constantes;

public class InitActivity extends Activity {

    private ImageView imagemJoao;
    private ImageView imagemMariana;
    private TextView topScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_acttivity);

        imagemJoao = (ImageView) findViewById(R.id.imageView_joao);
        imagemJoao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaGame(Constantes.JOAO);
            }
        });
        imagemMariana = (ImageView) findViewById(R.id.imageView_mariana);
        imagemMariana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaGame(Constantes.MARIANA);
            }
        });
        topScores = (TextView) findViewById(R.id.topscores);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscaTopScore();

    }

    private void buscaTopScore() {
        JumperDao dao = new JumperDao(this);
        Pontuacao pontuacao = dao.buscarMaiorPontuacao();
        topScores.setText(getString(R.string.maior_pontuacao) + pontuacao.getPontos());
    }

    public void iniciaGame(String personagem){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constantes.PERSONAGEM_SELECIONADO, personagem);
        startActivity(intent);
    }



}
