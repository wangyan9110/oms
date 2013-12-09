<@override name="styles">
	<link href="<@s.url '/resources/css/layout.css'/>" rel="stylesheet" type="text/css" />
    <link href="<@s.url '/resources/css/site.css'/>" rel="stylesheet" type="text/css" />
</@override>

<@override name="main">

 <div class="globle_wrap">
        <div class="globle_header">
          编辑订单	<span>Add Order</span>
            <div class="opt_back"><a href="index">返回列表</a></div>
        </div>
        <form action="editForm" method="post">
            <div class="form_wrap">
                <h1>1、编辑订单基本信息</h1>
                           <dl>
                    <dt>订单编号：</dt>
                    <dd>
                        <input type="hidden" name="orderId" value="${order.orderId}" />
                        <label id="lblOrderID">${order.orderId}</label>
                    </dd>
                </dl>
                
                <dl>
                    <dt>
                        <label art='label' required='true'>客户：</label></dt>
                    <dd>
                        <input type="hidden" id="hidCustomerID" name="customerId" value="${order.customerId}" />
                        <input name="cmbCustomerId" id="cmbCustomerID" art="combobox" required="true" emptytext="请选择" comboattrs="{maxHeight:100}" />
                    </dd>
                    <dt>
                        <label art='label' required='true'>收货人：</label></dt>
                    <dd>
                        <input type="text" id="shipName" art="textbox" maxlength="20" required="true" name="ship.name" value="${order.ship.name}"  />
                    </dd>
                    <dt>
                        <label art='label' required='true'>订购时间：</label></dt>
                    <dd>
                        <input type="text" id="orderDate" name="orderDate" value="${order.orderDate?string("yyyy-MM-dd")}" art="datetimer" required="true" validtype="date"/>
                    </dd>
                    <dt>
                        <label art='label' required='true'>发货时间：</label></dt>
                    <dd>
                        <input type="text" id="shippedDate" name="shippedDate" value="${order.shippedDate?string("yyyy-MM-dd")}" required="true" validtype="date" art="datetimer" />
                    </dd>
                    <dt>
                        <label art='label' required='true'>到货时间：</label></dt>
                    <dd>
                        <input type="text" id="requiredDate" name="requiredDate" value="${order.requiredDate?string("yyyy-MM-dd")}" required="true" validtype="date" art="datetimer" />
                    </dd>
                    <dt>
                        <label art='label' required='true'>收货地址：</label></dt>
                    <dd>
                        <input type="text" id="shipAddress" required="true" value="${order.ship.address.address}" name="ship.address.address" art="textbox" emptytext="限制长度(0,30)" validtype="length[0,30]" />
                    </dd>
                    <dt>
                        <label art='label' required='true'>负责人：</label></dt>
                    <dd>
                        <input type="hidden" id="hidEmployeeID" name="employeeId" value="${order.employeeId}" />
                        <input name="cmbEmployeeId" id="cmbEmployeeID" art="combobox" emptytext="请选择" comboattrs="{maxHeight:100}" required="true" />
                    </dd>
                    <dt>
                        <label art='label' required='true'>运费：</label></dt>
                    <dd>
                        <input type="text" id="freight" name="freight" class="txt_num" value="${order.freight}" art="textbox" textmode="float" required="true" maxlength="10" />RMB
                    </dd>
                    <dt>
                        <label art='label' required='true'>物流：</label></dt>
                    <dd>
                        <input type="hidden" id="hidShipVia" name="shipperId" value="${order.shipperId}" />
                        <input id="cmbShipVia" art="combobox" name="cmbShipVia" art="combobox" required="true" emptytext="请选择" comboattrs="{maxHeight:100}" />
                        <label id="lblPhone"></label>
                    </dd>
                </dl>
                <dl>
                    <dt></dt>
                    <dd>
                        <input type="submit" class="sbm_next" value="更新并下一步" />
                        <label class="lb_msg">此页面所有字段必须填写！</label>
                    </dd>
                </dl>
                <div class="clear">
                </div>
                <div class="form_floattip">
                    <h4>注意：</h4>
                    <ol>
                        <li>订单编号由系统自动生成；</li>
                        <li>此页面所有字段必须填写；</li>
                        <li>系统默认币种为人民币（RMB）。</li>
                    </ol>
                </div>
            </div>
        </form>
    </div>


</@override>

<@override name="scripts">
<script type="text/javascript" src="<@s.url '/resources/js/addOrder.js'/>"></script>
<script type="text/javascript">

</script>
</@override>

<@extends name="/common/layout.ftl" title="添加订单"></@extends>