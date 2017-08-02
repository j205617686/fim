package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.DataNotFoundException;
import model.bean.ProductInfoBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class getProductServlet
 */

public class getProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String barcode = request.getParameter("barcode");
		int exception=0;
		JSONObject alldata =new JSONObject();  //all json data include status
		Exception ex=null;
		JSONObject obj = new JSONObject();
		
	try{
		barcode = new String(barcode.getBytes("ISO-8859-1"), "UTF-8");
	
		System.out.println(barcode);
		//String companyName ="�S�ѥ�����ڸ�T�ѥ��������q";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
	    ProductInfoBean productObj=new ProductInfoBean();
	    		
	    productObj=SQH.getDistinctProductInfo(barcode);
		
	
	    
	    System.out.println(productObj.getRelInfo().size());
		
	   
		if(SQH.getProductInfo(barcode).getProductName().equals(""))
		{
			
			throw new DataNotFoundException();
		}
	    
			
				
				obj.put("ProductName",productObj.getProductName() );
				obj.put("importer", productObj.getImporter());
				obj.put("placeOfOrigin", productObj.getPlaceOfOrigin());
				obj.put("agents",productObj.getAgent());
				obj.put("manuAddress",productObj.getManuAddress());
				
				JSONArray addArr = new JSONArray();
				JSONArray relArr = new JSONArray();
				for(int i=0;i<productObj.getAdditive().size();i++)
				{
					addArr.put(productObj.getAdditive().get(i));
					
				}
				
				
				for(int i=0;i<productObj.getRelInfo().size();i++)
				{
					relArr.put(productObj.getRelInfo().get(i));
					//System.out.println(relArr);
				}
				
				obj.put("additive", addArr);
				
				obj.put("relInfo", relArr);
				
			
				
				
				
				
				
				
				
		}catch(Exception e)
		{
			exception++;
			ex=e;
			
		}
		
		if(exception==1)
		{
			try {
				alldata.put("status", "Exception:"+ex);
				alldata.put("data", obj);
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
				alldata.put("data", obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(alldata.toString());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
