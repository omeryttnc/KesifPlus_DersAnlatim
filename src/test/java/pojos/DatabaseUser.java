package pojos;

import java.util.List;

public class DatabaseUser {
    private int userId;
    private String email;
    private String firstName;
    private int age;

    private List<DatabaseUser> userList;

    public DatabaseUser(int userId, String email, String firstName, int age) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

//    public List<DatabaseUser> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(DatabaseUser databaseUser) {
//       userList.add(databaseUser);
//    }
}
