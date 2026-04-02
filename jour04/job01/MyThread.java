package jour04.job01;

public class MyThread extends Thread{

    String text;

    public MyThread(String text) {
        this.text = text;
    }
    
    @Override
    public void run() {
        System.out.println(this.text);
    }
}
