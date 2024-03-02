package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CharEncodingFilter
 */
@WebFilter(filterName = "/CharEncodingFilter", urlPatterns = "/*")
public class CharEncodingFilter extends HttpFilter implements Filter {
    
	private String encoding;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public CharEncodingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) 새로고침할 때마다 계속
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("*****do");
		
		request.setCharacterEncoding(encoding);

		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig) 앱 실행할 때 처음에 한 번만 실행 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("*****init");
		encoding = fConfig.getInitParameter("encoding");
		if(encoding==null) {
			encoding = "UTF-8";
		}
	}

}
