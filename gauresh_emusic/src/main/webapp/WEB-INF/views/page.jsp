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
<%@include file="shared/header.jsp"%>
</head>
<body>

	<%@include file="shared/menubar.jsp"%>
<!-- if user clicked home -->
	<c:if test="${ifUserClickedHome == true }">
		<%@include file="index.jsp"%>
	</c:if>
<!-- if user clicked about us -->
	<c:if test="${ifUserClickedAbout == true }">
		<%@include file="./static/about.jsp"%>
	</c:if>
<!-- if user clicked contact us -->
	<c:if test="${ifUserClickedContact == true }">
		<%@include file="./static/contact.jsp"%>
	</c:if>
<!-- if user clicked view product for admin -->
	<c:if test="${ifUserClickedViewProducts == true }">
		<%@include file="./admin/viewProducts.jsp"%>
	</c:if>
<!-- if user clicked view category for admin -->
	<c:if test="${ifUserClickedViewCategory == true }">
		<%@include file="./admin/viewCategories.jsp"%>
	</c:if>
<!-- if user clicked view supplier for admin -->
	<c:if test="${ifUserClickedViewSuppliers == true }">
		<%@include file="./admin/viewSuppliers.jsp"%>
	</c:if>
<!-- if any error or exception is there -->
	<c:if test="${ifAnyError == true }">
		<%@include file="error.jsp"%>
	</c:if>
<!-- if user clicked login -->
	<c:if test="${ifLoginIsClicked == true }">
		<%@include file="login.jsp"%>
	</c:if>
<!-- if user clicked register -->
	<c:if test="${ifRegisterIsClicked == true }">
		<%@include file="register.jsp"%>
	</c:if>
	<!-- if user clicked view product detail -->
	<c:if test="${ifUserClickedProductDetails == true }">
		<%@include file="./user/selectedProduct.jsp"%>
	</c:if>
	<!-- if user clicked view product list -->
	<c:if test="${ifUserSelectProductList == true }">
		<%@include file="productList.jsp"%>
	</c:if>
	<!-- if user clicked my cart -->
	<c:if test="${ifUserClickedMyCart == true }">
		<%@include file="./user/cart.jsp"%>
	</c:if>

	<%@include file="./shared/footer.jsp"%>

	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>

</body>
</html>
