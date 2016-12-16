<%--ALL THE TAG LIBRARIES INCLUDED HERE --%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../shared/header.jsp"%>
</head>
<body>
	<div class="container">
		<br> <br> <br> <br> <br>
		<div class="jumbotron">
			<img src="${images}/thankyou.jpg" class="img-rounded" alt="ThankYou"
				width="304" height="236">
			<h3 align="center">You will receive your order within six days.</h3>
			<p align="center">Keep Visiting</p>
			<span class="align-right"> <a href="${contextPath}/index"
				class="btn btn-link" class="pull-right">Back to home</a></span>
		</div>
	</div>
	<%@include file="../shared/footer.jsp"%>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>