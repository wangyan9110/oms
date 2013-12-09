$(function() {
	// 产品下拉框
	$("#cmbProductID").combobox({
		dataFields : {
			value : "value",
			text : "text"
		},
		url : "../Product/list.json",
		onDataBind : function(args) {
			this.attr("value", $("#hidProductID").val());
		},
		onSelect : function(args) {
			var value = $("#cmbProductID").combobox("value");
			$("#hidProductID").val(value);
			if (value == "") {
				return;
			}
			$.get("../Product/get.json", {
				"productId" : value
			}, function(data) {
				var product = eval(data);
				$("#lblProductID").text(value);
				$("#lblProductQuantity").text(product.unitsInStock);
				$("#lblUnitPrice").text(product.unitPrice);
				$("#lblQuantityPerUnit").text(product.quantityPerUnit);
			});
		}
	});

	// 添加订单中，添加订单详情
	$("#btnSumbitAdd").click(
			function() {
				var productId = $("#hidProductID").val();
				var productName = $("#cmbProductID").combobox("text");
				var unitPrice = $("#lblUnitPrice").text();
				var quantity = $("#quantity").val();
				$.post("../Order/addOrderDetail.json", {
					"productId" : productId,
					"unitPrice" : unitPrice,
					"quantity" : quantity
				}, function(data) {
					var ajaxMsg = eval(data);
					if (ajaxMsg.type == 1) {
						var li = "<li><span>数量：" + quantity + "&nbsp;&nbsp;单价:"
								+ unitPrice + "</span>\t" + productName
								+ "</li>";
						$("#products").append(li);
					} else {
						$.alert({
							title : "提示",
							message : ajaxMsg.msg
						});
					}
					$("#hidProductID").val("");
					$("#cmbProductID").combobox("value", "");
					$("#lblUnitPrice").text("");
					$("#lblProductID").text("");
					$("#lblProductQuantity").text("");
					$("#lblQuantityPerUnit").text("");
					$("#quantity").val("");
				});
				return false;
			});

	// 删除订单详情
	$("a[delete=true]").live("click", function() {
		
		var orderId = $(this).attr("orderId");
		var productId = $(this).attr("productId");
		var temp = $(this);

		$.confirm({
			"title" : "确认框",
			"message" : "确定要删除该订单明细吗？",
			"btnok" : "确定",
			"btnCancel" : "取消",
			fnOk : function() {
				$.get("../Order/deleteOrderDetail.json", {
					"orderId" : orderId,
					"productId" : productId
				}, function(data) {
					var ajaxMsg = eval(data);
					if (ajaxMsg.type == 1) {
						temp.parent().parent().remove();
					} else {
						$.alert({
							title : "提示",
							message : ajaxMsg.msg
						});
					}
				});
			}
		});

	});

	$("#btnSumbitEdit").click(
					function() {
						var productId = $("#hidProductID").val();
						var productName = $("#cmbProductID").combobox("text");
						var unitPrice = $("#lblUnitPrice").text();
						var quantity = $("#quantity").val();
						var orderId = $("#orderId").val();
						
						$.post(
								"../Order/editOrderByAddOrderDetail.json",
								{
									"productId" : productId,
									"unitPrice" : unitPrice,
									"quantity" : quantity,
									"orderId" : orderId
								},
								function(data) {
									var ajaxMsg = eval(data);
									if (ajaxMsg.type == 1) {
										var li = "<li><div class='left'><span>"
												+ productName
												+ "数量："
												+ quantity
												+ "&nbsp;&nbsp;单价:"
												+ unitPrice
												+ "</span>\t</div><div class='right'><a href='#' delete=true orderId="
												+ orderId
												+ " productId="
												+ productId
												+ " >删除</a></div></li>";
										$("#products").append(li);
									} else {
										$.alert({
											title : "提示",
											message : ajaxMsg.msg
										});
									}
									$("#hidProductID").val("");
									$("#cmbProductID").combobox(
											"value", "");
									$("#lblUnitPrice").text("");
									$("#lblProductID").text("");
									$("#lblProductQuantity").text("");
									$("#lblQuantityPerUnit").text("");
									$("#quantity").val("");
								});
						return false;
					});

});