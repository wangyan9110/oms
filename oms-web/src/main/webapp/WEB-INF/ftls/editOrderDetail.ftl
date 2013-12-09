<@override name="styles">
	<link href="<@s.url '/resources/css/layout.css'/>" rel="stylesheet" type="text/css" />
    <link href="<@s.url '/resources/css/site.css'/>" rel="stylesheet" type="text/css" />
</@override>

<@override name="main">

<div class="globle_wrap">
<form action="#" method="post">
	<div class="globle_header">
编辑订单		<span>Add Order</span>
	</div>
	<div class="form_wrap">
		<h1>
2、编辑订单中的商品信息 	</h1>                                                     
			<div class="aod_left">
				<label class="lb_msg"></label>
				<dl>
					<dt><label art='label' required='true'>产品名称：</label></dt>
					<dd>
						<input type="hidden" id="orderId" name="orderId" value="${orderId}" />
						<input type="hidden" id="hidProductID" name="productId" value="" />
						<input id="cmbProductID" name="productId" art="combobox" emptytext="请选择" required="true" comboattrs="{maxHeight:100}" />
					</dd>
					<dt><label art='label' required='true'>产品数量：</label></dt>
					<dd><input type="text"  art="textbox" textmode="int" minNum="1" id="quantity" validType="minValue[1]"  required="true" class="txt_num"  name="quantity" value="" />
					<label id="lblProductQuantity">&nbsp;</label>
					</dd>
					<dt>产品编号：</dt><dd><label id="lblProductID">&nbsp;</label></dd>
					<dt>产品单价：</dt><dd><label id="lblUnitPrice">&nbsp;</label>RMB</dd>
					<dt>规格说明：</dt><dd><label id="lblQuantityPerUnit">&nbsp;</label></dd>
				</dl>
				<dl>
					<dt></dt>
					<dd>
						<input type="submit" id="btnSumbitEdit" class="sbm_add" value="添加" />
						<label class="lb_msg">此页面所有字段必须填写！</label>
					</dd>
				</dl>
				<div class="clear">
				</div>
			</div>
			<div class="aod_right">
				<h2>所有产品</h2>
					<ul class="list_details" id="products">
					<#list details as detail>
							<li>
							<div class="left">
								<span>${detail.productName}
									&nbsp;&nbsp;
									数量：${detail.quantity}&nbsp;&nbsp;
									单价：￥${detail.unitPrice}
								</span>
							</div>
							<div class="right">
								<a href="#" delete=true orderId="${detail.orderId}" productId="${detail.productId}" >删除</a>
							</div>
							</li>
					</#list>
			   </ul>
				<div class="clear">
				</div>
				<div class="list_opt">
					<a class="sbm_pre" href="edit?orderId=${orderId}">上一步</a>
					<input name="btnAction" id="btnAction" type="button" class="sbm_cmt" value="完成" />
				</div>
			</div>
		</div>
	</form>
</div>

</@override>

<@override name="scripts">
<script type="text/javascript" src="<@s.url '/resources/js/addOrderDetail.js'/>"></script>
<script type="text/javascript">
$("#btnAction").click(function(){
window.location="<@s.url '/Order/index'/>";
});
</script>
</@override>

<@extends name="/common/layout.ftl" title="编辑订单详情"></@extends>