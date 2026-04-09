package ca.bytetube.ood._21_adplatform;

import java.util.Objects;

public class Ad {
    private long id;
    private String content;
    private int score;
    private long sequence;


    public Ad(long id, String content, int score, long sequence) {
        this.id = id;
        this.content = content;
        this.score = score;
        this.sequence = sequence;
    }

    public static Ad of(long id, String content, int score, long sequence) {
        Objects.requireNonNull(content, "content must not be null");
        return new Ad(id, content, score, sequence);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", score=" + score +
                '}';
    }
}
