package org.lunapark.dev.jme3template;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jme3.app.AndroidHarness;
import com.jme3.system.android.AndroidConfigChooser;

import java.util.logging.Level;
import java.util.logging.LogManager;


public class MainActivity extends AndroidHarness {

    public MainActivity() {
        // Set the application class to run
        appClass = Game.class.getCanonicalName();

        // Try ConfigType.FASTEST; or ConfigType.LEGACY if you have problems
        eglConfigType = AndroidConfigChooser.ConfigType.BEST;

        // Exit Dialog title & message
        exitDialogTitle = "Exit";
        exitDialogMessage = "Are you sure you want to quit?";

        // Choose screen orientation
        screenOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        // Enable MouseEvents being generated from TouchEvents (default = true)
        mouseEventsEnabled = true;

        // Set the default logging level (default=Level.INFO, Level.ALL=All Debug Info)
        LogManager.getLogManager().getLogger("").setLevel(Level.INFO);
    }
}
