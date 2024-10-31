package Ejecutables;  // Declaración del paquete donde se encuentra la clase

import java.sql.Connection;          // Importa la clase para manejar la conexión a la base de datos
import java.sql.DriverManager;       // Importa la clase para gestionar los controladores de conexión a la base de datos
import java.sql.SQLException;        // Importa la clase para manejar excepciones de SQL
import java.util.logging.Level;      // Importa los niveles de log para registros de mensajes (info, error, etc.)
import java.util.logging.Logger;     // Importa la clase Logger para imprimir mensajes de log en caso de error

public class Conexion {              // Declaración de la clase `Conexion`
    String bd = "inv";               // Nombre de la base de datos por defecto
    String url = "jdbc:mysql://localhost:3306/"; // URL base de conexión a MySQL
    String user = "root";            // Usuario de acceso a la base de datos
    String password = "";            // Contraseña de acceso a la base de datos
    String driver = "com.mysql.cj.jdbc.Driver"; // Driver JDBC para conectar a MySQL
    Connection cx;                   // Variable de tipo `Connection` para gestionar la conexión activa
    
    // Constructor que permite especificar el nombre de la base de datos
    public Conexion(String bd) {
        this.bd = bd;                // Asigna el nombre de la base de datos a la variable `bd`
    }
    
    // Método para establecer la conexión a la base de datos
    public Connection conectar() throws SQLException {
        try {
            Class.forName(driver);   // Carga el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password); // Establece la conexión con los parámetros dados
            System.out.println("Se conectó a bd " + bd); // Mensaje indicando que la conexión fue exitosa
        } catch (ClassNotFoundException ex) {  // Captura la excepción si el driver no se encuentra
            System.out.println("No se pudo conectar a " + bd); // Mensaje de error en caso de falla en la conexión
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex); // Registro detallado de la excepción
        }
        return cx;                   // Devuelve el objeto `Connection` si se logró la conexión
    }
    
    // Método para cerrar la conexión a la base de datos
    public void desconectar() {
        try {
            cx.close();              // Intenta cerrar la conexión activa
        } catch (SQLException ex) {  // Captura la excepción si ocurre un error al cerrar
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex); // Registro detallado del error en el cierre
        }
    }
    
    // Método principal para probar la conexión
    public static void main(String[] args) throws SQLException {
        Conexion conexion = new Conexion("inv");  // Crea una instancia de `Conexion` con la base de datos `inv`
        conexion.conectar();                      // Llama al método `conectar` para iniciar la conexión
    }
}
