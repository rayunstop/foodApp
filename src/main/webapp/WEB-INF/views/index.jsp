<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>美食分享管理系统</title>
<%@ include file="/WEB-INF/views/include/basicCss.jsp" %>
</head>
<body>
	<div id="maincontainer" class="clearfix">
		<!-- header begin-->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<!-- header end-->
		<div id="contentwrapper">
		
			<!-- mainContent -->
			<div class="main_content"></div>
		</div>
		<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
			title="Hide Sidebar">Sidebar switch</a>
		<!-- side bar begin -->
		<%@ include file="/WEB-INF/views/include/leftSiderBar.jsp" %>
		<!-- side bar end -->
	</div>




	<script src="${ctxResources}/bootstrap/js/jquery-1.11.1.min.js"></script>
	<!-- main bootstrap js -->
	<script src="${ctxResources}/bootstrap/js/bootstrap.min.js"></script>
	<!-- scroll -->
	<script src="${ctxResources}/antiscroll/antiscroll.js"></script>
	<script src="${ctxResources}/antiscroll/jquery-mousewheel.js"></script>
	<!-- js cookie plugin -->
	<script src="${ctxResources}/js/jquery.cookie.min.js"></script>
	<!-- hidden elements width/height -->
	<script src="${ctxResources}/js/jquery.actual.min.js"></script>
	<script src="${ctxResources}/js/app_common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			/* $.getJSON("${ctx}/josnData", function(data){
					  $.each(data, function(i,item){
						  console.log(data[i].age);
					  });
					  
					}); */
					
			$.ajax({
				url:'${ctx}/test',
				type:'post',
				data:{param2:'good',data:{age:18,sex:"南"}},
				success:function(message){
					console.log(message);
				}
				
			});
			
		});
	
	</script>
</body>
</html>