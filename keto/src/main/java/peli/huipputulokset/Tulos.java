
package peli.huipputulokset;

/**
 * Luokasta luodut oliot sisältävät pelaajan nimen ja pelin pistemäärän. Luokka sisältää metodeja näiden käsittelyä varten
 * @author noora
 */
public class Tulos implements Comparable<Tulos> {
    private final String nimi;
    private final int pisteet;
    
    public Tulos(String nimi, int pisteet){
        this.nimi = nimi;
        this.pisteet = pisteet;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    @Override
    public int compareTo(Tulos toinen) {
        return toinen.getPisteet() - this.pisteet;
    }
    
}
