package net.thinksquared.lilldep.struts;

/*******************************************************
* Form for holding uploaded data
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
import org.apache.struts.upload.*;

public class ImportForm extends ActionForm {

	protected FormFile file;

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		if (file == null || !file.getFileName().toLowerCase().endsWith(".csv")) {
			if (file != null)
				file.destroy();
			ActionErrors errors = new ActionErrors();
			errors.add("import", new ActionMessage("lilldep.error.file-error"));
			return errors;
		}
		return null;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

}
