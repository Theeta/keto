package peli.domain;

import java.awt.Color;

/**
 * Enumia käytetään värien ilmaisemiseen ja se tarjoaa metodeja värin
 * esittämiseen graafisessa muodossa sekä värien sekoittamiseen.
 *
 * @author noora
 */
public enum Vari {

    TYHJA,
    SININEN,
    PUNAINEN,
    LIILA,
    KELTAINEN,
    VIHREA,
    ORANSSI,
    VALKOINEN,
    VAALEANSININEN,
    VAALEANPUNAINEN,
    VAALEANLIILA,
    VAALEANKELTAINEN,
    VAALEANVIHREA,
    VAALEANORANSSI;

    /**
     * Metodi kertoo millä värikoodilla kukin väri esitetään ruudulla.
     *
     * @return Palauttaa värin ilmaisemiseen käytettävän värikoodin.
     */
    public Color varinVari() {
        switch (this) {
            case TYHJA:
                return Color.LIGHT_GRAY;
            case SININEN:
                return Color.BLUE;
            case PUNAINEN:
                return Color.RED;
            case LIILA:
                return Color.MAGENTA;
            case KELTAINEN:
                return Color.YELLOW;
            case VIHREA:
                return Color.GREEN;
            case ORANSSI:
                return Color.ORANGE;
            case VALKOINEN:
                return Color.WHITE;
            case VAALEANSININEN:
                return Color.CYAN;
            case VAALEANPUNAINEN:
                return Color.PINK;
            case VAALEANLIILA:
                return Color.DARK_GRAY;
            case VAALEANKELTAINEN:
                return Color.DARK_GRAY;
            case VAALEANVIHREA:
                return Color.DARK_GRAY;
            case VAALEANORANSSI:
                return Color.DARK_GRAY;
            default:
                return Color.LIGHT_GRAY;
        }
    }

    /**
     * Metodi kertoo, kuinka monen pisteen arvoinen kukin väri on.
     *
     * @return Palauttaa väristä saatavan pistemäärän.
     */
    public int varinPisteet() {
        switch (this) {
            case TYHJA:
                return 0;
            case SININEN:
                return 1;
            case PUNAINEN:
                return 1;
            case LIILA:
                return 2;
            case KELTAINEN:
                return 1;
            case VIHREA:
                return 2;
            case ORANSSI:
                return 2;
            case VALKOINEN:
                return 1;
            case VAALEANSININEN:
                return 2;
            case VAALEANPUNAINEN:
                return 2;
            case VAALEANLIILA:
                return 2;
            case VAALEANKELTAINEN:
                return 2;
            case VAALEANVIHREA:
                return 2;
            case VAALEANORANSSI:
                return 2;
            default:
                return 0;
        }
    }

    /**
     * Metodia käytetään kahden värin yhdistämiseen.
     *
     * @param vari Kertoo mihin väriin jotakin väriä yritetään yhdistää.
     * @return Palautetaan tyhjä, jos kyseisten värien yhdistäminen ei tuota
     * uutta väriä ja muuten palautetaan yhdistelmäväri.
     */
    public Vari varienYhdiste(Vari vari) {
        switch (this) {
            case TYHJA:
                return Vari.TYHJA;
            case SININEN:
                if (vari.equals(Vari.PUNAINEN)) {
                    return Vari.LIILA;
                } else if (vari.equals(Vari.KELTAINEN)) {
                    return Vari.VIHREA;
                } else if (vari.equals(Vari.VALKOINEN)) {
                    return Vari.VAALEANSININEN;
                } else {
                    return Vari.TYHJA;
                }
            case PUNAINEN:
                if (vari.equals(Vari.SININEN)) {
                    return Vari.LIILA;
                } else if (vari.equals(Vari.KELTAINEN)) {
                    return Vari.ORANSSI;
                } else if (vari.equals(Vari.VALKOINEN)) {
                    return Vari.VAALEANPUNAINEN;
                } else {
                    return Vari.TYHJA;
                }
            case LIILA:
                if (vari.equals(Vari.VALKOINEN)) {
                    return Vari.VAALEANLIILA;
                } else {
                    return Vari.TYHJA;
                }
            case KELTAINEN:
                if (vari.equals(Vari.SININEN)) {
                    return Vari.VIHREA;
                } else if (vari.equals(Vari.PUNAINEN)) {
                    return Vari.ORANSSI;
                } else if (vari.equals(Vari.VALKOINEN)) {
                    return Vari.VAALEANKELTAINEN;
                } else {
                    return Vari.TYHJA;
                }
            case VIHREA:
                if (vari.equals(Vari.VALKOINEN)){
                    return Vari.VAALEANVIHREA;
                } else {
                    return Vari.TYHJA;
                }
            case ORANSSI:
                if (vari.equals(Vari.VALKOINEN)){
                    return Vari.VAALEANORANSSI;
                } else {
                    return Vari.TYHJA;
                }
            case VALKOINEN:
                if (vari.equals(Vari.SININEN)){
                    return Vari.VAALEANSININEN;
                } else if (vari.equals(Vari.PUNAINEN)){
                    return Vari.VAALEANPUNAINEN;
                } else if (vari.equals(Vari.LIILA)){
                    return Vari.VAALEANLIILA;
                } else if (vari.equals(Vari.KELTAINEN)){
                    return Vari.VAALEANKELTAINEN;
                } else if (vari.equals(Vari.VIHREA)){
                    return Vari.VAALEANVIHREA;
                } else if (vari.equals(Vari.ORANSSI)){
                    return Vari.VAALEANORANSSI;
                } else {
                    return Vari.TYHJA;
                }
            case VAALEANSININEN:
                return Vari.TYHJA;
            case VAALEANPUNAINEN:
                return Vari.TYHJA;
            case VAALEANLIILA:
                return Vari.TYHJA;
            case VAALEANKELTAINEN:
                return Vari.TYHJA;
            case VAALEANVIHREA:
                return Vari.TYHJA;
            case VAALEANORANSSI:
                return Vari.TYHJA;
            default:
                return Vari.TYHJA;
        }
    }
}
