package br.com.kenuiapps.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.kenuiapps.jumper.R;

/**
 * Created by daniel on 23/11/15.
 */
public class Som {

    private final SoundPool sound;
    public static int PULO;
    public static int PONTOS;
    public static int COLISAO;

    public Som(Context context){
        sound  = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = sound.load(context, R.raw.pulo, 1);
        PONTOS = sound.load(context, R.raw.pontos, 1);
        COLISAO = sound.load(context, R.raw.youlose, 1);
    }

    public void tocaSom(int som){
        sound.play(som, 1, 1, 1, 0,1);
    }
}
