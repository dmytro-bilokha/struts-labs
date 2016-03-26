package net.thinksquared.lilldep.util;

/************************************************
* Parses a csv file, giving records at each read
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
import java.util.*;
import net.thinksquared.lilldep.database.*;

public class CSVIterator implements Iterator{

  private ArrayList headers;
  private BufferedReader reader;
  private Map data;
  private String delimiter;	

  public CSVIterator(String fname, String del) throws Exception{
    this(new File(fname), del);	
  }

  public CSVIterator(File file, String del) throws Exception{
      this(new FileReader(file),del);
  }

  public CSVIterator(Reader r, String del) throws Exception{
      reader = new BufferedReader(r);	
      data = new HashMap();
      delimiter = del; 
      headers = new ArrayList();
      initialize(reader.readLine(),delimiter);			
  }

  public boolean hasNext(){

	try{

		String aline = reader.readLine();
		if(aline == null){
			return false;
		}else{
			parse(aline,delimiter);
			return true;
		}

	}catch(Exception e){
		e.printStackTrace();
		return false;
	}

  }

  private void parse(String aline, String delimiter){

	//parse the string
	StringTokenizer st = new StringTokenizer(aline,delimiter,true);
	String prev = "";
	int i = 0;
	data.clear();
	while(st.hasMoreTokens()){
		String s = st.nextToken();
		if(s.equals(delimiter) && prev.equals(delimiter)){
			data.put(headers.get(i++),"");			
		}else if(!s.equals(delimiter)){
			data.put(headers.get(i++),s.trim());			
		}		
		prev = s;
	}
	
  }	

  private void initialize(String header, String delimiter){
	StringTokenizer st = new StringTokenizer(header,delimiter);
	while(st.hasMoreTokens()){
		String h = st.nextToken().trim();
		headers.add(h);						
	}
  }

  public Object next(){ return data; }
  public void remove(){}

}
