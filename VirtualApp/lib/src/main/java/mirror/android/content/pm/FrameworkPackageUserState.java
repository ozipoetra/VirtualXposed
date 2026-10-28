package mirror.android.content.pm;

import mirror.RefClass;
import mirror.RefStaticObject;

/**
 * Mirror of android.content.pm.pkg.FrameworkPackageUserState,
 * the interface that replaced android.content.pm.PackageUserState
 * in Android 14. AOSP's own PackageParser uses its DEFAULT
 * singleton wherever the legacy code used a fresh
 * PackageUserState instance.
 */
public class FrameworkPackageUserState {
    public static Class<?> TYPE = RefClass.load(FrameworkPackageUserState.class,
            "android.content.pm.pkg.FrameworkPackageUserState");
    public static RefStaticObject<Object> DEFAULT;
}
