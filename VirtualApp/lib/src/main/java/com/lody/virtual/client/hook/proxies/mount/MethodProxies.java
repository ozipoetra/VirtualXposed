package com.lody.virtual.client.hook.proxies.mount;

import android.os.Build;

import com.lody.virtual.client.hook.base.MethodProxy;
import com.lody.virtual.client.hook.utils.MethodParameterUtils;
import com.lody.virtual.os.VUserHandle;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @author Lody
 */

class MethodProxies {

    static class GetVolumeList extends MethodProxy {

        @Override
        public String getMethodName() {
            return "getVolumeList";
        }

        @Override
        public boolean beforeCall(Object who, Method method, Object... args) {
            if (args == null || args.length == 0) {
                return super.beforeCall(who, method, args);
            }
            if (args[0] instanceof Integer) {
                // The first parameter is a raw userId, not a
                // uid: since Android 13, StorageManager passes
                // Context.getUserId() and StorageManagerService
                // compares it directly against the caller's
                // userId, demanding INTERACT_ACROSS_USERS on a
                // mismatch. This hook used to rewrite the
                // argument to the real UID (the Android 12
                // semantics) — on Android 13+ the service reads
                // that as "user 10365" and throws
                // SecurityException, which killed every guest
                // bind inside VClientImpl.setupVirtualStorage
                // (Environment.getExternalStorageDirectory ->
                // getVolumeList). Passing the real userId is
                // also correct on Android 12, whose service
                // derives the userId from the value
                // (getUserId(0) == 0 for the primary user).
                args[0] = VUserHandle.getUserId(getRealUid());
            }
            MethodParameterUtils.replaceFirstAppPkg(args);
            return super.beforeCall(who, method, args);
        }

        @Override
        public Object afterCall(Object who, Method method, Object[] args, Object result) throws Throwable {
            return result;
        }
    }

    static class Mkdirs extends MethodProxy {

        @Override
        public String getMethodName() {
            return "mkdirs";
        }

        @Override
        public boolean beforeCall(Object who, Method method, Object... args) {
            MethodParameterUtils.replaceFirstAppPkg(args);
            return super.beforeCall(who, method, args);
        }

        @Override
        public Object call(Object who, Method method, Object... args) throws Throwable {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                return super.call(who, method, args);
            }
            String path;
            if (args.length == 1) {
                path = (String) args[0];
            } else {
                path = (String) args[1];
            }
            File file = new File(path);
            if (!file.exists() && !file.mkdirs()) {
                return -1;
            }
            return 0;
        }
    }
}
