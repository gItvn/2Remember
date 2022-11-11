import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RecursoCompartido rc = new RecursoCompartido();
        HiloEjecutar aux;

        // Thread(ThreadGroup,name) -->
        ThreadGroup tg = new ThreadGroup("GrupoHilos");
        String tmp;

        for (int i = 0; i < 100; i++) {
            if (!(i % 2 == 0)) {
                tmp = "" + i;
                aux = new HiloEjecutar(tg, tmp, rc);
                aux.setPriority(MAX_PRIORITY);
                aux.start();


            } else {
                tmp = "" + i;
                aux = new HiloEjecutar(tg, tmp, rc);
                aux.setPriority(MIN_PRIORITY);
                aux.start();

            }
        }
        while (!(tg.activeCount() == 0)) {
            Thread.sleep(100);
        }
        System.out.println("Número total de operaciones --> "+rc.getRecurso());
    }







    }

    class HiloEjecutar extends Thread{
    RecursoCompartido rc;
    public HiloEjecutar(ThreadGroup group, String rsc, RecursoCompartido recursoCompartido){
        super(group,rsc);
        rc=recursoCompartido;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            int a=23*34;
            rc.sumRecurso();
        }

        System.out.println("FINALIZA: Hilo:"+this.getName()+" Prioridad:"+this.getPriority());
    }
}
class RecursoCompartido {
    private int recurso;

    RecursoCompartido() {
        recurso = 0;
    }

    public int getRecurso() {
        return recurso;
    }

    public synchronized void sumRecurso() {
        recurso++;
    }
}


