package net.thinksquared.lilldep.struts;

/*******************************************************
* The Find Tile's Action
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

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.actions.TilesAction;

import net.thinksquared.lilldep.database.*;
import net.thinksquared.lilldep.util.*;

public class FindAction extends TilesLookupDispatchAction implements JSPConstants {

	public Map<String, String> getKeyMethodMap() {
		HashMap<String, String> m = new HashMap<>();
		m.put("lilldep.jsp.find.button", "find");
		return m;
	}

	public ActionForward find(ComponentContext context, ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ContactForm contactForm = (ContactForm) form;
		Contact contact = contactForm.getContact();
		if (contact != null) {
			Contact contactReplicant = contact.klone();
			request.getSession().setAttribute(JSPConstants.FIND_QUERY, contactReplicant);
			Scroller scroller = ContactPeer.find(contactReplicant);
			request.setAttribute(JSPConstants.FIND_RESULTS, scroller);
		}
		return null;
	}

	public ActionForward unspecified(ComponentContext context, ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {

		// forward to unknown()
		return unknown(context, mapping, form, request, response);

	}

	public ActionForward unknown(ComponentContext context, ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Contact contact = (Contact) request.getSession().getAttribute(JSPConstants.FIND_QUERY);
		if (contact != null) {
			Scroller scroller = ContactPeer.find(contact);
			request.setAttribute(JSPConstants.FIND_RESULTS, scroller);
		}
		return null;
	}

}
