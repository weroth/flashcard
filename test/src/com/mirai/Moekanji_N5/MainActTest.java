package com.mirai.Moekanji_N5;

import android.app.Activity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.mirai.Moekanji_N5.MainActTest \
 * com.mirai.Moekanji_N5.tests/android.test.InstrumentationTestRunner
 */
@RunWith(RobolectricTestRunner.class)
public class MainActTest {
    private Activity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainAct.class).create().get();

    }

    /*
    Test: App name is correct
    Expected Outcome: Success
     */
    @Test
    public void shouldHaveCorrectAppName() throws Exception {
        assertThat(activity.getResources().getString(R.string.app_name), equalTo("Moekanji"));

    }



}
