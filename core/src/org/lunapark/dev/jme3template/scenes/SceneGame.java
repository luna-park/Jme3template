package org.lunapark.dev.jme3template.scenes;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

import org.lunapark.dev.jme3template.Game;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 * Created by znak on 05.04.2015.
 */
public class SceneGame extends SceneBase implements ScreenController {

    private Geometry geom;

    /**
     * TODO GAME CODE
     */
    @Override
    protected void start() {
        prepareGui();

        Box b = new Box(1, 1, 1);
        Sphere sphere = new Sphere(8, 8, 1);
        geom = new Geometry("Geom", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.White);
        geom.setMaterial(mat);
        rootNode.attachChild(geom);
        createPostFx();
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
        System.out.println("Bind");
    }

    @Override
    public void onStartScreen() {

    }

    @Override
    public void onEndScreen() {

    }

    private void prepareGui() {
        Game.nifty.gotoScreen("hud");

        //Game.nifty.exit();
        app.getFlyByCamera().setEnabled(true);
        app.getFlyByCamera().setDragToRotate(false);
        inputManager.setCursorVisible(false);
    }

    private void createPostFx() {
        makeToonish(rootNode);
        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        CartoonEdgeFilter toon = new CartoonEdgeFilter();
        toon.setEdgeWidth(2.0f);
        toon.setEdgeIntensity(1.0f);
        toon.setNormalThreshold(0);
        fpp.addFilter(toon);
        viewPort.addProcessor(fpp);
    }

    public void makeToonish(Spatial spatial) {
        if (spatial instanceof Node) {
            Node n = (Node) spatial;
            for (Spatial child : n.getChildren())
                makeToonish(child);
        } else if (spatial instanceof Geometry) {
            Geometry g = (Geometry) spatial;
            Material m = g.getMaterial();
            if (m.getMaterialDef().getName().equals("Phong Lighting")) {
                Texture t = assetManager.loadTexture("Textures/ColorRamp/toon.png");
//                t.setMinFilter(Texture.MinFilter.NearestNoMipMaps);
//                t.setMagFilter(Texture.MagFilter.Nearest);
                m.setTexture("ColorRamp", t);
                m.setBoolean("UseMaterialColors", true);
                m.setColor("Specular", ColorRGBA.Black);
                m.setColor("Diffuse", ColorRGBA.White);
                m.setBoolean("VertexLighting", true);
            }
        }
    }

    @Override
    public void update(float tpf) {
        geom.rotate(0, tpf * 3, tpf * 4);
    }
}
