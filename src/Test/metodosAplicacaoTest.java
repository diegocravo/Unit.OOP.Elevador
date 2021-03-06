package Test;

import Application.*;
import Entities.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class metodosAplicacaoTest {

    @Test
    public void prioridadeElevador() {
        Elevador elevador1 = new Elevador(01, true, true);
        Elevador elevador2 = new Elevador(02, true, false);
        metodosAplicacao.elevador1.setAndarAtual(10);
        metodosAplicacao.prioridadeElevador(1, 5);
        assertFalse(metodosAplicacao.elevador1.isPrioritario());
        assertTrue(metodosAplicacao.elevador2.isPrioritario());
    }
}