<@override name="styles">
	<link href="<@s.url '/resources/css/login.css'/>" rel="stylesheet" type="text/css" />
</@override>

<@override name="main">

<div class="l_wrap">
	<div class="l_left">
		<div class="l_desc">
		</div>
	</div>
	<div class="l_right">
		<div class="l_form">
			<h1>登录</h1>
			<form action="<@s.url '/Login/index'/>" method="post" name="loginForm" id="loginForm" onsubmit="return FormCheck()">
				<p><label for="AccountNo">用户名：</label></p>
				<p><input name="userName" id="AccountNo" type="text" class="l_textbox" art="textbox" 
					maxlength="12" showmaxlength="false" emptytext="用户名" required="true" requiredMsg="用户名不能为空" /></p>
				<p><label for="Password">密码：</label></p>
				<p><input name="password" id="Password" type="password" class="l_textbox" art="textbox"
					maxlength="12" showmaxlength="false" emptytext="密码" required="true" requiredMsg="密码不能为空" /></p>
				<p>
					<input name="remember" id="RememberMe" type="checkbox" value="true" />
					<label for="RememberMe">两周之内自动登录</label>
				</p>
				<p>
					<input type="submit" class="l_sbmt" value="登　录" />
					<br />
					<br />
					<span class="l_errormsg">
						<#if errors??>
							<#list errors as error>
								${error.defaultMessage}
							</#list>
						</#if>
						<#if error??>
						${error}
						</#if>
					</span>
				</p>
			</form>
		</div>
	</div>
</div>


</@override>

<@override name="scripts">
<script type="text/javascript">
	function FormCheck() {
		return $.isValid();
	}
</script>
</@override>

<@extends name="/common/layout.ftl" title="登录"></@extends>