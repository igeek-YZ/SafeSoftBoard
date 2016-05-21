package com.igeek.safesoftboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

import com.igeek.safesoftboard.SoftKey.KeyType;

/**
 * 数字键盘布局
 */
public class SoftKeyNumLayView extends SoftKeyView {

	/**
	 * 数字键盘的分布4行3列
	 */
	private int row = 4;
	private int col = 3;


	public SoftKeyNumLayView(Context context) {
		this(context, null);
	}

	public SoftKeyNumLayView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public SoftKeyNumLayView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public SoftKey[] initSoftKeys() {
		SoftKey[] result = new SoftKey[10];
		for (int i = 0; i < result.length; i++) {
			SoftKey btn = new SoftKey();
			btn.setText(String.valueOf(i));
			result[i] = btn;
		}
		return result;
	}

	@Override
	public SoftKey[] measureSoftKeysPos(SoftKey[] softKeys) {
		for (int i = 0; i < softKeys.length; i++) {
			softKeys[i].setX(blockWidth / 2 + (i % col) * blockWidth);
			softKeys[i].setY(blockHeight / 2 + (i / col % row) * blockHeight);
			softKeys[i].setWidth(blockWidth);
			softKeys[i].setHeight(blockHeight);
		}
		return softKeys;
	}

	@Override
	public int measureBlockWidth(int keyBoardwidth) {
		return keyBoardwidth/col;
	}

	@Override
	public int measureBlockHeight(int keyBoardHeight) {
		return keyBoardHeight/row;
	}

	@Override
	public void drawSoftKeysPos(Canvas canvas, SoftKey[] softKeys) {
		if (softKeys == null) {
			return ;
		}

		canvas.drawColor(Color.WHITE);
		//画垂直分割线
		for (int index = 0; index < col; index++) {
			canvas.drawLine((index + 1) * blockWidth, 0, (index + 1)* blockWidth, getHeight(), keyBorderPaint);
		}

		//画水平分割线
		for (int index = 0; index < row; index++) {
			canvas.drawLine(0, index * blockHeight, getWidth(),index * blockHeight, keyBorderPaint);
		}

		//画软键盘的9个数字按钮
		for (int index = 0; index < softKeys.length-1; index++) {
			drawSoftKey(canvas, softKeys[index]);
		}

		//创建软键盘的删除按钮
		if(delBtn==null){
			delBtn=new SoftKey();
			delBtn.setKeyType(KeyType.ICON);
			delBtn.setIcon(R.drawable.ic_softkey_delete);
			delBtn.setHeight(blockHeight);
			delBtn.setWidth(blockWidth);
			delBtn.setX(softKeys[softKeys.length-1].getX());
			delBtn.setY(softKeys[softKeys.length-1].getY());
			softKeys[softKeys.length-1].setX(blockWidth / 2 + ((col-2)% col) * blockWidth);
			softKeys[softKeys.length-1].setY(blockHeight / 2 + ((row-1) % row) * blockHeight);
		}

		//画软键盘的删除按钮
		drawSoftKey(canvas,delBtn);

		//画第10个数字按钮
		drawSoftKey(canvas,softKeys[softKeys.length-1]);

		if(confirmBtn==null){
			confirmBtn=new SoftKey();
			confirmBtn.setText("确定");
			confirmBtn.setHeight(blockHeight);
			confirmBtn.setWidth(blockWidth);
			confirmBtn.setX(blockWidth / 2 + ((col-1)% col) * blockWidth);
			confirmBtn.setY(blockHeight / 2 + ((row-1) % row) * blockHeight);
		}

		drawSoftKey(canvas,confirmBtn);

	}
}
