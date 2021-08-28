<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<title>Investor WatchList</title>
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
	    
	    function numberFormat(nStr) {
	        nStr += '';
	        x = nStr.split('.');
	        x1 = x[0];
	        x2 = x.length > 1 ? '.' + x[1] : '';
	        var rgx = /(\d+)(\d{3})/;
	        while (rgx.test(x1)) {
	            x1 = x1.replace(rgx, '$1' + ',' + '$2');
	        }
	        return x1 + x2;
	    }
		
		function getInvestorData() {
			var url = 'http://localhost:8080/AppWebBackend/service/investor/' + investorid;
			$.get(url, function(datas, status) {
				console.log(datas);
				//-- 歡迎訊息 ------------------------------------
				$('#username').text(datas.username);
				$('#email').text(datas.email);
				//-- WatchList ---------------------------
				$('#myWatchTable tbody > tr').remove(); // 先將畫面暫存資料清除
				$.each(datas.watchLists, function(i, item) { 
					var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td nowrap>{3}</td><td>{4}</td><td style="color:{12}" align="right">{5}</td><td style="color:{12}" align="right">{6}</td><td style="color:{12}" align="right">{7}</td><td style="color:{12}" align="right">{8}</td><td style="color:{12}" align="right">{9}</td><td align="right">{10}</td><td nowrap>{11}</td></tr>';
					$('#myWatchTable').append(
						String.format(html, item.id, item.stockPool.typeid, '<span title="按我一下可以看K線圖" style="cursor:pointer" onclick="queryHistQuotes(\'' + item.stockPool.symbol + '\')">' + item.stockPool.symbol + '</span>', item.stockPool.symbolname, item.stockPool.warning, 
								            item.realTimeStock.bid, item.realTimeStock.ask, item.realTimeStock.lastprice, item.realTimeStock.change, item.realTimeStock.changePercent, numberFormat(item.realTimeStock.volume), item.realTimeStock.transdate, (item.realTimeStock.change >= 0)?'red':'#005100')		
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
	我的觀察股(WatchList)
	<p />
	<table id="myWatchTable" class="pure-table pure-table-bordered">
	    <thead>
	        <tr>
	            <th nowrap>id</th>
	            <th nowrap>種類</th>
	            <th nowrap>代號</th>
	            <th nowrap>名稱</th>
	            <th nowrap>警示</th>
	            <!-- 即時盤中資訊  -->
	            <th nowrap>買價</th>
	            <th nowrap>賣價</th>
	            <th nowrap>成交</th>
	            <th nowrap>漲跌</th>
	            <th nowrap>幅%</th>
	            <th nowrap>總量</th>
	            <th nowrap>時間</th>
	        </tr>
	    </thead>
	    <tbody>
	    			       
	    </tbody>
	</table>
	
	<p />
	
</body>
</html>