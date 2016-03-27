package net.thinksquared.lilldep.database;
/**
  * Autogenerated by Lisptorq 0.1.4 
*/
import java.sql.*;

public class BaseCollectionPeer  { 

	public static void doInsert(BaseCollection args0)
	throws Exception{
        Connection connection = Database.getConnection(); 
        doSave(args0,false,connection);
        Database.release(connection);
	} 

	public static void doInsert(BaseCollection args0,Connection connection)
	throws Exception{ 
        doSave(args0,false,connection);
	} 

	public static void doUpdate(BaseCollection args0)
	throws Exception{ 	
        Connection connection = Database.getConnection(); 
        doSave(args0,true,connection);
        Database.release(connection);
    }

	public static void doUpdate(BaseCollection args0,Connection connection)
	throws Exception{ 	
        doSave(args0,true,connection);
    }

	private static void doSave(BaseCollection args0, boolean isUpdate, Connection connection)
	throws Exception{ 

        Statement statement = connection.createStatement();        
        String query = "";
        if(isUpdate){
            query = "UPDATE collection SET " + " name = " + Criteria.escape(args0.getName()) + " , " + " memo = " + Criteria.escape(args0.getMemo()) + " WHERE " + " collection_id = " + Criteria.escape(args0.getCollectionId()) + "";
            statement.executeUpdate(query);
        }else{
            query = "INSERT INTO collection ( name , memo ) VALUES ( " + Criteria.escape(args0.getName()) + " , " + Criteria.escape(args0.getMemo()) + " )";         
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                args0.collectionId=rs.getInt(1);
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
        statement.executeUpdate(args0.deleteSQL("COLLECTION"));
        statement.close();
    } 

	public static void doDelete(BaseCollection args0)
	throws Exception{ 
        Connection connection = Database.getConnection();
        doDelete(args0,connection);
        Database.release(connection);
    } 

	public static void doDelete(BaseCollection args0, Connection connection)
	throws Exception{ 
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM collection WHERE " + " collection_id = " + Criteria.escape(args0.getCollectionId()) + "");
        statement.close();
        args0.saved = false; 	
    } 

	public static Scroller doSelect(Criteria args0)
	throws Exception{ 
		return doSelect(args0.selectSQL("COLLECTION.COLLECTION_ID,COLLECTION.NAME,COLLECTION.MEMO","COLLECTION"));
	} 

	public static Scroller doSelect(String sql)
	throws Exception{         
        return new  CollectionScroller(sql,false);
	} 

	public static Scroller doSelect(Criteria args0, boolean recycle)
	throws Exception{ 
		return doSelect(args0.selectSQL("COLLECTION.COLLECTION_ID,COLLECTION.NAME,COLLECTION.MEMO","COLLECTION"),recycle);
	} 

	public static Scroller doSelect(String sql, boolean recycle)
	throws Exception{         
        return new  CollectionScroller(sql,recycle);
	} 

	protected static Collection getBean(ResultSet results, Collection ret)
	throws Exception{ 

				ret.collectionId=results.getInt("COLLECTION_ID");
				ret.name=results.getString("NAME");
				ret.memo=results.getString("MEMO");
        
    
        ret.saved = true;        
                
        return ret;   
	} 


    private static class CollectionScroller implements Scroller{

        Statement statement;
        ResultSet results;   
        boolean recycle = false;  
        Collection cache = null;    

        private CollectionScroller(String sql,boolean recycle) throws Exception{

            Connection connection = Database.getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            results = statement.executeQuery(sql);
            Database.release(connection);
            this.recycle = recycle;
            
        }

        public Object next(){        
            try{     
                cache = (recycle && cache != null)?  BaseCollectionPeer.getBean(results, cache) : 
                                                     BaseCollectionPeer.getBean(results, new Collection());
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
                cache = (recycle && cache != null)?  BaseCollectionPeer.getBean(results, cache) : 
                                                     BaseCollectionPeer.getBean(results, new Collection());
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