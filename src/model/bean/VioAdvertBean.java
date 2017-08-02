package model.bean;

public class VioAdvertBean {

	public VioAdvertBean() {
		// TODO Auto-generated constructor stub
	}
	public String productName;
	public String vioCompany;
	public String punishDate;
	public String punishlaw;
	public String publishDate;
	public String mediaClass;
	public String media;
	public String situation;
	public String punishOrgan;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPunishOrgan() {
		return punishOrgan;
	}
	public void setPunishOrgan(String punishOrgan) {
		this.punishOrgan = punishOrgan;
	}
	public String getVioCompany() {
		return vioCompany;
	}
	public void setVioCompany(String vioCompany) {
		this.vioCompany = vioCompany;
	}
	public String getPunishDate() {
		return punishDate;
	}
	public void setPunishDate(String punishDate) {
		this.punishDate = punishDate;
	}
	public String getPunishlaw() {
		return punishlaw;
	}
	public void setPunishlaw(String punishlaw) {
		this.punishlaw = punishlaw;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getMediaClass() {
		return mediaClass;
	}
	public void setMediaClass(String mediaClass) {
		this.mediaClass = mediaClass;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	@Override
	public String toString() {
		return "VioAdvertBean [productName=" + productName + ", vioCompany=" + vioCompany + ", punishDate=" + punishDate
				+ ", punishlaw=" + punishlaw + ", publishDate=" + publishDate + ", mediaClass=" + mediaClass
				+ ", media=" + media + ", situation=" + situation + ", punishOrgan=" + punishOrgan + "]";
	}
	
	
	
	
	
}
