<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- YOUR TAGLIB DECLARATION HERE -->

<html>

    <head>
        <title><bean:message key="lilldep.jsp.listing.title"/></title>
        <style type="text/css" media="screen">@import "./styles/styles.css";</style>
    </head>    
    <body>   

       	  <ul id="navbar">
            <li><a href="full.jsp"><bean:message key="lilldep.jsp.full.nav"/></a></li>
            <li><a href="mnc.jsp"><bean:message key="lilldep.jsp.mnc.nav"/></a></li>
            <li><a href="Collect.do"><bean:message key="lilldep.jsp.collection.nav"/></a></li>
            <li><a href="import.jsp"><bean:message key="lilldep.jsp.import.nav"/></a></li>
            <li><a href="Listing.do" class="selected"><bean:message key="lilldep.jsp.listing.nav"/></a></li>
    	  </ul> 	
    
                <table width="100%">
                <tr>
                    <td width="20%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.name"/></strong></td>
                    <td width="15%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.email"/></strong></td>
                    <td width="20%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.company"/></strong></td>
                    <td width="40%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.address"/></strong></td>
                    <td><strong><bean:message key="lilldep.jsp.dataentry.prompt.postcode"/></strong></td>
                    <td width="15%"><strong><bean:message key="lilldep.jsp.dataentry.prompt.website"/></strong></td>
                </tr>

                <!-- DISPLAY THE LISTING HERE -->
   
                </table>       
    
    </body>
</html>

