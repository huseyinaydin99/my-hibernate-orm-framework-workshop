package tr.com.huseyinaydin;

import javax.persistence.Entity;
import javax.persistence.Id;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

@Entity
public class Personel {
    private int personelId;
    private String personelAdi, personelSoyadi;
    @Id
    public int getPersonelId() {
        return personelId;
    }
    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }
    public String getPersonelAdi() {
        return personelAdi;
    }
    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }
    public String getPersonelSoyadi() {
        return personelSoyadi;
    }
    public void setPersonelSoyadi(String personelSoyadi) {
        this.personelSoyadi = personelSoyadi;
    }
}
