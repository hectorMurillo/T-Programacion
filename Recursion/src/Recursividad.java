import java.util.ArrayList;
import java.util.Scanner;

public class Recursividad {

    //1
    public static int sumarValoresArray(int arreglo[],int tamano) {
        int suma = 0;
        //Caso base
        if (tamano == 0) {
            return 0;
            //caso base
        }else if(tamano == 1){
            suma = arreglo[0];
        }else {
            //Progreso
            suma = (arreglo[tamano - 1]) + sumarValoresArray(arreglo, tamano - 1);
        }
        return suma;
    }

    //2
    public static int sumarValoresList(ArrayList<Integer> listaNumeros,int size){
        int suma = 0;
        if(size == 0){
            return 0;
        }else if(size == 1){
            return listaNumeros.get(0);
        }else{
            suma = (listaNumeros.get(size-1) + sumarValoresList(listaNumeros,size-1));
        }
        return  suma;
    }

    //3
    public static void leerVector(int pos, int[] vector){
        if (pos == vector.length-1)
        {
            System.out.println("Elemento en posición "+pos + " es "+vector[pos]);
        }
        else {
            System.out.println("Elemento en posición "+pos + " es "+vector[pos]);
            leerVector(pos+1,vector);
        }
    }

    //4 Factorial
    public static int factorial(int numero){
        int fact = 0;
        if(numero>0){
            fact = calculaFactorial(numero);
        }else{
            System.out.println("El valor debe ser positivo");
        }
        return  fact;
    }

    private static int calculaFactorial(int numero){
        if(numero == 0){
            return 1;
        }
        else
            return numero * calculaFactorial(numero-1);
    }

    //5 Fibonacci
    public static int fibonacci(int num){
        int resu = 0;
        Scanner leer = new Scanner(System.in);
        int resp = 0;
        if(num >= 0){
            do{
                System.out.println("1.Recursivo\n 2.Iterativo\n 3. Guardando valores previos");
                resp = leer.nextInt();
            }while(resp < 1 || resp >3);
            switch (resp){
                case 1: hazFibonacciR(num);
                    break;
                case 2: hazFibonacciI(num);
                    break;
                case 3: hazValoresPrevios(num);
                    break;
                default:
                    break;
            }
            resu = hazFibonacciR(num);
        }else{
            System.out.println("El valor debe ser positivo...");
        }
        return resu;
    }

    private static void hazValoresPrevios(int num) {

    }

    private static int hazFibonacciI(int num) {
        System.out.println("--- Método iterativo ---");

        int i = 0;
        int j = 1;

        for (int k = 1; k < num; k++)
        {
            int t;
            t = i + j;
            i = j;
            j = t;
        }

        return j;
    }

    private static int hazFibonacciR(int num){
        System.out.println("---- Metodo Recursivo ---");
        if(num == 0 || num==1)
            return num;
        else
            return hazFibonacciR(num-1) + hazFibonacciR(num-2);
    }

    //6 Busqueda binaria
    public static int busca(int aBuscar){
        int[]array ={1,4,7,8,9,14,23,47,56,60,61,63,65,66,68,69,70,73,76,77,79,80,82};
        int inferior = 0, superior = array.length-1;
        return buscaBinariaRecursiva(array,inferior,superior,aBuscar);
    }
    private static int buscaBinariaRecursiva(int[] array,int inferior, int superior,int dato) {
        int media = (superior + inferior) / 2;
        int centro = array[media];

        if (inferior > superior)
            return -1;
        else if(centro == dato)
            return media;
        else if (centro < dato)
            return buscaBinariaRecursiva(array, media+1, superior, dato);
        else
            return buscaBinariaRecursiva(array, inferior, media-1, dato);
    }

    //7 Convertir decimal a binario
    public static String binario(int num){
        int a;
        if(num>0){
            a= num%2;
            return (binario(num/2)+""+a);
        }
        return "";
    }

    //m=n+1:
    public static  int Ackerman(int m, int n){
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return Ackerman(m - 1, 1);
        } else {
            return Ackerman(m - 1, Ackerman(m, n - 1));
        }
    }


    public static int potencia( int base, int n) {
        if ( n == 0 ) {
            return 1;
        }
        return ( base * potencia(base,n-1));
    }


}
