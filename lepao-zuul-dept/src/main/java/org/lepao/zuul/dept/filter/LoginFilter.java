package org.lepao.zuul.dept.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

//使用路由网关的过滤器

@Component
public class LoginFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		//得到请求上下文
		RequestContext context = RequestContext.getCurrentContext();
		//得到httpServletContext
		HttpServletRequest  request = context.getRequest();
		String token = request.getParameter("token");
		HttpServletResponse response = context.getResponse();
		if(token==null)
		{
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().write("非法请求");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 是否过滤
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 过滤顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 什么时候进行过滤
	 */
	@Override
	public String filterType() {
		//路由之前
		return "pre";
	}

}
