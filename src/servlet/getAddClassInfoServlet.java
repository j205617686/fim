package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.NullPointerException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.DataNotFoundException;
import model.bean.additiveClassBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class getAddClassServlet
 */

public class getAddClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAddClassInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	String className = request.getParameter("className");
	
	int exception=0;
	Exception ex = null;
	JSONObject alldata =new JSONObject();
	JSONObject obj = new JSONObject();
	
	try {
	className = new String(className.getBytes("ISO-8859-1"), "UTF-8");
		
	
	
	
	
		System.out.println(className);
		//String companyName ="露天市集國際資訊股份有限公司";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
		additiveClassBean classInfoObj = new additiveClassBean();
		
			classInfoObj = SQH.getClassInfo(className);
		
		
			if(classInfoObj.getChiName().equals(""))
			{
				throw new DataNotFoundException();
				
			}
			
			
			
				obj.put("chiName", classInfoObj.getChiName());
				obj.put("engName", classInfoObj.getEngName());
				obj.put("purpose", classInfoObj.getPurpose());
				
				
				JSONArray comArray = new JSONArray();
				
				for(int i=0;i<classInfoObj.getCommons().size();i++)
				{
					JSONObject comObj = new JSONObject();
					
					comObj.put("example", classInfoObj.getCommons().get(i).getExample());
					comObj.put("items", classInfoObj.getCommons().get(i).getItems());
					comObj.put("sideEffect", classInfoObj.getCommons().get(i).getSideEffect());
					
					comArray.put(comObj);
				}
			
				obj.put("commons", comArray);
				
			
	}
	catch (Exception e) {
		exception++;
		ex=e;
		e.printStackTrace();
		// TODO Auto-generated catch block
	
	}
	
	
		//response.setLocale(Locale.TAIWAN);
		//response.setCharacterEncoding("UTF-8");
	if(exception==1)
		{
			try {
				alldata.put("status", ex);
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
