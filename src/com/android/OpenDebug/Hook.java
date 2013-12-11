package com.android.OpenDebug;

import java.lang.reflect.Method;

import android.content.Context;
import android.util.Log;
import com.saurik.substrate.*;

public class Hook {
	private static String _TAG = "OpenDebug";
	   static void initialize() {

            MS.hookClassLoad("android.os.Process", new MS.ClassLoadHook() {
                public void classLoaded(Class<?> _class) {
                    hookMethod(_class, "start", 
                    		new Class<?>[] {String.class, String.class, Integer.TYPE, 
                    			Integer.TYPE, int[].class, Integer.TYPE, Integer.TYPE,
                            	Integer.TYPE, String.class, String[].class});
                }
            });
	   }

	protected static void hookMethod(Class<?> _class, String methodName,
									Class<?>[] params) {
        Method method;
        try {
            method = _class.getMethod(methodName, params);
        } catch (NoSuchMethodException e) {
            method = null;
            Log.i(_TAG, "NoSuchMethod: " + methodName + 
            		" with " + params.length + " args");
        }
 
        if (method != null) {
        	Log.i(_TAG, "Hooking " + methodName + 
        			"() with " + params.length + " args");
            MS.hookMethod(_class, method,
    			new MS.MethodAlteration<Context, Object>() {
                public Object invoked(final Context hooked,
                		final Object... args) throws Throwable {
                			args[5] = ((Integer) args[5] | 0x1);
                			return invoke(hooked, args);
                }
        	});
        }
	}
}
