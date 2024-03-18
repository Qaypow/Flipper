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

    private static final float MAX_COLLISION_TIME = 0.3f;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture balleTexture;
    private Ball balle;
    private BitmapFont font;
    private Wall wall;
    private Texture wallTexture;
    private final float safetyMargin = 10;
    public boolean collisionDetected = false;
    private float collisionTime;


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

    //Collision detection
    if (balle.getX() < wall.getPositionX() + wallTexture.getWidth()/2 - safetyMargin &&
            balle.getX() + balleTexture.getWidth()/30 > wall.getPositionX() + safetyMargin &&
            balle.getY() < wall.getPositionY() + wallTexture.getHeight()/10 - safetyMargin  &&
            balle.getY() + balleTexture.getHeight() / 30 > wall.getPositionY() + safetyMargin) {

        collisionTime += deltaTime;
        balle.setVelocity(-wall.getRestitution() * balle.getVelocityX(), - wall.getRestitution() * balle.getVelocityY()); // Inversion de la direction horizontal
        // Vérifiez si la collision dure trop longtemps
        if (collisionTime > MAX_COLLISION_TIME) {
            // Si la collision dure trop longtemps, ajustez la position de la balle
            // Assurez-vous de mettre à jour correctement les vitesses de la balle
            balle.setX(balle.getX());
            balle.setY(balle.getY());
            balle.setVelocity(0, 0); // Arrête la balle
        }
    } else {
        collisionTime = 0;

    }
    System.out.println("Temps de collision : " + collisionTime);


    // Mettre à jour la balle
    balle.update(deltaTime);
    // Définition la projection de la caméra
    batch.setProjectionMatrix(camera.combined);
    // Dessin de la balle
    batch.begin();
    batch.draw(balleTexture,balle.getX(),balle.getY(),balleTexture.getWidth()/30f,balleTexture.getHeight()/30f);
    // Draw the wall
    batch.draw(wallTexture, wall.getPositionX(), wall.getPositionY(), wallTexture.getWidth()/2, wallTexture.getHeight()/10);


    batch.end();
    }


    @Override

public void dispose() {
    batch.dispose();
    balleTexture.dispose();
    font.dispose();
    }
}





