package game.Enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum EnemyType {
    MENDANHA (3),
    MARGARIDA(3),
    ANDREIA (3),
    MONSTER (1),
    EU(5);

    private int lifes;
    private Picture picture;

    EnemyType(int lifes) {
        this.lifes = lifes;
    }



    public int getLifes() {
        return lifes;
    }
    }
