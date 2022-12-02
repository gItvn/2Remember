/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author pat0gen0
 */
public class ClockLabel extends JLabel implements Runnable, Serializable  {

// método útil para formatear horas, da más potencial a Bean
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    
    private String StringCurTime;
    private boolean Format12_24 = true; // control del estado del formato

    public ClockLabel() {
        new Thread(this).start();

    }

    private void setHour() {
        while (true) {
            StringCurTime = sdf.format(Calendar.getInstance().getTime());
            this.setText(StringCurTime); // añadir tras extender JLabel
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void format12_24() {
        if (Format12_24) {
            sdf = new SimpleDateFormat("HH:mm:ss");
            Format12_24 = false;
        } else {
            sdf = new SimpleDateFormat("hh:mm:ss a");
            Format12_24 = true;
        }
    }

    public void run() {
        setHour();
    }

}
