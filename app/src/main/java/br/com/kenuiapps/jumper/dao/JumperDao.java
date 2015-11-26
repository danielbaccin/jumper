package br.com.kenuiapps.jumper.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;

import br.com.kenuiapps.jumper.R;
import br.com.kenuiapps.jumper.elements.Pontuacao;
import br.com.kenuiapps.jumper.util.Constantes;

/**
 * Created by danielbaccin on 25/11/15.
 */
public class JumperDao {
    private Context mContext;
    private DbHelper dbHelper;
    private SQLiteDatabase db = null;
    private static JumperDao instance;

    public JumperDao(Context context) {
        super();
        this.mContext = context;

    }

    public static JumperDao getInstance(Context context) {
        if (instance == null) {
            synchronized (JumperDao.class) {
                if (instance == null) {
                    instance = new JumperDao(context);
                }
            }
        }
        return instance;
    }

    private void openConnection() {

        try {
            this.dbHelper = new DbHelper(this.mContext);
            db = dbHelper.getWritableDatabase();
        } catch (Exception e) {

            Log.e(Constantes.TAG, "Erro ao abrir conex?es JumperDao");
        }
    }

    private void closeConnection() {
        try {
            if (null != db) {
                db.close();
                db = null;
                dbHelper.close();
            }

        } catch (Exception e) {
            Log.e(Constantes.TAG, "Erro ao fechar conex?es JumperDao");
        }
    }

    public boolean salvaPontuacao(Pontuacao pontuacao) {

        if (pontuacao != null) {

            try {
                openConnection();

                ContentValues campos = new ContentValues();

                campos.put(Constantes.PONTUACAO_NOME, pontuacao.getNome());
                campos.put(Constantes.PONTUACAO_DATA, pontuacao.getData().getTime());
                campos.put(Constantes.PONTUACAO_PONTOS, pontuacao.getPontos());

                try {
                    return ( db.insertOrThrow(Constantes.TABELA_PONTUACAO, Constantes.DATABASE, campos) != -1);
                } catch (Exception e) {
                    e.getMessage();
                    Log.e(Constantes.TAG, "insert: " + mContext.getString(R.string.app_name));
                }

            } finally {
                closeConnection();
            }
        }

        return false;
    }

    public Pontuacao buscarMaiorPontuacao(){
        openConnection();
        Cursor cursor = db.rawQuery("SELECT nome, data, MAX(pontos) as pontos FROM pontuacao", null);
        if(cursor.moveToNext()){
            Pontuacao pontuacao = criarPontuacao(cursor);
            cursor.close();
            return pontuacao;
        }
        closeConnection();
        return null;
    }

    private Pontuacao criarPontuacao(Cursor cursor) {
        Pontuacao pontuacao = new Pontuacao(
                cursor.getString(cursor.getColumnIndex(Constantes.PONTUACAO_NOME)),
                new Date(cursor.getLong(cursor.getColumnIndex(Constantes.PONTUACAO_DATA))),
                cursor.getInt(cursor.getColumnIndex(Constantes.PONTUACAO_PONTOS))
        );
        return pontuacao;
    }


}
