$(function(){
	//物流下拉框
	$("#cmbShipVia").combobox({
		dataFields:{value:"value",text:"text"},
		url:"../Shipper/list.json",
		onDataBind:function(args){
			this.attr("value",$("#hidShipVia").val());
		},
		onSelect:function(args){
			var value=$("#cmbShipVia").combobox("value");
			$("#hidShipVia").val(value);
			$.get("../Shipper/get.json",{"shipperId":value},function(data){
				var ship=eval(data);
				$("#lblPhone").text(ship.phone);
			});
		}
	});
	//客户下拉框
	$("#cmbCustomerID").combobox({
		dataFields:{value:"value",text:"text"},
		url:"../Customer/list.json",
		onDataBind:function(args){
			this.attr("value",$("#hidCustomerID").val());
		},
		onSelect:function(args){
			var value=$("#cmbCustomerID").combobox("value");
			$("#hidCustomerID").val(value);
		}
	});
	//雇员下拉框
	$("#cmbEmployeeID").combobox({
		dataFields:{value:"value",text:"text"},
		url:"../Employee/list.json",
		onDataBind:function(args){
			this.attr("value",$("#hidEmployeeID").val());
		},
		onSelect:function(args){
			var value=$("#cmbEmployeeID").combobox("value");
			$("#hidEmployeeID").val(value);
		}
	});
});