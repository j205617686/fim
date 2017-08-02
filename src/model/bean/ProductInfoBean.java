package model.bean;

import java.util.ArrayList;

public class ProductInfoBean {

	String productName;
	String importer;
	String agent;
	String manuAddress;
	ArrayList<String> relInfo;
	ArrayList<String> additive;
	String placeOfOrigin;
	String barcode;
	
	public ProductInfoBean() {
		this.agent="";
		this.importer="";
		this.placeOfOrigin="";
		this.productName="";
		this.manuAddress="";
		this.barcode="";
		
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImporter() {
		return importer;
	}
	public void setImporter(String importer) {
		this.importer = importer;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getManuAddress() {
		return manuAddress;
	}
	public void setManuAddress(String manuAddress) {
		this.manuAddress = manuAddress;
	}
	public ArrayList<String> getRelInfo() {
		return relInfo;
	}
	public void setRelInfo(ArrayList<String> relInfo) {
		this.relInfo = relInfo;
	}
	public ArrayList<String> getAdditive() {
		return additive;
	}
	public void setAdditive(ArrayList<String> additive) {
		this.additive = additive;
	}
	
	public void addAdditive(String addi) {
		additive.add(addi);
	}
	
	public void addrelInfo(String relInfo_a) {
		relInfo.add(relInfo_a);
	}
	
	
	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}
	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}
	@Override
	public String toString() {
		return "ProductInfoBean [productName=" + productName + ", importer=" + importer + ", agent=" + agent
				+ ", manuAddress=" + manuAddress + ", relInfo=" + relInfo + ", additive=" + additive
				+ ", placeOfOrigin=" + placeOfOrigin + "]";
	}
	
	
	
	
	
}
