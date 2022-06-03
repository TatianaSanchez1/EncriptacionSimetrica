import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Security seguridad = new Security();

        seguridad.addKey("Colombia");
        System.out.println("Este es un ejemplo de RNF para la clase de Arquitectura de Software\n");
        System.out.println("--------- Encriptado ----------");
        String texto = seguridad.encriptar("Este es un ejemplo de RNF para la clase de Arquitectura de Software");
        System.out.println(texto);
        System.out.println();
        System.out.println("--------- Desencriptado ----------");
        System.out.println(seguridad.desencriptar(texto));
    }
}
