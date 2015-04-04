package org.lunapark.dev.jme3template;

import com.jme3.app.SimpleApplication;

import org.lunapark.dev.jme3template.scenes.SceneBase;
import org.lunapark.dev.jme3template.scenes.SceneGame;

/**
 * Created by znak on 05.04.2015.
 */
public class Game extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        // Stats view
        //setDisplayStatView(false);
        //setDisplayFps(false);

        SceneBase state = new SceneGame();
        state.initialize(getStateManager(), this);
        stateManager.attach(state);
    }
}