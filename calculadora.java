
/**
 *
 * @author Fredy Velasquez 
 * @author Diego Castellanos
 */
public interface calculadora<E> { //Interface creada por los estudiantes para el desarrollo de la tarea
    public int suma(int x, int y);
    public int resta(int x, int y);
    public int multiplicacion(int x, int y);
    public int division(int x, int y);
    public int operar(Stack x);//operar recibe un stack en formato postfix, y lo opera para devolver un entero que es igual al valor total de la operación
    public String decode(String a);//función que se encarga de leer el archivo y decodificar cada línea para realizar las operaciones de cada una
}