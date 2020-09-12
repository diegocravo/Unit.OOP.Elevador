package Test;

import Entities.Elevador;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElevadorTest {

    @Test
    public void ligarDesligar() {
        Elevador elevador = new Elevador(001, true, true);
        elevador.ligarDesligar();
        assertFalse(elevador.isLigado());
        elevador.ligarDesligar();
        assertTrue(elevador.isLigado());
    }

    @Test
    public void testCalcularEsforco() {
        Elevador elevador = new Elevador(001, true, true);
        assertEquals(500, elevador.calcularEsforco(1, 5), 0.0);
        assertEquals(1125, elevador.calcularEsforco(1, 10), 0.0);
        assertEquals(0, elevador.calcularEsforco(1, 1), 0.0);
    }

    @Test
    public void testAtivarPrioridade(){
        Elevador elevador = new Elevador(001, true, false);
        elevador.ativarPrioridade();
        assertTrue(elevador.isPrioritario());
    }

    @Test
    public void testDesativarPrioridade(){
        Elevador elevador = new Elevador(001, true, true);
        elevador.desativarPrioridade();
        assertFalse(elevador.isPrioritario());
    }

}