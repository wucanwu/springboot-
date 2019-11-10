package org.lepao.zuul.dept.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


//为每一个服务路由失败创建一个回调

@Component
public class FeignFallBackProvider implements FallbackProvider{

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				//设置返回响应的请求头
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
			
			/**
			 * 响应内容
			 */
			@Override
			public InputStream getBody() throws IOException {
				ObjectMapper objectMapper = new ObjectMapper();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("status", 200);
				map.put("message", "无法连接,请检查您的网络");
				return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
			}
			
			@Override
			public String getStatusText() throws IOException {
				
				return HttpStatus.OK.getReasonPhrase();
			}
			
			/**
			 * 返回状态码
			 */
			@Override
			public HttpStatus getStatusCode() throws IOException {
				
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				
				return HttpStatus.OK.value();
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	@Override
	public String getRoute() {
		
		//返回哪一个路由失败了
		return "comsumer80";
	}

}
