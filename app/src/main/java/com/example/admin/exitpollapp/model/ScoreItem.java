package com.example.admin.exitpollapp.model;

public class ScoreItem {

   /* public final long _id;
    public final int score1;
    public final int score2;
    public final int score3;
    public final int scoreno;

    public ScoreItem(long _id, int score1, int score2, int score3, int scoreno) {
        this._id = _id;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.scoreno = scoreno;
    }*/

   public final long _id;
   public final int score;
   public final String scoreName;
   public final String image;

    public ScoreItem(long _id, int score , String scoreName, String image) {
        this._id = _id;
        this.score = score;
        this.scoreName = scoreName;
        this.image = image;
    }

/*public final long _id;
    public final String score1;
    public final String score2;
    public final String score3;
    public final String scoreno;

    public ScoreItem(long _id, String score1, String score2, String score3, String scoreno) {
        this._id = _id;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.scoreno = scoreno;
    }*/
}
