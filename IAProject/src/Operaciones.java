import javafx.application.Application;

public class Operaciones  implements  Runnable{
    private  boolean cronometroActivo = false;
    public Operaciones() {

    }
    public void empezarCronometro()
    {
       cronometroActivo = true;
       Thread hilo = new Thread(this);
       hilo.start();
    }

    @Override
    public void run() {
        Integer minutos = 0, segundos = 0, milisegundos = 0;
        String min="",seg="",mil="";
        try
        {
            while (cronometroActivo)
            {
                Thread.sleep(4);
                if( milisegundos == 1000 )
                {
                    milisegundos = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos vuelven a 0
                    if( segundos == 60 )
                    {
                        segundos = 0;
                        minutos++;
                    }
                }

                //Esto solamente es estetica para que siempre este en formato
                //00:00:000
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();

                if( milisegundos < 10 ) mil = "00" + milisegundos;
                else if( milisegundos < 100 ) mil = "0" + milisegundos;
                else mil = milisegundos.toString();

                System.out.println(min+":"+seg+":"+mil);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Hubo un error "+ ex.getMessage());
        }
    }
}
