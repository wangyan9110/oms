

<@override name="styles">
	<link href="<@s.url '/resources/css/layout.css'/>" rel="stylesheet" type="text/css" />
	<link href="<@s.url '/resources/js/jart/themes/default/main.css' />" rel="stylesheet" type="text/css" />
     <link href="<@s.url '/resources/css/site.css' />"  rel="stylesheet" type="text/css" />
</@override>

<@override name="main">
	<div class="globle_wrap">
<div class="globle_header">
订单列表	<span>Order List</span>
	<div class="opt">
		<a href="javascript:void(0);" onclick="searchArea();" class="opt_search">&nbsp;</a>
		<a href="<@s.url '/Order/add'/>" class="opt_add">&nbsp;</a>
	</div>
	<div id="searchDiv">
		<form action="<@s.url '/Order/index'/>" method="post" id="searchForm" name="searchForm">
		<input type="hidden" name="pageIndex" value="1"/>
			<p><label for="s_orderid">订单编号：</label></p>
			<p><input type="text" id="orderId" name="orderId" value="${orderId}" /></p>
			<br />
			<p><label for="s_orderid">物流：</label></p>
			<p><input type="text" id="companyName" name="companyName" value="${companyName}" /></p>
			<br />
			<br />
			<p>
				<a class="s_submit" href='javascript:$("#searchForm").submit();'>搜索</a>
				<a class="s_cancel" href="javascript:void(0);" onclick="searchArea();">取消</a>
			</p>
		</form>
	</div>
</div>
		<ul class="dl_wrapul">
		<#list simpleOrders as simpleOrder>
	<li>
		<div class="dl_left">
			<p class="dl_name">
				<a href="detail.do?orderId=${simpleOrder.orderId}">${simpleOrder.shipName}<span>${simpleOrder.orderId}</span></a>
			</p>
			<p class="dl_common">
				<span>订购时间：${simpleOrder.orderDate}</span>
				<span>物流：${simpleOrder.shipCompanyName}</span>
			</p>
		</div>
		<div class="dl_right">
			<a class="dl_editbutton" href="edit?orderId=${simpleOrder.orderId}">编辑</a>
			<a class="dl_delbutton" href="orderDetail?orderId=${simpleOrder.orderId}">删除</a>
		</div>
		<div class="clear"></div>
	</li>
	</#list>
		</ul>
<div art="pager" id="pager" totalcount="${total}" template="textMode" pagesize="10" pageindex="${curPage}" onpageindexchanged="pageIndexChanged" >
</div>
	</div>

</@override>

<@override name="scripts">
<script type="text/javascript">
<#if error??>
$.alert({"title":"提示","message":"${error}"});
</#if>

// 分页链接
function pageIndexChanged(){
var orderId=$("#orderId").val();
var companyName=$("#companyName").val();
var baseUrl="index?pageIndex=" + $("#pager").pager("pageindex");
if(orderId!=""){
 	baseUrl=baseUrl+"&orderId="+orderId;
}
<#if error??>

<#else>
if(companyName!=""){
	baseUrl=baseUrl+"&companyName="+companyName;
}
</#if>
location.href=baseUrl;
}
// 搜索框
function searchArea(){
$("#searchDiv").css("display") == "none"?($("#searchDiv").show()):($("#searchDiv").hide());
}
</script>
</@override>

<@extends name="/common/layout.ftl" ></@extends>