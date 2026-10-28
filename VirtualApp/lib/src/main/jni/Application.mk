APP_ABI := x86_64 arm64-v8a
# Was android-14; current NDKs no longer ship platforms below
# android-21, which is also the app's minSdk.
APP_PLATFORM := android-21
# fbjni (fb/) builds with -Werror; current Clang warns on VLAs
# in C++ (a GNU extension this 2018 code uses deliberately).
# Demote that one diagnostic back to a warning — the specific
# -Wno-error wins over the makefiles' blanket -Werror.
APP_CPPFLAGS += -Wno-error=vla-cxx-extension
APP_STL := c++_static
APP_OPTIM := release
VA_ROOT          := $(call my-dir)
NDK_MODULE_PATH  := $(NDK_MODULE_PATH):$(VA_ROOT)