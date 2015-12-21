package com.example.ywang4241.fitness;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ywang4241 on 11/13/2015.
 */
public class Goal {

    private UUID mId;
    private String mGoal;
    private Date mDate;
    private int mSteps;

    public Goal(){
        //generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
        mSteps = 0;
    }


    public String getGoal() {
        return mGoal;
    }

    public void setGoal(String goal) {
        this.mGoal = goal;
    }

    public String getmGoal() {
        return mGoal;
    }

    public void setmGoal(String mGoal) {
        this.mGoal = mGoal;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getmSteps() {
        return mSteps;
    }

    public void setmSteps(int mSteps) {
        this.mSteps = mSteps;
    }
}
