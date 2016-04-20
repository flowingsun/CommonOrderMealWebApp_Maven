package com.flowingsun.webapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.flowingsun.webapp.domain.User;

@Repository
public class SysAdmin_CheckLogin implements HandlerInterceptor {
	
	/** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		//过滤登陆页
		if (user == null) {
			response.sendRedirect(basePath+"admin_login/login.html");
			return true;
		}
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setContentType("text/html;charset=utf-8");//设置输出编码
	}

	/** 
     *   在DispatcherServlet完全处理完请求后被调用  
     *   当有拦截器出现异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
