-keepnames class ** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations
-keepattributes InnerClasses
-keepattributes EnclosingMethod
-dontobfuscate


-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }



-dontwarn java.lang.invoke.*
-dontwarn org.apache.commons.**
-keep class org.apache.http.** { *; }
-dontwarn org.apache.http.**

### PICASSO
-dontnote com.squareup.picasso.Utils
-dontwarn com.squareup.picasso.OkHttpDownloader


### OKHTTP
-dontnote okhttp3.internal.Platform


### OKIO

-dontwarn okio.Okio
-dontwarn okio.DeflaterSink
-dontnote sun.misc.Unsafe
-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry

-dontwarn okio.**

# Retrofit
-dontwarn retrofit2.**
-dontwarn org.codehaus.mojo.**
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {@retrofit2.* <methods>;}
-keepclasseswithmembers interface * { @retrofit2.* <methods>;}

####### RxAndroid #######
-dontwarn rx.internal.util.unsafe.**

### ABOUT ###
-keep class .R
-keep class **.R$* {
    <fields>;
}
-keep class com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic { *; }


-keep class org.eclipse.mat.** { *; }
-keep class com.squareup.leakcanary.** { *; }
-keep class com.squareup.haha.** { *; }

-dontwarn com.squareup.haha.guava.**
-dontwarn com.squareup.haha.perflib.**
-dontwarn com.squareup.haha.trove.**
-dontwarn com.squareup.leakcanary.**

### OTTO ###
-keepattributes *Annotation*
-keepclassmembers class ** {
    @com.squareup.otto.Subscribe public *;
    @com.squareup.otto.Produce public *;
}

-keep class com.firebase.** { *; }
-keep class org.apache.** { *; }
-keepnames class com.fasterxml.jackson.** { *; }
-keepnames class javax.servlet.** { *; }
-keepnames class org.ietf.jgss.** { *; }
-dontwarn org.w3c.dom.**

 -keep class matthew.shannon.vibetribe.service.Metadata.MetadataManager { public *; }

 ##---------------Begin: proguard configuration for Gson  ----------
 # Gson uses generic type information stored in a class file when working with fields. Proguard
 # removes such information by default, so configure it to keep all of it.
 -keepattributes Signature
 -keepattributes *Annotation*

 # Gson specific classes
 -keep class sun.misc.Unsafe { *; }

 # Application classes that will be serialized/deserialized over Gson
 -keep class ph.reggis.FEDT.model.api.** { *; }

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keepresourcexmlelements manifest/application/meta-data@value=GlideModule