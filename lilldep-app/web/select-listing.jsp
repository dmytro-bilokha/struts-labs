<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html>

    <head>
        <title><bean:message key="lilldep.jsp.search.add-contacts"/></title>
        <style type="text/css" media="screen">@import "./styles/styles.css";</style>
    </head>    
    <body>   

                <h1><bean:message key="lilldep.jsp.search.add-contacts"/></h1>

                <table width="100%">
                <tr>
                    <td></td>
                    <td width="20%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.name"/></strong></td>
                    <td width="15%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.email"/></strong></td>
                    <td width="20%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.company"/></strong></td>
                    <td width="40%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.address"/></strong></td>
                    <td><strong><bean:message key="lilldep.jsp.dataentry.prompt.postcode"/></strong></td>
                    <td width="15%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.website"/></strong></td>
                </tr>

                <!-- YOUR IMPLEMENTATION HERE -->
   
                </table>       
    
    </body>
</html>

