<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<title>Investor TransactionLog</title>
	<script>
		// 投資人 id
		var investorid = 1;
		
		// 公用程式相當於 Java 的 String.format
		String.format = function () {
	        if (arguments.length == 0)
	            return null;
	        var str = arguments[0];
	        for (var i = 1; i < arguments.length; i++) {
	            var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
	            str = str.replace(re, arguments[i]);
	        }
	        return str;
	    };
		
		function getInvestorData() {
			var url = 'http://localhost:8080/AppWebBackend/service/investor/' + investorid;
			$.get(url, function(datas, status) {
				console.log(datas);
				//-- 歡迎訊息 ------------------------------------
				$('#username').text(datas.username);
				$('#email').text(datas.email);
				//-- Transaction Log ---------------------------
				$('#myTransTable tbody > tr').remove(); // 先將畫面暫存資料清除
				$.each(datas.transactionLogs, function(i, item) { 
					var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td nowrap>{3}</td><td>{4}</td><td>{5}</td><td nowrap>{6}</td></tr>';
					$('#myTransTable').append(
						String.format(html, item.id, item.bs, item.stockPool.symbol, item.stockPool.symbolname, item.amount, item.price, item.tdate)		
					);
				});
			});
		}
		
		// Jquery 進入點
		$(document).ready(function() {
			getInvestorData();
		});
	</script>
</head>
<body style="padding: 15px">
	Hello <span id="username"></span> <span id="email"></span> 
	<p />
	我的交易紀錄
	<p />
	<table id="myTransTable" class="pure-table pure-table-bordered">
	    <thead>
	        <tr>
	            <th nowrap>id</th>
	            <th nowrap>買賣</th>
	            <th nowrap>代號</th>
	            <th nowrap>名稱</th>
	            <th nowrap>股數</th>
	            <th nowrap>價格</th>
	            <th nowrap>時間</th>
	        </tr>
	    </thead>
	    <tbody>
	    			       
	    </tbody>
	</table>
	
	<p />
	
</body>
</html>