
<@override name="styles">
	<link href="<@s.url '/resources/css/layout.css'/>" rel="stylesheet" type="text/css" />
	<link href="<@s.url '/resources/js/jart/themes/default/main.css' />" rel="stylesheet" type="text/css" />

</@override>

<@override name="main">

<div art="layout" filly="true">
	<div region="north" class="north">
		<div class="header">
			<a class="logout" href="<@s.url '/Login/loginOut'/>"></a>
			<#if userInfo??>
			<span>${userInfo.name}：你好，欢迎使用订单管理系统！</span>
			</#if>
		</div>
	</div>
	<div region="west" resizable="true" collapsible="true" size="240">
		<div art="navbar" exclude="true"  filly="true" autotop="true">
			<div text="菜单栏" expanded="true">
				<div url="<@s.url '/Order/index' />" target="fm">
订单列表				</div>
				<div url="<@s.url '/Order/add'/>" target="fm" class="nav_item">
添加订单				</div>
			</div>
		</div>
	</div>
	<div region="middle">
		<div art="panel" id="pnlDoc" title="文档说明" filly="true">
			<iframe id="fm" name="fm" art="iframe" panelid="main" width="100%" filly="true" frameborder="0"
				allowtransparency="true"></iframe>
		</div>
	</div>
	<div region="south" class="bottom">
		<div class="footer">讯飞智元软件工程中心 &copy; 2012</div>
	</div>
</div>

</@override>

<@extends name="/common/layout.ftl" ></@extends>