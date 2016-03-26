package net.thinksquared.lilldep.struts;

/*******************************************************
* LookupDispatchAction for Tiles
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

import java.lang.reflect.Method;

import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.actions.*;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.actions.TilesAction;

public abstract class TilesLookupDispatchAction extends LookupDispatchAction{


    protected Class[] tilesTypes = {
                ComponentContext.class,
                ActionMapping.class,
                ActionForm.class,
                HttpServletRequest.class,
                HttpServletResponse.class};
    
     /**
     * A simpler version of DispatchAction.dispatchMethod()
     */
    protected ActionForward dispatchMethod(ActionMapping mapping,
                                           ActionForm form,
                                           HttpServletRequest request,
                                           HttpServletResponse response,
                                           String name) throws Exception {

        ComponentContext context = getComponentContext(request);

        if (name == null) {
            return this.unspecified(context, mapping, form, request, response);
        }

        // Identify the method object to be dispatched to
        Method method = null;
        try {

            method = getMethod(name);

        } catch(NoSuchMethodException e) {
            
            e.printStackTrace();

            return this.unknown(context, mapping, form, request, response);
        }

        ActionForward forward = null;
        try {
            Object args[] = {context, mapping, form, request, response};
            forward = (ActionForward) method.invoke(this, args);

        } catch(Exception ignore) {

            ignore.printStackTrace();

        }

        return (forward);
    }


    protected ComponentContext getComponentContext(HttpServletRequest request)
    throws ServletException{
        ComponentContext context = ComponentContext.getContext(request);
        if (context == null) {
            throw new ServletException("Can't find Tile Context");
        }
        return context;
    }

    protected String getLookupMapName(
        HttpServletRequest request,
        String keyName,
        ActionMapping mapping)
        throws ServletException {

        String name = "unknown";
        try{
            name = super.getLookupMapName(request,keyName,mapping);
        }catch(ServletException ignore){}

        return name;
    }

    protected Method getMethod(String name)
            throws NoSuchMethodException {
        types = tilesTypes;
        return super.getMethod(name);
    }



    /** Default implementations for unspecified and cancelled **/

    public ActionForward unspecified(ComponentContext context,
                                 ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws ServletException{

        return null;

    }

    public ActionForward cancelled(ComponentContext context,
                                 ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws ServletException{

        return null;

    }

    public ActionForward unknown(ComponentContext context,
                                 ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws ServletException{

        return null;

    }

}


