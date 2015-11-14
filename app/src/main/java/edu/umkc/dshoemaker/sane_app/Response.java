package edu.umkc.dshoemaker.sane_app;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Rhonda on 11/13/2015.
 */

//THIS IS JUST A PLACEHOLDER FOR THE REPORT CREATED
    //BY THE USER WHICH IS CREATED BY SARAH. REPORT.JAVA IS IMPROPERLY NAMED RIGHT NOW
public class Response {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mReported;

    public Response() {
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
