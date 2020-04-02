package Get;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoas {
	
	private String NamePes;
	private String SobrePes;
	private Date NascPes;
	private String CnhPes;
	private int DDDPes;
	private String NumPes;
	private String EmailPes;
	private String EndPes;
	private String CidPes;
	private String UfPes;
	
	
	
	public String getNamePes() {
		return NamePes;
	}

	public void setNamePes(String namePes) {
		NamePes = namePes;
	}

	public String getSobrePes() {
		return SobrePes;
	}

	public void setSobrePes(String sobrePes) {
		SobrePes = sobrePes;
	}

	public Date getNascPes() {
		return NascPes;
	}

	public void setNascPes(Date nascPes) {
		NascPes = nascPes;
	}

	public String getCnhPes() {
		return CnhPes;
	}

	public void setCnhPes(String cnhPes) {
		CnhPes = cnhPes;
	}

	public int getDDDPes() {
		return DDDPes;
	}

	public void setDDDPes(int dDDPes) {
		DDDPes = dDDPes;
	}

	public String getNumPes() {
		return NumPes;
	}

	public void setNumPes(String numPes) {
		NumPes = numPes;
	}

	public String getEmailPes() {
		return EmailPes;
	}

	public void setEmailPes(String emailPes) {
		EmailPes = emailPes;
	}

	public String getEndPes() {
		return EndPes;
	}

	public void setEndPes(String endPes) {
		EndPes = endPes;
	}

	public String getCidPes() {
		return CidPes;
	}

	public void setCidPes(String cidPes) {
		CidPes = cidPes;
	}

	public String getUfPes() {
		return UfPes;
	}

	public void setUfPes(String ufPes) {
		UfPes = ufPes;
	}

	public String getDataNasFormated() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.NascPes == null)
			return format.format(new Date());
		
		return format.format(this.NascPes);
	}
	
	public String getDataNasDateInput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (this.NascPes == null)
			return format.format(new Date());
		
		return format.format(this.NascPes);
	}
	
}
