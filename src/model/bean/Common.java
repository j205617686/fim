package model.bean;

public class Common {

	@Override
	public String toString() {
		return "Common [example=" + example + ", items=" + items + ", sideEffect=" + sideEffect + "]";
	}
	public Common() {
		// TODO Auto-generated constructor stub
	}
	
	String example;
	String items;
	String sideEffect;
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getSideEffect() {
		return sideEffect;
	}
	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	

}
