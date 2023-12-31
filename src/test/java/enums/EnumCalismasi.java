package enums;

public enum EnumCalismasi {
    USER1("user1@gmail.com", "user1Passsword"),
    USER2("user2@gmail.com", "user2Passsword"),
    USER3("user3@gmail.com", "user3Passsword"),
    USER4("user4@gmail.com", "user4Passsword"),
    DEMOKESIF("demokesif1@gmail.com", "123456789"),
    ;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    EnumCalismasi(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void login() {
        System.out.println("email : " + this.email + " password : " + this.password);
        System.out.println("user logged in with credentials");
    }

    public String getToken() {
        return "token__" + this.email + this.password;
    }

}
