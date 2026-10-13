package com.gemcoder.system.controller;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.NavigationpageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/Navigationpage")
public class NavigationpageController{

  @Resource private NavigationpageService NavigationpageService;

	@Value("${security.url.login}")
	private String loginUrl;



	@RequestMapping(value = "/getUserMenuPermissions")
	@ResponseBody
	public Result getUserMenuPermissions(@RequestBody(required = false) Map<String,Object> paramMap) {

		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return NavigationpageService.getUserMenuPermissions(paramMap);
	}

	@RequestMapping(value = "/getIndexMenu")
	@ResponseBody
	public Result getIndexMenu() {

		//如果有需要校验的入参, 请在这里补充代码进行校验

		//调用service层的代码

		return NavigationpageService.getIndexMenu();
	}



	@RequestMapping(value = "/logout")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 清除当前用户的认证信息
		SecurityContextHolder.clearContext();
		// 使当前会话失效
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}


	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public Result getUserInfo(@RequestBody(required = false) Map<String,Object> paramMap) {

		//如果有需要校验的入参, 请在这里补充代码进行校验

		//调用service层的代码

		return NavigationpageService.getUserInfo(paramMap);
	}




}
