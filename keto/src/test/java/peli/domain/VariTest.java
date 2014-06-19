
package peli.domain;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VariTest {
    
    public VariTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void punainenPalauttaaOikeanVarin() {
        assertEquals(Color.RED, Vari.PUNAINEN.varinVari());
    }
    
    @Test
    public void sininenPalauttaaOikeanVarin() {
        assertEquals(Color.BLUE, Vari.SININEN.varinVari());
    }
    @Test
    public void tyhjaPalauttaaOikeanVarin() {
        assertEquals(Color.LIGHT_GRAY, Vari.TYHJA.varinVari());
    }
    @Test
    public void liilaPalauttaaOikeanVarin() {
        assertEquals(Color.MAGENTA, Vari.LIILA.varinVari());
    }
    
    @Test
    public void keltainenPalauttaaOikeanVarin() {
        assertEquals(Color.YELLOW, Vari.KELTAINEN.varinVari());
    }
    
    @Test
    public void vihreaPalauttaaOikeanVarin() {
        assertEquals(Color.GREEN, Vari.VIHREA.varinVari());
    }
    
    @Test
    public void oranssiPalauttaaOikeanVarin() {
        assertEquals(Color.ORANGE, Vari.ORANSSI.varinVari());
    }
    
    @Test
    public void valkoinenPalauttaaOikeanVarin() {
        assertEquals(Color.WHITE, Vari.VALKOINEN.varinVari());
    }
    
    @Test
    public void vaaleansininenPalauttaaOikeanVarin() {
        assertEquals(Color.CYAN, Vari.VAALEANSININEN.varinVari());
    }
    
    @Test
    public void vaaleanpunainenPalauttaaOikeanVarin() {
        assertEquals(Color.PINK, Vari.VAALEANPUNAINEN.varinVari());
    }
    
    @Test
    public void vaaleanliilaPalauttaaOikeanVarin() {
        assertEquals(Color.DARK_GRAY, Vari.VAALEANLIILA.varinVari());
    }
    
    @Test
    public void vaaleankeltainenPalauttaaOikeanVarin() {
        assertEquals(Color.DARK_GRAY, Vari.VAALEANKELTAINEN.varinVari());
    }
    
    @Test
    public void vaaleanvihreäPalauttaaOikeanVarin() {
        assertEquals(Color.DARK_GRAY, Vari.VAALEANVIHREA.varinVari());
    }
    
    @Test
    public void vaaleanoranssiPalauttaaOikeanVarin() {
        assertEquals(Color.DARK_GRAY, Vari.VAALEANORANSSI.varinVari());
    }
    
    @Test
    public void tyhjaPalauttaaOikeanPistemaaran() {
        assertEquals(0, Vari.TYHJA.varinPisteet());
    }
    
    @Test
    public void sininenPalauttaaOikeanPistemaaran() {
        assertEquals(1, Vari.SININEN.varinPisteet());
    }
    
    @Test
    public void punainenPalauttaaOikeanPistemaaran() {
        assertEquals(1, Vari.PUNAINEN.varinPisteet());
    }
    
    @Test
    public void liilaPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.LIILA.varinPisteet());
    }
    
    @Test
    public void keltainenPalauttaaOikeanPistemaaran() {
        assertEquals(1, Vari.KELTAINEN.varinPisteet());
    }
    
    @Test
    public void vihreaPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VIHREA.varinPisteet());
    }
    
    @Test
    public void oranssiPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.ORANSSI.varinPisteet());
    }
    
    @Test
    public void valkoinenPalauttaaOikeanPistemaaran() {
        assertEquals(1, Vari.VALKOINEN.varinPisteet());
    }
    
    @Test
    public void vaaleansininenPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VAALEANSININEN.varinPisteet());
    }
    
    @Test
    public void vaaleanpunainenPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VAALEANPUNAINEN.varinPisteet());
    }
    
    @Test
    public void vaaleanliilaPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VAALEANLIILA.varinPisteet());
    }
    
    @Test
    public void vaaleankeltainenPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VAALEANKELTAINEN.varinPisteet());
    }
    
    @Test
    public void vaaleanvihreaPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VAALEANVIHREA.varinPisteet());
    }
    
    @Test
    public void vaaleanoranssiPalauttaaOikeanPistemaaran() {
        assertEquals(2, Vari.VAALEANORANSSI.varinPisteet());
    }
    
    @Test
    public void punainenYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void punainenYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.LIILA, Vari.PUNAINEN.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void punainenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void punainenYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void punainenYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.ORANSSI, Vari.PUNAINEN.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void punainenYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void punainenYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void punainenYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANPUNAINEN, Vari.PUNAINEN.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void punainenYhdistettynaVaaleansiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VAALEANSININEN));
    }
    
    @Test
    public void punainenYhdistettynaVaaleanpunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VAALEANPUNAINEN));
    }
    
    @Test
    public void punainenYhdistettynaVaaleanliilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VAALEANLIILA));
    }
    
    @Test
    public void punainenYhdistettynaVaaleankeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VAALEANKELTAINEN));
    }
    
    @Test
    public void punainenYhdistettynaVaaleanvihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VAALEANVIHREA));
    }
    
    @Test
    public void punainenYhdistettynaVaaleanoranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.PUNAINEN.varienYhdiste(Vari.VAALEANORANSSI));
    }
    
    @Test
    public void sininenYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.LIILA, Vari.SININEN.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void sininenYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void sininenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void sininenYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void sininenYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VIHREA, Vari.SININEN.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void sininenYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void sininenYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void sininenYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANSININEN, Vari.SININEN.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void sininenYhdistettynaVaaleansiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VAALEANSININEN));
    }
    
    @Test
    public void sininenYhdistettynaVaaleanpunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VAALEANPUNAINEN));
    }
    
    @Test
    public void sininenYhdistettynaVaaleanliilaPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VAALEANLIILA));
    }
    
    @Test
    public void sininenYhdistettynaVaaleankeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VAALEANKELTAINEN));
    }
    
    @Test
    public void sininenYhdistettynaVaaleanvihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VAALEANVIHREA));
    }
    
    @Test
    public void sininenYhdistettynaVaaleanoranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.SININEN.varienYhdiste(Vari.VAALEANORANSSI));
    }
    
    @Test
    public void tyhjaYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void tyhjaYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void tyhjaYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void tyhjaYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void tyhjaYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void tyhjaYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void tyhjaYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void tyhjaYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void tyhjaYhdistettynaVaaleansiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VAALEANSININEN));
    }
    
    @Test
    public void tyhjaYhdistettynaVaaleanpunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VAALEANPUNAINEN));
    }
    
    @Test
    public void tyhjaYhdistettynaVaaleanliilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VAALEANLIILA));
    }
    
    @Test
    public void tyhjaYhdistettynaVaaleankeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VAALEANKELTAINEN));
    }
    
    @Test
    public void tyhjaYhdistettynaVaaleanvihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VAALEANVIHREA));
    }
    
    @Test
    public void tyhjaYhdistettynaVaaleanoranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.TYHJA.varienYhdiste(Vari.VAALEANORANSSI));
    }
    
    @Test
    public void liilaYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void liilaYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void liilaYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void liilaYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void liilaYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void liilaYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void liilaYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.LIILA.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void liilaYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANLIILA, Vari.LIILA.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void keltainenYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.ORANSSI, Vari.KELTAINEN.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void keltainenYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VIHREA, Vari.KELTAINEN.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void keltainenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.KELTAINEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void keltainenYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.KELTAINEN.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void keltainenYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.KELTAINEN.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void keltainenYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.KELTAINEN.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void keltainenYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.KELTAINEN.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void keltainenYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANKELTAINEN, Vari.KELTAINEN.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void vihreaYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void vihreaYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void vihreaYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void vihreaYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void vihreaYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void vihreaYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void vihreaYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VIHREA.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void vihreaYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANVIHREA, Vari.VIHREA.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void oranssiYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void oranssiYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void oranssiYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void oranssiYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void oranssiYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void oranssiYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void oranssiYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.ORANSSI.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void oranssiYhdistettynaValkoiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANORANSSI, Vari.ORANSSI.varienYhdiste(Vari.VALKOINEN));
    }
    
    @Test
    public void valkoinenYhdistettynaPunaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANPUNAINEN, Vari.VALKOINEN.varienYhdiste(Vari.PUNAINEN));
    }
    
    @Test
    public void valkoinenYhdistettynaSiniseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANSININEN, Vari.VALKOINEN.varienYhdiste(Vari.SININEN));
    }
    
    @Test
    public void valkoinenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VALKOINEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void valkoinenYhdistettynaLiilaanPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANLIILA, Vari.VALKOINEN.varienYhdiste(Vari.LIILA));
    }
    
    @Test
    public void valkoinenYhdistettynaKeltaiseenPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANKELTAINEN, Vari.VALKOINEN.varienYhdiste(Vari.KELTAINEN));
    }
    
    @Test
    public void valkoinenYhdistettynaVihreaanPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANVIHREA, Vari.VALKOINEN.varienYhdiste(Vari.VIHREA));
    }
    
    @Test
    public void valkoinenYhdistettynaOranssiinPalauttaaOikeanVarin() {
        assertEquals(Vari.VAALEANORANSSI, Vari.VALKOINEN.varienYhdiste(Vari.ORANSSI));
    }
    
    @Test
    public void vaaleansininenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VAALEANSININEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void vaaleanpunainenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VAALEANPUNAINEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void vaaleanliilaYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VAALEANLIILA.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void vaaleankeltainenYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VAALEANKELTAINEN.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void vaaleanvihreaYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VAALEANVIHREA.varienYhdiste(Vari.TYHJA));
    }
    
    @Test
    public void vaaleanoranssiYhdistettynaTyhjaanPalauttaaOikeanVarin() {
        assertEquals(Vari.TYHJA, Vari.VAALEANORANSSI.varienYhdiste(Vari.TYHJA));
    }
}
