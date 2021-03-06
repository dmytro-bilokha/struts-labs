package net.thinksquared.lilldep.struts;

/*******************************************************
* Import CSV data into the contact database
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

import java.io.*;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.upload.*;

import net.thinksquared.lilldep.database.BaseContactPeer;
import net.thinksquared.lilldep.database.Contact;

//import com.sun.javafx.collections.MappingChange.Map;

import net.thinksquared.lilldep.util.*;

public final class ImportAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ImportForm importForm = (ImportForm) form;
		FormFile formFile = importForm.getFile();
		try (Reader importFileReader = new BufferedReader(
				new InputStreamReader(formFile.getInputStream()))) {
			Iterator<Map<String, String>> importedContactsIterator = new CSVIterator(importFileReader, "|");
			while (importedContactsIterator.hasNext()) {
				Map<String, String> contactMap = importedContactsIterator.next();
				(new Contact(contactMap)).save();
			}
			formFile.destroy();
		} catch (Exception ex) {
			ActionMessages errors = new ActionMessages();
			errors.add("import", new ActionMessage("lilldep.error.import"));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

}
