package tr.com.huseyinaydin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Table(name ="PERSONELTABLOSU") 
public class Personel {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)	              
	private int personelId;
	private String personelAdi; 
	private String personelSoyadi;
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