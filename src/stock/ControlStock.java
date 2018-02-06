package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


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
public class ControlStock {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion = "";
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/controlStock";
            String usuario = "postgres";
            String password = "1234";

            Connection con = DriverManager.getConnection(url, usuario, password);

            do {
                System.out.println("1.Añadir producto");
                System.out.println("2.Buscar por nombre");
                System.out.println("S.Salir");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "1":
                        anadirProducto(con);
                        break;
                    case "2":
                        break;
                    case "3":
                        break;

                }

            } while (!opcion.equals("s"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlStock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void anadirProducto(Connection con) {
        System.out.println("Referencia: ");
        String referencia = entrada.nextLine();
        System.out.println("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Precio de compra: ");
        double precioCompra = Double.parseDouble(entrada.nextLine());
        System.out.println("Precio de venta: ");
        double precioVenta = Double.parseDouble(entrada.nextLine());
        System.out.println("Stock: ");
        int stock = Integer.parseInt(entrada.nextLine());
        try {
            Statement statement = con.createStatement();
            String producto = "INSERT INTO stock (referencia, nombre, "
                    + "precioCompra, precioVenta, stock) "
                    + " VALUES ('" + referencia
                    + "','" + nombre
                    + "'," + precioCompra
                    + "," + precioVenta
                    + "," + stock
                    + ");";
            statement.executeUpdate(producto);
            System.out.println("Producto guardado.");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: No se ha podido guardar el producto.");
        }
    }
}
