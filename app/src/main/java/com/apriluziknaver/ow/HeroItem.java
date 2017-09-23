package com.apriluziknaver.ow;

/**
 * Created by mapri on 2017-09-23.
 */

public class HeroItem {

    String title;
    String name;
    String imgURL;

    //개요
    String part; //역할
    String about; //설명
    String diff; //난이도

    //기술
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
}
