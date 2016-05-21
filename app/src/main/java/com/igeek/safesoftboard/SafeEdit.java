package com.igeek.safesoftboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.PopupWindow.OnDismissListener;

public class SafeEdit extends EditText implements OnDismissListener{

	private SoftKeyBoard softKeyBoard;

	public SafeEdit(Context context) {
		super(context);
		initSafeEdit(context);
	}

	public SafeEdit(Context context, AttributeSet attrs) {
		super(context, attrs);
		initSafeEdit(context);
	}

	public SafeEdit(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initSafeEdit(context);
	}
	
	public void initSafeEdit(Context context){
		//setOnFocusChangeListener(this);
	}

	
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_UP){
			if (softKeyBoard == null) {
				softKeyBoard=new SoftKeyBoard(getContext());
				softKeyBoard.setEdit(this);
				softKeyBoard.setOnDismissListener(this);
				softKeyBoard.show();
			}
		}
		return true;
	}

	@Override
	public void onDismiss() {
		softKeyBoard.recycle();
		softKeyBoard=null;
	}
}
