import java.util.Set;

public class ThreadSet {
    public static void main(String args[]) throws Exception{
        Thread.currentThread().setName("ThreadSet");
        for ( int i=0; i< 100; i++){
            Thread t = new Thread(new MyThread());
            t.setName(""+i);
            t.start();
        }
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for ( Thread t : threadSet){
            if ( t.getThreadGroup() == Thread.currentThread().getThreadGroup()){
                System.out.println(""+t+":"+"status:"+t.getState());
            }
        }
    }
}

class MyThread implements Runnable{
    public void run(){
        try{
            Thread.sleep(5000);
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}