package mirror.android.content;

import mirror.RefClass;
import mirror.RefObject;

/**
 * @author Lody
 */

public class IntentFilter {
    public static Class Class = RefClass.load(IntentFilter.class, android.content.IntentFilter.class);
    // The runtime type of IntentFilter.mActions changed from
    // ArrayList (to Android 11) to ArraySet (Android 12+), so
    // this mirror deliberately exposes it as Object — a
    // List<String> typing makes RefObject.get throw
    // ClassCastException on modern Android.
    public static RefObject<Object> mActions;
}
