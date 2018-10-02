package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	//private BitmapFont MyBit8//
	private Music musicBackbround;
	private com.badlogic.gdx.math.Rectangle rinRestangle;
	private OrthographicCamera orthographicCamery;
	private Vector3 objVertor3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img
		img = new Texture("par.png");

		//Create
		orthographicCamery = new OrthographicCamera();
		orthographicCamery.setToOrtho(false, 800, 400);

		//Inher
		rinRestangle =new com.badlogic.gdx.math.Rectangle();
		rinRestangle.x = 368;
		rinRestangle.y = 20;
		rinRestangle.width = 128;
		rinRestangle.height = 128;
		//Music
		musicBackbround = Gdx.audio.newMusic(Gdx.files.internal("rin.mp3"));

		//Star&LoopMusic
		musicBackbround.setLooping(true);
		musicBackbround.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 750, 0);
		batch.end();

		//About
		orthographicCamery.update();

		//Update
		batch.setTransformMatrix(orthographicCamery.combined);

		//Reder

		batch.begin();
		batch.draw(img,rinRestangle.x, rinRestangle.y);
		batch.end();

		//Imput
		if (Gdx.input.isTouched()){
			objVertor3 =new Vector3();
			objVertor3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			orthographicCamery.unproject(objVertor3);
			rinRestangle.x =objVertor3.x -32;

		}//end if
		//control
		if (rinRestangle.x < 0){
			rinRestangle.x = 0;
		}
		if (rinRestangle.x > 736){
			rinRestangle.x = 736;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
