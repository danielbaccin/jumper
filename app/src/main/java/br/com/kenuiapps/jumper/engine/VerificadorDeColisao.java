package br.com.kenuiapps.jumper.engine;

import br.com.kenuiapps.jumper.elements.Canos;
import br.com.kenuiapps.jumper.elements.Passaro;

/**
 * Created by daniel on 27/04/15.
 */
public class VerificadorDeColisao {

    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {

        return canos.temColisaoCom(passaro);
    }
}
