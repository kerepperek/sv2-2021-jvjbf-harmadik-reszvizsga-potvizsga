package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Podcast implements Content,Comparable<Podcast>{

    private String title;
    private List<String> speakers = new ArrayList<>();
    private List<User> usersClicked = new ArrayList<>();

    public Podcast(String title, List<String> speakers) {
        this.title = title;
        this.speakers.addAll(speakers);
    }
    @Override
    public void click(User user) {
        usersClicked.add(user);
    }

    public List<String> getSpeakers() {
        return speakers;
    }

    @Override
    public boolean isPremiumContent() {
        return false;
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
    public int compareTo(Podcast other) {
        return getTitle().compareTo(other.getTitle());
    }
}
