package tr.com.huseyinaydin;

import javax.persistence.Embeddable;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

@Embeddable 
//BU SINIF BASKA VARLIK SINIFLARI TARAFINDAN GÖMÜLÜ OLARAK KULLANILABİLİR
//BIR ALAN GIBI KULLANILACAK GÖMÜLECEK
public class Adres {
	private String sehir;
	private String semt;
	private String mahalle;
	private String cadde;
	private String kapiNo;
	private String kat;
	private String daireNo;
	private String postaKodu;

	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getSemt() {
		return semt;
	}
	public void setSemt(String semt) {
		this.semt = semt;
	}
	public String getMahalle() {
		return mahalle;
	}
	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}
	public String getCadde() {
		return cadde;
	}
	public void setCadde(String cadde) {
		this.cadde = cadde;
	}
	public String getKapiNo() {
		return kapiNo;
	}
	public void setKapiNo(String kapiNo) {
		this.kapiNo = kapiNo;
	}
	public String getKat() {
		return kat;
	}
	public void setKat(String kat) {
		this.kat = kat;
	}
	public String getDaireNo() {
		return daireNo;
	}
	public void setDaireNo(String daireNo) {
		this.daireNo = daireNo;
	}
	public String getPostaKodu() {
		return postaKodu;
	}
	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
}