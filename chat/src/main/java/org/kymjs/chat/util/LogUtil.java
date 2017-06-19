package org.kymjs.chat.util;

import android.util.Log;

/**
 * 日志打印类 发布时建议关闭日志打印
 * 
 * 1、Log.v 的调试颜色为黑色的，任何消息都会输出，这里的v代表verbose啰嗦的意思，平时使用就是Log.v("","");
 * 2、Log.d的输出颜色是蓝色的，仅输出debug调试的意思，但他会输出上层的信息，过滤起来可以通过DDMS的Logcat标签来选择.
 * 3、Log.i的输出为绿色，一般提示性的消息information，它不会输出Log.v和Log.d的信息，但会显示i、w和e的信息
 * 4、Log.w的意思为橙色，可以看作为warning警告，一般需要我们注意优化Android代码，同时选择它后还会输出Log.e的信息。
 * 5、Log.e为红色，可以想到error错误，这里仅显示红色的错误信息，这些错误就需要我们认真的分析，查看栈的信息了。
 */
public class LogUtil {
	/** 日志打印开关 */
	private final static boolean IS_DEBUG_ON = true;
	private final static String DEBUG_TAG = "livehome";

	public static void v(String text) {
		if (IS_DEBUG_ON) {
			Log.v(DEBUG_TAG, text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void v(Class clazz, String text) {
		if (IS_DEBUG_ON) {
			Log.v(DEBUG_TAG, clazz.getName() + "---" + text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void v(Class clazz, String text, Exception e) {
		if (IS_DEBUG_ON) {
			Log.v(DEBUG_TAG,
					clazz.getName() + "---" + text + "--" + e.getMessage());
		}
	}

	public static void i(String text) {
		if (IS_DEBUG_ON) {
			Log.i(DEBUG_TAG, text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void i(Class clazz, String text) {
		if (IS_DEBUG_ON) {
			Log.i(DEBUG_TAG, clazz.getName() + "---" + text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void i(Class clazz, String text, Exception e) {
		if (IS_DEBUG_ON) {
			Log.i(DEBUG_TAG,
					clazz.getName() + "---" + text + "--" + e.getMessage());
		}
	}

	public static void d(String text) {
		if (IS_DEBUG_ON) {
			Log.d(DEBUG_TAG, text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void d(Class clazz, String text) {
		if (IS_DEBUG_ON) {
			Log.d(DEBUG_TAG, clazz.getName() + "---" + text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void d(Class clazz, String text, Exception e) {
		if (IS_DEBUG_ON) {
			Log.d(DEBUG_TAG,
					clazz.getName() + "---" + text + "--" + e.getMessage());
		}
	}

	public static void w(String text) {
		if (IS_DEBUG_ON) {
			Log.w(DEBUG_TAG, text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void w(Class clazz, String text) {
		if (IS_DEBUG_ON) {
			Log.w(DEBUG_TAG, clazz.getName() + "---" + text);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void w(Class clazz, String text, Exception e) {
		if (IS_DEBUG_ON) {
			Log.w(DEBUG_TAG,
					clazz.getName() + "---" + text + "--" + e.getMessage());
		}
	}

	public static void e(String text) {
		Log.e(DEBUG_TAG, text);
	}

	@SuppressWarnings("rawtypes")
	public static void e(Class clazz, String text) {
		Log.e(DEBUG_TAG, clazz.getName() + "---" + text);
	}

	@SuppressWarnings("rawtypes")
	public static void e(Class clazz, String text, Exception e) {
		Log.e(DEBUG_TAG, clazz.getName() + "---" + text + "--" + e.getMessage());
	}

}
