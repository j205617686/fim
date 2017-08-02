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
			
			a.setCls(arr.getJSONObject(0).getString("���O").split(" ")[1].toString());
			a.setChiName(arr.getJSONObject(1).getString("����~�W").toString());
			a.setEngName(arr.getJSONObject(2).getString("�^��~�W").toString());
			a.setRange(arr.getJSONObject(3).getString("�ϥέ��~�d��έ��q").toString());
			a.setRestriction(arr.getJSONObject(4).getString("�ϥέ���").toString());
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
			
			a.setPlaceOfOrigin(arr.getJSONObject(0).getString("���a"));
			a.setTopic(arr.getJSONObject(1).getString("�D��"));
			a.setReason(arr.getJSONObject(2).getString("��]"));
			a.setImporter(arr.getJSONObject(3).getString("�i�f�ӦW��"));
			a.setImporterAddress(arr.getJSONObject(4).getString("�i�f�Ӧa�}"));
			a.setReasonDetail(arr.getJSONObject(6).getString("���X���]�[�˥X�q�Բӻ���"));
			a.setLawRestriction(arr.getJSONObject(7).getString("�k�W���q�з�"));
			a.setManufacturer(arr.getJSONObject(8).getString("�s�y�t�ΥX�f�ӦW��"));
			a.setSituation(arr.getJSONObject(12).getString("�B�m����"));
			a.setReleaseDate(arr.getJSONObject(13).getString("�o�����"));
			a.setTestDate(arr.getJSONObject(14).getString("������z���"));
			a.setPhoto(arr.getJSONObject(15).getString("����"));
			
			
			
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
			
			a.setProductName(arr.getJSONObject(0).getString("�H�W���~�W��"));
			a.setVioCompany(arr.getJSONObject(1).getString("�H�W�t�ӦW�٩έt�d�H"));
			a.setPunishOrgan(arr.getJSONObject(2).getString("�B������"));
			a.setPunishDate(arr.getJSONObject(3).getString("�B�����"));
			a.setPunishlaw(arr.getJSONObject(4).getString("�B���k��"));
			a.setPublishDate(arr.getJSONObject(5).getString("�Z�����"));
			a.setMediaClass(arr.getJSONObject(6).getString("�Z���C�����O"));
			a.setMedia(arr.getJSONObject(7).getString("�Z���C��"));
			a.setSituation(arr.getJSONObject(8).getString("�d�B����"));
		
			
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
			
			a.setApprovedID(arr.getJSONObject(0).getString("�\�i�Ҧr��"));
			a.setCls(arr.getJSONObject(1).getString("���O"));
			a.setChiName(arr.getJSONObject(2).getString("����~�W"));
			a.setApprovedDate(arr.getJSONObject(3).getString("�֥i���"));
			a.setAppSuppliers(arr.getJSONObject(4).getString("�ӽа�"));
			a.setApprovedSit(arr.getJSONObject(5).getString("�Ҫp"));
			a.setIngredient(arr.getJSONObject(6).getString("�O���\�Ĭ�������"));
			a.setEffect(arr.getJSONObject(7).getString("�O���\��"));;
			a.setEffectClaim(arr.getJSONObject(8).getString("�O���\�īź�"));
			a.setWarning(arr.getJSONObject(9).getString("ĵ�y"));
			a.setPrecautions(arr.getJSONObject(10).getString("�`�N�ƶ�"));
			
		
			
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
			
			a.setApprovedID(arr.getJSONObject(0).getString("�\�i�Ҧr��"));
			a.setCls(arr.getJSONObject(1).getString("���O"));
			a.setChiName(arr.getJSONObject(2).getString("����~�W"));
			a.setApprovedDate(arr.getJSONObject(3).getString("�֥i���"));
			a.setAppSuppliers(arr.getJSONObject(4).getString("�ӽа�"));
			a.setApprovedSit(arr.getJSONObject(5).getString("�Ҫp"));
			a.setIngredient(arr.getJSONObject(6).getString("�O���\�Ĭ�������"));
			a.setEffect(arr.getJSONObject(7).getString("�O���\��"));;
			a.setEffectClaim(arr.getJSONObject(8).getString("�O���\�īź�"));
			a.setWarning(arr.getJSONObject(9).getString("ĵ�y"));
			a.setPrecautions(arr.getJSONObject(10).getString("�`�N�ƶ�"));
			
		
			
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
			
			c.setChiName(arr.getJSONObject(0).getString("���O"));
			c.setEngName(arr.getJSONObject(1).getString("�^��W"));
			c.setPurpose(arr.getJSONObject(2).getString("�ت��@��"));
			
			JSONArray commArr = (JSONArray) arr.getJSONObject(3).get("�`���~�W");
			
			ArrayList<Common> comAL=new ArrayList<Common>();
			for(int j=0;j<commArr.length();j++)
			{
				
				
				String number=Integer.toString(j);
				
				JSONObject comm= (JSONObject)commArr.get(j);
				
				JSONArray coma=(JSONArray)comm.get(number);
				
				
				Common co=new Common();
				
				co.setItems(coma.getJSONObject(0).getString("�����~��"));
				co.setSideEffect(coma.getJSONObject(1).getString("�L�q�i��Ƨ@��"));
				co.setExample(coma.getJSONObject(2).getString("�Ҥl"));
				
				
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
