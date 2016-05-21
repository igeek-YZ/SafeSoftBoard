package com.igeek.safesoftboard;

import android.graphics.Canvas;
import android.view.View;

public interface ISoftKeyBoard extends View.OnTouchListener,ISoftKeyEvent{

	/**
	 * 初始化关键的字符数组
	 * @return
	 */
	public SoftKey[] initSoftKeys();

	/**
	 * 数组重新随机排列
	 * @param softKeys 软键盘中的关键字符数组
	 * @return
	 */
	public SoftKey[] makeSoftKeysRandom(SoftKey[] softKeys);
	/**
	 * 初始化字符数组的绘画位置
	 * @param softKeys 软键盘中的关键字符数组
	 * @return
	 */
	public SoftKey[] measureSoftKeysPos(SoftKey[] softKeys);
	/**
	 *
	 * 计算每个softkey的宽度
	 * @param keyBoardwidth 软键盘的宽度
	 * @return
	 */
	public int measureBlockWidth(int keyBoardwidth);
	/**
	 * 计算每个softkey的高度
	 * @param keyBoardHeight 软键盘的高度
	 * @return
	 */
	public int measureBlockHeight(int keyBoardHeight);
	/**
	 * 绘制字符数组
	 * @param canvas
	 * @param softKeys
	 */
	public void drawSoftKeysPos(Canvas canvas,SoftKey[] softKeys);

	/**
	 * 绘制按钮
	 * @param canvas
	 * @param softkey
	 */
	public void drawSoftKey(Canvas canvas,SoftKey softkey);

	/**
	 * 获取用户手指正在触摸的sofkey
	 * @param eventX 手指所在当前视图的X坐标
	 * @param eventY 手指所在当前视图的Y坐标
	 * @return
	 */
	public SoftKey obtainTouchSoftKey(int eventX, int eventY);
	/**
	 * 重置所有按钮的状态
	 */
	public void resetSoftKeysState();
}
