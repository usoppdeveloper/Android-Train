package ru.buggytrain.unittesttrain;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleCallback;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * See examples here
 * http://www.vogella.com/tutorials/AndroidTesting/article.html
 * https://developer.android.com/training/testing/samples.html
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MySimpleInstrumentedTest {
    private static String TAG = MySimpleInstrumentedTest.class.getSimpleName() + "_tag";

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void init() {
        Log.e(TAG, "init");
        ActivityLifecycleMonitorRegistry.getInstance().addLifecycleCallback(new ActivityLifecycleCallback() {
            @Override
            public void onActivityLifecycleChanged(Activity activity, Stage stage) {
                Log.d(TAG, "activity: " + activity + ", stage: " + stage);
            }
        });
    }

    @Before
    public void start() {
        Log.e(TAG, "start");
    }

    @After
    public void end() {
        Log.e(TAG, "end");
    }

    @Test
    public void checkAppContext() throws Exception {
        Log.e(TAG, "useAppContext");
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("ru.buggytrain.unittesttrain", appContext.getPackageName());
    }

    @Test
    public void findViewTest() {
        Log.e(TAG, "findViewTest");
        MainActivity activity = activityRule.getActivity();
        View viewById = activity.findViewById(R.id.text_view);
        assertThat(viewById, notNullValue());
    }
}
