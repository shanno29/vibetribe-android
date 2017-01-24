# Proguard rules that are applied to your test apk/code.
-ignorewarnings

-keepattributes *Annotation*

-dontnote junit.framework.**
-dontnote junit.runner.**

-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**
-dontwarn org.hamcrest.**
-dontwarn com.squareup.javawriter.JavaWriter
# Uncomment this if you use Mockito
#-dontwarn org.mockito.**

-dontobfuscate
-dontoptimize
-optimizations !code/allocation/variable

-keep public class com.google.common.base.** {public *;}
-keep public class com.google.common.collect.Sets
-keepclassmembers class com.google.common.collect.Sets** {*;}
-keep public class com.google.common.collect.Collections2
-keepclassmembers class com.google.common.collect.Collections2** {*;}
-keep public final class com.google.common.collect.Lists
-keepclassmembers class com.google.common.collect.Lists** {*;}
-keep public final class com.google.common.collect.Iterables
-keepclassmembers class com.google.common.collect.Iterables** {*;}
-keep public class com.google.common.collect.ImmutableList.** {public *;}
-keep public class com.google.common.io.CharStreams {public *;}
-keep public class com.google.common.collect.HashMultiset
-keepclassmembers class com.google.common.collect.HashMultiset** {*;}
-keep public class com.google.common.collect.HashBiMap
-keepclassmembers class com.google.common.collect.HashBiMap** {*;}
-keep public class javax.annotation.Nullable.** {public *;}
-keep public class com.google.common.util.** {public *;}
-keep public class com.google.common.primitives.** {public *;}

-keep public class * implements butterknife.Unbinder { public <init>(...); }
-keep class butterknife.*
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }

-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe
-dontwarn com.squareup.okhttp.**
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn java.lang.invoke**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

-dontwarn android.databinding.**
-keep class android.databinding.** { *; }

-dontwarn com.roughike.bottombar.**

-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }

-keep class com.squareup.** { *; }
-keep interface com.squareup.** { *; }
-dontwarn com.squareup.**

-dontwarn javax.lang.**
-dontwarn javax.tools.**
-dontwarn javax.annotation.**
-dontwarn autovalue.shaded.com.**
-dontwarn com.google.auto.value.**

-dontnote android.net.http.*
-dontnote org.apache.commons.codec.**
-dontnote org.apache.http.**
-dontnote sun.misc.**
-dontnote java.lang**
-dontnote matthew.shannon.vibetribe**

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {public static final *** NULL;}
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {@com.google.android.gms.common.annotation.KeepName *;}
-keepnames class * implements android.os.Parcelable {public static final ** CREATOR;}
-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**
-keepclassmembers class ** {** base;}

-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontnote okhttp3.**

# Okio
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

-dontwarn java.lang.invoke.*


-keep class android.databinding.** { *; }
-dontwarn android.databinding.**


-dontwarn com.squareup.javawriter.JavaWriter

-dontwarn org.hamcrest.**
-dontwarn android.test.**
-dontwarn android.support.test.**

-keep class org.hamcrest.** {
   *;
}

-keep class org.junit.** { *; }
-dontwarn org.junit.**
-dontwarn org.junit.internall.**
-dontwarn org.junit.rules.**
-dontwarn android.support.test.**

-keep class junit.** { *; }
-dontwarn junit.**

-keep class sun.misc.** { *; }
-dontwarn sun.misc.**

-dontwarn android.test.**

-ignorewarnings

-keepattributes *Annotation*

-dontnote junit.framework.**
-dontnote junit.runner.**

-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**
-dontwarn org.hamcrest.**
-dontwarn com.squareup.javawriter.JavaWriter
-dontwarn org.mockito.**

-dontwarn java.lang.invoke.*

-keep public class * extends android.app.Activity
-keep public class * extends android.support.v7.app.ActionBarActivity
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

-keepclasseswithmembers class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class * extends android.app.Activity {
       public void *(android.view.View);
}

-dontwarn java.lang.invoke.*


-keepclassmembers class **.R$* {
       public static <fields>;
}