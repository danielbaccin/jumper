package br.com.kenuiapps.jumper;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import br.com.kenuiapps.jumper.dao.JumperDao;
import br.com.kenuiapps.jumper.elements.Pontuacao;
import br.com.kenuiapps.jumper.util.Constantes;

/**
 * Created by daniel on 26/11/15.
 */
public class JumperDaoTest extends AndroidTestCase {

    public void testInsertDb()
    {
        JumperDao dao = new JumperDao(mContext);
        boolean salvou = dao.salvaPontuacao(dadoUmaPontuacao(10));
        assertTrue(salvou);
    }


    public void testDeveriaValidarMaiorPontuacao()
    {
        mContext.deleteDatabase(Constantes.DATABASE);
        JumperDao dao = new JumperDao(mContext);
        dao.salvaPontuacao(dadoUmaPontuacao(10));
        dao.salvaPontuacao(dadoUmaPontuacao(30));
        dao.salvaPontuacao(dadoUmaPontuacao(20));
        Pontuacao pontuacao = dao.buscarMaiorPontuacao();
        assertEquals("maior pontuacao", 30, pontuacao.getPontos());
    }

    private Pontuacao dadoUmaPontuacao(int pontos) {
        Pontuacao ponttuacao = new Pontuacao();
        ponttuacao.setNome("teste");
        ponttuacao.setPontos(pontos);
        return ponttuacao;
    }



}
