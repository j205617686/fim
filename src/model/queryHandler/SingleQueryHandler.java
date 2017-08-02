package model.queryHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;
import org.json.JSONArray;
import org.json.JSONException;

import model.bean.AdditiveBean;
import model.bean.Common;
import model.bean.HealthFoodBean;
import model.bean.ProductInfoBean;
import model.bean.VioAdvertBean;
import model.bean.VioHistoryBean;
import model.bean.additiveClassBean;

public class SingleQueryHandler {

	
	
	public static void main(String[] arg) throws IOException {
		
		SingleQueryHandler q = new SingleQueryHandler();
		
		//System.out.println(q.getClass("鈣"));  //用添加劑名稱找食品添加物使用範圍及限量暨規格標準資料集(一個添加劑可能同時是好幾個不同的類別)
		//System.out.println(q.getAdditiveInfo("檸檬酸鈣"));
		//System.out.println(q.getClassInfo("膨脹劑")); //用添加劑類別名稱找特性
		//System.out.println(q.getVioHistory("台灣大創百貨股份有限公司")); //用公司名稱找違規歷史
		//System.out.println(q.getVioAdvert("露天市集國際資訊股份有限公司")); //用公司名稱找違規廣告
		//System.out.println(q.getHealthFoodInfo("桂格養生燕麥麵")); //用產品名稱找健康食品
		//System.out.println(q.getHealthFoodByEffect("調節血脂功能")); //用功效找健康食品
		//System.out.println(q.getProductInfo("4710901891947"));
		
		System.out.println(q.getDistinctProductInfo("4710901891947"));
		/*
		ArrayList<String> nullArr=new ArrayList<String>();
		
		ArrayList<String> a=new ArrayList<String>();
		a.add("維生素C鈉鹽");
		a.add("難消化性麥芽糊精");
		a.add("碳酸氫鈉");
		
		
		q.InsertProductInformation("1","原萃日式纖綠茶",a,"宏全國際股份有限公司","中華民國","太古可口可樂股份有限公司",nullArr,"台中市梧棲區草楠里13鄰大業路6號");
		*/
		
		/*
		
		q.updateProductName("日式無糖綠茶-茶裏王","茶裏王日式無糖綠茶","4710901891947");
		q.updateImporter("", "", "4710901891947");
		q.updateAgents("","統一企業股份有限公司" , "4710901891947");
		q.updateManuAddress("", "台灣台中市梧棲區加工出口區經三路1號", "4710901891947");
		q.updatePlaceOfOrigin("", "台灣", "4710901891947");
		
		try {
			q.updateAdditive("[]", "[\"L-抗壞血酸鈉\",\"食鹽\",\"碳酸氫鈉\"]", "4710901891947");
			
			
			q.updateRelInfo("[]", "[\"健康食品\"]", "4710901891947");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		
		
		
		
		
		
		
	}
	
	
	public void updateProductName(String oldProductName,String wewProductName,String barcode) {
	
	String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
						"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
						"DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:productName \""+oldProductName+"\" . } ;\n"+
						"INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:productName \""+wewProductName+"\" . } ;\n";

			
			

	System.out.println(queryString);
	
	
	UpdateRequest ur = new UpdateRequest();
	UpdateProcessor up;
	String  service ="http://localhost:3030/productTemp/update";
	
	ur.add(queryString);

	up=UpdateExecutionFactory.createRemote(ur,service);
	up.execute();
	
	
	System.out.println("\nInsertData complete.");
	
	
	
	
	
	
	}
	
	public void updateImporter(String oldImporter,String newImporter,String barcode) {
		
		String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
				"DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:importer \""+oldImporter+"\" . } ;\n"+
				"INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:importer \""+newImporter+"\" . } ;\n";
				
	
	

		System.out.println(queryString);
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(queryString);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		System.out.println("\nInsertData complete.");
		
		
		
	}
	public void updateAgents(String oldAgents,String newAgents,String barcode) {
		
		String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
				"DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:agents \""+oldAgents+"\" . } ;\n"+
				"INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:agents \""+newAgents+"\" . } ;\n";

		System.out.println(queryString);
		
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(queryString);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		System.out.println("\nInsertData complete.");
		
		
		
	}
	
	public void updateManuAddress(String oldManuAddress,String newManuAddress,String barcode) {
		
		String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
				"DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:manufactAddress \""+oldManuAddress+"\" . } ;\n"+
				"INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:manufactAddress \""+newManuAddress+"\" . } ;\n";

		System.out.println(queryString);
		
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(queryString);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		System.out.println("\nInsertData complete.");
		
		
		
	}
	

	
	public void updatePlaceOfOrigin(String oldPlaceOfOrigin,String newPlaceOfOrigin,String barcode) {
		
		String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
				"DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:placeOfOrigin \""+oldPlaceOfOrigin+"\" . } ;\n"+
				"INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:placeOfOrigin \""+newPlaceOfOrigin+"\" . } ;\n";

	
		System.out.println(queryString);
		
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(queryString);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		System.out.println("\nInsertData complete.");
		
	}
	
	
	
	public void updateAdditive(String oldAdditiveJSON,String newAdditiveJSON,String barcode) throws JSONException {
	
		
		
		String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n";
		
		System.out.println(newAdditiveJSON);
		
		
			JSONArray oldJSONArr=new JSONArray(oldAdditiveJSON);
			JSONArray newJSONArr=new JSONArray(newAdditiveJSON);
	
		
		
		
		for(int i=0;i<oldJSONArr.length();i++)
		{
			queryString+="DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:additive \""+oldJSONArr.get(i)+"\" . } ;\n";
		}
		
		
		for(int j=0;j<newJSONArr.length();j++)
		{
			queryString+="INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:additive \""+newJSONArr.get(j)+"\" . } ;\n";
		}
		
				
			

		System.out.println(queryString);
		
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(queryString);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		
		
	
	}
	public void updateRelInfo(String oldRelInfoJSON,String newRelInfoJSON,String barcode) throws JSONException {
		
		String queryString ="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n";
		
		
		
			JSONArray oldJSONArr=new JSONArray(oldRelInfoJSON);
			JSONArray newJSONArr=new JSONArray(newRelInfoJSON);
	
		
		
		
		for(int i=0;i<oldJSONArr.length();i++)
		{
			queryString+="DELETE DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:relatedInfo \""+oldJSONArr.get(i)+"\" . } ;\n";
		}
		
		
		for(int j=0;j<newJSONArr.length();j++)
		{
			queryString+="INSERT DATA {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:relatedInfo \""+newJSONArr.get(j)+"\" . } ;\n";
		}
		
				
			

		System.out.println(queryString);
		
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(queryString);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public additiveClassBean getClassInfo(String className) throws FileNotFoundException {
		
		
		String allstr=new String();
		
		additiveClassBean classObj=new additiveClassBean();
		ArrayList<Common> commonArr=new ArrayList<Common>();
		
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/addiclass/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:chiName \""+className+"\" .\n"
				+ "?s fim:engName ?engname .\n"
				+ "?s fim:purpose ?purpose .\n"
				+ "?s fim:commons ?commons .\n"
				+ "?commons fim:items ?items .\n"
				+ "?commons fim:example ?example .\n"
				+ "?commons fim:sideEffect ?sideEffect .\n"
				
				+ "}\n";
				
	
		
		String qs=allstr;
		
		//System.out.println(qs);
		
		Query query=QueryFactory.create(qs);
	
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/additiveClass/query", query);
		String l;
		
		
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				classObj.setChiName(className);
				classObj.setEngName(sol.get("engname").toString());
				classObj.setPurpose(sol.get("purpose").toString());
				
				
				Common com=new Common();
				
				com.setItems(sol.get("items").toString());
				com.setExample(sol.get("example").toString());
				com.setSideEffect(sol.get("sideEffect").toString());
				
				commonArr.add(com);
				
				//findURI.add(l);
				c++;
				
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		classObj.setCommons(commonArr);
		
		//System.out.println(classObj);
		
		
		return classObj;
		
		
		
		
		
		
		
		
		
	}

	public ArrayList<AdditiveBean> getAdditiveInfo(String additiveName) throws IOException {
		
		String allstr=new String();
		
		ArrayList<AdditiveBean> addiInfoArr= new ArrayList<AdditiveBean>();
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX fimadd: <http://data.fim.com.tw/rdf/resource/addiclass/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:chiName \""+additiveName+"\" .\n"
				+"?s fim:class ?class .\n"
				+ "?s fim:engName ?engName .\n"
				+ "?s fim:restriction ?restriction .\n"
				+ "?s fim:limitOfUse ?limitOfUse .\n"
				+ "}\n";
	
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
		
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/additiveInformation/query", query);
		String l;
		
		ArrayList<String> classArr = new ArrayList<String>();
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				AdditiveBean additiveObj = new AdditiveBean();
				additiveObj.setChiName(additiveName);
				additiveObj.setEngName(sol.get("engName").toString());
				additiveObj.setRestriction(sol.get("restriction").toString());
				additiveObj.setRange(sol.get("limitOfUse").toString());
				additiveObj.setCls(sol.get("class").toString());
				additiveObj.setShortlink(sol.get("s").toString());
				
				
				
				
				
				addiInfoArr.add(additiveObj);
				
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		//System.out.println(addiInfoArr.get(0));
		
		return addiInfoArr;
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	public ArrayList<String> getClass(String additiveName) throws IOException {
		
		String allstr=new String();
		
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX fimadd: <http://data.fim.com.tw/rdf/resource/addiclass/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select ?o \n"
				+"where{\n"
				+"?s fim:chiName \""+additiveName+"\" .\n"
				+"?s fim:class ?o .\n"
				+ "}\n";
					
					
					
					
					
		
		//System.out.println(allstr);
		// TODO Auto-generated method stub
		FileManager.get().addLocatorClassLoader(SingleQueryHandler.class.getClassLoader());
		
		
		Model model = RDFDataMgr.loadModel("./resource/additiveInformation.rdf") ;
		
		FileInputStream in1 = new FileInputStream(new File("./resource/additiveInformation.rdf"));
		FileInputStream in2 = new FileInputStream(new File("./resource/additiveClass.rdf"));
		model = ModelFactory.createOntologyModel();
		model.read(in1,null,"RDF/XML-ABBREV");
		model.read(in2,null,"RDF/XML-ABBREV");
		
		
		
		//Model model1= FileManager.get().loadModel("http://dbpedia.org/page/Jay_Chou");
		Model model2= FileManager.get().loadModel("./resource/additiveInformation.rdf");
		Model model3= FileManager.get().loadModel("./resource/additiveClass.rdf");
		
		
		model2.add(model3);
		//mainModel.add(model3);
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
		
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/additiveInformation/query", query);
		
		//QueryExecution qexec = QueryExecutionFactory.create(qs, model);
		String l;
		
		ArrayList<String> classArr = new ArrayList<String>();
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				l=sol.get("o").toString();
				
				classArr.add(l);
				c++;
				//System.out.println(sol);
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		
		
		return classArr;
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	public ArrayList<VioHistoryBean> getVioHistory(String importer) throws IOException {
		
		
		 ArrayList<VioHistoryBean> allviohistory = new ArrayList<VioHistoryBean>();
		
		String allstr=new String();
		
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:importer \""+importer+"\" .\n"
				+ "?s fim:importerAddress ?importerAddress .\n"
				+ "?s fim:topic ?topic .\n"
				+ "?s fim:releaseDate ?releaseDate .\n"
				+ "?s fim:manufacturer ?manufacturer .\n"
				+ "?s fim:placeOfOrigin ?placeOfOrigin .\n"
				+ "?s fim:reason ?reason .\n"
				+ "?s fim:lawRestriction ?lawRestriction .\n"
				+ "?s fim:photo ?photo .\n"
				+ "?s fim:situation ?situation .\n"
				+ "?s fim:testDate ?testDate .\n"
				+ "?s fim:reasonDetail ?reasonDetail .\n"
				+ "}\n";
					
		
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
	
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/violationHistoryInformation/query", query);

		String l;
		
		ArrayList<String> classArr = new ArrayList<String>();
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				
				VioHistoryBean viohistoryObj = new VioHistoryBean();
				
				viohistoryObj.setImporter(importer);
				viohistoryObj.setImporterAddress(sol.get("importerAddress").toString());
				viohistoryObj.setTopic(sol.get("topic").toString());
				viohistoryObj.setLawRestriction(sol.get("lawRestriction").toString());
				viohistoryObj.setManufacturer(sol.get("manufacturer").toString());
				viohistoryObj.setPhoto(sol.get("photo").toString());
				viohistoryObj.setPlaceOfOrigin(sol.get("placeOfOrigin").toString());
				viohistoryObj.setReason(sol.get("reason").toString());
				viohistoryObj.setReleaseDate(sol.get("releaseDate").toString());
				viohistoryObj.setTestDate(sol.get("testDate").toString());
				viohistoryObj.setReasonDetail(sol.get("reasonDetail").toString());
				viohistoryObj.setSituation(sol.get("situation").toString());
				
				
				allviohistory.add(viohistoryObj);
				c++;
				//System.out.println(sol);
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		
		
		
		//System.out.println(allviohistory);
		
		
		return allviohistory;
	}
	

	public ArrayList<VioAdvertBean> getVioAdvert(String importer) throws IOException {
		
		

		ArrayList<VioAdvertBean> allvioAdvert = new ArrayList<VioAdvertBean>();
		
		String allstr=new String();
		
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX fimadd: <http://data.fim.com.tw/rdf/resource/addiclass/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:vioCompany \""+importer+"\" .\n"
				+ "?s fim:productName ?productName .\n"
				+ "?s fim:punishDate ?punishDate .\n"
				+ "?s fim:punishLaw ?punishLaw .\n"
				+ "?s fim:publishDate ?publishDate .\n"
				+ "?s fim:mediaClass ?mediaClass .\n"
				+ "?s fim:media ?media .\n"
				+ "?s fim:situation ?situation .\n"
				+ "?s fim:punishOrgan ?punishOrgan .\n"
				+ "}\n";
					
		/*
		//System.out.println(allstr);
		FileManager.get().addLocatorClassLoader(SingleQueryHandler.class.getClassLoader());
		
		
	
		FileInputStream in1 = new FileInputStream(new File("./resource/violationAdvertInformation.rdf"));
	
		Model model = ModelFactory.createOntologyModel();
		model.read(in1,null,"RDF/XML-ABBREV");
		
		
		*/
		
		
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/violationAdvertInformation/query", query);

		
		//QueryExecution qexec = QueryExecutionFactory.create(qs, model);
		String l;
		
		ArrayList<String> classArr = new ArrayList<String>();
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				
				VioAdvertBean vioAdvertObj = new VioAdvertBean();
				vioAdvertObj.setVioCompany(importer);
				vioAdvertObj.setProductName(sol.get("productName").toString());
				vioAdvertObj.setMedia(sol.get("media").toString());
				vioAdvertObj.setMediaClass(sol.get("mediaClass").toString());
				vioAdvertObj.setPublishDate(sol.get("publishDate").toString());
				vioAdvertObj.setPunishDate(sol.get("punishDate").toString());
				vioAdvertObj.setPunishlaw(sol.get("punishLaw").toString());
				vioAdvertObj.setPunishOrgan(sol.get("punishOrgan").toString());
				vioAdvertObj.setSituation(sol.get("situation").toString());
		
				
				
				allvioAdvert.add(vioAdvertObj);
				c++;
				//System.out.println(sol);
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		
		//System.out.println(allvioAdvert.get(0));
		
		
		return allvioAdvert;
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public HealthFoodBean getHealthFoodInfo(String productName) {
		
		String allstr=new String();
		HealthFoodBean healthFoodObj=new HealthFoodBean();
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX fimadd: <http://data.fim.com.tw/rdf/resource/addiclass/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:chiName \""+productName+"\" .\n"
				+"?s fim:approvedDate ?approvedDate .\n"
				+"?s fim:approvedSit ?approvedSit .\n"
				+"?s fim:effectClaim ?effectClaim .\n"
				+"?s fim:warning ?warning .\n"
				+"?s fim:approvedID ?approvedID .\n"
				+"?s fim:precautions ?precautions .\n"
				+"?s fim:effect ?effect .\n"
				+"?s fim:appSuppliers ?appSuppliers .\n"
				+"?s fim:cls ?cls .\n"
				+"?s fim:ingredient ?ingredient .\n"
				+ "}\n";
					
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
		
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/HealthFood/query", query);

		String l;
		
		ArrayList<String> classArr = new ArrayList<String>();
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				
				healthFoodObj.setChiName(productName);
				healthFoodObj.setApprovedDate(sol.get("approvedDate").toString());
				healthFoodObj.setApprovedID(sol.get("approvedID").toString());
				healthFoodObj.setApprovedSit(sol.get("approvedSit").toString());
				healthFoodObj.setAppSuppliers(sol.get("appSuppliers").toString());
				healthFoodObj.setCls(sol.get("cls").toString());
				healthFoodObj.setEffect(sol.get("effect").toString());
				healthFoodObj.setEffectClaim(sol.get("effectClaim").toString());
				healthFoodObj.setIngredient(sol.get("ingredient").toString());
				healthFoodObj.setPrecautions(sol.get("precautions").toString());
				healthFoodObj.setWarning(sol.get("warning").toString());
				
				
				c++;
				
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		
		//System.out.println(healthFoodObj);
		return healthFoodObj;
		
		
		
	}
	
	public ArrayList<HealthFoodBean> getHealthFoodByEffect (String effect) {
		
		ArrayList<HealthFoodBean> allEffectProduct = new ArrayList<HealthFoodBean>();
		String allstr=new String();
		
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX fimadd: <http://data.fim.com.tw/rdf/resource/addiclass/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:effect \""+effect+"\" .\n"
				+"?s fim:approvedDate ?approvedDate .\n"
				+"?s fim:approvedSit ?approvedSit .\n"
				+"?s fim:effectClaim ?effectClaim .\n"
				+"?s fim:warning ?warning .\n"
				+"?s fim:approvedID ?approvedID .\n"
				+"?s fim:precautions ?precautions .\n"
				+"?s fim:chiName ?productName .\n"
				+"?s fim:appSuppliers ?appSuppliers .\n"
				+"?s fim:cls ?cls .\n"
				+"?s fim:ingredient ?ingredient .\n"
				+ "}\n";
					
					
		
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
		
		
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/HealthFood/query", query);

		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				HealthFoodBean healthFoodObj=new HealthFoodBean();
				
				healthFoodObj.setChiName(sol.get("productName").toString());
				healthFoodObj.setApprovedDate(sol.get("approvedDate").toString());
				healthFoodObj.setApprovedID(sol.get("approvedID").toString());
				healthFoodObj.setApprovedSit(sol.get("approvedSit").toString());
				healthFoodObj.setAppSuppliers(sol.get("appSuppliers").toString());
				healthFoodObj.setCls(sol.get("cls").toString());
				healthFoodObj.setEffect(effect);
				healthFoodObj.setEffectClaim(sol.get("effectClaim").toString());
				healthFoodObj.setIngredient(sol.get("ingredient").toString());
				healthFoodObj.setPrecautions(sol.get("precautions").toString());
				healthFoodObj.setWarning(sol.get("warning").toString());
				
				c++;
				allEffectProduct.add(healthFoodObj);
				
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		//System.out.println(c);
		//System.out.println(allEffectProduct.get(0));
		return allEffectProduct;
		
		
	}
	
	public ProductInfoBean getProductInfo(String barcode)
	{
		ProductInfoBean productObj = new ProductInfoBean();
		
		
		String allstr=new String();
		
		/*
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select * \n"
				+"where{\n"
				+"?s fim:barcode \""+barcode+"\" .\n"
				+"?s fim:name ?name .\n"
				+"?s fim:agents ?agents .\n"
				+"?s fim:placeOfOrigin ?placeOfOrigin .\n"
				+"?s fim:importer ?importer .\n"
				+"?s fim:manufactAddress ?manufactAddress .\n"
				+"OPTIONAL {?s fim:additive ?additive .}\n"
				+"OPTIONAL {?s fim:relatedInfo ?relInfo. FILTER (strstarts(str(fim:relatedInfo), str(rdf:_)))}\n"
				+ "}\n";
					
		*/
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select REDUCED * \n"
				+"where{\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:productName ?name .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:agents ?agents .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:placeOfOrigin ?placeOfOrigin .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:importer ?importer .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:manufactAddress ?manufactAddress .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:additive ?additive .}\n"
				//+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:relatedInfo ?relInfo. FILTER (strstarts(str(fim:relatedInfo), str(rdf:_)))}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:relatedInfo ?relInfo .}\n"
				+ "}\n";
		
		
		
		
		System.out.println(allstr);
		
		String qs=allstr;
		
		Query query=QueryFactory.create(qs);
		
	
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/productTemp/query", query);

		String l;
		
		ArrayList<String> add=new ArrayList<String>();
		
		ArrayList<String> rel=new ArrayList<String>();
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				
				
				productObj.setBarcode(barcode);
				
				
				
				
				
				try{
					productObj.setProductName(sol.get("name").toString());
					
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setAgent(sol.get("agents").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setImporter(sol.get("importer").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setManuAddress(sol.get("manufactAddress").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setPlaceOfOrigin(sol.get("placeOfOrigin").toString());
				}catch(Exception e)
				{
					
				}
				try{
					
					add.add(sol.get("additive").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					
					if(rel.size()==0)
						
						rel.add(sol.get("relInfo").toString());
					
					for(int i=0;i<rel.size();i++)
					{
					if(sol.get("relInfo").toString().equals(rel.get(i))!=true)
					{
						rel.add(sol.get("relInfo").toString());
					}
					}
					
					
				}catch(Exception e)
				{
					
				}
				
				
				
				
				
				
				
				
				//productObj.addrelInfo(sol.get("relInfo").toString());
				
				
				
				
				c++;
				//System.out.println(sol);
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		
		productObj.setAdditive(add);
		productObj.setRelInfo(rel);
		
		
		//System.out.println(productObj.getRelInfo().size());
		//System.out.println(productObj);
		return productObj;
		
	}
	
	
	
	public ProductInfoBean getDistinctProductInfo(String barcode)
	{
		ProductInfoBean productObj = new ProductInfoBean();
		
		
		String qs=new String();
		
		
		ArrayList<String> add=new ArrayList<String>();
		
		ArrayList<String> rel=new ArrayList<String>();
		
		qs="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select REDUCED * \n"
				+"where{\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:productName ?name .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:agents ?agents .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:placeOfOrigin ?placeOfOrigin .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:importer ?importer .}\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:manufactAddress ?manufactAddress .}\n"
				+ "}\n";
		
		
		String additiveStr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select Distinct * \n"
				+"where{\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:additive ?additive .}\n"
				+ "}\n";
				
		String relInfoStr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+"select Distinct * \n"
				+"where{\n"
				+"OPTIONAL {<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcode+"> fim:relatedInfo ?relInfo .}\n"
				+ "}\n";
		
		//System.out.println(allstr);
		
		Query query=QueryFactory.create(qs);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:3030/productTemp/query", query);
		int c=0;
		try {
			ResultSet results=qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				productObj.setBarcode(barcode);
				try{
					productObj.setProductName(sol.get("name").toString());
					
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setAgent(sol.get("agents").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setImporter(sol.get("importer").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setManuAddress(sol.get("manufactAddress").toString());
					
				}catch(Exception e)
				{
					
				}
				try{
					
					productObj.setPlaceOfOrigin(sol.get("placeOfOrigin").toString());
				}catch(Exception e)
				{
				}
				
				c++;
				//System.out.println(sol);
			}
			
		}
		finally {
			
			qexec.close();
			
		}
		Query queryADD=QueryFactory.create(additiveStr);
		QueryExecution qexecADD = QueryExecutionFactory.sparqlService("http://localhost:3030/productTemp/query", queryADD);
		
		try {
			ResultSet results=qexecADD.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				
				try{
					
					add.add(sol.get("additive").toString());
					
				}catch(Exception e)
				{
					
				}
				
			}
			
		}
		finally {
			
			qexecADD.close();
			
		}
		Query queryRel=QueryFactory.create(relInfoStr);
		QueryExecution qexecRel = QueryExecutionFactory.sparqlService("http://localhost:3030/productTemp/query", queryRel);
		
		try {
			ResultSet results=qexecRel.execSelect();
			while(results.hasNext()) {
				QuerySolution sol=results.nextSolution();
				
				try{
					
					rel.add(sol.get("relInfo").toString());
					
				}catch(Exception e)
				{
					
				}
				
			}
			
		}
		finally {
			
			qexecRel.close();
			
		}
		
		productObj.setAdditive(add);
		productObj.setRelInfo(rel);
		
		
		//System.out.println(productObj.getRelInfo().size());
		//System.out.println(productObj);
		return productObj;
		
	}
	
	
	
	
	
	
	
	public void InsertProductInformation(String barcodeNum,String ProductName,ArrayList<String> AdditiveData,String ImporterPara,String PlaceOfOriginPara,String AgentPara,ArrayList<String> relatedInfo,String manuAddress)
	{
		String allstr = new String();
		
		String AdditiveDataQStr= new String();
		String relatedInfoQStr=new String();
		
		
		String fimNameURI="<http://data.fim.com.tw/rdf/resource/ProductInformation/"+barcodeNum+">";
		
		for(String add:AdditiveData)
		{
			AdditiveDataQStr+=fimNameURI+" fim:additive \""+add+"\" .\n";
		}
		for(String rel:relatedInfo)
		{
			relatedInfoQStr+=fimNameURI+" fim:relatedInfo \""+rel+"\" .\n";
			
		}
		
		
		
		
		allstr="PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "INSERT DATA {\n"
				+ AdditiveDataQStr
				+ relatedInfoQStr
				+ fimNameURI +" fim:name \""+ProductName+"\" .\n"
				+ fimNameURI +" fim:importer \""+ImporterPara+"\" .\n"
				+ fimNameURI +" fim:agents \""+AgentPara+"\" .\n"
				+ fimNameURI +" fim:placeOfOrigin \""+PlaceOfOriginPara+"\" .\n"
				+ fimNameURI +" fim:manufactAddress \""+manuAddress+"\" .\n"
				+"}";
		
		
		
		System.out.println(allstr);
		
		ArrayList<String> separateStr=new ArrayList<String>();
		
		separateStr.add("PREFIX fim: <http://data.fim.com.tw/rdf/resource/>\n"
				+ "INSERT DATA {\n"
				+ AdditiveDataQStr
				+ relatedInfoQStr
				+ "}");
		
		separateStr.add("INSERT {\n"
				+ fimNameURI +" fim:name \""+ProductName+"\" .}\n"
				+ "WHERE { "+fimNameURI+" fim:name \""+"\" .}\n");
		
		separateStr.add( "INSERT {\n"
				+ fimNameURI +" fim:importer \""+ImporterPara+"\" .}\n"
				+ "WHERE { "+fimNameURI+" fim:importer \""+"\" .}\n");
		separateStr.add( "INSERT {\n"
				+ fimNameURI +" fim:agents \""+AgentPara+"\" .}\n"
				+ "WHERE { "+fimNameURI+" fim:agents \""+"\" .}\n");
		separateStr.add( "INSERT {\n"
				+ fimNameURI +" fim:placeOfOrigin \""+PlaceOfOriginPara+"\" .}\n"
				+ "WHERE { "+fimNameURI+" fim:placeOfOrigin \""+"\" .}\n");
		separateStr.add("INSERT {\n"
				+ fimNameURI +" fim:manufactAddress \""+manuAddress+"\" .}\n"
				+ "WHERE { "+fimNameURI+" fim:manufactAddres"
						+ " \""+"\" .}\n");
		
		/*
		UpdateRequest q = UpdateFactory.create(allstr);
		UpdateProcessor u = UpdateExecutionFactory.createRemote(q,"http://localhost:3030/product/");
		u.execute();
		*/
		
		UpdateRequest ur = new UpdateRequest();
		UpdateProcessor up;
		String  service ="http://localhost:3030/productTemp/update";
		
		ur.add(allstr);

		up=UpdateExecutionFactory.createRemote(ur,service);
		up.execute();
		
		
		System.out.println(allstr+"\nInsertData complete.");
		
		
	}
	
	
	
	
	
	
}
