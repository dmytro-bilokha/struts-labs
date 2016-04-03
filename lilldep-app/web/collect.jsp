<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>

    <head>
        <title><bean:message key="lilldep.jsp.collection.title"/></title>
        <style type="text/css" media="screen">@import "./styles/styles.css";</style>
    </head>    
    <body>   

       	  <ul id="navbar">
            <li><a href="full.jsp"><bean:message key="lilldep.jsp.full.nav"/></a></li>
            <li><a href="mnc.jsp"><bean:message key="lilldep.jsp.mnc.nav"/></a></li>
            <li><a href="Collect.do" class="selected"><bean:message key="lilldep.jsp.collection.nav"/></a></li>
            <li><a href="import.jsp"><bean:message key="lilldep.jsp.import.nav"/></a></li>
            <li><a href="Listing.do"><bean:message key="lilldep.jsp.listing.nav"/></a></li>
    	  </ul> 	


                <h1><bean:message key="lilldep.jsp.collection.title"/></h1>
                <table>
                <tr>
                    <td></td>
                    <td><a href="new-collection.jsp"><bean:message key="lilldep.jsp.collection.new"/></a></td>
                </tr>
            

                                <!-- YOUR IMPLEMENTATION HERE -->        


                </table>	

    
    </body>
</html>

