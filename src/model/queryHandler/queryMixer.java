package model.queryHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import static java.lang.System.*; 
import model.bean.*;
public class queryMixer {


	public static void main(String[] arg) throws IOException {
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
		
		//案例1
		String productName="原萃日式纖綠茶";
		System.out.println("產品名稱:"+productName);
		
		out.println("其中一個成分:"+SQH.getProductInfo(productName).getAdditive().get(2));
		out.println("用添加劑找到:"+SQH.getAdditiveInfo(SQH.getProductInfo(productName).getAdditive().get(2)).get(0));
		out.println("此添加劑類別:"+SQH.getAdditiveInfo(SQH.getProductInfo(productName).getAdditive().get(2)).get(0).getCls());
		out.println("此添加劑類別資訊:"+SQH.getClassInfo(SQH.getAdditiveInfo("碳酸氫鈉").get(0).getCls()));
		
		out.println("\n\n---------------------------------------");
		//案例2
		
		String productName2="大創本煉羊羹";
		System.out.println("產品名稱:"+productName2);
		
		out.println("公司名稱:"+SQH.getProductInfo(productName2));
		out.println("此間公司違規歷史資訊:"+"共"+SQH.getVioHistory("台灣大創百貨股份有限公司").size()+"個,第一個是:"+SQH.getVioHistory("台灣大創百貨股份有限公司").get(0));
		
		out.println("\n\n---------------------------------------");
		//案例3
		
		
		String productName3="艾琳台灣綠茶";
		System.out.println("產品名稱:"+productName3);
		
		out.println("公司名稱:"+SQH.getProductInfo(productName3));
		out.println("此間公司違規廣告資訊:"+"共"+SQH.getVioAdvert("艾琳農坊股份有限公司").size()+"個,第一個是:"+SQH.getVioAdvert("艾琳農坊股份有限公司"));
		
		out.println("\n\n---------------------------------------");
		//案例4
		
		String productName4="雀巢金選奶茶";
		System.out.println("產品名稱:"+productName4);
		
		out.println("公司名稱:"+SQH.getProductInfo(productName4));
		out.println("此間公司違規歷史資訊:"+"共"+SQH.getVioHistory("台灣雀巢股份有限公司").size()+"個,第一個是:"+SQH.getVioHistory("台灣雀巢股份有限公司").get(0));
		
		out.println("\n\n---------------------------------------");
		//案例5
		
		
		
		String productName5="精製餅乾";
		System.out.println("產品名稱:"+productName5);
		
		out.println("公司名稱:"+SQH.getProductInfo(productName5));
		out.println("此間公司違規歷史資訊:"+"共"+SQH.getVioHistory("鴻滕貿易有限公司").size()+"個,第一個是:"+SQH.getVioHistory("鴻滕貿易有限公司").get(0));
		out.println("此間公司違規廣告資訊:"+"共"+SQH.getVioAdvert("香華天普忍國際股份有限公司").size()+"個,第一個是:"+SQH.getVioAdvert("香華天普忍國際股份有限公司").get(0));
		
		
		out.println("\n\n---------------------------------------");
	
		//案例6
		String productName6="奧利多碳酸飲料";
		System.out.println("產品名稱:"+SQH.getProductInfo(productName6));
		
		System.out.println(SQH.getHealthFoodInfo(productName6));
		System.out.println("用effect找到的: 共"+SQH.getHealthFoodByEffect(SQH.getHealthFoodInfo(productName6).getEffect()).size()
				+"個,第一個是:"+SQH.getHealthFoodByEffect(SQH.getHealthFoodInfo(productName6).getEffect()).get(0));
		
		
		
		
		
		
		
		
		
		
	}

}
