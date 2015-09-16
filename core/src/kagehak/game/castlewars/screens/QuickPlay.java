package kagehak.game.castlewars.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by kagehak on 9/12/15.
 */
public class QuickPlay implements Screen {
    private final Game game; //
    private SpriteBatch batch;
    private Stage stage;
    private final float viewScale;

    Sprite Box;

    public QuickPlay(Game game) {
        this.game = game;
        this.viewScale = Gdx.graphics.getHeight() / 1080f; // helps scale to all screen resolutions
    }

    @Override
    public void show() {
        stage = new Stage();
        // the stage is like a 2D Canves for Actors the be placed on.
        // the stage also handle input events it can distribute to the Actors
        batch = new SpriteBatch();
        // the batch optimize draws for processing by the GPU

        Box = new Sprite(new Texture(Gdx.files.internal("box.png")));
        Box.setSize(Box.getWidth() * viewScale, Box.getHeight() * viewScale);
        Box.setPosition(Gdx.graphics.getWidth() / 2 - Box.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Box.getHeight() / 2);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255f / 255f, 235f / 255f, 215f / 255f, 1); // set Background Color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(); // calls .act() on every Actor in stage;

        batch.begin(); // gives permission to draw to batch
        Box.draw(batch);
        stage.draw(); // draw stage to batch
        batch.end();  // draws the things specified since batch.begin
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
