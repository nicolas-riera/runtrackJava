package jour04.job01;

public class ThreadProject {
    public static void main(String[] args) {
        MyThread myrthread = new MyThread("Mon thread est en cours");

        myrthread.start();
    }

}
