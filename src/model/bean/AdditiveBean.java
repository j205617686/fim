package model.bean;

public class AdditiveBean {

	public AdditiveBean() {
		// TODO Auto-generated constructor stub
	}

	public String cls;
	public String chiName;
	public String engName;
	public String restriction;
	public String range;
	public String shortlink;
	
	
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
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
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getShortlink() {
		return shortlink;
	}
	public void setShortlink(String shortlink) {
		this.shortlink = shortlink;
	}
	@Override
	public String toString() {
		return "AdditiveBean [cls=" + cls + ", chiName=" + chiName + ", engName=" + engName + ", restriction="
				+ restriction + ", range=" + range + ", shortlink=" + shortlink + "]";
	}
	
	
	
}
