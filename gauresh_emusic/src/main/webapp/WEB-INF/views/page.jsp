<%--ALL THE TAG LIBRARIES INCLUDED HERE --%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="shared/header.jsp"%>
</head>
<body>
	
	<%@include file="shared/menubar.jsp"%>

	<c:if test="${ifUserClickedHome == true }">
		<%@include file="index.jsp"%>
	</c:if>

	<c:if test="${ifUserClickedAbout == true }">
		<%@include file="about.jsp"%>
	</c:if>

	<c:if test="${ifUserClickedContact == true }">
		<%@include file="contact.jsp"%>
	</c:if>

	<c:if test="${ifUserClickedViewProducts == true }">
		<%@include file="./admin/viewProducts.jsp"%>
	</c:if>
	
	<c:if test="${ifUserClickedViewCategory == true }">
		<%@include file="./admin/viewCategories.jsp"%>
	</c:if>
	
	<c:if test="${ifUserClickedViewSuppliers == true }">
		<%@include file="./admin/viewSuppliers.jsp"%>
	</c:if>

	<c:if test="${ifUserClickedLogin == true }">
		<%@include file="login.jsp"%>
	</c:if>
	
	<c:if test="${ifUserClickedProduct == true }">
		<%@include file="product.jsp"%>
	</c:if>
	
	<c:if test="${ifUserClickedProductDetail == true }">
		<%@include file="productDetail.jsp"%>
	</c:if>
	
	<%@include file="./shared/footer.jsp"%>

	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>
