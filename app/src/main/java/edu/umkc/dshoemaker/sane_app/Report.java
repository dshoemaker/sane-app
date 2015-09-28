package edu.umkc.dshoemaker.sane_app;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Drew on 9/23/2015.
 */
public class Report {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mReported;

    public Report() {
        //Generate unique ID
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public Date getDate(){
        return mDate;
    }

    public void setDate(Date date){
        mDate = date;
    }

    public boolean isReported(){
        return mReported;
    }

    public void setReported(boolean reported) {
        mReported = reported;
    }
}

