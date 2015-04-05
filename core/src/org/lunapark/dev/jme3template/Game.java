package org.lunapark.dev.jme3template;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;

import org.lunapark.dev.jme3template.scenes.SceneGame;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 * Created by znak on 05.04.2015.
 */
public class Game extends SimpleApplication implements ScreenController {

    public static Nifty nifty;

    @Override
    public void simpleInitApp() {
        // Stats view
        setDisplayStatView(false);
        //setDisplayFps(false);

        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
        nifty = niftyDisplay.getNifty();
        nifty.registerScreenController(this);
        nifty.addXml("Interface/screen.xml");
        nifty.gotoScreen("mainmenu");
        guiViewPort.addProcessor(niftyDisplay);

        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);

        // Start main menu scene
//        SceneMenu state = new SceneMenu();
//        stateManager.attach(state);
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {

    }

    @Override
    public void onStartScreen() {

    }

    @Override
    public void onEndScreen() {

    }

    public void onClick(String id) {
        System.out.println(id);
        switch (id) {
            case "StartButton":
                SceneGame game = new SceneGame();
                stateManager.attach(game);
                break;
            case "QuitButton":
                stop();
                break;
        }
    }
}