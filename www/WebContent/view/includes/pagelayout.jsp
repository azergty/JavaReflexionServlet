<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${Template.getName()}</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()+"/ROOT/css/Menu.css" %>" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()+"/ROOT/css/Web.css" %>" />

<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

</head>
<body>


	<div class="header">
		<div class="header-items">
			<a href="<%=request.getContextPath()+"/index"%>" title="${Translate.get("Acceuil", false)}" >${Translate.get("Acceuil")}</a>
		</div>
		<div class="header-items">
			<a href="<%=request.getContextPath()+"/modules/liste-des-modules" %>" >Mes modules</a>
		</div>
		<div class="header-items">
			<a href="<%=request.getContextPath()+"/test"%>" >Test</a>
		</div>
		<div class="header-items ">
			<a class="connexion" href=" <%=request.getSession()==null? request.getContextPath()+"/users/deconnexion" : request.getContextPath()+"/users/connexion"  %>" >${sessionScope==null? "Déconnexion" : "Connexion" }</a>
				<div class="menu-connexion">
					<div class="container-connexion">
				      <jsp:include page="/view/users/connexion.jsp">
				            <jsp:param name="year" value="2020"/>
				        </jsp:include>
					</div>
				</div>
		</div>
				
	</div>
	<div class="header-margin" ></div>

	<div class="container">

      <jsp:include page="${Template.getUrl()}">
            <jsp:param name="year" value="${Template.getDate()}"/>
        </jsp:include>
	</div>     
	<div class="footer-margin"></div>       
	<div class="footer">
		<div class="footer-content">
			<div class="footer-item">
				Mon footer
			</div>
			
		</div>

	</div>
</body>
</html>