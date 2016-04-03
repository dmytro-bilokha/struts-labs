<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- YOUR TAGLIB DECLARATION HERE -->

<html>

    <head>
        <title><bean:message key="lilldep.jsp.list-collection.title"/></title>
        <style type="text/css" media="screen">@import "./styles/styles.css";</style>
    </head>    
    <body>   

       	  <ul id="navbar">
            <li><a href="full.jsp"><bean:message key="lilldep.jsp.full.nav"/></a></li>
            <li><a href="mnc.jsp"><bean:message key="lilldep.jsp.mnc.nav"/></a></li>
            <li><a href="Collect.do"><bean:message key="lilldep.jsp.collection.nav"/></a></li>
            <li><a href="import.jsp"><bean:message key="lilldep.jsp.import.nav"/></a></li>
            <li><a href="Listing.do"><bean:message key="lilldep.jsp.listing.nav"/></a></li>
            <li><a href="AddContacts.do"><bean:message key="lilldep.jsp.search.add-contacts"/></a></li>
    	  </ul> 	

                <!-- DISPLAY THE COLLECTION'S NAME HERE -->
    
                <table width="100%">
                <tr>
                    <td width="20%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.name"/></strong></td>
                    <td width="15%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.email"/></strong></td>
                    <td width="20%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.company"/></strong></td>
                    <td width="40%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.address"/></strong></td>
                    <td><strong><bean:message key="lilldep.jsp.dataentry.prompt.postcode"/></strong></td>
                    <td width="15%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.website"/></strong></td>
                </tr>

                <!-- DISPLAY THE COLLECTION'S LISTING HERE -->
   
                </table>       
    
    </body>
</html>

