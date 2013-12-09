package com.iflytek.oms.oms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iflytek.framework.pagination.PaginationResult;
import com.iflytek.oms.main.controller.BaseController;
import com.iflytek.oms.main.dto.AjaxMessage;
import com.iflytek.oms.oms.domain.Order;
import com.iflytek.oms.oms.domain.OrderDetail;
import com.iflytek.oms.oms.dto.SimpleOrderDto;
import com.iflytek.oms.oms.service.OrderService;
import com.iflytek.oms.oms.dto.OrderAndDetail;
import com.iflytek.oms.ums.dto.SessionInfo;

/**
 * @author wangyan9110
 * 
 */
@Controller
@RequestMapping(value = "Order/*")
public class OrderController extends BaseController {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = -454353453534L;
	
	/**
	 * sessionKey
	 */
	private static final String USERINFO="userInfo";
	
	/**
	 * 错误信息
	 */
	private static final String ERROR="error";
	
	/**
	 * 订单业务对象
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * 加载订单列表视图
	 * 
	 * @param pageIndex
	 *            第几页
	 * @param orderId
	 *            订单编号
	 * @param companyName
	 *            公司
	 * @param model
	 *            页面视图模型
	 * @return 订单列表视图
	 */
	@RequestMapping(value = "index")
	public String index(Integer pageIndex, Integer orderId, String companyName,
			Model model) {
		Integer curPage = 1;
		if (pageIndex != null) {
			curPage = pageIndex;
		}
		PaginationResult<SimpleOrderDto> simpleOrders = null;
		if (orderId != null) {
			curPage = 1;
			simpleOrders = new PaginationResult<SimpleOrderDto>(1);
			simpleOrders.getRows().add(orderService.getSimpleOrderById(orderId));
		} else if (companyName != null && !"".equals(companyName)) {
			try {
				simpleOrders = orderService.getPagedOrders(curPage, 10,
						companyName.trim());
			} catch (RuntimeException e) {
				model.addAttribute(ERROR, e.getMessage());
				simpleOrders = orderService.getPagedOrders(curPage, 10);
			}
		} else {
			simpleOrders = orderService.getPagedOrders(curPage, 10);
		}

		model.addAttribute("simpleOrders", simpleOrders.getRows());
		model.addAttribute("curPage", curPage);
		model.addAttribute("total", simpleOrders.getTotal());
		model.addAttribute("orderId", orderId);
		model.addAttribute("companyName", companyName);
		return "orderlist";
	}

	/**
	 * 加载订单详情
	 * 
	 * @param orderId
	 *            订单编号
	 * @param model
	 *            页面视图模型
	 * @return 订单详情视图
	 */
	@RequestMapping(value = "orderDetail")
	public String orderDetail(Integer orderId, Model model) {
		OrderAndDetail orderAndDetail = orderService.getOrderAndDetailsById(orderId);
		model.addAttribute("order", orderAndDetail);
		model.addAttribute("details", orderAndDetail.getDetails());
		return "orderDetail";
	}

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 *            订单编号
	 * @param model
	 *            页面视图模型
	 * @return 删除信息
	 */
	@RequestMapping(value = "delete")
	public String delete(Integer orderId, Model model) {
		try {
			orderService.delete(orderId);
			return redirect("index");
		} catch (RuntimeException e) {
			model.addAttribute(ERROR, "订单删除失败");
			return redirect("orderDetail?orderId=" + orderId);
		}
	}

	/**
	 * 添加订单
	 * 
	 * @return 添加订单视图
	 */
	@RequestMapping(value = "add")
	public String addOrder() {
		return "addOrder";
	}

	/**
	 * 订单详情视图
	 * 
	 * @return 添加订单详情视图
	 */
	@RequestMapping(value = "addDetails")
	public String addOrderDetail() {
		return "addOrderDetail";
	}

	/**
	 * 添加订单
	 * 
	 * @param order
	 *            订单主信息
	 * @param session
	 *            会话
	 * @return 跳转视图
	 */
	@RequestMapping(value = "addForm")
	public String addOrderForm(Order order, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(USERINFO);
		orderService.addSimpleOrder(sessionInfo.getUserId(), order);
		return redirect("addDetails");
	}

	/**
	 * 添加订单详情
	 * 
	 * @param orderDetail
	 *            订单详情
	 * @param session
	 *            会话
	 * @return 订单信息
	 */
	@RequestMapping(value = "addOrderDetail.json")
	@ResponseBody
	public AjaxMessage addOrderDetailForm(OrderDetail orderDetail,
			HttpSession session) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(USERINFO);
			orderService.addOrderDetail(sessionInfo.getUserId(), orderDetail);
			return ajaxInfo("添加订单明细成功");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ajaxError(e.getMessage());
		}
	}

	/**
	 * 完成订单
	 * 
	 * @param session
	 *            会话
	 * @param model
	 *            页面模型
	 * @return 完成添加订单
	 */
	@RequestMapping(value = "completeOrder")
	public String completeOrder(HttpSession session, Model model) {
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(USERINFO);
			orderService.addOrder(sessionInfo.getUserId());
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute(ERROR, e.getMessage());
		}
		return redirect("index");
	}

	/**
	 * 编辑订单
	 * 
	 * @param orderId
	 *            订单编号
	 * @param model
	 *            页面模型
	 * @return 订单信息
	 */
	@RequestMapping(value = "edit")
	public String editOrder(Integer orderId, Model model) {
		model.addAttribute("order", orderService.getOrderById(orderId));
		return "editOrder";
	}

	/**
	 * 编辑订单
	 * 
	 * @param order
	 *            订单信息
	 * @return 视图
	 */
	@RequestMapping(value = "editForm")
	public String editOrder(Order order) {
		orderService.updateOrder(order);
		return redirect("editOrderDetail?orderId=" + order.getOrderId());
	}

	/**
	 * 编辑订单详情
	 * 
	 * @param orderId
	 *            订单编号
	 * @param model
	 *            页面视图
	 * @return 订单详情视图
	 */
	@RequestMapping(value = "editOrderDetail")
	public String editOrderDetail(Integer orderId, Model model) {
		model.addAttribute("details",
				orderService.getOrderDetailByOrderId(orderId));
		model.addAttribute("orderId", orderId);
		return "editOrderDetail";
	}

	/**
	 * 删除订单详情
	 * 
	 * @param productId
	 *            产品编号
	 * @param orderId
	 *            订单编号
	 * @return 删除
	 */
	@RequestMapping(value = "deleteOrderDetail.json")
	@ResponseBody
	public AjaxMessage deleteOrderDetail(Integer productId, Integer orderId) {
		try {
			orderService.deleteOrderDetail(orderId, productId);
			return ajaxInfo("删除成功");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ajaxError(e.getMessage());
		}
	}

	/**
	 * 添加订单详情 编辑订单中
	 * 
	 * @param od
	 *            订单详情
	 * @return 信息结果
	 */
	@RequestMapping(value = "editOrderByAddOrderDetail.json")
	@ResponseBody
	public AjaxMessage editOrderByAddOrderDetail(OrderDetail od) {
		try {
			orderService.addOrderDetail(od);
			return ajaxInfo("添加成功");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ajaxError(e.getMessage());
		}
	}
}
