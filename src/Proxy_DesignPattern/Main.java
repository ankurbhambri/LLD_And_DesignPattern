package Proxy_DesignPattern;

public class Main {
    public static void main(String[] args) {
        // User with admin privileges
        Image adminImage = new ProxyImage("admin_image.jpg", "ADMIN");
        adminImage.display();
        adminImage.delete();

        System.out.println("\n#######################################################\n");

        // User without admin privileges
        Image userImage = new ProxyImage("user_image.jpg", "USER");
        userImage.display(); // Loading + Displaying
        userImage.delete();  // Access Denied
    }
}
