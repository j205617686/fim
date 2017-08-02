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
		
		
		//�ר�1
		String productName="��Ѥ馡�ֺ��";
		System.out.println("���~�W��:"+productName);
		
		out.println("�䤤�@�Ӧ���:"+SQH.getProductInfo(productName).getAdditive().get(2));
		out.println("�βK�[�����:"+SQH.getAdditiveInfo(SQH.getProductInfo(productName).getAdditive().get(2)).get(0));
		out.println("���K�[�����O:"+SQH.getAdditiveInfo(SQH.getProductInfo(productName).getAdditive().get(2)).get(0).getCls());
		out.println("���K�[�����O��T:"+SQH.getClassInfo(SQH.getAdditiveInfo("�һĲB�u").get(0).getCls()));
		
		out.println("\n\n---------------------------------------");
		//�ר�2
		
		String productName2="�j�Х��Ҧ�ü";
		System.out.println("���~�W��:"+productName2);
		
		out.println("���q�W��:"+SQH.getProductInfo(productName2));
		out.println("�������q�H�W���v��T:"+"�@"+SQH.getVioHistory("�x�W�j�Цʳf�ѥ��������q").size()+"��,�Ĥ@�ӬO:"+SQH.getVioHistory("�x�W�j�Цʳf�ѥ��������q").get(0));
		
		out.println("\n\n---------------------------------------");
		//�ר�3
		
		
		String productName3="��Y�x�W���";
		System.out.println("���~�W��:"+productName3);
		
		out.println("���q�W��:"+SQH.getProductInfo(productName3));
		out.println("�������q�H�W�s�i��T:"+"�@"+SQH.getVioAdvert("��Y�A�{�ѥ��������q").size()+"��,�Ĥ@�ӬO:"+SQH.getVioAdvert("��Y�A�{�ѥ��������q"));
		
		out.println("\n\n---------------------------------------");
		//�ר�4
		
		String productName4="���_���磻��";
		System.out.println("���~�W��:"+productName4);
		
		out.println("���q�W��:"+SQH.getProductInfo(productName4));
		out.println("�������q�H�W���v��T:"+"�@"+SQH.getVioHistory("�x�W���_�ѥ��������q").size()+"��,�Ĥ@�ӬO:"+SQH.getVioHistory("�x�W���_�ѥ��������q").get(0));
		
		out.println("\n\n---------------------------------------");
		//�ר�5
		
		
		
		String productName5="��s�氮";
		System.out.println("���~�W��:"+productName5);
		
		out.println("���q�W��:"+SQH.getProductInfo(productName5));
		out.println("�������q�H�W���v��T:"+"�@"+SQH.getVioHistory("�E��T���������q").size()+"��,�Ĥ@�ӬO:"+SQH.getVioHistory("�E��T���������q").get(0));
		out.println("�������q�H�W�s�i��T:"+"�@"+SQH.getVioAdvert("���ؤѴ��԰�ڪѥ��������q").size()+"��,�Ĥ@�ӬO:"+SQH.getVioAdvert("���ؤѴ��԰�ڪѥ��������q").get(0));
		
		
		out.println("\n\n---------------------------------------");
	
		//�ר�6
		String productName6="���Q�h�һĶ���";
		System.out.println("���~�W��:"+SQH.getProductInfo(productName6));
		
		System.out.println(SQH.getHealthFoodInfo(productName6));
		System.out.println("��effect��쪺: �@"+SQH.getHealthFoodByEffect(SQH.getHealthFoodInfo(productName6).getEffect()).size()
				+"��,�Ĥ@�ӬO:"+SQH.getHealthFoodByEffect(SQH.getHealthFoodInfo(productName6).getEffect()).get(0));
		
		
		
		
		
		
		
		
		
		
	}

}
