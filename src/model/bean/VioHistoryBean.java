package model.bean;

public class VioHistoryBean {
/*
	@Override
	public String toString() {
		return"{\"PlaceOfOrigin\":\""+PlaceOfOrigin+"\","
				+"\"topic\":\""+topic+"\","
				+"\"reason\":\""+reason+"\","
				+"\"importer\":\""+importer+"\","
				+"\"reasonDetail\":\""+reasonDetail+"\","
				+"\"lawRestriction\":\""+lawRestriction+"\","
				+"\"manufacturer\":\""+manufacturer+"\","
				+"\"importerAddress\":\""+importerAddress+"\","
				+"\"photo\":\""+photo+"\","
				+"\"releaseDate\":\""+releaseDate+"\","
				+"\"testDate\":\""+testDate+"\","
				+"\"situation\":\""+situation+"\""
				+ "}";
	}
	*/
	public VioHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String PlaceOfOrigin;
	public String topic;
	public String reason;
	public String importer;
	public String reasonDetail;
	public String lawRestriction;
	public String manufacturer;
	public String importerAddress;
	public String photo;
	public String releaseDate;
	public String testDate;
	public String situation;
	
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getImporterAddress() {
		return importerAddress;
	}
	public void setImporterAddress(String importerAddress) {
		importerAddress = importerAddress;
	}
	public String getPlaceOfOrigin() {
		return PlaceOfOrigin;
	}
	public void setPlaceOfOrigin(String placeOfOrigin) {
		PlaceOfOrigin = placeOfOrigin;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getImporter() {
		return importer;
	}
	public void setImporter(String importer) {
		this.importer = importer;
	}
	public String getReasonDetail() {
		return reasonDetail;
	}
	public void setReasonDetail(String reasonDetail) {
		this.reasonDetail = reasonDetail;
	}
	public String getLawRestriction() {
		return lawRestriction;
	}
	public void setLawRestriction(String lawRestriction) {
		this.lawRestriction = lawRestriction;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	

}
