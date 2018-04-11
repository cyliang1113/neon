package cn.lab.neon.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AccessFilter implements Filter {
	private static final Log log = LogFactory.getLog(AccessFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = null;
		String requestURL = null;
		
		try {
			httpRequest = (HttpServletRequest) request;
			requestURL= httpRequest.getRequestURL().toString();
		} catch (ClassCastException e) {
			log.error("non-HTTP request");
		}
		log.info(requestURL + "----start");
		chain.doFilter(request, response);
		log.info(requestURL + "----end");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
