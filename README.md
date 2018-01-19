# ShadowFrameLayout
Android library for draw shadow effect inside layout. 
<br /> <br />
**How to get a Git project into your build:**

**Step 1.** Add the JitPack repository to your build file, add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```  
**Step 2.** Add the dependency
```
dependencies {
  compile 'com.github.R12rus:ShadowFrameLayout:1.0.1'
}
```

# **How to use:<br />**
app:shadowTopHeight="6dp"<br />
app:shadowBottomHeight="6dp"<br />
app:shadowLeftHeight="6dp"<br />
app:shadowRightHeight="6dp"<br />

```
<r12.shadowframelayout.ShadowFrameLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:shadowTopHeight="6dp"
        app:shadowBottomHeight="6dp">
```
# Example
![Alt text](/example.jpg?raw=true "ShadowFrameLayout example")
