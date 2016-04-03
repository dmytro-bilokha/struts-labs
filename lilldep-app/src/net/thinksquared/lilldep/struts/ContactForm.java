package net.thinksquared.lilldep.struts;

import java.util.regex.Pattern;

/*******************************************************
* Form for data entry
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
import net.thinksquared.lilldep.database.*;

public class ContactForm extends ActionForm {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	protected Contact contact;

	public ContactForm() {
		contact = new Contact();
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (contact.getCompany() == null || contact.getCompany().trim().isEmpty())
			errors.add("company", new ActionMessage("lilldep.error.company"));
		if (contact.getName() == null || contact.getName().trim().isEmpty())
			errors.add("name", new ActionMessage("lilldep.error.name"));
		if (contact.getEmail() == null || contact.getEmail().trim().isEmpty())
			errors.add("email", new ActionMessage("lilldep.error.email"));
		else if (!VALID_EMAIL_ADDRESS_REGEX.matcher(contact.getEmail()).find())
			errors.add("email", new ActionMessage("lilldep.error.email"));
		return errors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		contact.clear();
	}


	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
