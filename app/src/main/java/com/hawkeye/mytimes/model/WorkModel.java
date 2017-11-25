package com.hawkeye.mytimes.model;

/**
 * Created by CRM on 11/25/2017.
 */

public class WorkModel {
    private long start;
    private long stop;
    private String title;

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void Start(){
        long start = System.currentTimeMillis();

    }
    public void end(){
       stop = System.currentTimeMillis();
    }
    public boolean hasEnded(){
        if(stop != 0){
            return true;
        } else {
            return false;
        }
    }


}
