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

import model.bean.DataNotFoundException;
import model.bean.ProductInfoBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class InsertProductServlet
 */

public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductServlet() {
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
		
		
		String action = request.getParameter("action");
		
		String oldData = request.getParameter("oldData");
		
		String newData = request.getParameter("newData");
		
		String barcode = request.getParameter("barcode");
		

		
		
		
		int exception=0;
		Exception ex = null;
		JSONObject alldata =new JSONObject();
		
		SingleQueryHandler SQH=new SingleQueryHandler();
		
		try{
			
			oldData = new String(oldData.getBytes("ISO-8859-1"), "UTF-8");
			newData = new String(newData.getBytes("ISO-8859-1"), "UTF-8");
			action = new String(action.getBytes("ISO-8859-1"), "UTF-8");
			
			
			System.out.println(action);
			System.out.println(oldData);
			
			System.out.println(newData);
			
			System.out.println(barcode);
			
			
			
		switch(action)
		{
		case "productName":
			System.out.println("productName");
			SQH.updateProductName(oldData,newData,barcode);
			
			
			
			break;
		case "agents":
			System.out.println("agents");
			SQH.updateAgents(oldData,newData,barcode);
			
			
			break;
		case "importer":
			System.out.println("importer");
			SQH.updateImporter(oldData,newData,barcode);
			
			break;
		case "placeOfOrigin":
			System.out.println("placeOfOrigin");
			SQH.updatePlaceOfOrigin(oldData,newData,barcode);
			
			break;
		case "manufactAddress":
			System.out.println("manufactAddress");
			SQH.updateManuAddress(oldData,newData,barcode);
			
			break;
		case "additive":
			System.out.println("additive");

			SQH.updateAdditive(oldData,newData,barcode);
			
			
			
			break;
		case "relInfo":
			
			System.out.println("relInfo");

			SQH.updateRelInfo(oldData,newData,barcode);
			
			
			break;
			
		default:
			System.out.println("DataNotFoundException");
			throw new DataNotFoundException();
		
		
		
		
		}
		
		
		
		}catch(Exception e)
		{
			exception++;
			ex=e;
			
		}
		
		if(exception==1)
		{
			try {
				alldata.put("status", "Exception:"+ex);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(alldata.toString());
			
		}
		else
		{
			try {
				alldata.put("status", "OK");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(alldata.toString());
		}
		
		
		
		
		
		
		
		
		

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
