package com.iflytek.oms.ums.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iflytek.oms.main.controller.BaseController;
import com.iflytek.oms.ums.domain.Employee;
import com.iflytek.oms.ums.dto.LoginInfo;
import com.iflytek.oms.ums.dto.SessionInfo;
import com.iflytek.oms.ums.service.EmployeeService;
import com.iflytek.oms.utils.SecurityUtils;

/**
 * 登录控制器
 * 
 * @author wangyan9110
 * 
 */
@Controller
@RequestMapping(value = "Login/*")
public class LoginController extends BaseController {

	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = -7989894389893L;
	
	/**
	 * 错误信息
	 */
	private static final String ERRORS="errors";
	
	/**
	 * 错误消息
	 */
	private static final String ERROR="error";

	/**
	 * 登录视图
	 */
	private final static String LOGIN = "login";

	/**
	 * 员工业务逻辑对象
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 加载登录页面
	 * 
	 * @return 登录视图
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return LOGIN;
	}

	/**
	 * 提交登录表单
	 * 
	 * @param loginInfo
	 *            登录信息
	 * @param result
	 *            验证结果
	 * @param session
	 *            会话
	 * @param response
	 * 			response对象
	 * @param model
	 *            模型
	 * @return 主视图
	 */
	@RequestMapping(value = "index", method = RequestMethod.POST)
	public String index(@Valid LoginInfo loginInfo, BindingResult result,
			HttpSession session,HttpServletResponse response, Model model) {

		if (result.hasErrors()) {
			model.addAttribute(ERRORS, result.getAllErrors());
			return LOGIN;
		}
		
		Employee employee=employeeService.getEmployeeByUserName(loginInfo.getUserName());
		if(employee==null){
			model.addAttribute(ERROR, "用户名不存在");
			return LOGIN;
		}

		if(!SecurityUtils.md5Encrypt(loginInfo.getPassword()).equals(employee.getPassword())){
            model.addAttribute(ERROR, "密码错误");
            return LOGIN;
        }
        SessionInfo info=new SessionInfo(employee.getEmployeeId(), employee.getName().toString());
        session.setAttribute("userInfo", info);
        if(loginInfo.isRemember()){
            response.addCookie(new Cookie("userName",loginInfo.getUserName()));
            response.addCookie(new Cookie("password", loginInfo.getPassword()));
        }

        return redirect("../Main/index");
	}
	
	/**
	 * 登出
	 * @param session 回话
	 * @param request 请求
	 * @return 登录视图
	 */
	@RequestMapping(value="loginOut")
	public String loginOut(HttpSession session,HttpServletRequest request){
		session.removeAttribute("userInfo");
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies){
			cookie.setMaxAge(0);
		}
		return redirect("../Login/index");
	}

}
