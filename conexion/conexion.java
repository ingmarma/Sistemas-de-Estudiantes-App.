package marma.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        var baseDatos = "estudiantes_bd";
        var url = "jdbc:mysql://localhost:3306/" +baseDatos;
        var usuario = "root";
        var password = "Liamypapi1";
        //Cargamos la clase del driver del mysql en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Ocurrio un error en la conexion: " +e.getMessage());
        }

        return conexion;
    }

        public static void main(String[] args) {
        var conexion = marma.conexion.conexion.getConexion();
        if (conexion != null)
            System.out.println("Conexion exitosa: " + conexion);
        else
            System.out.println("Error al conectarse");


        }
}
