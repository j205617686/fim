package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.AdditiveBean;
import model.bean.DataNotFoundException;
import model.queryHandler.SingleQueryHandler;


public class getAddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAddInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String additiveName = request.getParameter("additiveName");
		JSONArray arr = new JSONArray();
		int exception=0;
		JSONObject alldata =new JSONObject();  //all json data include status
		
		Exception ex=null;
		
	try{
		additiveName = new String(additiveName.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println(additiveName);
		//String companyName ="露天市集國際資訊股份有限公司";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
		ArrayList<AdditiveBean> AdditiveInfoArr = SQH.getAdditiveInfo(additiveName);
		
		
		System.out.println(SQH.getAdditiveInfo(additiveName));
		
		if(SQH.getAdditiveInfo(additiveName).size()==0)
		{
			
			throw new DataNotFoundException();
		}
		
		
		
		for(int i=0;i<AdditiveInfoArr.size();i++)
		{
			JSONObject obj = new JSONObject();
			
			
				obj.put("chiName", AdditiveInfoArr.get(i).getChiName());
				obj.put("class", AdditiveInfoArr.get(i).getCls());
				obj.put("engName", AdditiveInfoArr.get(i).getEngName());
				obj.put("limitOfUse", AdditiveInfoArr.get(i).getRange());
				obj.put("restriction", AdditiveInfoArr.get(i).getRestriction());
				obj.put("shortlink", AdditiveInfoArr.get(i).getShortlink());
				
				
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
