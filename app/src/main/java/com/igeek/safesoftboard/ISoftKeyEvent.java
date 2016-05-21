package com.igeek.safesoftboard;

public interface ISoftKeyEvent {
	/**
	 * 更新手指在视图上按钮的状态
	 * @param eventX 手指所在当前视图的X坐标
	 * @param eventY 手指所在当前视图的Y坐标
	 * @param action 事件的动作  -down,move
	 * @return true -表示需要刷新视图，反之无需刷新
	 */
	public boolean handleKeyTouching(int eventX, int eventY,int action);
	/**
	 * 是否拦截用户手指的抬起事件(action_up)
	 * @param eventX 手指所在当前视图的X坐标
	 * @param eventY 手指所在当前视图的Y坐标
	 * @param action 事件的动作  -up
	 */
	public boolean handleTouchUp(int eventX, int eventY,int action);
	/**
	 * 通知长按删除事件
	 */
	public void performQuickDelete();
	/**
	 * 取消长按删除事件
	 */
	public void cancelQuickDelete();
	
}
