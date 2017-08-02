package model.bean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class getJSONData {

	
	public static String toUtf8(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes("UTF-8"),"UTF-8");
		}
	
	public ArrayList<AdditiveBean> getAdditiveData() throws JSONException  {
		// TODO Auto-generated method stub

		JavaHttpUrlConnectionReader reader=new JavaHttpUrlConnectionReader("http://data.fda.gov.tw/cacheData/61_3.json");
		
		String getRidOfQM=reader.getResults().substring(1, reader.getResults().length()-1);
		
		ArrayList<AdditiveBean> allAddiAL= new ArrayList<AdditiveBean>();
		
		
		
		JSONArray allAdd=new JSONArray(getRidOfQM);
		
		//System.out.println(allAdd);
		
		int all=1233826;
		
		
		for(int i=0;i<allAdd.length();i++)
		{

			
			
			
			
			JSONArray arr=(JSONArray) allAdd.get(i);
			
			/*
			for(int j=0;j<arr.length();j++)
			{
			
			JSONObject obj=arr.getJSONObject(i);
			
			
			System.out.println(obj);
			
			}
			*/
			AdditiveBean a=new AdditiveBean();
			
			a.setCls(arr.getJSONObject(0).getString("類別").split(" ")[1].toString());
			a.setChiName(arr.getJSONObject(1).getString("中文品名").toString());
			a.setEngName(arr.getJSONObject(2).getString("英文品名").toString());
			a.setRange(arr.getJSONObject(3).getString("使用食品範圍及限量").toString());
			a.setRestriction(arr.getJSONObject(4).getString("使用限制").toString());
			a.setShortlink("http://opendatataiwan.com/d/"+all+"/additive");
			allAddiAL.add(a);
			
			all--;
		
		}
		
		
		/*
		for(AdditiveBean a : allAddiAL)
		{
			
			System.out.println(a.cls +","+a.chiName+","+a.shortlink);
		}
		
		*/
		
		return allAddiAL;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
	public ArrayList<VioHistoryBean> getVioHistoryData() throws JSONException  {
		
		ArrayList<VioHistoryBean> allVioHisAL=new ArrayList<VioHistoryBean>();
		
		
		JavaHttpUrlConnectionReader reader=new JavaHttpUrlConnectionReader("http://data.fda.gov.tw/cacheData/52_3.json");
		
		String getRidOfQM=reader.getResults().substring(1, reader.getResults().length()-1);
		
		
		JSONArray allVio=new JSONArray(getRidOfQM);
		
		for(int i=0;i<allVio.length();i++)
		{

			
			
			
			
			JSONArray arr=(JSONArray) allVio.get(i);
			
			/*
			for(int j=0;j<arr.length();j++)
			{
			
			JSONObject obj=arr.getJSONObject(i);
			
			
			System.out.println(obj);
			
			}
			*/
			VioHistoryBean a=new VioHistoryBean();
			
			a.setPlaceOfOrigin(arr.getJSONObject(0).getString("產地"));
			a.setTopic(arr.getJSONObject(1).getString("主旨"));
			a.setReason(arr.getJSONObject(2).getString("原因"));
			a.setImporter(arr.getJSONObject(3).getString("進口商名稱"));
			a.setImporterAddress(arr.getJSONObject(4).getString("進口商地址"));
			a.setReasonDetail(arr.getJSONObject(6).getString("不合格原因暨檢出量詳細說明"));
			a.setLawRestriction(arr.getJSONObject(7).getString("法規限量標準"));
			a.setManufacturer(arr.getJSONObject(8).getString("製造廠或出口商名稱"));
			a.setSituation(arr.getJSONObject(12).getString("處置情形"));
			a.setReleaseDate(arr.getJSONObject(13).getString("發布日期"));
			a.setTestDate(arr.getJSONObject(14).getString("報驗受理日期"));
			a.setPhoto(arr.getJSONObject(15).getString("附圖"));
			
			
			
			allVioHisAL.add(a);
			
			
		}
		
		
		return allVioHisAL;
		
		
		/*
		for(VioHistoryBean a : allVioHisAL)
		{
			
			System.out.println(a.getImporter());
		}
		*/
		
		
		
		
		
		
		
		
	}
		
	public ArrayList<VioAdvertBean> getVioAdvertData() throws JSONException  {
		
		ArrayList<VioAdvertBean> allVioAdertAL=new ArrayList<VioAdvertBean>();
		
		
		JavaHttpUrlConnectionReader reader=new JavaHttpUrlConnectionReader("http://data.fda.gov.tw/cacheData/22_3.json");
		
		String getRidOfQM=reader.getResults().substring(1, reader.getResults().length()-1);
		
		
		JSONArray allVio=new JSONArray(getRidOfQM);
		
		for(int i=0;i<allVio.length();i++)
		{

			
			
			
			
			JSONArray arr=(JSONArray) allVio.get(i);
			
			/*
			for(int j=0;j<arr.length();j++)
			{
			
			JSONObject obj=arr.getJSONObject(i);
			
			
			System.out.println(obj);
			
			}
			*/
			VioAdvertBean a=new VioAdvertBean();
			
			a.setProductName(arr.getJSONObject(0).getString("違規產品名稱"));
			a.setVioCompany(arr.getJSONObject(1).getString("違規廠商名稱或負責人"));
			a.setPunishOrgan(arr.getJSONObject(2).getString("處分機關"));
			a.setPunishDate(arr.getJSONObject(3).getString("處分日期"));
			a.setPunishlaw(arr.getJSONObject(4).getString("處分法條"));
			a.setPublishDate(arr.getJSONObject(5).getString("刊播日期"));
			a.setMediaClass(arr.getJSONObject(6).getString("刊播媒體類別"));
			a.setMedia(arr.getJSONObject(7).getString("刊播媒體"));
			a.setSituation(arr.getJSONObject(8).getString("查處情形"));
		
			
			allVioAdertAL.add(a);
			
			
		}
		
		
		
		
		
		
		for(VioAdvertBean a : allVioAdertAL)
		{
			
			System.out.println(a.getProductName()+a.getPunishOrgan());
		}
		
		return allVioAdertAL;
		
		
		
		
		
		
		
	}
		
	public ArrayList<HealthFoodBean> getHealthFood() throws JSONException  {
		
		ArrayList<HealthFoodBean> allHealthFoodAL=new ArrayList<HealthFoodBean>();
		
		
		JavaHttpUrlConnectionReader reader=new JavaHttpUrlConnectionReader("http://data.fda.gov.tw/cacheData/19_3.json");
		
		String getRidOfQM=reader.getResults().substring(1, reader.getResults().length()-1);
		
		
		JSONArray allVio=new JSONArray(getRidOfQM);
		
		for(int i=0;i<allVio.length();i++)
		{

			
			
			
			
			JSONArray arr=(JSONArray) allVio.get(i);
			
			/*
			for(int j=0;j<arr.length();j++)
			{
			
			JSONObject obj=arr.getJSONObject(i);
			
			
			System.out.println(obj);
			
			}
			*/
			HealthFoodBean a=new HealthFoodBean();
			
			a.setApprovedID(arr.getJSONObject(0).getString("許可證字號"));
			a.setCls(arr.getJSONObject(1).getString("類別"));
			a.setChiName(arr.getJSONObject(2).getString("中文品名"));
			a.setApprovedDate(arr.getJSONObject(3).getString("核可日期"));
			a.setAppSuppliers(arr.getJSONObject(4).getString("申請商"));
			a.setApprovedSit(arr.getJSONObject(5).getString("證況"));
			a.setIngredient(arr.getJSONObject(6).getString("保健功效相關成分"));
			a.setEffect(arr.getJSONObject(7).getString("保健功效"));;
			a.setEffectClaim(arr.getJSONObject(8).getString("保健功效宣稱"));
			a.setWarning(arr.getJSONObject(9).getString("警語"));
			a.setPrecautions(arr.getJSONObject(10).getString("注意事項"));
			
		
			
			allHealthFoodAL.add(a);
			
			
		}
		
		
		
		
		
		/*
		for(HealthFoodBean a : allHealthFoodAL)
		{
			
			System.out.println(a);
		}
		*/
		
		System.out.println(allHealthFoodAL.get(0));
		
		return allHealthFoodAL;
		
		
		
		
		
		
		
	}
			
	
	public ArrayList<?> getBeanData() throws JSONException{
		
		
		ArrayList<HealthFoodBean> allHealthFoodAL=new ArrayList<HealthFoodBean>();
		
		
		JavaHttpUrlConnectionReader reader=new JavaHttpUrlConnectionReader("http://data.fda.gov.tw/cacheData/19_3.json");
		
		String getRidOfQM=reader.getResults().substring(1, reader.getResults().length()-1);
		
		
		JSONArray allVio=new JSONArray(getRidOfQM);
		
		for(int i=0;i<allVio.length();i++)
		{

			
			
			
			
			JSONArray arr=(JSONArray) allVio.get(i);
			
			/*
			for(int j=0;j<arr.length();j++)
			{
			
			JSONObject obj=arr.getJSONObject(i);
			
			
			System.out.println(obj);
			
			}
			*/
			HealthFoodBean a=new HealthFoodBean();
			
			a.setApprovedID(arr.getJSONObject(0).getString("許可證字號"));
			a.setCls(arr.getJSONObject(1).getString("類別"));
			a.setChiName(arr.getJSONObject(2).getString("中文品名"));
			a.setApprovedDate(arr.getJSONObject(3).getString("核可日期"));
			a.setAppSuppliers(arr.getJSONObject(4).getString("申請商"));
			a.setApprovedSit(arr.getJSONObject(5).getString("證況"));
			a.setIngredient(arr.getJSONObject(6).getString("保健功效相關成分"));
			a.setEffect(arr.getJSONObject(7).getString("保健功效"));;
			a.setEffectClaim(arr.getJSONObject(8).getString("保健功效宣稱"));
			a.setWarning(arr.getJSONObject(9).getString("警語"));
			a.setPrecautions(arr.getJSONObject(10).getString("注意事項"));
			
		
			
			allHealthFoodAL.add(a);
			
			
		}
		
		
		
		
		
		/*
		for(HealthFoodBean a : allHealthFoodAL)
		{
			
			System.out.println(a);
		}
		*/
		
		System.out.println(allHealthFoodAL.get(0));
		
		return allHealthFoodAL;
		
		
		
		
		
		
		
		
	}
	
	
	public ArrayList<additiveClassBean> getAddiClassData() throws JSONException, IOException{
		
		
		
		//FileReader fr = new FileReader();

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./resource/additiveClass.txt"), "UTF-8"));
		String allstr=new String();
		while (br.ready()) {

			//System.out.println(br.readLine());
			String tempstr=br.readLine();
			
			
			//System.out.println(br.readLine());
			
			allstr+=tempstr;
			allstr+="\n";

		}

		
		br.close();
		
		String getRidOfQM=allstr.substring(1, allstr.length()-1);
		
		JSONArray allAddClass = new JSONArray(getRidOfQM);
		
		ArrayList<additiveClassBean> cls=new ArrayList<additiveClassBean>();
		
		for(int i=0;i<allAddClass.length();i++)
		{
			
			additiveClassBean c=new additiveClassBean();
			
			JSONArray arr=(JSONArray) allAddClass.get(i);
			
			c.setChiName(arr.getJSONObject(0).getString("類別"));
			c.setEngName(arr.getJSONObject(1).getString("英文名"));
			c.setPurpose(arr.getJSONObject(2).getString("目的作用"));
			
			JSONArray commArr = (JSONArray) arr.getJSONObject(3).get("常見品名");
			
			ArrayList<Common> comAL=new ArrayList<Common>();
			for(int j=0;j<commArr.length();j++)
			{
				
				
				String number=Integer.toString(j);
				
				JSONObject comm= (JSONObject)commArr.get(j);
				
				JSONArray coma=(JSONArray)comm.get(number);
				
				
				Common co=new Common();
				
				co.setItems(coma.getJSONObject(0).getString("食物品項"));
				co.setSideEffect(coma.getJSONObject(1).getString("過量可能副作用"));
				co.setExample(coma.getJSONObject(2).getString("例子"));
				
				
				comAL.add(co);
			}
			
			c.setCommons(comAL);
			
			
			
			cls.add(c);
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return cls;
		
	}
	
	
	public static void main(String[] arg) throws JSONException, IOException {
		
		getJSONData g=new getJSONData();
		
		g.getAddiClassData();
		
		
		
	}
	
	
	
	
	
		
	
}
