package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.bean.DataNotFoundException;
import model.bean.HealthFoodBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class getHealthFoodServlet
 */

public class getHealthFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getHealthFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String HealthFoodName = request.getParameter("healthfoodname");
		JSONObject obj = new JSONObject();
		int exception=0;
		JSONObject alldata =new JSONObject();  //all json data include status
		
		Exception ex=null;
		
	try{
		HealthFoodName = new String(HealthFoodName.getBytes("ISO-8859-1"), "UTF-8");
	
		System.out.println(HealthFoodName);
		//String companyName ="露天市集國際資訊股份有限公司";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
		System.out.println(SQH.getHealthFoodInfo(HealthFoodName));
		
		
		
		
		
		HealthFoodBean healthFoodObj =SQH.getHealthFoodInfo(HealthFoodName);
		
		
			if(healthFoodObj.getChiName().equals(""))
			{
				
				throw new DataNotFoundException();
			}
			
			
				
				obj.put("chiName", healthFoodObj.getChiName());
				obj.put("class", healthFoodObj.getCls());
				obj.put("ApprovedID", healthFoodObj.getApprovedID());
				obj.put("ApprovedSit", healthFoodObj.getApprovedSit());
				obj.put("ApprovedDate", healthFoodObj.getApprovedDate());
				obj.put("AppSuppliers", healthFoodObj.getAppSuppliers());
				obj.put("effect",healthFoodObj.getEffect());
				obj.put("effectClaim", healthFoodObj.getEffectClaim());
				obj.put("ingredient",healthFoodObj.getIngredient());
				obj.put("warning", healthFoodObj.getWarning());
				obj.put("precautions", healthFoodObj.getPrecautions());
				
				
				
				
	}
	catch(Exception e)
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
