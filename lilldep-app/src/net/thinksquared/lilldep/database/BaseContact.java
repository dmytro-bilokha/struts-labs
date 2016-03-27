package net.thinksquared.lilldep.database;
/**
  * Autogenerated by Lisptorq 0.1.4 
*/
import java.sql.*;
import java.util.Iterator;
public class BaseContact  { 
	public static final String MEMO  = "CONTACT.MEMO"; 
	public static final String ACTIVITY  = "CONTACT.ACTIVITY"; 
	public static final String COUNTRY  = "CONTACT.COUNTRY"; 
	public static final String ADDRESS  = "CONTACT.ADDRESS"; 
	public static final String FAX  = "CONTACT.FAX"; 
	public static final String EMAIL  = "CONTACT.EMAIL"; 
	public static final String DESIGNATION  = "CONTACT.DESIGNATION"; 
	public static final String CONTACT_ID  = "CONTACT.CONTACT_ID"; 
	protected String memo; 
	protected String activity; 
	protected String country; 
	protected String address; 
	protected String fax; 
	protected String email; 
	protected String designation; 
	protected int contactId; 
	protected String name; 
	protected String department; 
	protected String tel; 
	protected String company; 
	protected String postcode; 
	protected String website; 
	protected String classification; 
	protected boolean saved  = false; 
	public static final String NAME  = "CONTACT.NAME"; 
	public static final String DEPARTMENT  = "CONTACT.DEPARTMENT"; 
	public static final String TEL  = "CONTACT.TEL"; 
	public static final String COMPANY  = "CONTACT.COMPANY"; 
	public static final String POSTCODE  = "CONTACT.POSTCODE"; 
	public static final String WEBSITE  = "CONTACT.WEBSITE"; 
	public static final String CLASSIFICATION  = "CONTACT.CLASSIFICATION"; 

	public void save()
	throws Exception{ 
		if(saved){
			BaseContactPeer.doUpdate(this);
		}else{
			BaseContactPeer.doInsert(this);
		}
	} 

	public String getClassification(){ 
		return classification;
	} 

	public String getWebsite(){ 
		return website;
	} 

	public String getPostcode(){ 
		return postcode;
	} 

	public String getCompany(){ 
		return company;
	} 

	public String getTel(){ 
		return tel;
	} 

	public String getDepartment(){ 
		return department;
	} 

	public String getName(){ 
		return name;
	} 

	public void setDesignation(String args0){ 
		designation =args0;
	} 

	public void setEmail(String args0){ 
		email =args0;
	} 

	public void setFax(String args0){ 
		fax =args0;
	} 

	public void setAddress(String args0){ 
		address =args0;
	} 

	public void setCountry(String args0){ 
		country =args0;
	} 

	public void setActivity(String args0){ 
		activity =args0;
	} 

	public void setMemo(String args0){ 
		memo =args0;
	} 

	public String getMemo(){ 
		return memo;
	} 

	public String getActivity(){ 
		return activity;
	} 

	public String getCountry(){ 
		return country;
	} 

	public String getAddress(){ 
		return address;
	} 

	public String getFax(){ 
		return fax;
	} 

	public String getEmail(){ 
		return email;
	} 

	public String getDesignation(){ 
		return designation;
	} 

	/**
	  * contactId is autogenerated 
	*/
	public int getContactId(){ 
		return contactId;
	} 

	public void setName(String args0){ 
		name =args0;
	} 

	public void setDepartment(String args0){ 
		department =args0;
	} 

	public void setTel(String args0){ 
		tel =args0;
	} 

	public void setCompany(String args0){ 
		company =args0;
	} 

	public void setPostcode(String args0){ 
		postcode =args0;
	} 

	public void setWebsite(String args0){ 
		website =args0;
	} 

	public void setClassification(String args0){ 
		classification =args0;
	} 
}