<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" class="error_page">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Error Page - 404</title>
		<!-- Bootstrap framework -->
            <link rel="stylesheet" href="${ctxResources}/bootstrap/css/bootstrap.min.css"  />
            <link rel="stylesheet" href="${ctxResources}/bootstrap/css/bootstrap-responsive.min.css"  />
		<!-- main styles -->
            <link rel="stylesheet" href="${ctxResources}/css/style.css"  />
			<link rel="shortcut icon" href="${ctxResources}/bootstrap/ico/favicon.png">
            <!-- <link rel="stylesheet" href="../../fonts.googleapis.com/css-family=Jockey+One.css"  /> -->
            
	</head>
	<body>

		<div class="error_box">
			<h1>404 Page/File not found</h1>
			<p>The page/file you've requested has been moved or taken off the site.</p>
			<a href="javascript:history.back()" class="back_link btn btn-small">Go back</a>
		</div>

	<script type="text/javascript">

		var _gaq = _gaq || [];
		_gaq.push(['_setAccount', 'UA-32339645-1']);
		_gaq.push(['_trackPageview']);
	  
		(function() {
		  var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		  ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		  var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		})();
	  
	</script>
		
	</body>
</html>
