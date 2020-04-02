package Get;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {
	
	private Date dtLoc;
	private Date dtEst;
	private String carros;
	private String pessoas;
	private float vlloc;
	private Date dtDev;
	private float vlMul;
	private float vlPag;
	private int flDev;
	private float vllocuni;
	
	public float getVllocuni() {
		return vllocuni;
	}

	public void setVllocuni(float vllocuni) {
		this.vllocuni = vllocuni;
	}

	public Date getDtLoc() {
		return dtLoc;
	}

	public void setDtLoc(Date dtLoc) {
		this.dtLoc = dtLoc;
	}

	public Date getDtEst() {
		return dtEst;
	}

	public void setDtEst(Date dtEst) {
		this.dtEst = dtEst;
	}

	public String getCarros() {
		return carros;
	}

	public void setCarros(String carros) {
		this.carros = carros;
	}

	public String getPessoas() {
		return pessoas;
	}

	public void setPessoas(String pessoas) {
		this.pessoas = pessoas;
	}

	public float getVlloc() {
		return vlloc;
	}

	public void setVlloc(float vlloc) {
		this.vlloc = vlloc;
	}

	public Date getDtDev() {
		return dtDev;
	}

	public void setDtDev(Date dtDev) {
		this.dtDev = dtDev;
	}

	public float getVlMul() {
		return vlMul;
	}

	public void setVlMul(float vlMul) {
		this.vlMul = vlMul;
	}

	public float getVlPag() {
		return vlPag;
	}

	public void setVlPag(float vlPag) {
		this.vlPag = vlPag;
	}

	public int getFlDev() {
		return flDev;
	}

	public void setFlDev(int flDev) {
		this.flDev = flDev;
	}

	public String getDataLocacaoFormated() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.dtLoc == null)
			return format.format(new Date());
		
		return format.format(this.dtLoc);
	}
	
	public String getDataLocacaoInput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (this.dtLoc == null)
			return format.format(new Date());
		
		return format.format(this.dtLoc);
	}
	
	public String getDataEstimativaFormated() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.dtEst == null)
			return format.format(new Date());
		
		return format.format(this.dtEst);
	}
	
	public String getDataEstimativaInput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (this.dtEst == null)
			return format.format(new Date());
		
		return format.format(this.dtEst);
	}
	
	public String getDevolucaoFormated() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.dtDev == null)
			return format.format(null);
		
		return format.format(this.dtDev);
	}
	
	public String getDevolucaoInput() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (this.dtDev == null)
			return format.format(null);
		
		return format.format(this.dtDev);
	}
	
}
