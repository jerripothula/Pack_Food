package com.example.pack_food;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;


public class Food implements Parcelable {



    private String name;
    private String location;
    private String keywords;
    private String d;
    private String email;
    private boolean share;
    private float  val;

    public Food()
    {
        super();
    }


    public Food(String name, String location, String keywords, String d, boolean share, String email, float val) {
        this.name = name;
        this.location = location;
        this.keywords = keywords;
        this.d = d;
        this.share = share;
        this.email = email;
        this.val = val;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }




    @RequiresApi(api = Build.VERSION_CODES.Q)
    public Food(Parcel in) {

        this.name=in.readString();
        this.location=in.readString();
        this.keywords=in.readString();
        this.d=in.readString();
        this.share=in.readByte()!=0;
        this.email=in.readString();
        this.val=in.readFloat();

    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(keywords);
        dest.writeString(d);
        dest.writeInt(share?1:0);
        dest.writeString(email);
        dest.writeFloat(val);

    }

    public String toString()
    {
        return name + "\n " + d;
    }
}
