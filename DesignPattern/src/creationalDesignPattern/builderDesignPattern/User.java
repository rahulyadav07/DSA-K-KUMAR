package creationalDesignPattern.builderDesignPattern;

public class User {

    private final String name;
    private final String email;
    private final int age;
    private final String phoneNumber;

    private User(Builder builder) {
        this.age = builder.age;
        this.email = builder.email;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
    }
    public void printAllField() {
        System.out.println(name);
        System.out.println(email);
        System.out.println(phoneNumber);
        System.out.println(age);
    }
    public  static class  Builder {
        private  String name;
        private  String email;
        private  int age;
        private  String phoneNumber;

        public Builder(String name) {
            this.name =name;
        }
       public Builder setEmail(String email) {
           this.email = email;
           return this;
       }
       public Builder setAge(int age){
           this.age = age;
           return this;
       }
       public Builder setPhoneNumber(String phoneNumber) {
           this.phoneNumber = phoneNumber;
           return this;
       }
       public User build() {
           return new User(this);
       }


    }

}

