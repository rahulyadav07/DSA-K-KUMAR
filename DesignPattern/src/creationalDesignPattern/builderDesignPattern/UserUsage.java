package creationalDesignPattern.builderDesignPattern;

public class UserUsage {
    public static void main(String[] args) {
        User  user = new User.Builder("Rahul")
                .setAge(24)
                .setEmail("rahulyadav@gmail.com")
                .setPhoneNumber("7017040404")
                .build();

        user.printAllField();
    }
}
