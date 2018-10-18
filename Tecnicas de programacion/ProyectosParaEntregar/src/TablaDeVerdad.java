import java.util.ArrayList;
import java.util.Stack;

public class TablaDeVerdad
{
    private boolean tablaDeVerdad[][];
    private ArrayList<Character> operandos = new ArrayList<>();
    private String posfija="";
    private Proposicion prop = new Proposicion();
    //Infija
    public void agregar(String proposicion)
    {
        this.operandos = this.obtenerOperandos(proposicion);
        this.tablaDeVerdad = this.crearTabla(proposicion);
        this.posfija = this.prop.infijoAPosFijo(proposicion);
        this.recorrerTabla();
    }

    private ArrayList<Character> obtenerOperandos(String proposicion) {
        for(int i = 0; i < proposicion.length(); i++)
        {
            if(Character.isLetter(proposicion.charAt(i)) && !operandos.contains(proposicion.charAt(i)))
                operandos.add(proposicion.charAt(i));
        }
        return  operandos;
    }
    public boolean[][]crearTabla(String proposicion)
    {
        int columnas = 0, renglones = 0, division = 0, contador = 0;
        boolean valor = true;
        boolean tablaDeVerdad[][];
        columnas = operandos.size();
        renglones = (int)Math.pow(2,columnas);
        tablaDeVerdad = new boolean[renglones][columnas+1];
        for(int i = 0; i < columnas; i++ ) {
            valor = true;
            contador = 0;
            division = (int)Math.pow(2,columnas - 1 - i);
            for (int j = 0; j < renglones; j++)
            {
                if(division == contador)
                {
                    valor = !valor;
                    contador = 0;
                }
                tablaDeVerdad[j][i] = valor;
                contador++;
            }
        }
        return tablaDeVerdad;
    }
    public void recorrerTabla(){
        Stack<Boolean> valores = new Stack<Boolean>();
        //recorrido de renglones
        for (int i=0;i<tablaDeVerdad.length;i++)
        {
            //recorriendo posfija
            for(int j = 0; j < posfija.length(); j++ )
            {
                //Letras
                if(Character.isLetter(posfija.charAt(j))){
                    //saca la posicion  de la letra dentro de operando
                    int posicion = operandos.indexOf(posfija.charAt(j));
                    valores.push(tablaDeVerdad[i][posicion]);

                }
                //Negacion
                else if(posfija.charAt(j) == '-')
                {
                    boolean valorNegado = valores.pop();
                    valores.push(!valorNegado);
                }
                //Operador
                else
                {
                    boolean a = false,b = false;
                    a = valores.pop();
                    b = valores.pop();
                    valores.push(evaluar(a,b,posfija.charAt(j)));
                }
            }
            tablaDeVerdad[i][tablaDeVerdad[i].length-1] = valores.pop();
        }
    }

    private boolean evaluar(boolean a, boolean b, char operador)
    {
        boolean valor = false;
        switch (operador){
            case '&':
                valor = a && b;
                break;
            case '|':
                valor = a || b;
                break;
            case '=':
                valor = a == b;
                break;
            case '>':
                valor = !b || a;
                break;
        }
        return valor;
    }

    public void imprimeTabla(){
        String encabezado = "";

        // Imprimimos la tabla de verdad
        for( int i = 0; i < operandos.size(); i++){
            encabezado += String.format("%10s %5s", operandos.get(i), "|" );
        }
        encabezado += String.format("%10s %5s", this.posfija, "|" );
        System.out.println( encabezado );

        for (int i = 0; i < encabezado.length(); i++ ){
            System.out.print("-");
        }
        System.out.println();

        for( int i = 0; i < this.tablaDeVerdad.length; i++ ){
            // Recorremos las columas
            for( int j = 0; j < this.tablaDeVerdad[i].length; j++ ){
                System.out.print( String.format("%10s %5s", tablaDeVerdad[i][j], "|" ) );
            }
            System.out.println();
        }
    }

    public void imprimirTipo(){
        int contador = 0;
        for(int i=0; i<tablaDeVerdad.length;i++){
            if(tablaDeVerdad[i][tablaDeVerdad[i].length-1]){
                contador++;
            }
        }
        if(contador == tablaDeVerdad.length){
            System.out.println("Tautologia");
        }else if(contador == 0){
            System.out.println("Contradicción");
        }else{
            System.out.println("Contingencia");
        }
    }
}
