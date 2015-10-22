package kagehak.game.castlewars.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kagehak.game.castlewars.gameEntities.Player;

/**
 * Created by kagehak on 9/12/15.
 */
public class PlayScreen implements Screen {
    Game game;
    SpriteBatch batch;
    Stage stage;
    final float viewScale;

    OrthographicCamera cam;
    Vector2 dragOld, dragNew;

    public Texture backgroundTexture;
    public Sprite backgroundSprite;

    Player user;
    Player enemy;

    // TEST

    public PlayScreen(Game game, Player user, Player enemy) {
        this.game = game;
        this.user = user;
        this.enemy = enemy;

        this.viewScale = Gdx.graphics.getHeight() / 1080f; // helps scale to all screen resolutions
    }

    @Override
    public void show() {
        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);

        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize((Gdx.graphics.getHeight() / backgroundSprite.getHeight()) * backgroundSprite.getWidth(), Gdx.graphics.getHeight());

        stage = new Stage();
        // the stage is like a 2D Canves for Actors the be placed on.
        // the stage also handle input events it can distribute to the Actors
        batch = new SpriteBatch();
        // the batch optimize draws for processing by the GPU
        dragNew = new Vector2();
        dragOld = new Vector2();


        // TEST


    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(cam.combined);
        UpdateCam();
        Draw();
    }

    public void Draw(){
        Gdx.gl.glClearColor(1, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        backgroundSprite.draw(batch);
        stage.draw();


        batch.end();
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

    public void UpdateCam() {

        if (Gdx.input.justTouched()) {
            dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            dragOld = dragNew;
        }
        if (Gdx.input.isTouched()) {
            dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            if (!dragNew.equals(dragOld) && cam.position.x >= Gdx.graphics.getWidth() / 2 && cam.position.x <= backgroundSprite.getWidth() - (Gdx.graphics.getWidth() / 2)) {
                cam.translate(dragOld.x - dragNew.x, 0);
                //button1.setPosition((float) 50, (float) (Gdx.graphics.getHeight() - button1.getHeight()));
                //button2.setPosition((float) 350, (float) (Gdx.graphics.getHeight() - button2.getHeight()));
                dragOld = dragNew; //Drag old becomes drag new.

                if (cam.position.x < Gdx.graphics.getWidth() / 2) {
                    cam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);

                }
                if (cam.position.x > backgroundSprite.getWidth() - (Gdx.graphics.getWidth() / 2)) {
                    cam.position.set(backgroundSprite.getWidth() - (Gdx.graphics.getWidth() / 2), Gdx.graphics.getHeight() / 2, 0);
                }

            }


        }
        cam.update();

    }


}
