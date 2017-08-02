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

import model.bean.DataNotFoundException;
import model.bean.VioAdvertBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class getVioAdvertServlet
 */

public class getVioAdvertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getVioAdvertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String companyName = request.getParameter("companyname");
		System.out.println(companyName);
		int exception=0;
		Exception ex = null;
		JSONObject alldata =new JSONObject();
		
		JSONArray arr = new JSONArray();
	try{	
		companyName = new String(companyName.getBytes("ISO-8859-1"), "UTF-8");
	
		System.out.println(companyName);
		//String companyName ="露天市集國際資訊股份有限公司";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
		ArrayList<VioAdvertBean> vioAdvertObj = SQH.getVioAdvert(companyName);
		
		
		if(vioAdvertObj.size()==0)
		{
			throw new DataNotFoundException();
		}
		
		for(int i=0;i<vioAdvertObj.size();i++)
		{
			
			JSONObject obj = new JSONObject();
			
				obj.put("productName", vioAdvertObj.get(i).getProductName());
				obj.put("vioCompany", vioAdvertObj.get(i).getVioCompany());
				obj.put("punishDate", vioAdvertObj.get(i).getPunishDate());
				obj.put("punishlaw", vioAdvertObj.get(i).getPunishlaw());
				obj.put("publishDate",vioAdvertObj.get(i).getPublishDate());
				obj.put("mediaClass", vioAdvertObj.get(i).getMediaClass());
				obj.put("media",vioAdvertObj.get(i).getMedia());
				obj.put("situation", vioAdvertObj.get(i).getSituation());
				obj.put("punishOrgan", vioAdvertObj.get(i).getPunishOrgan());
				
				
				arr.put(obj);
				
			
		
		
		}
	}catch (Exception e) {
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
