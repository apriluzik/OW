package com.apriluziknaver.ow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mapri on 2017-09-23.
 */

public class HeroItem implements Parcelable{

    String title;
    String name;
    String imgURL;

    //개요
    String part; //역할
    String about; //설명
    String diff; //난이도

//    //기술
    String hIcon;   //영웅 아이콘
    String hVideo;  //영웅 비디오

    String skill01;
    String icon01;

    String skill02;
    String icon02;

    String skill03;
    String icon03;

    String skill04;
    String icon04;

    String skill05;
    String icon05;

    String skill06;
    String icon06;

    //소개
    String ownName; //본명
    String age; //나이
    String occ; //직업
    String bound; //활동근거지
    String aff; //소속
    String comment; //대사
    String story;

    public HeroItem() {
    }

    public HeroItem(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    protected HeroItem(Parcel in) {
        title = in.readString();
        name = in.readString();
        imgURL = in.readString();
        part = in.readString();
        about = in.readString();
        diff = in.readString();
        hIcon = in.readString();
        hVideo = in.readString();
        skill01 = in.readString();
        icon01 = in.readString();
        skill02 = in.readString();
        icon02 = in.readString();
        skill03 = in.readString();
        icon03 = in.readString();
        skill04 = in.readString();
        icon04 = in.readString();
        skill05 = in.readString();
        icon05 = in.readString();
        skill06 = in.readString();
        icon06 = in.readString();
        ownName = in.readString();
        age = in.readString();
        occ = in.readString();
        bound = in.readString();
        aff = in.readString();
        comment = in.readString();
        story = in.readString();
    }

    public static final Creator<HeroItem> CREATOR = new Creator<HeroItem>() {
        @Override
        public HeroItem createFromParcel(Parcel in) {
            return new HeroItem(in);
        }

        @Override
        public HeroItem[] newArray(int size) {
            return new HeroItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(name);
        parcel.writeString(imgURL);
        parcel.writeString(part);
        parcel.writeString(about);
        parcel.writeString(diff);
        parcel.writeString(hIcon);
        parcel.writeString(hVideo);
        parcel.writeString(skill01);
        parcel.writeString(icon01);
        parcel.writeString(skill02);
        parcel.writeString(icon02);
        parcel.writeString(skill03);
        parcel.writeString(icon03);
        parcel.writeString(skill04);
        parcel.writeString(icon04);
        parcel.writeString(skill05);
        parcel.writeString(icon05);
        parcel.writeString(skill06);
        parcel.writeString(icon06);
        parcel.writeString(ownName);
        parcel.writeString(age);
        parcel.writeString(occ);
        parcel.writeString(bound);
        parcel.writeString(aff);
        parcel.writeString(comment);
        parcel.writeString(story);
    }
}
