package net.thinksquared.lilldep.struts;

/*******************************************************
* Add/edit/delete a contact
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.thinksquared.lilldep.database.Contact;
import net.thinksquared.lilldep.database.ContactPeer;
import net.thinksquared.lilldep.database.Criteria;
import net.thinksquared.lilldep.database.Scroller;

public final class EditContactAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null) {
			try {
				// get Contact by Id
				Criteria crit = new Criteria();
				crit.add(Contact.CONTACT_ID, Integer.parseInt(id.trim()));
				Scroller results = ContactPeer.doSelect(crit);
				if (!results.hasNext())
					return mapping.getInputForward();

				// save Contact to form
				ContactForm cForm = (ContactForm) form;
				cForm.setContact((Contact) results.next());
				return mapping.findForward("success");
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		return mapping.getInputForward();
	}

}
