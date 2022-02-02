package contentsite;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContentService {

    private Set<User> users = new TreeSet<>();
    private Set<Content> contents = new TreeSet<>();

    public Set<User> getAllUsers() {
        return users;
    }

    public Set<Content> getAllContent() {
        return contents;
    }

    public void registerUser(String name, String password) {
        User user=new User(name, password);
        if(users.contains(user)){
            throw new IllegalArgumentException("Username is already taken: "+name);
        }
        users.add(new User(name, password));
    }

    public void addContent(Content content) {

        if(content.contains(content)){
            throw new IllegalArgumentException("Content name is already taken: "+content.getTitle());
        }
        users.add(new Content(content));
    }

    public void logIn(String username, String password) {

    }

    public void clickOnContent(User user, Content content) {

    }
}
