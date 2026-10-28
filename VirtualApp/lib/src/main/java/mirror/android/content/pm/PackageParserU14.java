package mirror.android.content.pm;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;

import mirror.MethodReflectParams;
import mirror.RefClass;
import mirror.RefStaticMethod;

/**
 * PackageParser generate*Info mirrors for Android 14+.
 *
 * Identical to the Marshmallow set except for the user-state
 * parameter: android.content.pm.PackageUserState was deleted
 * in Android 14, and the generate*Info methods now take an
 * android.content.pm.pkg.FrameworkPackageUserState. Verified
 * against AOSP android-16.0.0_r1 PackageParser signatures —
 * the arities are unchanged, only the state type moved.
 */
public class PackageParserU14 {
    public static Class<?> TYPE = RefClass.load(PackageParserU14.class, "android.content.pm.PackageParser");
    @MethodReflectParams({"android.content.pm.PackageParser$Activity", "int", "android.content.pm.pkg.FrameworkPackageUserState", "int"})
    public static RefStaticMethod<ActivityInfo> generateActivityInfo;
    @MethodReflectParams({"android.content.pm.PackageParser$Package", "int", "android.content.pm.pkg.FrameworkPackageUserState"})
    public static RefStaticMethod<ApplicationInfo> generateApplicationInfo;
    @MethodReflectParams({"android.content.pm.PackageParser$Package", "[I", "int", "long", "long", "java.util.Set", "android.content.pm.pkg.FrameworkPackageUserState"})
    public static RefStaticMethod<PackageInfo> generatePackageInfo;
    @MethodReflectParams({"android.content.pm.PackageParser$Provider", "int", "android.content.pm.pkg.FrameworkPackageUserState", "int"})
    public static RefStaticMethod<ProviderInfo> generateProviderInfo;
    @MethodReflectParams({"android.content.pm.PackageParser$Service", "int", "android.content.pm.pkg.FrameworkPackageUserState", "int"})
    public static RefStaticMethod<ServiceInfo> generateServiceInfo;
}
