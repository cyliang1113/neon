package cn.lab.neon.common.soa.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.lab.neon.common.soa.TrackNumberContext;
import cn.lab.neon.common.soa.log.Log4JLogTailMDC;
import cn.lab.neon.common.util.UUIDUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TrackFilter implements Filter {
	private static final Log log = LogFactory.getLog(TrackFilter.class);

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
			log.error("non-HTTP request", e);
		}

		try {
			if(TrackNumberContext.getTrackNumber() == null){
				String trackNumber = UUIDUtil.generateUuid();
				TrackNumberContext.setTrackNumber(trackNumber);
			}
			Log4JLogTailMDC.setTail(TrackNumberContext.getTrackNumber());
			log.info(requestURL + " -------- start");
			chain.doFilter(request, response);
		} finally {
			log.info(requestURL + " -------- end");
			TrackNumberContext.remove();
			Log4JLogTailMDC.removeTail();
		}

}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
