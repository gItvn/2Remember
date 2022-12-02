import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Act2_5 {
    public static void main(String[] args) throws InterruptedException{
        Semaphore s=new Semaphore(1,true);
        Random r=new Random();
        int posRelevo=0;
        Scanner sc=new Scanner(System.in);
        int nJugadores=5;


        // quito el permiso para controlar el inicio
        s.acquire(1);

        //carrera
        System.out.println("Bienvenidos a la carrera anual de programadores!!");
        Thread.sleep(1000);
        System.out.println("Este año contamos con más participantes de lo común");
        Thread.sleep(1500);
        System.out.println("Un gran aplauso para ellos!!");
        Thread.sleep(1500);
        System.out.println("CLAP");
        Thread.sleep(1000);
        System.out.println("No era eso a lo que me refería pero ya da igual, por que la carrera va a comenzar!!!");
        Thread.sleep(2000);

        System.out.println("Preparados?");
        Thread.sleep(1000);
        System.out.println("Listos?");
        Thread.sleep(1000);



        for(int i=0;i<nJugadores;i++){
            posRelevo=i;
            Thread corredor=new Thread(()->{
                try {
                    s.acquire(1);
                    System.out.println("\n " + Thread.currentThread().getName());
                    System.out.println("Pasooo que voy ardiendooo!!");

                    for (int j = 0; j < r.nextInt(3) + 1; j++) {
                        System.out.println("tuf tuf tuf");
                    }

                    // el release aquí para asegurar que sea cuando termina
                    System.out.println("Fin del tramo de: "+Thread.currentThread().getName());
                    s.release(1);

                    // con esta lambda no creo poder evitar lanzar el "He terminado" último hilo porque no puedo usar variables no finales.
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            corredor.setName("Corredor:"+(i+1));
            corredor.start();
        }

        System.out.println("-----Escribe BAAM para comenzar la carrera----- ");
           while(!(sc.next().equalsIgnoreCase("baam"))){}
           s.release(1);

        System.out.println("YAAA!!!!");
        Thread.sleep(1000);

        while(s.hasQueuedThreads()){}
        System.out.println("La carrera ha terminado");
    }
}
