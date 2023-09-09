package com.situ.bean;

public class Feedback {
    private  Integer id ;
    private  Integer gid ;
    private  String  feedback;

    public Feedback() {
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", gid=" + gid +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    public Feedback(Integer id, Integer gid, String feedback) {
        this.id = id;
        this.gid = gid;
        this.feedback = feedback;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
