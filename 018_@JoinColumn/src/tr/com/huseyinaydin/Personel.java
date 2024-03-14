package tr.com.huseyinaydin;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

@Entity 
@Table(name = "personeltablosu") //TABLO ÖZELLİKLERİ
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ID ALANINA OTOMATIK ID DEGERLER VERILIYOR
	private int personelId;
	private String personelAdi;
	private String personelSoyadi;
	private Date personelKayitTarihi;

	@Embedded //BU ALANA BAŞKA BİR SINIFTAKİ BÖLGELER GÖMÜLECEK - GELECEK
	@ElementCollection //COCUK DETAY TABLOLARINI OLUŞTURMAYA YARAR
	@JoinTable(name="personeladrestablosu", //KALITIM TABLOSU
	joinColumns = @JoinColumn(name="personel_id")
	//COCUK ALT DETAY TABLODAKI ID KOLONUN ADINI DEGISTIRIR - KALITIM SUTUNU
	)
	private Set<Adres> adresListesi = new HashSet<>();
	public Set<Adres> getAdresListesi() {
		return adresListesi;
	}
	public void setAdresListesi(Set<Adres> adresListesi) {
		this.adresListesi = adresListesi;
	}
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
	public Date getPersonelKayitTarihi() {
		return personelKayitTarihi;
	}
	public void setPersonelKayitTarihi(Date personelKayitTarihi) {
		this.personelKayitTarihi = personelKayitTarihi;
	}
}