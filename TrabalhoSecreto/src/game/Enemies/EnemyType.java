package game.Enemies;

public enum EnemyType {
    TEAMROCKET(3),
    EU(5);

    private int lifes;

    EnemyType(int lifes) {
        this.lifes = lifes;
    }

    public int getLifes() {
        return lifes;
    }
    }
