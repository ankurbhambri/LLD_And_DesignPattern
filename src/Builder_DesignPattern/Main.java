package Builder_DesignPattern;

public class Main {
    public static void main(String[] args) {
        Student student = Student.Builder.newInstance()
                .setId(1)
                .setName("Ram")
                .setAddress("Noida")
                .build();
        System.out.println(student);
    }
}
