import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        int [] numeros = {100,200,500};
        //1.- Sumar numeros en un arreglo
        System.out.println(Recursividad.sumarValoresArray(numeros,numeros.length));
        ArrayList<Integer> numerosArray = new ArrayList<>();
        numerosArray.add(120);
        numerosArray.add(20);
        //2.-Sumar elementos de una lista
        System.out.println("Suma lista "+Recursividad.sumarValoresList(numerosArray,numerosArray.size()));
        //3.-Impresion de datos de un arreglo
        Recursividad.leerVector(0,numeros);
        //4.-Factorial
        System.out.println("Factorial "+Recursividad.factorial(5));

        //5.- Fibonacci
        System.out.println("Fibonacci "+Recursividad.fibonacci(7));
        System.out.println("Fibonacci "+Recursividad.fibonacci(7));
        //6.-Busqueda Binaria
        System.out.println(Recursividad.busca(61));
        //7.-Convertir de decimal a binario
        System.out.println(Recursividad.binario(740));
        //8.- Elevar a una potencia un numero
        System.out.println("Potencia de "+6+" a la "+2+"="+Recursividad.potencia(6,2));
        //9.-Funcion de Ackerman
        System.out.println("Ackerman "+Recursividad.Ackerman(1,2));
        //10
    }
}
