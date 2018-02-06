package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class Stock {

    
    static Scanner entrada = new Scanner(System.in);
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
                    case "3":
                        break;
                }

            } while (!opcion.equals("s"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void anyadirProducto(){
       
        
    } 

}
