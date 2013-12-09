<@override name="styles">
	<link href="<@s.url '/resources/css/layout.css'/>" rel="stylesheet" type="text/css" />
	 <link href="<@s.url '/resources/css/site.css' />"  rel="stylesheet" type="text/css" />
</@override>

<@override name="main">

<div class="globle_wrap">
<div class="globle_header">删除订单<span>Delete Order</span>
	<div class="opt_back">
		<a href="index">返回</a></div>
</div>
	<div class="od_wrap">
		<div class="left">
			<dl>
				<dt>订单编号：</dt>
				<dd><label>${order.orderId}</label></dd>
				<dt>客户名称：</dt>
				<dd>${order.customerName}</dd>
				<dt>收货人：</dt>
				<dd>${order.shipName}</dd>
				<dt>收货地址：</dt>
				<dd>${order.shipAddress}</dd>
				<dt>联系电话：</dt>
				<dd>${order.customerPhone}</dd>
				<dt>负责人：</dt>
				<dd>${order.employeeName}</dd>
				<dt>运费：</dt>
				<dd>${order.freight}</dd>
				<dt>物流：</dt>
				<dd>${order.shipCompanyName}</dd>
			</dl>
		</div>
		<div class="right">
			<h2>所有产品</h2>
			<ul>
			<#list details as detail>
					<li>
						<span>
							数量：${detail.quantity}&nbsp;&nbsp;
							单价：￥${detail.unitPrice}
						</span>
						${detail.productName}</li>
				</#list>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
<div class="do_wrap">
	<div>
		<a href="delete?orderId=${order.orderId}" class="do_yes">是</a>&nbsp;
		<a href="index" class="do_no">否</a>
		</div>
你确定要删除该订单吗？		</div>
</div>


</@override>

<@override name="scripts">
<script type="text/javascript">
<#if error??>
alert(${error});
</#if>
</script>
</@override>

<@extends name="/common/layout.ftl" title="删除订单"></@extends>