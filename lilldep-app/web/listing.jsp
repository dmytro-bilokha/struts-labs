<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- YOUR TAGLIB DECLARATION HERE -->
<%@ taglib uri="/tags/bean" prefix="bean"%>
<%@ taglib uri="/tags/html" prefix="html"%>
<%@ taglib uri="/tags/logic" prefix="logic"%>
<%@ taglib uri="/tags/nested" prefix="nested"%>
<%@ taglib uri="/tags/tiles" prefix="tiles"%>

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

		<logic:iterate name="listing" id="contact" indexId="cnt">
			<!-- DISPLAY THE LISTING HERE -->
			<tr>
				<td><bean:write name="contact" property="name" /></td>
				<td><bean:write name="contact" property="email" /></td>
				<td><bean:write name="contact" property="company" /></td>
				<td><bean:write name="contact" property="address" /></td>
				<td><bean:write name="contact" property="postcode" /></td>
				<td><a href="<bean:write name="contact" property="website" />">
						<bean:write name="contact" property="website" />
				</a></td>
			</tr>
		</logic:iterate>
	</table>

</body>
</html>

