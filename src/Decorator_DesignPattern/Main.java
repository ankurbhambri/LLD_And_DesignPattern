package Decorator_DesignPattern;

public class Main {
    public static void  main (String[] args) {
        BasicNotify basicNotify = new BasicNotify();

        WhatsAppDecorator whatsAppDecorator = new WhatsAppDecorator(basicNotify);
        System.out.println(whatsAppDecorator.send("WhatsApp notification"));

        FacebookDecorator facebookDecorator = new FacebookDecorator(basicNotify);
        System.out.println(facebookDecorator.send("Facebook notification"));

    }
}
