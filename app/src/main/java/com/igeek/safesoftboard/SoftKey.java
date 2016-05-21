package com.igeek.safesoftboard;

import java.io.Serializable;


public class SoftKey implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * X坐标
	 */
	private int x;
	/**
	 * y坐标
	 */
	private int y;
	/**
	 * 图标
	 */
	private int icon;
	/**
	 * 按钮的宽度
	 */
	private int width;
	/**
	 * 按钮的高度
	 */
	private int height;
	/**
	 * 按钮的文本
	 */
	private String text;
	/**
	 * 是否被按下选中
	 */
	private boolean isPreessed;
	
	private KeyType keyType=KeyType.TEXT;
	
	public static enum KeyType{
		TEXT,ICON,TEXT_ICON;
	}
	
	public SoftKey() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public KeyType getKeyType() {
		return keyType;
	}

	public void setKeyType(KeyType keyType) {
		this.keyType = keyType;
	}

	public boolean isPreessed() {
		return isPreessed;
	}

	public void setPreessed(boolean isPreessed) {
		this.isPreessed = isPreessed;
	}
	
	public boolean updatePressed(int eventX, int eventY){
		 boolean isPress=this.isPreessed;
		 this.isPreessed=inRange(eventX,eventY);
		 return isPress!=this.isPreessed;
	}

	public boolean equa(SoftKey btn) {
		if (x == btn.getX() && y == btn.getY()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean inRange(int eventX, int eventY) {
		boolean inXRange = (eventX > x - width / 2)
				&& (eventX < x + width / 2);
		boolean inYRange = (eventY > y - height / 2)
				&& (eventY < y + height / 2);
		if (inXRange && inYRange) {
			return true;
		} else {
			return false;
		}
	}

}
