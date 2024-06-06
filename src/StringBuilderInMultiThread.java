public class StringBuilderInMultiThread {
    public static void th() {
        StringBuilder stringBuilder = new StringBuilder();

        Thread thread1 = new Thread(() -> {
            stringBuilder.append("\n");
            for (int i = 0; i < 10000; i++) {
                stringBuilder.append("a");
            }
        });
        Thread thread2 = new Thread(() -> {
            stringBuilder.append("\n");
            for (int i = 0; i < 10000; i++) {
                stringBuilder.append("b");
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
    }

    public static void main(String[] args) {
        th();
    }
}
