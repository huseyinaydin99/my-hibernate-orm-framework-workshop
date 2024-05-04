package tr.com.huseyinaydin.okul;

//بسم الله الرحمن الرحيم
/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Hibernate.
 *
 */

public class Ders implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long dersId;
	private String dersAdi;

	public Ders() {
	}

	public Ders(String dersAdi) {
		this.setDersAdi(dersAdi);
	}

	public long getDersId() {
		return dersId;
	}

	public void setDersId(long dersId) {
		this.dersId = dersId;
	}

	public String getDersAdi() {
		return dersAdi;
	}

	public void setDersAdi(String dersAdi) {
		this.dersAdi = dersAdi;
	}
}