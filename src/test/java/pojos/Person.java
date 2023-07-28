package pojos;

public record Person( String firstName,String lastName,String email) {

    public Person(String firstName, String lastName) {
        this(firstName, lastName, firstName.addGmail());
    }

    public String getFullName(){
        return firstName+lastName;
    }
}
