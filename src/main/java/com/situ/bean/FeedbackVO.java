package com.situ.bean;

public class FeedbackVO {
    private Integer id;
    private String gameName;
    private String cName;
    private String feedBack;

    public FeedbackVO() {
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", cName='" + cName + '\'' +
                ", feedBack='" + feedBack + '\'' +
                '}';
    }

    public FeedbackVO(Integer id, String gameName, String cName, String feedBack) {
        this.id = id;
        this.gameName = gameName;
        this.cName = cName;
        this.feedBack = feedBack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
