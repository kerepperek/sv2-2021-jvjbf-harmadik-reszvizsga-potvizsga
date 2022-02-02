package contentsite;

public class User implements Comparable<User>{

     private String userName;
     private int password;
     private boolean premiumMember;
     private boolean logIn;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = (userName+password).hashCode();
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public void upgradeForPremium() {
        this.premiumMember = true;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public boolean isLogIn() {
        return logIn;
    }

    @Override
    public int compareTo(User other) {
        return getUserName().compareTo(other.getUserName());
    }
}
