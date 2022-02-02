package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Video implements Content,Comparable<Video> {

    private String title;
    private int length;
    private List<User> usersClicked = new ArrayList<>();

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public void click(User user) {
        usersClicked.add(user);
    }

    @Override
    public boolean isPremiumContent() {
        return length>15;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(usersClicked);
    }

@Override
public int compareTo(Video other) {
        return getTitle().compareTo(other.getTitle());
        }
}
