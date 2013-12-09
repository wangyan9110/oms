package com.iflytek.oms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iflytek.oms.utils.JsPrintHelper;

/**
 * @author wangyan9110
 * 
 */
public class LoginIntegerceptor extends HandlerInterceptorAdapter {

	/**
	 * 登录
	 */
	private static final String LOGIN = "Login";

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null) {
			return;
		}
		String url = request.getServletPath();
		if (!url.contains(LOGIN)) {
			HttpSession session = request.getSession();
			if (session.getAttribute("userInfo") == null) {
				JsPrintHelper.jsAlertAndRedirect("您还没有登录，请先登录",
						"../Login/index", response);
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url=request.getServletPath();
		if(url.endsWith("json")){
			response.setContentType("application/json;utf-8");
		}else{
			response.setContentType("text/html;utf-8");
		}
		
		return true;
	}

}
