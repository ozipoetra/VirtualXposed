package mirror.android.content.pm;

import android.content.pm.Signature;
import android.util.ArraySet;

import mirror.MethodParams;
import mirror.RefClass;
import mirror.RefConstructor;

/**
 * Mirror of the top-level android.content.pm.SigningDetails
 * (as opposed to PackageParser's nested namesake). On
 * Android 14+ this is the type SigningInfo's constructor
 * takes; PackageParser.generatePackageInfo converts the
 * nested details into this type through the same
 * four-argument constructor mirrored here.
 */
public class SigningDetails {
    public static Class<?> TYPE = RefClass.load(SigningDetails.class, "android.content.pm.SigningDetails");

    @MethodParams({Signature[].class, int.class, ArraySet.class, Signature[].class})
    public static RefConstructor<Object> ctor;
}
