import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        // Definimos la lista fuera del ciclo while
        List<Persona> peronsas = new ArrayList<>();
        // Empezamos con el menu
        var salir = false;
        while (!salir){
            mostarMenu();
            try {
                salir = ejecutarOperacion(consola, peronsas);
            } catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }

    }

    private static void mostarMenu(){
        System.out.print("""
                ***** Listado Peronas App *****
                1. Agregar
                2. Listar
                3. Salir
                """);

        System.out.print("Proporciona una opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada
        switch (opcion){
            case 1 -> {// Agrega persona a la Lista
                System.out.print("Ingresa el nombre de la persona: ");
                var nombre = consola.nextLine();
                System.out.print("Ingresa el telefono de la persona: ");
                var telefono = consola.nextLine();
                System.out.print("Ingresa el email de la persona: ");
                var email = consola.nextLine();
                // Crear el objeto de Persona
                var persona = new Persona(nombre, telefono, email);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }// Fin del caso 1
            case 2 -> { // Listar Personas
                if(personas.isEmpty()){
                    System.out.println("La lista de Personas se encuentra vacia, porfavor primero agregue una persona");
                }else {
                    System.out.println("Listado de Personas: ");
                    // Usando lambda y metodo de referencia
                    //personas.forEach((persona) -> System.out.println(peronsa));
                    personas.forEach(System.out::println);
                }
            }
            case 3 ->{ // Salimos del ciclo
                System.out.println("Hasta pronto ....");
                salir = true;
            }
            default -> {
                System.out.println("Opcion incorrecta: " + opcion + " porfavor seleciona una opcion correcta");
            }
        }//Fin del swicth
        return salir;
    }
}