package Ejecutables;

import java.sql.Connection;          // Para la conexión
import java.sql.DriverManager;       // Para manejar el driver de Java a MySQL
import java.sql.PreparedStatement;   // Para crear sentencias SQL
import java.sql.ResultSet;           // Para obtener resultados de consultas
import java.sql.SQLException;        // Para manejar excepciones
import java.util.Scanner;            // Para leer la entrada del usuario
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcional {
    String bd = "inv"; // Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/"; // URL de conexión
    String user = "root"; // Usuario de MySQL
    String password = ""; // Contraseña de MySQL
    String driver = "com.mysql.cj.jdbc.Driver"; // Driver de MySQL
    Connection cx; // Objeto de conexión

    public Funcional(String bd) {
        this.bd = bd; // Inicializa la base de datos
    }

    // Método para conectar a la base de datos
    public Connection conectar() throws SQLException {
        try {
            Class.forName(driver); // Carga el driver
            cx = DriverManager.getConnection(url + bd, user, password); // Conexión
            System.out.println("Se conectó a la base de datos " + bd);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo conectar a " + bd);
            Logger.getLogger(Funcional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx; // Retorna la conexión
    }

    // Método para desconectar de la base de datos
    public void desconectar() {
        try {
            if (cx != null && !cx.isClosed()) { // Verifica si la conexión está abierta
                cx.close(); // Cierra la conexión
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para extraer un producto por nombre
    public void extraerProductoPorNombre(String nombreProducto) {
        String query = "SELECT * FROM productos WHERE nombre = ?"; // Consulta SQL para buscar el producto por nombre
        
        try (PreparedStatement preparedStatement = cx.prepareStatement(query)) {
            preparedStatement.setString(1, nombreProducto); // Establece el parámetro de búsqueda
            ResultSet resultSet = preparedStatement.executeQuery(); // Ejecuta la consulta
            
            if (resultSet.next()) { // Si hay un resultado
                int id = resultSet.getInt("id"); // Obtiene el ID del producto
                System.out.println("Producto encontrado: ID = " + id + ", Nombre = " + nombreProducto);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Funcional conexion = new Funcional("inv"); // Crea una instancia de conexión
        Scanner scanner = new Scanner(System.in); // Crea un Scanner para leer la entrada del usuario
        
        try {
            Connection conn = conexion.conectar(); // Conecta a la base de datos
            
            // Pide al usuario que ingrese el nombre del producto a buscar
            System.out.print("Ingrese el nombre del producto a buscar: ");
            String nombreProducto = scanner.nextLine(); // Lee el nombre del producto
            
            conexion.extraerProductoPorNombre(nombreProducto); // Llama al método para extraer el producto
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        } finally {
            conexion.desconectar(); // Desconecta al finalizar
            scanner.close(); // Cierra el Scanner
        }
    }
}
