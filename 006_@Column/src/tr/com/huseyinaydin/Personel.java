package tr.com.huseyinaydin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

@Entity (name = "PERSONS")
public class Personel implements Serializable {
	
	@Id
	@Column (name="ID")
	private int personelId;
	
	@Column (name="ADI")
	private String personelAdi;
	
	@Column (name="SOYADI")
	private String personelSoyadi;
	
	private static final long serialVersionUID = 1L;

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