package es.upm.miw.pd.text.solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.pd.text.solution.Texto;
import es.upm.miw.pd.text.solution.FactoriaCaracter;
import es.upm.miw.pd.text.solution.Parrafo;


public class TextoTest {
    private Texto H, o, l, a, pf, txt;

    @Before
    public void ini() {
        H = FactoriaCaracter.getFactoriaCaracter().get('H');
        o = FactoriaCaracter.getFactoriaCaracter().get('o');
        l = FactoriaCaracter.getFactoriaCaracter().get('l');
        a = FactoriaCaracter.getFactoriaCaracter().get('a');
        pf = new Parrafo();
        pf.add(H);
        pf.add(o);
        pf.add(l);
        pf.add(a);
        txt = new TextoCompuesto();
        txt.add(pf);
        txt.add(pf);
    }

    @Test
    public void testCaracterFlyweight() {
        assertSame(H, FactoriaCaracter.getFactoriaCaracter().get('H'));
    }

    @Test
    public void testCaracterAddCaracter() {
        H.add(o);
    }

    @Test
    public void testDibujarCaracterNormal() {
        assertEquals("o", o.dibujar(false));
    }

    @Test
    public void testDibujarCaracterMayusculas() {
        assertEquals("O", o.dibujar(true));
    }

    // ----------------------------------------------

    @Test
    public void testParrafoNormal() {
        assertEquals("Hola\n", pf.dibujar(false));
    }

    @Test
    public void testParrafoMayusculas() {
        assertEquals("HOLA\n", pf.dibujar(true));
    }

    @Test
    public void testParrafoNoAddParrafo() {
        try {
            pf.add(pf);
            fail("");
        } catch (UnsupportedOperationException ignored) {
            ignored.toString();
        }
    }

    // ----------------------------------------------

    @Test
    public void testTextoNormal() {
        assertEquals("Hola\nHola\n---o---\n",txt.dibujar(false));
    }
    
    @Test
    public void testTextoMayusculas() {
        assertEquals("HOLA\nHOLA\n---o---\n",txt.dibujar(true));
    }
    
    @Test
    public void testTextoNoAddCaracter() {
        try {
            txt.add(H);
            fail();
        } catch (UnsupportedOperationException ignored) {
            ignored.toString();
        }
    }

}
