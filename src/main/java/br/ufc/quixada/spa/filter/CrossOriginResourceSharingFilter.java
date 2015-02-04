package br.ufc.quixada.spa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter to enable Cross Origin Requests for a RESTful Web Service.
 * It includes headers for Cross-Origin Resource Sharing (CORS) in the response.
 */
@WebFilter("/*")
public class CrossOriginResourceSharingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) resp;

		// Used to allow AJAX requests from other hosts 
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
