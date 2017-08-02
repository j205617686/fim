package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.bean.ProductInfoBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/InsertProductServlet")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductInfoBean productObj=new ProductInfoBean();
		SingleQueryHandler SQH = null;
		
		String ProductJsonStr = new String();
		try {
			ProductJsonStr = request.getParameter("productJSON");
			
			ProductJsonStr = new String(ProductJsonStr.getBytes("ISO-8859-1"), "UTF-8");
		
			productObj = new ProductInfoBean();
			SQH = new  SingleQueryHandler();
		
		
			JSONObject productJson = new JSONObject(ProductJsonStr);

			ArrayList<String> additiveAL = new ArrayList<String>();

			ArrayList<String> relInfoAL = new ArrayList<String>();

			productObj.setImporter(productJson.get("importer").toString());
			productObj.setProductName(productJson.get("ProductName").toString());
			productObj.setPlaceOfOrigin(productJson.get("placeOfOrigin").toString());
			productObj.setManuAddress(productJson.get("manuAddress").toString());
			productObj.setAgent(productJson.get("agents").toString());

			for (int i = 0; i < productJson.getJSONArray("additive").length(); i++) {
				additiveAL.add(productJson.getJSONArray("additive").get(i).toString());
			}
			for (int i = 0; i < productJson.getJSONArray("relInfo").length(); i++) {
				relInfoAL.add(productJson.getJSONArray("relInfo").get(i).toString());
			}

			productObj.setAdditive(additiveAL);
			productObj.setRelInfo(relInfoAL);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			response.getWriter().write("Insert Failed");
		}

		SQH.InsertProductInformation(productObj.getBarcode(), productObj.getProductName(), productObj.getAdditive(), productObj.getImporter(), productObj.getPlaceOfOrigin(), productObj.getAgent(), productObj.getRelInfo(), productObj.getManuAddress());
		
		
		
		System.out.println(productObj.toString());
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write("Insert OK");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
