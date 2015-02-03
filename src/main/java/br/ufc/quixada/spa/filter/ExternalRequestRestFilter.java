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
 * Servlet Filter implementation class ExternalRequestRestFilter
 */
@WebFilter("/*")
public class ExternalRequestRestFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtrando!!!");
		HttpServletResponse response = (HttpServletResponse) resp;

		// Used to allow AJAX requests from other hosts 
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
