package com.mygdx.flipper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import components.Wall;






public class Flipper extends ApplicationAdapter {
    
    private OrthographicCamera camera;
    private SpriteBatch batch;   
    private Texture balleTexture;
    private Ball balle;
    private BitmapFont font;
    private Wall wall;
    private Texture wallTexture;



@Override
   
public void create() {
    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    camera = new OrthographicCamera(screenWidth,screenHeight);
    camera.setToOrtho(false);
// Inverser l'axe y
    batch=new SpriteBatch();
// importation image de la balle
    balleTexture = new Texture("ball.png");       
// Création de la balle avec des valeurs initiales
    balle = new Ball(162,600);
// Creation of a wall
    wall= new Wall(150, 300, 24, 2);
// Importation of the wall's image
    wallTexture = new Texture("wall.png");
// Initialisation de BitmapFont
    font = new BitmapFont();
    font.setColor(Color.WHITE);
    }

@Override
   
public void render() {
              
    Gdx.gl.glClearColor(2,1,1,1);
       
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    float deltaTime = Gdx.graphics.getDeltaTime();
    // Mettre à jour la balle
    balle.update(deltaTime);
    // Définition la projection de la caméra
    batch.setProjectionMatrix(camera.combined);
    // Dessin de la balle   
    batch.begin();   
    batch.draw(balleTexture,balle.getX(),balle.getY(),balleTexture.getWidth()/30f,balleTexture.getHeight()/30f);
    // Draw the wall
    batch.draw(wallTexture, wall.getPositionX(), wall.getPositionY(), wallTexture.getWidth()/2f, wallTexture.getHeight()/10f);    
    
    //Collision detection
    if (balle.getX() < wall.getPositionX() + wall.getLength() &&
    balle.getX() + balleTexture.getWidth() / 30f > wall.getPositionX() &&
    balle.getY() < wall.getPositionY() + wall.getHeight() &&
    balle.getY() + balleTexture.getHeight() / 30f > wall.getPositionY()) {
    // Collision détectée, ajustez la direction de la balle pour qu'elle rebondisse
    balle.setVelocity(-balle.getVelocityX(), -balle.getVelocityY()); // Inversion de la direction horizontale
 
}
       

    batch.end();
    }


    @Override
   
public void dispose() {
    batch.dispose();
    balleTexture.dispose();
    font.dispose();
    }
}





