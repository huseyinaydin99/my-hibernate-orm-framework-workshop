package tr.com.huseyinaydin.okul;

import java.io.Serializable;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

public class Ogrenci implements Serializable {

	private static final long serialVersionUID = 1L;
	private long ogrenciId;
	private String ogrenciAdi;
	private Adres ogrenciAdres;

	public Ogrenci() {
	}

	public Ogrenci(String ogrenciAdi, Adres ogrenciAdres) {
		this.ogrenciAdi = ogrenciAdi;
		this.ogrenciAdres = ogrenciAdres;
	}

	public long getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(long ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public String getOgrenciAdi() {
		return ogrenciAdi;
	}

	public void setOgrenciAdi(String ogrenciAdi) {
		this.ogrenciAdi = ogrenciAdi;
	}

	public Adres getOgrenciAdres() {
		return ogrenciAdres;
	}

	public void setOgrenciAdres(Adres ogrenciAdres) {
		this.ogrenciAdres = ogrenciAdres;
	}
}