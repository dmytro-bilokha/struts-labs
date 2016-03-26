<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- YOUR TAGLIB DECLARATIONS HERE -->

<html:html>

    <head>
        <title><bean:message key="lilldep.jsp.mnc.title"/></title>
        <style type="text/css" media="screen">@import "./styles/styles.css";</style>
    </head>    
    <body>   

       	  <ul id="navbar">
            <li><a href="full.jsp"><bean:message key="lilldep.jsp.full.nav"/></a></li>
            <li><a href="mnc.jsp" class="selected"><bean:message key="lilldep.jsp.mnc.nav"/></a></li>
            <li><a href="Collect.do"><bean:message key="lilldep.jsp.collection.nav"/></a></li>
            <li><a href="import.jsp"><bean:message key="lilldep.jsp.import.nav"/></a></li>
            <li><a href="Listing.do"><bean:message key="lilldep.jsp.listing.nav"/></a></li>
    	  </ul> 	  

          <h2><!-- GLOBAL ERROR MESSAGE FROM LAB 7 HERE  --></h2>

          <!-- 
                YOUR FORM HERE. NOTE THAT:

                1) The form handler is ContactFormHandlerMNC
                2) The properties to be displayed are name,designation,department,email,company,address,postcode.
                3) Remember to put in error message tags for the relevant properties.
                4) The "classification" property should be set to "MNC" using the "hidden" tag.

          -->      
            
    
    </body>
</html:html>

