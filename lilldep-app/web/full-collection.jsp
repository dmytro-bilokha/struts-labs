<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html:html>

    <head>
        <title><bean:message key="lilldep.jsp.full.title"/></title>
        <style type="text/css" media="screen">@import "./styles/styles.css";</style>
    </head>    
    <body>   

    <ul id="navbar">
      <li><a href="CollectionNav.do?action=previous"><bean:message key="lilldep.jsp.collection-full.prev.nav"/></a></li>
      <li><a href="CollectionNav.do?action=next"><bean:message key="lilldep.jsp.collection-full.next.nav"/></a></li>
      <li><a href="list-collection.jsp"><bean:message key="lilldep.jsp.list-collection.title"/></a></li>
    </ul> 	

        <h2><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE"/></h2>
    
        <html:form action="ContactUpdate.do" focus="name">

        <table> 
        
            <tr>
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.name"/></td>            
            <td>
                <html:text property="contact.name" size="60" />
                <span class="error"><html:errors property="contact.name"/></span>
            </td>
            </tr><tr>
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.designation"/></td>            
            <td><html:text property="contact.designation" size="60" /></td>
            </tr><tr>
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.department"/></td>            
            <td><html:text property="contact.department" size="60" /></td>
            </tr><tr> 

            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.email"/></td>            
            <td>
                <html:text property="contact.email" size="60" />
                <span class="error"><html:errors property="contact.email"/></span>
            </td>
            </tr><tr>
           
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.company"/></td>            
            <td>
                <html:text property="contact.company" size="60" />
                <span class="error"><html:errors property="contact.company"/></span>
            </td>
            </tr><tr>            

            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.address"/></td>            
            <td><html:textarea property="contact.address" rows="5" cols="30"/></td>
            </tr><tr>
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.postcode"/></td>            
            <td><html:text property="contact.postcode" size="8" /></td>
            </tr><tr>            
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.country"/></td>            
            <td><html:text property="contact.country" size="60" /></td>
            </tr><tr>
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.tel"/></td>                        
              <td><html:text property="contact.tel" size="20" />                   
              <bean:message key="lilldep.jsp.dataentry.prompt.fax"/>        
              <html:text property="contact.fax" size="20" /></td>
            </tr><tr>
            
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.website"/></td>            
            <td><html:text property="contact.website" size="60" /></td>   
            </tr><tr>     
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.activity"/></td>            
            <td><html:textarea property="contact.activity" rows="5" cols="30"/></td>
            </tr><tr>                       
                                  
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.classification"/></td>            
            <td><html:text property="contact.classification" size="60"/></td>
            </tr><tr>
            
            <td align="right"><bean:message key="lilldep.jsp.dataentry.prompt.memo"/></td>            
            <td><html:textarea property="contact.memo" rows="5" cols="30"/></td>
            </tr><tr>            
            <td colspan = "2">
                <html:submit><bean:message key="lilldep.jsp.prompt.submit"/></html:submit>
            </td></tr>           
       
          </table>               
          </html:form>        
    
    </body>
</html:html>

