<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>

<head>
<title><bean:message key="lilldep.jsp.listing.title" /></title>
<style type="text/css" media="screen">
@import "./styles/styles.css";
</style>
</head>
<body>

	<ul id="navbar">
		<li><a href="full.jsp"><bean:message
					key="lilldep.jsp.full.nav" /></a></li>
		<li><a href="mnc.jsp"><bean:message key="lilldep.jsp.mnc.nav" /></a></li>
		<li><a href="Collect.do"><bean:message
					key="lilldep.jsp.collection.nav" /></a></li>
		<li><a href="import.jsp"><bean:message
					key="lilldep.jsp.import.nav" /></a></li>
		<li><a href="Listing.do" class="selected"><bean:message
					key="lilldep.jsp.listing.nav" /></a></li>
	</ul>

	<table width="100%">
		<tr>
			<td width="20%"><strong><bean:message
						key="lilldep.jsp.dataentry.prompt.name" /></strong></td>
			<td width="15%"><strong><bean:message
						key="lilldep.jsp.dataentry.prompt.email" /></strong></td>
			<td width="20%"><strong><bean:message
						key="lilldep.jsp.dataentry.prompt.company" /></strong></td>
			<td width="40%"><strong><bean:message
						key="lilldep.jsp.dataentry.prompt.address" /></strong></td>
			<td><strong><bean:message
						key="lilldep.jsp.dataentry.prompt.postcode" /></strong></td>
			<td width="15%"><strong><bean:message
						key="lilldep.jsp.dataentry.prompt.website" /></strong></td>
		</tr>

		<c:forEach var="contact" items="${listing}">
			<tr>
				<td><c:out value="${contact.name}" /></td>
				<td><c:out value="${contact.email}" /></td>
				<td><c:out value="${contact.company}" /></td>
				<td><c:out value="${contact.address}" /></td>
				<td><c:out value="${contact.postcode}" /></td>
				<td><a href="<c:out value="${contact.website}" />"> <c:out
							value="${contact.website}" /></a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

