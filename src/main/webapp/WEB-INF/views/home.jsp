<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib tagdir="/WEB-INF/tags/json" prefix="json"  %>

<!doctype html>
<html>
	<head>
		<title>Home</title>

		<meta charset="utf-8" />

		<link href="/personalisation/resources/css/vendor/bootstrap.min.css" rel="stylesheet" />
		<link href="/personalisation/resources/css/global.css" rel="stylesheet" />

		<script src="/personalisation/resources/js/vendor/jquery-1.11.1.min.js"></script>
		<script src="/personalisation/resources/js/vendor/bootstrap.min.js"></script>
	</head>
	<body>
	
		<jsp:include page="/WEB-INF/views/includes/global/header.jsp" />
	
		<%-- Dummy customer, for prototype --%>
		<c:set var="customerId" value="${1}" />
		
		<%-- Get the personalised products for the current customer --%>
		<c:import url="/customer/${customerId}" var="products" />
		
		<%-- Parse the JSON string into a loop-able collection --%>
		<json:parse json="${products}" var="products" />

		<%-- Show those beautiful products to our customer! --%>
		<h1>Personalised Products based on your past purchases</h1>
		
		<c:choose>
			<c:when test="${fn:length(products) > 0}">
				<ul class="products">
					<c:forEach items="${products}" var="product">
						<li>
							<h2>${product.title_keyword}</h2>
							${product.MASTER_COLOUR_ATT_KEYWORD} - ${product.product_id}
							<img src="/personalisation/resources/img/products/${product.product_id}.jpg" alt="${product.title_keyword}" width="150" />
						</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p>Sorry, but there are no products to display.</p>
			</c:otherwise>
		</c:choose>
		
		<jsp:include page="/WEB-INF/views/includes/global/footer.jsp" />
		
		<script src="/personalisation/resources/js/global.js"></script>
	</body>
</html> 