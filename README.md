# Libgdx Android Leak
In [AndroidApplication] and [AndroidFragmentApplication] classes, they hold an instance of `this.*` on `Gdx.*` (Especially this line `Gdx.app = this;`).

But if fragment/activity get destroyed these references are still alive, so they create a memroy leak.

Here is an example with LeakCanary:

<img src="https://github.com/SaeedMasoumi/libgdx-android-leak/blob/master/images/fragment-leak.png" width="500">

<img src="https://github.com/SaeedMasoumi/libgdx-android-leak/blob/master/images/activity-leak.png" width="500">
 
So these references should not exist after the end of their expected lifetime. Simply we can do this:
``` 
        Gdx.app = null;
        Gdx.input = null;
        Gdx.audio = null;
        Gdx.files = null;
        Gdx.graphics = null;
        Gdx.net = null;
```
In `onDestroy` method of activties/fragments to avoid memory leak. 

And Leak Canary will not show any memory leaks related to libgdx:

<img src="https://github.com/SaeedMasoumi/libgdx-android-leak/blob/master/images/no-leak.png" width="500">

[AndroidFragmentApplication]: <https://github.com/libgdx/libgdx/blob/master/backends/gdx-backend-android/src/com/badlogic/gdx/backends/android/AndroidFragmentApplication.java#L234>
[AndroidApplication]: <https://github.com/libgdx/libgdx/blob/master/backends/gdx-backend-android/src/com/badlogic/gdx/backends/android/AndroidApplication.java#L287>
