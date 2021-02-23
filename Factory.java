
/*
* @author Fredy Velasquez
* @author Diego Castellanos
*
*/

//Clase que me ayuda a implementar el patron FACTORY
public class Factory{
    public Stack getStackFactory(String str, int s){ //Parametros para obtener cada instancia segun lo deseado
        Stack fac = null;
        switch(str){ //Aca establezco el Switch que segun lo que reciba por el usuario me devolvera la implementacion que se necesite
            case "2":
                //fac = new Stack(); //Immplementa ArrayList
                break;
            case "3":
                fac = new StackVector(s);   //El desarrollo de estas clases fue hecho por el catedratico
                break; //Implementacion con VECTOR
            case "4": // Implementacion con SIMPLES
                fac = new StackList();
                break;
            case "5": //Implementacion con DOBLES
                fac = new StackDoubleLinkedList();
                break;
        
        }
        return fac; //Valor de retorno
    }

}