package tr.com.huseyinaydin.map;

import java.util.Date;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

public class OgrenciBilgisi {
	
	private Integer ogrenciId;
	private String adres;
	private String kayitNo;
	private String telefonNo;
	private String email;	
	private Date  dogumTarihi;
	private Date kayitTarihi;	
	private Ogrenci ogrenci;

	public Integer getOgrenciId() {
		return ogrenciId;
	}
	public void setOgrenciId(Integer ogrenciId) {
		this.ogrenciId = ogrenciId;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getKayitNo() {
		return kayitNo;
	}
	public void setKayitNo(String kayitNo) {
		this.kayitNo = kayitNo;
	}
	public String getTelefonNo() {
		return telefonNo;
	}
	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	public Date getKayitTarihi() {
		return kayitTarihi;
	}
	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}
	public Ogrenci getOgrenci() {
		return ogrenci;
	}
	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}
}