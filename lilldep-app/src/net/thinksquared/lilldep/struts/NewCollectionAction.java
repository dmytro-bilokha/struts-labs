package net.thinksquared.lilldep.struts;

/*******************************************************
* Creates a new Collection.
* author: Arnold Doray
* date: 19 Mar 2005
* version: 0.0
* Copyright 2005 Arnold Doray   
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
********************************************************/

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import net.thinksquared.lilldep.database.*;

public final class NewCollectionAction extends Action implements JSPConstants{

    private final String QUERY_PREFIX = "SELECT CONTACT.CONTACT_ID,CONTACT.NAME,CONTACT.DESIGNATION,CONTACT.DEPARTMENT,CONTACT.EMAIL,CONTACT.TEL,CONTACT.FAX,CONTACT.COMPANY,CONTACT.ADDRESS,CONTACT.POSTCODE,CONTACT.COUNTRY,CONTACT.WEBSITE,CONTACT.ACTIVITY,CONTACT.CLASSIFICATION,CONTACT.MEMO, UPPER(CONTACT.COMPANY) AS UCOMPANY FROM CONTACT WHERE ";
    private final String QUERY_SUFFIX = " ORDER BY UCOMPANY";

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws Exception{

            //YOUR IMPLEMENTATION HERE.

            //NOTE: The query passed to ContactPeer's doSelect()
            //      should be QUERY_PREFIX + query + QUERY_SUFFIX

            return null;//REMOVE!
        
    }

}


