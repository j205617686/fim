package model.bean;

public class HealthFoodBean {

	public HealthFoodBean() {
		this.ChiName="";
	}
	
	
	public String ApprovedID;
	public String cls;
	public String ChiName;
	public String ApprovedDate;
	public String AppSuppliers;
	public String Warning;
	public String Precautions;
	public String ingredient;
	public String effect;
	public String ApprovedSit;
	public String EffectClaim;
	
	public String getEffectClaim() {
		return EffectClaim;
	}
	public void setEffectClaim(String effectClaim) {
		EffectClaim = effectClaim;
	}
	public String getApprovedSit() {
		return ApprovedSit;
	}
	public void setApprovedSit(String approvedSit) {
		ApprovedSit = approvedSit;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getApprovedID() {
		return ApprovedID;
	}
	public void setApprovedID(String approvedID) {
		ApprovedID = approvedID;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getChiName() {
		return ChiName;
	}
	public void setChiName(String chiName) {
		ChiName = chiName;
	}
	public String getApprovedDate() {
		return ApprovedDate;
	}
	public void setApprovedDate(String approvedDate) {
		ApprovedDate = approvedDate;
	}
	public String getAppSuppliers() {
		return AppSuppliers;
	}
	public void setAppSuppliers(String appSuppliers) {
		AppSuppliers = appSuppliers;
	}
	public String getWarning() {
		return Warning;
	}
	public void setWarning(String warning) {
		Warning = warning;
	}
	public String getPrecautions() {
		return Precautions;
	}
	public void setPrecautions(String precautions) {
		Precautions = precautions;
	}
	@Override
	public String toString() {
		return "HealthFoodBean [ApprovedID=" + ApprovedID + ", cls=" + cls + ", ChiName=" + ChiName + ", ApprovedDate="
				+ ApprovedDate + ", AppSuppliers=" + AppSuppliers + ", Warning=" + Warning + ", Precautions="
				+ Precautions + ", ingredient=" + ingredient + ", effect=" + effect + ", ApprovedSit=" + ApprovedSit
				+ ", EffectClaim=" + EffectClaim + "]";
	}
	
}
