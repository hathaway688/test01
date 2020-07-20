package com.sitech.mybatis.dao;

public class Music {
int id;
String name;
String singer;
String picture;	
String mp3;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSinger() {
	return singer;
}
public void setSinger(String singer) {
	this.singer = singer;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getMp3() {
	return mp3;
}
public void setMp3(String mp3) {
	this.mp3 = mp3;
}
@Override
public String toString() {
	return "Music [id=" + id + ", name=" + name + ", singer=" + singer + ", picture=" + picture + ", mp3=" + mp3 + "]";
}	

}
