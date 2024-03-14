package com.mygdx.flipper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball {
       
    private float x, y; // Position de la balle
    private float velocityX, velocityY; // Vitesse de la balle
    private static final float GRAVITY = 9.81f; // Constante de gravité
    private float angle = 6.5f; // Angle d'inclinaison du plan en degrés
    private float pixelToMeters = 462f;    //Paramètre à mettre dans le fichier des paramètres pour ne pas avoir à le coder en dur
    private Texture balleTexture; // Image de la balle
    private int imageWidth, imageHeight; // Dimensions de l'image de la balle en pixels
    private float scaleX, scaleY; // Facteurs d'échelle pour redimensionner la balle


    public Ball(float x, float y) {
        this.x = x;
        this.y = y;
        this.velocityX = 0; // La balle démarre sans vitesse horizontale
        this.velocityY = 0; // La balle démarre sans vitesse verticale
        balleTexture = new Texture("ball.png");
        this.imageWidth = balleTexture.getWidth();
        this.imageHeight = balleTexture.getHeight();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    public void update(float deltaTime) {
        
        // Mettre à jour la vitesse en fonction de la gravité
        float angleRadians = (float) Math.toRadians(angle);
        velocityY -= GRAVITY * (float) Math.sin(angleRadians) * deltaTime;

        // Mettre à jour la position en fonction de la vitesse
        x += velocityX * deltaTime * pixelToMeters;
        y += velocityY * deltaTime * pixelToMeters;

        //Détecter la collision avec le bas de la fenêtre
        if(y<0) {           
            y = 0;

        // Empêcher la balle de passer en dessous de la fenêtre
           velocityY=0;
        // Arrêter la balle lorsque la collision est détectée
       
    }
}

    //Definition of all the getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    // Méthodes pour définir la vitesse de la balle
    public void setVelocity(float velocityX, float velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    // public void resize (int windowWidth, int windowHeight) {
    //     // Calculer les nouveaux facteurs d'échelle en fonction des dimensions de la fenêtre
    //     float newScaleX = (float) windowWidth / (float) imageWidth;
    //     float newScaleY = (float) windowHeight / (float) imageHeight;

    //     // Appliquer les nouveaux facteurs d'échelle
    //     scaleX = newScaleX;
    //     scaleY = newScaleY;
    // }
    
//     public void draw(SpriteBatch batch) {
//         // Dessiner la balle en utilisant les facteurs d'échelle
//         batch.draw(balleTexture, x, y, imageWidth * scaleX, imageHeight * scaleY);
//     }

//     public void setWindowSize(float windowHeight) {
//         // Par exemple, vous pouvez adapter pixelsToMeters en fonction de la nouvelle taille de la fenêtre
//         float screenHeight = Gdx.graphics.getHeight();
//         float flipperHeight = 1.3f;
//         pixelToMeters = screenHeight / flipperHeight;


//     }
}




