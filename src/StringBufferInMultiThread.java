public class StringBufferInMultiThread {
    public static void th(){
        StringBuffer stringBuffer = new StringBuffer();

        Thread thread1 = new Thread(() -> {
            stringBuffer.append("\n");
            for(int i = 0; i < 10000; i++){
                stringBuffer.append("a");
            }
        });
        Thread thread2 = new Thread(() -> {
            stringBuffer.append("\n");
            for(int i = 0; i < 10000; i++){
                stringBuffer.append("b");
            }
        });

        thread1.start();
        thread2.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(stringBuffer);
        System.out.println(stringBuffer.length());
    }

    public static void main(String[] args) {
        th();
    }
}
