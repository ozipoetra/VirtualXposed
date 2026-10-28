package com.android.internal.content;

import android.content.Intent;

/**
 * Compile-time stub for the hidden framework type used by
 * ClientTransactionHandler.handleNewIntent signatures.
 * At runtime the real framework class is loaded from the
 * boot classpath; this source only gives the compiler a
 * type to check signatures against. (The mirror class of
 * the same name cannot be used as a parameter type: its
 * binary name differs, so methods declared with it do not
 * actually override the framework methods.)
 */
public class ReferrerIntent extends Intent {
}
