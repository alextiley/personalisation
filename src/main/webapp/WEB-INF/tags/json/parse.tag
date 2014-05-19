<%@ tag description="Converts a JSON string to a HashMap or ArrayList" pageEncoding="UTF-8" %>

<%@ tag import="java.util.List" %>
<%@ tag import="java.util.Map" %>
<%@ tag import="java.util.LinkedList" %>
<%@ tag import="java.util.LinkedHashMap" %>
<%@ tag import="org.json.simple.parser.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ attribute name="json" required="true" rtexprvalue="true" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>

<%@ variable name-from-attribute="var" alias="returnValue" variable-class="java.lang.String" scope="AT_END" %>

<%-- Remove any excess whitespace --%>
<c:set var="json" value="${fn:trim(json)}" />

<%-- Strip out CDATA for XML feeds --%>
<c:if test="${fn:contains(json, '<![CDATA[')}">
	<c:set var="json" value="${fn:replace(json, '<![CDATA[', '')}" />
	<c:set var="json" value="${fn:replace(json, ']]>', '')}" />
</c:if>

<%
	String jsonText = (String) jspContext.getAttribute("json");

	if (jsonText != null) {

		JSONParser parser = new JSONParser();

		try {
			Object returnValue = parser.parse(jsonText);
		    jspContext.setAttribute("returnValue", returnValue);
		} catch(ParseException e) {
			System.out.println(e);
		}
	}
%>

<c:if test="${empty var}">
	${returnValue}
</c:if>