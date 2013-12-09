package com.iflytek.oms.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyan9110
 *
 */
public class JsPrintHelper {
	
	/**
	 * 私有构造器
	 */
	private JsPrintHelper() {

	}

	/**
	 * 跳转页面
	 * @param message 弹出消息
	 * @param url  地址
	 * @param resp 响应流
	 */
	public final static void jsAlertAndRedirect(String message, String url,
			HttpServletResponse resp) {
		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
			writer.append("<script type='text/javascript'>");
			writer.append("alert('");
			writer.append(message);
			writer.append("');");
			writer.append("window.location='");
			writer.append(url);
			writer.append("';");
			writer.append("</script>");
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("来自JsPrintHelper.JsAlert", e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
