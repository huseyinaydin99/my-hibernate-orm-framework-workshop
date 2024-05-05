package tr.com.huseyinaydin.magaza;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Urun {

    private int urunId;
    private String urunAdi;
    private double urunFiyati;

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public double getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(double urunFiyati) {
        this.urunFiyati = urunFiyati;
    }
}