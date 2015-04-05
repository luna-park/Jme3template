package org.lunapark.dev.jme3template.scenes;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.InputManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;

/**
 * Created by znak on 05.04.2015.
 */
public abstract class SceneBase extends AbstractAppState {

    protected SimpleApplication app;
    protected Node rootNode, guiNode;
    protected AssetManager assetManager;
    protected AppStateManager stateManager;
    protected InputManager inputManager;
    protected ViewPort viewPort, guiViewPort;
    protected AudioRenderer audioRenderer;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        this.app = (SimpleApplication) app; // can cast Application to something more specific
        this.audioRenderer = this.app.getAudioRenderer();
        this.assetManager = this.app.getAssetManager();
        this.stateManager = this.app.getStateManager();
        this.inputManager = this.app.getInputManager();
        this.guiViewPort = this.app.getGuiViewPort();
        this.viewPort = this.app.getViewPort();
        this.rootNode = this.app.getRootNode();
        this.guiNode = this.app.getGuiNode();
        start();
    }

    protected abstract void start();

}
