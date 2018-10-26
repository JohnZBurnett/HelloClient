import java.io.*;
import javax.servlet.http.*;
import java.util.*; 
import javax.servlet.*; 

public class ShowParameters extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws IOException 
	  {
		showRequestParameters( request, response ); 
	  }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	  throws ServletException, IOException
	  {
		doGet( request, response); 
	  }
	
	void showRequestParameters(HttpServletRequest request, HttpServletResponse response)
	  throws IOException
	  {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		out.println("<html><head><title>Show Parameters</title></head></body>" + "<h1>Parameters</h1><ul>");
		
		Map<String, String[]> params = request.getParameterMap();
		
		for ( String name : params.keySet() ) 
		{
			String [] values = params.get( name );
			out.println("<li>" + name + " =" + Arrays.asList(values) ); 
		}
		
		out.println("</ul><p><form method=\"POST\" action=\"" + request.getRequestURI() + "\">" + "Field 1 <input name=\"Field 1\" size=20><br>" + "Field 2 <input name=\"Field 2\" size=20><br>" + "<br><input type=\"submit\" value=\"Submit\"</form>"); 
		out.close(); 
	  }
}
