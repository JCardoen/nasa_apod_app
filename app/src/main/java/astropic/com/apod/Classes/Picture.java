package astropic.com.apod.Classes;

import java.net.URL;

/**
 * Created by Joachim on 02/11/2017.
 */

public class Picture {
    public String title;
    public String author;
    public String date;
    public String explanation;
    public String url;

    public Picture(String title, String author, String date, String explanation, String url) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.explanation = explanation;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
