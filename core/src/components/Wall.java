package components;

import com.badlogic.gdx.graphics.Texture;

public class Wall {
    private int positionX;
    private int positionY;
    private int length;
    private int height;
    private Texture texture;

    public Wall(int positionX, int positionY, int length, int height) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.length = length;
        this.height = height;
    }
    //Definition of all the getters
    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Texture getTexture() {
        return texture;
    }

    // Method to change the position of the wall
    public void changePosition(int newPositionX, int newPositionY) {
        this.positionX = newPositionX;
        this.positionY = newPositionY;
    }

    // Method to resize the wall
    public void resize(int newLength, int newHeight) {
        this.length = newLength;
        this.height = newHeight;
    }

}
