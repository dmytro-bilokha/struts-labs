<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<logic:notEmpty name="find-results">
	<h2>
		<bean:message key="lilldep.jsp.find.title" />
	</h2>
	<table width="100%">
		<logic:iterate id="contact" name="find-results">
			<tr>
				<td><a
					href="EditContact.do?id=<bean:write name="contact" property="contactId" />">
						<logic:empty name="contact" property="company">
							<bean:message key="lilldep.jsp.dataentry.prompt.uknown" />
						</logic:empty> <logic:notEmpty name="contact" property="company">
							<bean:write name="contact" property="company" />
						</logic:notEmpty>
				</a></td>
			</tr>
		</logic:iterate>
	</table>
</logic:notEmpty>
