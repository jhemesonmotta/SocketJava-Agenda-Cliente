package Classes;

import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyThread extends Thread {
    DateFormat dateFormat = null;
    Date date = null;
    String time;
    int delay;
    String name;
    
    public MyThread(String name,  int delay){
        this.delay = delay;
        this.name = name;
    }
    
    public void run() {
        for(int j=0;j<100;j++) {   
            for (int i=0; i<999999999; i++){
                try{
                    sleep(delay);
                }
                catch(InterruptedException e){
                    System.out.println("Thread: "+ name + "foi interrompida ");
                }
                System.out.println("Thread: "+ name+" >> "+this.getTime());
            }
        }
    }
    
    public String getTime(){
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
        time = dateFormat.format(date);
        return this.time;
    }
}