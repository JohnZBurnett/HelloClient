import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

public class ConLimitFilter implements Filter {
	int limit;
	volatile int count;
	
	public void init( FilterConfig filterConfig ) throws ServletException
	{
		String s = filterConfig.getInitParameter("limit");
		if ( s == null ) {
			throw new ServletException("Missing init parameter:" + limit);
		limit = Integer.parseInt( s ); 
		}
	}
}
