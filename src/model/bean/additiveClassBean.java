package model.bean;

import java.util.ArrayList;



public class additiveClassBean {

	@Override
	public String toString() {
		return "additiveClassBean [chiName=" + chiName + ", engName=" + engName + ", purpose=" + purpose + ", commons="
				+ commons + "]";
	}
	public additiveClassBean() {
		this.chiName="";
	}

	
	public String chiName;
	public String engName;
	public String purpose;
	public ArrayList<Common> commons;
	public String getChiName() {
		return chiName;
	}
	public void setChiName(String chiName) {
		this.chiName = chiName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public ArrayList<Common> getCommons() {
		return commons;
	}
	public void setCommons(ArrayList<Common> commons) {
		this.commons = commons;
	}
	

	
	
	
	


	



	
	
	
	
	
	
}
