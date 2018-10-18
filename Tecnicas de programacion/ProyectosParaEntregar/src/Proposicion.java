import javax.swing.text.html.parser.Parser;
import java.util.Stack;

public class Proposicion {
    public String infijoAPosFijo(String proposicion) {
        Stack<Character> Operadores = new Stack<>();
        String resultado = "";
        for (int i = 0; i < proposicion.length(); i++) {
            char caracter = proposicion.charAt(i);
            if (!Character.isLetter(caracter)) {
                if (caracter == ')')
                {
                    while (!Operadores.isEmpty())
                    {
                        if (Operadores.peek() != '(')
                        {
                            resultado += Operadores.pop();
                        }
                        else
                        {
                            Operadores.pop();
                            break;
                        }
                    }
                    if(!Operadores.isEmpty() && Operadores.peek() == '-')
                    {
                        resultado += Operadores.pop();
                    }
                }
                else if (caracter == '-')
                {
                    char parteNegada = proposicion.charAt(i + 1);
                    if (Character.isLetter(parteNegada)) {
                        resultado +=  parteNegada +""+ caracter;
                        i++;
                    } else {
                        Operadores.push(caracter);
                    }
                } else {
                    Operadores.push(caracter);
                }
            }
            else
            {
                resultado += caracter;
            }
            if(i == proposicion.length()-1 && !Operadores.isEmpty())
            {
                resultado += Operadores.pop();
            }
        }
        return resultado;
    }
}