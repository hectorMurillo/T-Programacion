package Modelos;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;
public class Fuzzy {
    private Variable nivelActual;
    public Fuzzy() {

    }

    public double getVariableOutPut(int errores, int ayudas, int tiempo, int nivel){
        FIS fis = FIS.load("fuzzyControl.fcl");
        if(fis == null){
            System.err.println("Error al leer archivo");
        }else{
            fis.setVariable("errores",errores);
            fis.setVariable("tiempo",tiempo);
            fis.setVariable("ayudas",ayudas);
            fis.setVariable("nivel",nivel);

            fis.evaluate();

            nivelActual = fis.getVariable("nivel");
        }
        return  nivelActual.getValue();
    }

}
