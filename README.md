# SafeSoftBoard
自定义数字，字母，符号的软键盘 继承View绘制。

####效果图如下

<img src="https://github.com/igeek-YZ/SafeSoftBoard/blob/master/pics/customsoftkeyboard.gif" width = "390" height = "698" alt="960" align=center />


####XML 说明
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.igeek.safesoftboard.SafeEdit
        android:id="@+id/test"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:background="@android:color/holo_orange_dark"
        android:gravity="center"
        android:text="bottom"
        android:visibility="visible" />

	</RelativeLayout>

####MainActivity 说明
	public class MainActivity extends Activity{

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
		}
	}

