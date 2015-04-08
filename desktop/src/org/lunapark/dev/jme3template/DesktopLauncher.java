package org.lunapark.dev.jme3template;

import com.jme3.system.AppSettings;

/**
 * Created by znak on 05.04.2015.
 */
class DesktopLauncher {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setResolution(800, 480);
        settings.setFrameRate(60);
        Game game = new Game();
        game.setSettings(settings);
        game.setShowSettings(false);
        game.start();
    }
}
