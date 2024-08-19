package Proxy_DesignPattern;

public class ProxyImage implements Image {
    private RealImage realImage;
    private final String fileName;
    private final String userRole;

    public ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy initialization
        }
        realImage.display();
    }

    @Override
    public void delete() {
        if (userRole.equals("ADMIN")) {
            if (realImage == null) {
                realImage = new RealImage(fileName); // Lazy initialization
            }
            realImage.delete();
        } else {
            System.out.println("Access Denied: Only admin can delete the image.");
        }
    }
}
