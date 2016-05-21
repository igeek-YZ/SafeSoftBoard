package com.igeek.safesoftboard;

public interface SoftKeyStatusListener {

	public void onPressed(SoftKey softKey);
	
	public void onDeleted();
	
	public void onConfirm();
	
}
