
import java.util.*;

public class Main {

    static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static String registerUser(
            List<User> users,
            String name,
            String email) {

        if (users == null){
            return "잘못된 사용자 목록";
        }
        if ((name == null) || name.isBlank()){
            return "이름 필수";
        }
        if ((email == null || email.isBlank())){
            return "이메일 필수";
        }

        for (int i=0; i<users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                return "이메일 중복";
            }
        }

        User user = new User(name, email);
        users.add(user);
        return "등록 성공";

    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        System.out.println(
                registerUser(users, "Kim", "kim@test.com")
        );

        System.out.println(
                registerUser(users, "Lee", "kim@test.com")
        );

        System.out.println(
                registerUser(users, "", "lee@test.com")
        );

        System.out.println(users.size());
    }
}
