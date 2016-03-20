package strutslabs.lab4;
/****************************************************
* Java tag handler class to convert Celsius to Fahrenheit
* or Kelvin.
*
* Copyright 2005 by Arnold Doray
*
*   This program is free software; you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation; either version 2 of the License, or
*   (at your option) any later version.
*
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with this program; if not, write to the Free Software
*   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*****************************************************/

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import java.util.logging.*;

public class Converter extends BodyTagSupport {

	private final static Logger logger = Logger.getLogger(Converter.class.getName());

	private final static String KELVIN_STARTS_WITH = "K";
	private final static String FAHRENHEIT_STARTS_WITH = "F";

	private String to;

	public int doAfterBody() {
		try {
			BodyContent bc = getBodyContent();
			JspWriter out = bc.getEnclosingWriter();
			double degrees = Double.parseDouble(bc.getString());
			if (to == null || to.length() == 0 || to.startsWith(FAHRENHEIT_STARTS_WITH))
				out.print(toFahrenheit(degrees));
			else if (to.startsWith(KELVIN_STARTS_WITH))
				out.print(toKelvin(degrees));
			else
				throw new IllegalArgumentException("Unsupported tag parameter: " + to);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Exception in converter class", ex);
		}
		return EVAL_PAGE; // tells servlet container to process rest of JSP
	}

	private double toFahrenheit(double c) {
		return 32.0 + (c * 1.8);
	}

	private double toKelvin(double c) {
		return 273.0 + c;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}