package kagehak.game.castlewars.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by kagehak on 9/11/15.
 */
public class MainMenu implements Screen {
    private final Game game; //
    private SpriteBatch batch;
    private Stage stage;
    private final float viewScale;

    private TextButton buttonCampaign;
    private TextButton buttonQuickPlay;
    private TextButton buttonCredit;


    public MainMenu(Game game) {
        this.game = game;
        this.viewScale = Gdx.graphics.getHeight() / 1080f; // helps scale to all screen resolutions 
    }

    @Override
    public void show() {
        stage = new Stage();
        // the stage is like a 2D Canves for Actors the be placed on.
        // the stage also handle input events it can distribute to the Actors
        batch = new SpriteBatch();
        // the batch optimize draws for processing by the PGU

        buttonCampaign = new TextButton("Campaign", getButtonStyle("BTN_GREEN_RECT_IN", "BTN_GREEN_RECT_OUT"));
        buttonCampaign.setPosition(getCenter(buttonCampaign), viewScale * 700);


        buttonQuickPlay = new TextButton("Quick Play", getButtonStyle("BTN_GRAY_RECT_IN", "BTN_GRAY_RECT_OUT"));
        buttonQuickPlay.setPosition(getCenter(buttonQuickPlay), viewScale * 400);

        buttonCredit = new TextButton("Credit", getButtonStyle("BTN_BLUE_RECT_IN", "BTN_BLUE_RECT_OUT"));
        buttonCredit.setPosition(getCenter(buttonCredit), viewScale * 100);


        stage.addActor(buttonCampaign);
        stage.addActor(buttonQuickPlay);
        stage.addActor(buttonCredit);

        Gdx.input.setInputProcessor(stage);

        buttonCampaign.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        buttonQuickPlay.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new QuickPlay(game));
            }
        });

        buttonCredit.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

            }
        });

    }

    public float getCenter(TextButton o){
        return Gdx.graphics.getWidth() / 2 - o.getWidth() / 2;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255f/255f, 235f/255f, 215f/255f, 1); // set Background Color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(); // calls .act() on every Actor in stage;

        batch.begin(); // gives permission to draw to batch
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

    public TextButton.TextButtonStyle getButtonStyle(String in, String out){
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();

        Skin skin = new Skin();
        TextureAtlas buttonAtlas = new TextureAtlas("UI/MainMenuButtons.pack");
        skin.addRegions(buttonAtlas);

        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(viewScale * 4);

        style.up = skin.getDrawable(out);
        style.up.setMinHeight(2*138*viewScale);
        style.up.setMinWidth(2 * 381 * viewScale);
        style.over = skin.getDrawable(in);
        style.over.setMinHeight(2*138*viewScale);
        style.over.setMinWidth(2 * 381 * viewScale);
        style.down = skin.getDrawable(in);
        style.down.setMinHeight(2*138*viewScale);
        style.down.setMinWidth(2 * 381 * viewScale);
        style.font = font;

        return style;
    }

}
