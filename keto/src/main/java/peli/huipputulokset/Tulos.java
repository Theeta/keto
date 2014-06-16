
package peli.huipputulokset;

public class Tulos implements Comparable<Tulos> {
    private String nimi;
    private int pisteet;
    
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
