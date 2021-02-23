


import java.util.Scanner;

/*
*
* @author Fredy Velasquez
* @author Diego Castellanos
 */
public class Main {

    public static void main(String[] args) {

        //Declaracion de variables que me ayudan a controlar el menu
        int opcion = 0;
        int op = 0;
        Scanner scan = new Scanner(System.in); //Uso de Scanner para leer la entrada de texto ingresada por el usuario
        //Factory f = new Factory();
        Calculo calculo = new Calculo();
        
        
        while (opcion != 6) { //While que controla el Menu 

            //Menu con las posibles opciones a elegir por el usuario
            System.out.println("\n\n-----------.M.E.N.U.-----------");
            System.out.println("Seleeciona una implementacion con la que desee trabajar: ");
            System.out.println("1. Convertir de INFIX a POSTFIX");//SI JALA
            System.out.println("2. ArrayList");//SI JALA
            System.out.println("3. Vector");//SI JALA
            System.out.println("4. Lista SIMPLE");//SI JALA
            System.out.println("5. Lista DOBLE");//NO SE SI JALA
            System.out.println("6. Salir\n\n");//NO SE SI JALA

            opcion = op;
            int respuesta;

            //Try-Catch para validar el correcto uso del menu y sus condicionales
            try {

                respuesta = Integer.parseInt(scan.next());
                //Implementacion de las posibles opciones utilizadas por el usuario
                if (respuesta > 0 && respuesta < 7) {
                    op = respuesta; //Devuelve la selección del usuario

                    if (op == 1) {//Leer expresion
                        System.out.println("Traslado expresion INFIX a POSTFIX");
                        calculo.inicio();
                    
                    } else if (op == 2) {//Implementacaion con ArrayList - Si jala
                        System.out.println("sTrabajando con la implementacion LISTA SIMPLE...");

                    

                    } else if (op == 3) {//Implementacion VECTOR - Si jala
                        System.out.println("Trabajando con la implementacion VECTOR..");

                        
                    } else if (op == 4) {//Implementacaion con LISTA SIMPPLE - Si jala
                        System.out.println("Trabajando con la implementacion LISTA SIMPLE...");

                    } else if (op == 5) {//Implementacion con LISTA DOBLE - Si jala

                        System.out.println("Trabajando con la implementacion LISTA DOBLE..");

                    } else if (op == 6) { //Salida

                        System.out.println("Adios UwU");
                        opcion = 6;

                    }
                } else {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {
                System.out.println("\nERROR: La opción ingresada no es válida, ingrese un número en el rango de opciones");
            }

        }
    }
}
