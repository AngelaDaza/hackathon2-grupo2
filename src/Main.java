import javax.swing.*;
import java.util.*;

public class Main {
    // Se define el mapa donde se guardaran los contactos
    private static Map<String, String> agenda = new HashMap<>();
    // Se definen las variables
    private static int cantidad = 10;
    private static boolean bandera = true;

    public static void main(String[] args) {
        // Se establece el ciclo que mostrara las opciones de menu
        while (bandera) {
            // Se muestra el menu al usuario para que ingrese la opcion
            int menu = Integer.parseInt(JOptionPane.showInputDialog("Menú: \n 1. Añadir contacto\n 2. Existe contacto\n 3. Listar contactos\n 4. Buscar contacto\n 5. Eliminar contacto\n 6. Agenda llena\n 7. Espacios libres\n 8. Salir"));
            // Se establece el condicional segun la opcion anterior
            switch (menu) {
                // Se llaman los metodos segun cada caso
                case 1:
                    añadirContacto();
                    break;
                case 2:
                    existeContacto();
                    break;
                case 3:
                    listarContactos();
                    break;
                case 4:
                    buscarContacto();
                    break;
                case 5:
                    eliminarContacto();
                    break;
                case 6:
                    agendaLlena();
                    break;
                case 7:
                    espaciosLibres();
                    break;
                case 8:
                    // Se asigna el valor de false a la variable bandera para que rompa el ciclo
                    bandera = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción valida");
            }
        }
    }
// Se definen los metodos
    private static void añadirContacto() {
        if (agenda.size() <= cantidad - 1) {
            String nombreContacto = JOptionPane.showInputDialog("Ingrese el nombre del contacto: ");
            String numeroTelefono = JOptionPane.showInputDialog("Ingrese el numero de telefono: ");
            // Agregar datos al mapa
            agenda.put(nombreContacto, numeroTelefono);
            JOptionPane.showMessageDialog(null, "Contacto añadido correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay más espacio en la agenda");
        }
    }

    private static void existeContacto() {
        String existeContacto = JOptionPane.showInputDialog("Ingrese el nombre del contacto que desea buscar: ");
        if (agenda.containsKey(existeContacto)) {
            JOptionPane.showMessageDialog(null, "El contacto SI existe en la agenda");
        } else {
            JOptionPane.showMessageDialog(null, "El contacto NO existe en la agenda");
        }
    }

    private static void listarContactos() {
        String listaContactos = "Lista de contactos: \n";
        for (Map.Entry<String, String> entry : agenda.entrySet()) {
            listaContactos += entry.getKey() + " - " + entry.getValue() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaContactos);
    }

    private static void buscarContacto() {
        String buscarContacto = JOptionPane.showInputDialog("Ingrese el nombre del contacto que desea buscar: ");
        if (agenda.containsKey(buscarContacto)) {
            JOptionPane.showMessageDialog(null, "El contacto '" + buscarContacto + "' existe en la agenda." + "\nNúmero de teléfono: " + agenda.get(buscarContacto));
        } else {
            JOptionPane.showMessageDialog(null, "El contacto no existe en la agenda");
        }
    }

    private static void eliminarContacto() {
        String eliminarContacto = JOptionPane.showInputDialog("Ingrese el nombre del contacto que desea eliminar: ");
        if (agenda.containsKey(eliminarContacto)) {
            agenda.remove(eliminarContacto);
            JOptionPane.showMessageDialog(null, "El contacto fue eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "El contacto no existe en la agenda");
        }
    }

    private static void agendaLlena() {
        if (agenda.size() <= cantidad) {
            JOptionPane.showMessageDialog(null, "Hay espacio en la agenda");
        } else {
            JOptionPane.showMessageDialog(null, "No hay más espacio en la agenda");
        }
    }

    private static void espaciosLibres() {
        JOptionPane.showMessageDialog(null, "Hay " + (cantidad - agenda.size()) + " espacios en agenda");
    }
}