
import java.util.*; //Importar paquete que me permite usar Scanner
import java.io.*;

/**
 *
 * @author Fredy Velasquez 
 * @author Diego Castellanos
 * @version 1.0
 */
public class Calculo implements calculadora { //Se implementa la interface calculadora desarrollada por los estudiantes


//Apartado el cual lee el archivo con nombre 'datos.txt' el cual contiene las operaciones con formato POSTFIX
    File txt = null;
    FileReader fr = null; //Creacion de variables las cuales me ayduaran a leer el archivo
    BufferedReader b = null;
    private StackList<Integer> aList = new StackList<>(); //ArrayList auxiliar para almacenar los operadores de las operaciones guardadas en el archio .txt
    private Scanner entrada = new Scanner(System.in); //Scanner para poder registrar la ruta del archivo .txt con las operaciones en notacion inversa

    

    /*
     * Metodo que da la bienvenida al usuario
     * 
     * @params: 
     * 
     * @return: 
     */
    public void bienvenida() {
        System.out.println("-------------------------------");
        System.out.print(" -- Bienvenido a la calculadora --");
        System.out.println("-------------------------------");
    }

    /**
     * METODO con el que se inicia la ejecucion principal del programa. Se pude
     * al usuario que digite la ruta la cual contiene el archivo con las
     * operaciones en el formato indicado POSTFIX
     *
     *
     *
     */
    public void inicio() {
        System.out.println("Data path: "); //Solicita al usuario la ruta en la que se encuentra su archivo
        String ruta = entrada.nextLine(); //Campo para ingresar la ruta
        System.out.print("\n");

        try { //Intenta validar los valores que se le pasaron . IO
            txt = new File(ruta);
            fr = new FileReader(txt); //Lee la ruta ingresada por el usuario
            b = new BufferedReader(fr);
            String ejecutar;
            while ((ejecutar = b.readLine()) != null) { //Obtengo el resultado de todas las operaciones realizadas
                System.out.println("El resultado de su operacion en formato POSTFIX: " + resultadoOperaciones(ejecutar));
            }

        } catch (Exception e) { //Expecion en caso de no encontrar un archivo o toparse con formato diferente
            System.out.println("[!] ERROR. COMPRUEBE EL ARCHIVO QUE ESTA USANDO");
        }
    }

    
    /*
     * Metodo que realiza las 4 operaciones de la calculadora
     * 
     * @params: Cadena se texto que se encuentra en el archivo .txt(formato postfix) que contiene operandos y operadores
     * 
     * @return: Resultado de la operaciones realizadas segun el archivo .txt
     */
    public int resultadoOperaciones(String ejecutar) { //Uso 'ejecutar' que fue validado previamente
        String[] operaciones2 = ejecutar.split(" "); //Aplico un split dado el formato de las operaciones postfix, de esa forma leo la operacion

        for (int i = 0; i < operaciones2.length; i++) { //FOR para recorrer el linea por linea en caso de que hayan mas operaciones
            //Tiene como restriccion la longitud de la operacion
            if (comprobacion(operaciones2[i])) { //IF que verifica si lo que encuentra es OPERANDO u OPERADOR
                aList.push(Integer.parseInt(operaciones2[i])); //Utilizo lista auxiliar para realizar operaciones
            } else {

                //Variables que almacenaran los valores que se ordenara y posteriormente operaran segun el operador indicado
                int operando1 = 0;
                int operando2 = 0;

                try { //Try - Catch que se ejecuta en caso que no hayan suficientes elementos por operar
                    operando1 = aList.pop();
                    operando2 = aList.pop();
                } catch (Exception e) {
                    System.out.println("[!]");
                }

                //SWITCH que realiza las 4 operaciones, segun la entrada POSTFIX se ejecuta cada una de calculo aritmenticos. Indica al usuario lo que se esta realizando
                switch (operaciones2[i]) {
                    case "+": //CASO en el cual se encuentre con una SUMA
                        System.out.println("Sumando: " + operando1 + " con " + operando2);//Le muestro al usuario la operacion que se esta realizando
                        aList.push(suma(operando1, operando2)); //Uso la lista auxiliar y el metodo de interface el cual ya esta implementado y luego opero segun el metodo SUMA
                        break;
                    case "-": //CASO en el cual se encuentre con una RESTA
                        System.out.println("Restando: " + operando1 + " con " + operando2);//Le muestro al usuario la operacion que se esta realizando
                        aList.push(resta(operando1, operando2)); //Uso la lista auxiliar y el metodo de interface el cual ya esta implementado y luego opero segun el metodo RESTA
                        break;
                    case "*": //CASO en el cual se encuentre con una MULTIPLICACION
                        System.out.println("Multiplicando: " + operando1 + " con " + operando2);//Le muestro al usuario la operacion que se esta realizando
                        aList.push(multiplicacion(operando1, operando2)); //Uso la lista auxiliar y el metodo de interface el cual ya esta implementado y luego opero segun el metodo MULTIPLICACION
                        break;
                    case "/": //CASO en el cual se encuentre con una DIVISION
                        System.out.println("Dividiendo: " + operando1 + " con " + operando2);  //Le muestro al usuario la operacion que se esta realizando
                        aList.push(division(operando1, operando2)); //Uso la lista auxiliar y el metodo de interface el cual ya esta implementado y luego opero segun el metodo DIVISION
                        break;
                }

            }

        }

        return aList.peek(); //Uso PEEK para poder ver el elemento que se encuentra en la primera posicion

    }

    /*
     * METODO que verifica el tipo de elemento a utilizar
     * 
     * @params el caracter a revisar
     * 
     * @return Si es un numero devuelve True de lo contrario False
     */
    private Boolean comprobacion(String revisar) {
        Boolean validado; //BOOLEEAN que sera validado durante la ejecucion
        try {
            Integer.parseInt(revisar);
            validado = true;
        } catch (Exception e) { //Lanza la excepcion cuando no cumpla con lo anterior
            validado = false;
        }
        return validado; //Resultado de lo validado por el TRY - CATCH
    }
    
    /**
     * Opera una suma con los parametros 'x' y 'y'
     *
     * @params: 'x' y 'y' operandos
     * @return: Resultado de la suma.
     */
    @Override
    public int suma(int x, int y) {
        return x + y;
    }

    /**
     * Opera una resta con los parametros 'x' y 'y'
     *
     * @params: 'x' y 'y' operandos
     * @return: Resultado de la resta.
     */
    @Override
    public int resta(int x, int y) {
        return x - y;
    }

    /**
     * Opera una multiplicacion con los parametros 'x' y 'y'
     *
     * @params: 'x' y 'y' operandos
     * @return: Resultado de la suma.
     */
    @Override
    public int multiplicacion(int x, int y) {
        return x * y;
    }

    /**
     * Opera una division con los parametros 'x' y 'y'
     *
     * @params: 'x' y 'y' operandos
     * @return: Resultado de la division.
     */
    @Override
    public int division(int x, int y) {
        return x / y;
    }

    @Override
    public int operar(Stack x) {
        return 0;
    }

    @Override
    public String decode(String a) {
        return null;
    }

}
