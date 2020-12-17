<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
  <!--[if gte IE 9]>
	<style type="text/css">
		.gradient {
		   filter: none;
		}
	</style>
	<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()+"/ROOT/css/Error_404.css"%>" />
	<title>404 Page no found </title>
	
</head>
<body>
	<div class="error-page-wrap">
		<article class="error-page gradient">
			<hgroup>
				<h1>404</h1>
				<h2>oops! page not found</h2>
			</hgroup>
			<a href="<%=request.getContextPath()+"/index" %>" title="Back to site" class="error-back">back</a>
		</article>
	</div>


</body>
</html>