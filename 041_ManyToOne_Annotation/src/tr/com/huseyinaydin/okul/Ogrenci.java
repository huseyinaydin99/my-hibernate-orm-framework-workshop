package tr.com.huseyinaydin.okul;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Hibernate.
 * @since 1994
 */

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "OGRENCI")
public class Ogrenci implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "OGRENCI_ID")
	private long ogrenciId;
	
	@Column(name = "OGRENCI_ADI", nullable = false, length = 100)
	private String ogrenciAdi;
	
	@ManyToOne(cascade = ALL) //CascadeType.ALL
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