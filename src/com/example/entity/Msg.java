package com.example.entity;

public class Msg {
	public static final int TYPE_RECEIVED = 0;
	public static final int TYPE_SEND = 1;
	public String content;
	public int type;
	public String getContent() {
		return content;
	}
	public int getType() {
		return type;
	}
	public Msg(String content,int type){
		this.content = content;
		this.type = type;
	}
}
