package android.window;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Compile-time stub for the hidden framework type whose
 * nested parcelable appears in ClientTransactionHandler
 * signatures on Android 16. At runtime the real framework
 * class is loaded from the boot classpath; this source
 * only gives the compiler a type to check signatures
 * against.
 */
public class SplashScreenView {

    public static class SplashScreenViewParcelable implements Parcelable {
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }
    }
}
