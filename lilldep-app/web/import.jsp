<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:html>

<head>
<title><bean:message key="lilldep.jsp.import.title" /></title>
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
		<li><a href="import.jsp" class="selected"><bean:message
					key="lilldep.jsp.import.nav" /></a></li>
		<li><a href="Listing.do"><bean:message
					key="lilldep.jsp.listing.nav" /></a></li>
	</ul>

	<html:form enctype="multipart/form-data" action="ImportForm.do">
		<html:file property="file" size="20" />
		<html:submit>
			<bean:message key="lilldep.jsp.prompt.submit" />
		</html:submit>
		<span class="error"><html:errors /></span>
	</html:form>

</body>
</html:html>

