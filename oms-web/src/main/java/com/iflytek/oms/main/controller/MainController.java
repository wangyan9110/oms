
package com.iflytek.oms.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangyan9110
 *
 */
@Controller
@RequestMapping(value="Main/*")
public class MainController {

	/**
	 * 主视图
	 * @return 主视图
	 */
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		return "main";
	}
}
