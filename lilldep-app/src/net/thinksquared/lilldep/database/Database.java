package net.thinksquared.lilldep.database;
/**
  * Autogenerated by Lisptorq 0.1.3 
  * from derby-connection.template
*/

import java.sql.*;
import java.util.Stack;

public class Database{ 

    private static Stack _pool = new Stack();

	static{ 
        try{

            //set path to database
            String catalinaHome = System.getProperty("catalina.home");
            if(catalinaHome == null){ 
                //we are called from an pre-install program
                System.setProperty("derby.system.home","./dbase"); 
            }else{ 
                //we are on a Tomcat servlet
                System.setProperty("derby.system.home",  
                                    catalinaHome + "/webapps/lilldep/dbase"); 
            }
	   	   Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        }catch(Exception e){
            e.printStackTrace();
        }
	} 

	public static Connection getConnection(){ 
		try{
            synchronized(_pool){            
                if(!_pool.empty()){
                    return (Connection) _pool.pop();
                }
            }  
			return DriverManager.getConnection("jdbc:derby:dbase");
		}catch(Exception e){
			e.printStackTrace();
		}
        return null;
	} 

    protected Connection getCreationConnection() throws Exception{
        return DriverManager.getConnection("jdbc:derby:dbase;create=true");        
    }

	public static void shutdown(){ 
        try{
            synchronized(_pool){
                while(!_pool.empty()){
                    try{
                        Connection conn = (Connection) _pool.pop();
                        conn.close();    
                    }catch(Exception ignore){}
                }
            }
    
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        }catch(SQLException ex){
            System.out.println("Shutting down derby: " + ex.getMessage());            
        }   
	} 

    
    public static void release(Connection connection){
        synchronized(_pool){
            try{ connection.setAutoCommit(true); }catch(Exception ignore){}
            _pool.push(connection);
        }
    }

}
