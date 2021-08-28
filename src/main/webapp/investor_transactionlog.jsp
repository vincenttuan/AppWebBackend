<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Investor TransactionLog</title>
</head>
<body>
	<script>
		// 投資人 id
		var investorid = 1;
		
		function getInvestorData() {
			var url = 'http://localhost:8080/AppWebBackend/service/investor/' + investorid;
			$.get(url, function(datas, status) {
				console.log(datas);
			});
		}
		
		// Jquery 進入點
		$(document).ready(function() {
			getInvestorData();
		});
	</script>
</body>
</html>