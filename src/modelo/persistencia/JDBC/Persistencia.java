package modelo.persistencia.JDBC;

import java.sql.*;

public class Persistencia {
        // XAMPP
    private static String login = "root";
    private static String psw = "";
    
    // COMMUNITY
//    private static String login = "root";
//    private static String password = "root1234";

    private static String url = "jdbc:mysql://localhost:3306/facturacion?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    
    private static Connection conexion=null;
    
    /**
     * La apertura de la conexi�n es implementada seg�n el patr�n singleton
     * De esta forma, a lo sumo, tendremos una s�la conexi�n abierta en la aplicaci�n
     */
    public static Connection createConnection(){
        if (conexion==null){
            try{
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
                
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conexion=DriverManager.getConnection(url,login,psw);
            }catch(ClassNotFoundException e){System.out.println(e);
            }catch(SQLException e){System.out.println(e);
            }catch(java.lang.InstantiationException e){System.out.println(e);
            }catch(java.lang.IllegalAccessException e){System.out.println(e);}
        }
        return conexion;
    }
    
    public static void closeConnection(){
        try{
            if(conexion!=null){
                conexion.close();
                conexion=null;
            }
        }catch(SQLException e){System.out.println(e);}
    }
    
}
