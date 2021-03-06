<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:html>

<head>
<title><bean:message key="lilldep.jsp.full.title" /></title>
<style type="text/css" media="screen">
@import "./styles/styles.css";
</style>
</head>
<body>

	<ul id="navbar">
		<li><a href="full.jsp" class="selected"><bean:message
					key="lilldep.jsp.full.nav" /></a></li>
		<li><a href="mnc.jsp"><bean:message key="lilldep.jsp.mnc.nav" /></a></li>
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

	<html:form action="ContactFormHandler.do" focus="name">
		<table>
			<tr>
				<td valign="top"><nested:nest property="contact">
						<table>

							<tr>
								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.name" /></td>
								<td><nested:text property="name" size="60" /> <span
									class="error"><html:errors property="contact.name" /></span></td>
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
									class="error"><html:errors property="contact.email" /></span></td>
							</tr>

							<tr>
								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.email" /></td>
								<td><html:text property="myemail" size="60" /> <span
									class="error"><html:errors property="myemail" /></span></td>
							</tr>

							<tr>
								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.company" /></td>
								<td><nested:text property="company" size="60" /> <span
									class="error"><html:errors property="contact.company" /></span></td>
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
								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.tel" /></td>
								<td><nested:text property="tel" size="20" /> <bean:message
										key="lilldep.jsp.dataentry.prompt.fax" /> <nested:text
										property="fax" size="20" /></td>
							</tr>
							<tr>


								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.website" /></td>
								<td><nested:text property="website" size="60" /></td>
							</tr>
							<tr>

								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.activity" /></td>
								<td><nested:textarea property="activity" rows="5" cols="30" /></td>
							</tr>
							<tr>


								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.classification" /></td>
								<td><nested:text property="classification" size="60" /></td>
							</tr>
							<tr>

								<td align="right"><bean:message
										key="lilldep.jsp.dataentry.prompt.memo" /></td>
								<td><nested:textarea property="memo" rows="5" cols="30" /></td>
							</tr>
							<tr>
								<td colspan="2"><html:submit property="command">
										<bean:message key="lilldep.jsp.prompt.submit" />
									</html:submit></td>
							</tr>

						</table>

					</nested:nest></td>
				<td valign="top"><html:submit property="command">
						<bean:message key="lilldep.jsp.find.button" />
					</html:submit> <tiles:insert definition=".find" /></td>
			</tr>
		</table>
	</html:form>

</body>
</html:html>

