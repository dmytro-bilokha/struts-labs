package net.thinksquared.lilldep.database;
/**
  * Autogenerated by Lisptorq 0.1.4 
*/
import java.sql.*;

public class BaseContactPeer  { 

	public static void doInsert(BaseContact args0)
	throws Exception{
        Connection connection = Database.getConnection(); 
        doSave(args0,false,connection);
        Database.release(connection);
	} 

	public static void doInsert(BaseContact args0,Connection connection)
	throws Exception{ 
        doSave(args0,false,connection);
	} 

	public static void doUpdate(BaseContact args0)
	throws Exception{ 	
        Connection connection = Database.getConnection(); 
        doSave(args0,true,connection);
        Database.release(connection);
    }

	public static void doUpdate(BaseContact args0,Connection connection)
	throws Exception{ 	
        doSave(args0,true,connection);
    }

	private static void doSave(BaseContact args0, boolean isUpdate, Connection connection)
	throws Exception{ 

        Statement statement = connection.createStatement();        
        String query = "";
        if(isUpdate){
            query = "UPDATE contact SET " + " name = " + Criteria.escape(args0.getName()) + " , " + " designation = " + Criteria.escape(args0.getDesignation()) + " , " + " department = " + Criteria.escape(args0.getDepartment()) + " , " + " email = " + Criteria.escape(args0.getEmail()) + " , " + " tel = " + Criteria.escape(args0.getTel()) + " , " + " fax = " + Criteria.escape(args0.getFax()) + " , " + " company = " + Criteria.escape(args0.getCompany()) + " , " + " address = " + Criteria.escape(args0.getAddress()) + " , " + " postcode = " + Criteria.escape(args0.getPostcode()) + " , " + " country = " + Criteria.escape(args0.getCountry()) + " , " + " website = " + Criteria.escape(args0.getWebsite()) + " , " + " activity = " + Criteria.escape(args0.getActivity()) + " , " + " classification = " + Criteria.escape(args0.getClassification()) + " , " + " memo = " + Criteria.escape(args0.getMemo()) + " WHERE " + " contact_id = " + Criteria.escape(args0.getContactId()) + "";
            statement.executeUpdate(query);
        }else{
            query = "INSERT INTO contact ( name , designation , department , email , tel , fax , company , address , postcode , country , website , activity , classification , memo ) VALUES ( " + Criteria.escape(args0.getName()) + " , " + Criteria.escape(args0.getDesignation()) + " , " + Criteria.escape(args0.getDepartment()) + " , " + Criteria.escape(args0.getEmail()) + " , " + Criteria.escape(args0.getTel()) + " , " + Criteria.escape(args0.getFax()) + " , " + Criteria.escape(args0.getCompany()) + " , " + Criteria.escape(args0.getAddress()) + " , " + Criteria.escape(args0.getPostcode()) + " , " + Criteria.escape(args0.getCountry()) + " , " + Criteria.escape(args0.getWebsite()) + " , " + Criteria.escape(args0.getActivity()) + " , " + Criteria.escape(args0.getClassification()) + " , " + Criteria.escape(args0.getMemo()) + " )";         
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                args0.contactId=rs.getInt(1);
            }
        }   
        statement.close();  
        args0.saved = true;      
	}
 
	public static void doDelete(Criteria args0)
	throws Exception{ 
        Connection connection = Database.getConnection();
        doDelete(args0,connection);
        Database.release(connection);
    } 

	public static void doDelete(Criteria args0, Connection connection)
	throws Exception{ 
        Statement statement = connection.createStatement();
        statement.executeUpdate(args0.deleteSQL("CONTACT"));
        statement.close();
    } 

	public static void doDelete(BaseContact args0)
	throws Exception{ 
        Connection connection = Database.getConnection();
        doDelete(args0,connection);
        Database.release(connection);
    } 

	public static void doDelete(BaseContact args0, Connection connection)
	throws Exception{ 
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM contact WHERE " + " contact_id = " + Criteria.escape(args0.getContactId()) + "");
        statement.close();
        args0.saved = false; 	
    } 

	public static Scroller doSelect(Criteria args0)
	throws Exception{ 
		return doSelect(args0.selectSQL("CONTACT.CONTACT_ID,CONTACT.NAME,CONTACT.DESIGNATION,CONTACT.DEPARTMENT,CONTACT.EMAIL,CONTACT.TEL,CONTACT.FAX,CONTACT.COMPANY,CONTACT.ADDRESS,CONTACT.POSTCODE,CONTACT.COUNTRY,CONTACT.WEBSITE,CONTACT.ACTIVITY,CONTACT.CLASSIFICATION,CONTACT.MEMO","CONTACT"));
	} 

	public static Scroller doSelect(String sql)
	throws Exception{         
        return new  ContactScroller(sql,false);
	} 

	public static Scroller doSelect(Criteria args0, boolean recycle)
	throws Exception{ 
		return doSelect(args0.selectSQL("CONTACT.CONTACT_ID,CONTACT.NAME,CONTACT.DESIGNATION,CONTACT.DEPARTMENT,CONTACT.EMAIL,CONTACT.TEL,CONTACT.FAX,CONTACT.COMPANY,CONTACT.ADDRESS,CONTACT.POSTCODE,CONTACT.COUNTRY,CONTACT.WEBSITE,CONTACT.ACTIVITY,CONTACT.CLASSIFICATION,CONTACT.MEMO","CONTACT"),recycle);
	} 

	public static Scroller doSelect(String sql, boolean recycle)
	throws Exception{         
        return new  ContactScroller(sql,recycle);
	} 

	protected static Contact getBean(ResultSet results, Contact ret)
	throws Exception{ 

				ret.contactId=results.getInt("CONTACT_ID");
				ret.name=results.getString("NAME");
				ret.designation=results.getString("DESIGNATION");
				ret.department=results.getString("DEPARTMENT");
				ret.email=results.getString("EMAIL");
				ret.tel=results.getString("TEL");
				ret.fax=results.getString("FAX");
				ret.company=results.getString("COMPANY");
				ret.address=results.getString("ADDRESS");
				ret.postcode=results.getString("POSTCODE");
				ret.country=results.getString("COUNTRY");
				ret.website=results.getString("WEBSITE");
				ret.activity=results.getString("ACTIVITY");
				ret.classification=results.getString("CLASSIFICATION");
				ret.memo=results.getString("MEMO");
        
    
        ret.saved = true;        
                
        return ret;   
	} 


    private static class ContactScroller implements Scroller{

        Statement statement;
        ResultSet results;   
        boolean recycle = false;  
        Contact cache = null;    

        private ContactScroller(String sql,boolean recycle) throws Exception{

            Connection connection = Database.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            results = statement.executeQuery(sql);
            Database.release(connection);
            this.recycle = recycle;
            
        }

        public Object next(){        
            try{     
                cache = (recycle && cache != null)?  BaseContactPeer.getBean(results, cache) : 
                                                     BaseContactPeer.getBean(results, new Contact());
                return cache;
            }catch(Exception ignore){
                return null;
            }
        }

        public boolean hasNext(){
            try{
                if(results.next()){
                    return true;
                }else{
                    return false;   
                }
            }catch(Exception ignore){
                return false;
            }
        }

        public Object previous(){        
            try{     
                cache = (recycle && cache != null)?  BaseContactPeer.getBean(results, cache) : 
                                                     BaseContactPeer.getBean(results, new Contact());
                return cache;
            }catch(Exception ignore){
                return null;
            }
        }

        public boolean hasPrevious(){
            try{
                if(results.previous()){
                    return true;
                }else{
                    return false;   
                }
            }catch(Exception ignore){
                return false;
            }
        }

        public void absolute(int position){
            try{results.absolute(position);}catch(Exception ignore){}    
        }

        public void remove() throws UnsupportedOperationException{ throw new UnsupportedOperationException(); }
        public int  size()   throws UnsupportedOperationException{ throw new UnsupportedOperationException(); }

        protected void finalize() throws Throwable{
            try{statement.close();}catch(Exception ignore){}
        }

    }


}
