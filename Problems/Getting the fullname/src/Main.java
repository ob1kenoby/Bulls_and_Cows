class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if (this.firstName.length() > 0 && this.lastName.length() > 0) {
            return this.firstName + " " + this.lastName;
        } else if (this.firstName.length() > 0) {
            return this.firstName;
        } else if (this.lastName.length() > 0) {
            return this.lastName;
        } else {
            return "Unknown"; // write your code here
        }
    }
}