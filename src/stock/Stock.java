package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD

/*
   nombre de la BBDD: controlStock

    CREATE TABLE stock(
            referencia VARCHAR(20) PRIMARY KEY,
        nombre VARCHAR(45),
        precioCompra NUMERIC(10,2),
        precioVenta NUMERIC(10,2),
            stock NUMERIC(10)
    );

 */
public class Stock {

    
    static Scanner entrada = new Scanner(System.in);
=======
public class Stock {

>>>>>>> a7eb3798d3f84c77f3eec3a44b3cea4e426f52a7
    public static void main(String[] args) {
        try {
            String opcion = "";

            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/controlStock";
            String usuario = "postgres";
            String password = "admin";

            Connection con = DriverManager.getConnection(url, usuario, password);

            do {
                System.out.println("1.Añadir producto");
                System.out.println("2.Buscar por nombre");
                System.out.println("S.Salir");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "1":
                        break;
                    case "2":
                        break;
<<<<<<< HEAD
                    case "3":
                        break;
=======
                        
>>>>>>> a7eb3798d3f84c77f3eec3a44b3cea4e426f52a7
                }

            } while (!opcion.equals("s"));
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
    }

    public static void anadirProducto(Connection con, String cod,
            String autor, String titulo) {
        try {
            Statement statement = con.createStatement();
            String anhadirLibro = "INSERT INTO stock (cod, autor, titulo) "
                    + " VALUES ('" + cod
                    + "','" + autor
                    + "','" + titulo
                    + "');";
            statement.executeUpdate(anhadirLibro);
            System.out.println("Producto guardado.");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: No se ha podido guardar el progucto.");
        }
    }
<<<<<<< HEAD
    
    private static void anyadirProducto(){
       
        
    } 
=======
>>>>>>> a7eb3798d3f84c77f3eec3a44b3cea4e426f52a7

}
