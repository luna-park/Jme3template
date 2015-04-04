package org.lunapark.dev.jme3template.scenes;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

/**
 * Created by znak on 05.04.2015.
 */
public class SceneGame extends SceneBase {

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key = new TextureKey("Textures/poster.jpg");
        Texture tex = assetManager.loadTexture(key);
        mat.setTexture("ColorMap", tex);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);

    }
}
