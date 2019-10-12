package org.techtown.mymovie;


import android.media.Image;

public class CommentItem {

    int resId;
    String id;
    int time;
    float rating;
    String comment;
    int recommend;

    public CommentItem(int resId, String id, int time, float rating, String comment, int recommend) {
        this.resId = resId;
        this.id = id;
        this.time = time;
        this.rating = rating;
        this.comment = comment;
        this.recommend = recommend;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "resId=" + resId +
                ", id='" + id + '\'' +
                ", time=" + time +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
