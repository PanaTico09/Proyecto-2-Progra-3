package servicios;

import java.sql.*;

/**
 *
 * @author Johan Herrera
 */
public class Conexion {

    private static Connection cnx = null;

    /**
     * <h1>Obtener</h1>
     * <p>Conecta el sistema con la base de datos.</p>
     * @return conexion con la base de datos MySQL
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/algoritmos", "root", "johan1998");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx; 
    }
    /**
     * <h1>Cerrar</h1>
     * <p>Cierra la conexion con la base de datos.</p>
     * @throws SQLException 
     */
    public static void cerrar() throws SQLException{
        if(cnx != null){
            cnx.close();
        }
    }
}
