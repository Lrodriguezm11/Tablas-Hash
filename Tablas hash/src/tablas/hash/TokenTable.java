import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TokenTable {
    
    public static void main(String[] args) {
        // Declarar el código fuente
        String codigo = "int suma = 0;\nsuma = 54 + 20;";
        
        // Crear la tabla hash
        Map<String, String> tablaHash = generarTablaHash(codigo);
        
        // Imprimir la tabla hash
        System.out.println("Tabla Hash:");
        System.out.println("Clave\tToken");
        for (String clave : tablaHash.keySet()) {
            String token = tablaHash.get(clave);
            System.out.println(clave + "\t" + token);
        }
        
        // Solicitar al usuario las claves de la tabla hash
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese las claves de la tabla hash (separadas por coma):");
        String clavesBusqueda = scanner.nextLine();
        scanner.close();
        
        // Buscar los tokens correspondientes a las claves ingresadas
        String[] claves = clavesBusqueda.split(",");
        System.out.println("\nTokens encontrados:");
        System.out.println("Clave\tToken");
        for (String clave : claves) {
            clave = clave.trim();
            String token = tablaHash.get(clave);
            if (token != null) {
                System.out.println(clave + "\t" + token);
            }
        }
    }
    
    public static Map<String, String> generarTablaHash(String codigo) {
        Map<String, String> tablaHash = new HashMap<>();
        
        // Dividir el código en líneas
        String[] lineas = codigo.split("\n");
        
        // Rastrear las coordenadas
        int fila = 0;
        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i].trim();
            if (!linea.isEmpty()) {
                // Dividir la línea en tokens
                String[] tokens = linea.split("\\s+");
                
                int columna = 0;
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        // Asignar la clave hash (fila, columna) al token
                        String clave = String.format("%d%d", fila, columna);
                        tablaHash.put(clave, token);
                    }
                    columna += token.length() + 1;
                }
            }
            fila++;
        }
        
        return tablaHash;
    }
}




