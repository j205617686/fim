package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.DataNotFoundException;
import model.bean.HealthFoodBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class getHealthFoodByEffectServlet
 */

public class getHealthFoodByEffectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getHealthFoodByEffectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String effect = new String();
		effect = request.getParameter("effect");
		int exception=0;
		JSONObject alldata =new JSONObject();  //all json data include status
		JSONArray arr = new JSONArray();
		Exception ex=null;
		
		
		try{
		effect = new String(effect.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println(effect);
		//String companyName ="露天市集國際資訊股份有限公司";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
	
		ArrayList<HealthFoodBean> HealthFoodArr =SQH.getHealthFoodByEffect(effect);
		
		if(SQH.getHealthFoodByEffect(effect).size()==0)
		{
			throw new DataNotFoundException();
		}
		
		
		for(int i=0;i<HealthFoodArr.size();i++)
		{
			JSONObject obj = new JSONObject();
			
			
				obj.put("chiName", HealthFoodArr.get(i).getChiName());
				obj.put("class", HealthFoodArr.get(i).getCls());
				obj.put("ApprovedID", HealthFoodArr.get(i).getApprovedID());
				obj.put("ApprovedSit", HealthFoodArr.get(i).getApprovedSit());
				obj.put("ApprovedDate", HealthFoodArr.get(i).getApprovedDate());
				obj.put("AppSuppliers", HealthFoodArr.get(i).getAppSuppliers());
				obj.put("effect", HealthFoodArr.get(i).getEffect());
				obj.put("effectClaim", HealthFoodArr.get(i).getEffectClaim());
				obj.put("ingredient", HealthFoodArr.get(i).getIngredient());
				obj.put("warning",HealthFoodArr.get(i).getWarning());
				obj.put("precautions", HealthFoodArr.get(i).getPrecautions());
				
				
				arr.put(obj);
				
			
		
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
				alldata.put("data", arr);
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
				alldata.put("data", arr);
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
