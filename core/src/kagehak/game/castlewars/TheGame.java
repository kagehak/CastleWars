package kagehak.game.castlewars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import kagehak.game.castlewars.screens.MainMenu;

public class TheGame extends Game {
	SpriteBatch batch;
	com.badlogic.gdx.Game game; // the game controls what Screen is shown
	
	@Override
	public void create () {
		game = this;
		batch = new SpriteBatch();

		game.setScreen(new MainMenu(game)); // Set shown Screen to new MainMenu Screen
	}

	@Override
	public void render () {
		super.render();
	}


}
