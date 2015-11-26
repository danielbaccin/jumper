package br.com.kenuiapps.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Date;

import br.com.kenuiapps.jumper.grafics.Cores;

/**
 * Created by daniel on 23/04/15.
 */
public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();

    private int id;
    private int pontos = 0;
    private String nome;
    private Date data = new Date();

    public Pontuacao() {  this.data = new Date(); }


    public Pontuacao(String nome, Date data, int pontos) {
        this.nome = nome;
        this.data = data;
        this.pontos = pontos;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);
    }

    public void aumenta() {
        pontos++;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
