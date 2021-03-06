package net.thinksquared.lilldep.struts;

import java.util.HashMap;
import java.util.Map;

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

import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.actions.LookupDispatchAction;

import net.thinksquared.lilldep.database.*;

public final class ContactAction extends LookupDispatchAction {

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionMessages formErrors = form.validate(mapping, request);
		if (!formErrors.isEmpty()) {
			saveErrors(request, formErrors);
			return mapping.getInputForward();
		}
		try {
			ContactForm contactForm = (ContactForm) form;
			contactForm.getContact().save();
			contactForm.setContact(new Contact()); // Interesting moment here
		} catch (Exception ex) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("lilldep.error.save"));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward find(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ContactForm contactForm = (ContactForm) form;
		contactForm.setContact(new Contact());
		return mapping.findForward("success");
	}

	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> m = new HashMap<>();
		m.put("lilldep.jsp.find.button", "find");
		m.put("lilldep.jsp.prompt.submit", "save");
		return m;
	}

}
