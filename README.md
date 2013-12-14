Android-OpenDebug
=================

Make any application debuggable on a device.

Description
-----------

This tool leverages Cydia Substrate to make all applications running on the device debuggable; once installed any application will let a debugger attach to them. 

Usage
-----

* Ensure that Cydia Substrate has been deployed on your test device. The installer requires a rooted device and can be found on the Google Play store at https://play.google.com/store/apps/details?id=com.saurik.substrate&hl=en 
* Download the pre-compiled APK available at https://github.com/iSECPartners/Android-OpenDebug/releases
* Install the APK package on the device:

        adb install Android-OpenDebug.apk

Notes
-----

This should only be used on test devices
