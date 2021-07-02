package com.example.earthquake;

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private String mDate;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double Magnitude, String Location, long TimeInMilliseconds, String url){
        mMagnitude=Magnitude;
        mLocation=Location;
        mTimeInMilliseconds=TimeInMilliseconds;
        mUrl=url;
    }
    public double getMagnitude(){return mMagnitude;}
    public String getmLocation(){return mLocation;}
    public String getmDate(){return mDate;}
    public long getmTimeInMilliseconds(){return mTimeInMilliseconds;}
    public String getmUrl(){return mUrl;}
}
