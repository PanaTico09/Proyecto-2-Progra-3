package servicios;

import da.DatosAlgoritmos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johan Herrera
 */
public class Datos_Servicios {

    private final String tabla = "algoritmos.datos";

    /**
     * <h1>Guardar</h1>
     * <p>
     * Guarda los datos dentro de la base de datos.</p>
     *
     * @param conexion
     * @param datos
     * @throws SQLException
     */
    public void guardar(Connection conexion, DatosAlgoritmos datos) throws SQLException {
        if (conexion != null) {
            try {
                PreparedStatement consulta;
                if (datos.getId_algoritmo() == null) {
                    consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(NombreAlgoritmo, TipoEstructura, Fecha, Duracion) VALUES(?, ?, ?, ?)");
                    consulta.setString(1, datos.getNombreAlgoritmo());
                    consulta.setString(2, datos.getTipoEstructura());
                    consulta.setDate(3, datos.getFecha());
                    consulta.setDouble(4, datos.getDuracion());
                } else {
                    consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET NombreAlgoritmo = ?, TipoEstructura = ?, Fecha = ?, Duracion = ?, WHERE idAlgoritmo= ?");
                    consulta.setString(1, datos.getNombreAlgoritmo());
                    consulta.setString(2, datos.getTipoEstructura());
                    consulta.setDate(3, datos.getFecha());
                    consulta.setDouble(4, datos.getDuracion());
                    consulta.setInt(5, datos.getId_algoritmo());
                }
                consulta.executeUpdate();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        }
    }

    /**
     * <h1>RecuperarPorID</h1>
     * <p>
     * Busca en la base de datos el id especificado.</p>
     *
     * @param conexion
     * @param id_Algoritmo
     * @return Los datos asociados al id especificado.
     * @throws SQLException
     */
    public DatosAlgoritmos recuperarPorId(Connection conexion, int id_Algoritmo) throws SQLException {
        DatosAlgoritmos datos = null;
        if (conexion != null) {
            try {
                PreparedStatement consulta = conexion.prepareStatement("SELECT NombreAlgoritmo, TipoEstructura, Fecha, Duracion FROM " + this.tabla + " WHERE idAlgoritmo = ?");
                consulta.setInt(1, id_Algoritmo);
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    datos = new DatosAlgoritmos(id_Algoritmo, resultado.getString("NombreAlgoritmo"), resultado.getString("TipoEstructura"),
                            resultado.getDate("Fecha"), resultado.getDouble("Duracion"));
                }
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
            return datos;
        }
        return null;
    }

    /**
     * <h1>Eliminar</h1>
     * <p>
     * Borra todos los datos que se encuentran almacenados en la base de
     * datos.</p>
     *
     * @param conexion
     * @throws SQLException
     */
    public void eliminar(Connection conexion) throws SQLException {
        if (conexion != null) {
            try {
                PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla);
                consulta.executeUpdate();
                consulta = conexion.prepareStatement("ALTER TABLE datos AUTO_INCREMENT = 1");
                consulta.executeUpdate();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        }
    }

    /**
     * <h1>Recuperar Todas</h1>
     * <p>
     * Busca todos los datos que se encuentran almacenados en la base de
     * datos.</p>
     *
     * @param conexion
     * @return Todos los datos guardados.
     * @throws SQLException
     */
    public List<DatosAlgoritmos> recuperarTodas(Connection conexion) throws SQLException {
        if (conexion != null) {
            List<DatosAlgoritmos> datos = new ArrayList<>();
            try {
                PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " ORDER BY idAlgoritmo");
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    datos.add(new DatosAlgoritmos(resultado.getInt("idAlgoritmo"), resultado.getString("NombreAlgoritmo"), resultado.getString("TipoEstructura"),
                            resultado.getDate("Fecha"), resultado.getDouble("Duracion")));
                }
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
            return datos;
        }
        return null;
    }

    /**
     * <h1>Recuperar Mas Rapido</h1>
     * <p>
     * Busca todos los datos que se encuentran almacenados en la base de datos.
     * Y los ordena por duracion de menor a mayor.</p>
     *
     * @param conexion
     * @return Todos los datos de la base de datos.
     * @throws SQLException
     */
    public List<DatosAlgoritmos> recuperarMasRapido(Connection conexion) throws SQLException {
        if (conexion != null) {
            List<DatosAlgoritmos> datos = new ArrayList<>();
            try {
                PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " ORDER BY Duracion");
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    datos.add(new DatosAlgoritmos(resultado.getInt("idAlgoritmo"), resultado.getString("NombreAlgoritmo"), resultado.getString("TipoEstructura"),
                            resultado.getDate("Fecha"), resultado.getDouble("Duracion")));
                }
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
            return datos;
        }
        return null;
    }
}
