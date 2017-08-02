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
import model.bean.VioHistoryBean;
import model.queryHandler.SingleQueryHandler;

/**
 * Servlet implementation class getVioHistoryServlet
 */
@WebServlet("/getVioHistoryServlet")
public class getVioHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getVioHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String companyName = new String();
		companyName = request.getParameter("companyname");
		int exception=0;
		Exception ex = null;
		JSONObject alldata =new JSONObject();

		JSONArray arr = new JSONArray();
		
		
		try {
		companyName = new String(companyName.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println(companyName);
		//String companyName ="露天市集國際資訊股份有限公司";
		
		SingleQueryHandler SQH = new SingleQueryHandler();
		
		//System.out.println(SQH.getVioHistory(companyName));
		
		ArrayList<VioHistoryBean> historyAL=SQH.getVioHistory(companyName);
		
		
		
		
		for(int i=0;i<historyAL.size();i++)
		{
			JSONObject obj = new JSONObject();
			
			try {
				obj.put("importer", historyAL.get(i).getImporter());
				obj.put("importerAddress", historyAL.get(i).getImporterAddress());
				obj.put("lawRestriction", historyAL.get(i).getLawRestriction());
				obj.put("manufacturer", historyAL.get(i).getManufacturer());
				obj.put("photo", historyAL.get(i).getPhoto());
				obj.put("placeOfOrigin", historyAL.get(i).getPlaceOfOrigin());
				obj.put("reason", historyAL.get(i).getReason());
				obj.put("reasonDetail", historyAL.get(i).getReasonDetail());
				obj.put("releaseDate", historyAL.get(i).getReleaseDate());
				obj.put("situation", historyAL.get(i).getSituation());
				obj.put("testDate", historyAL.get(i).getTestDate());
				obj.put("topic", historyAL.get(i).getTopic());
				
				
				
				arr.put(obj);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
		
		
		ArrayList<VioHistoryBean> allData=SQH.getVioHistory(companyName);
		
		
		
		if(allData.size()==0)
		{
			
			throw new DataNotFoundException();
			
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
