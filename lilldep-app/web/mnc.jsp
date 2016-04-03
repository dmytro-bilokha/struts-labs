<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:html>

<head>
<title><bean:message key="lilldep.jsp.mnc.title" /></title>
<style type="text/css" media="screen">
@import "./styles/styles.css";
</style>
</head>
<body>

	<ul id="navbar">
		<li><a href="full.jsp"><bean:message
					key="lilldep.jsp.full.nav" /></a></li>
		<li><a href="mnc.jsp" class="selected"><bean:message
					key="lilldep.jsp.mnc.nav" /></a></li>
		<li><a href="Collect.do"><bean:message
					key="lilldep.jsp.collection.nav" /></a></li>
		<li><a href="import.jsp"><bean:message
					key="lilldep.jsp.import.nav" /></a></li>
		<li><a href="Listing.do"><bean:message
					key="lilldep.jsp.listing.nav" /></a></li>
	</ul>

	<h2>
		<html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" />
	</h2>

	<html:form action="ContactFormHandlerMNC.do" focus="name">
		<nested:nest property="contact">
			<table>

				<tr>
					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.name" /></td>
					<td><nested:text property="name" size="60" /> <span
						class="error"><html:errors property="name" /></span></td>
				</tr>

				<tr>
					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.designation" /></td>
					<td><nested:text property="designation" size="60" /></td>
				</tr>
				<tr>

					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.department" /></td>
					<td><nested:text property="department" size="60" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.email" /></td>
					<td><nested:text property="email" size="60" /> <span
						class="error"><html:errors property="email" /></span></td>
				</tr>

				<tr>
					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.company" /></td>
					<td><nested:text property="company" size="60" /> <span
						class="error"><html:errors property="company" /></span></td>
				</tr>

				<tr>
					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.address" /></td>
					<td><nested:textarea property="address" rows="5" cols="30" /></td>
				</tr>
				<tr>

					<td align="right"><bean:message
							key="lilldep.jsp.dataentry.prompt.postcode" /></td>
					<td><nested:text property="postcode" size="8" /></td>
				</tr>
				<tr>

					<td colspan="2"><html:submit>
							<bean:message key="lilldep.jsp.prompt.submit" />
						</html:submit></td>
				</tr>

			</table>
			<nested:hidden property="classification" value="MNC" />
		</nested:nest>
	</html:form>



</body>
</html:html>

