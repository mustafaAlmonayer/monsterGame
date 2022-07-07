public class Monster {
    private final String NAME;
    private final char CODE;
    private final int DMG;
    private final int MOV;
    private int health;
    private int xPos;
    private int yPos;
    private boolean alive;

    public Monster(String NAME){
        this.NAME = NAME;
        this.CODE = NAME.charAt(0);
        this.health = 10000;
        this.DMG = 1000;
        this.MOV = 1;
        this.xPos = -1;
        this.yPos = -1;
        this.alive = true;

    }

    public char getCODE() {
        return CODE;
    }

    public int getDMG() {
        return DMG;
    }

    public int getXPos() {
        return xPos;
    }
    public int getYPos() {
        return yPos;
    }
    public int getHealth() {
        return health;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setHealth(int health) {
        this.health = health;

        if (health <= 0){
            this.alive = false;
        }
    }
    @Override
    public String toString() {
        return "Name: " + this.NAME + ", Code: " + this.CODE + ", Health: " + this.health + ", DMG: " + this.DMG
                + ", MOV: " + this.MOV + ", xPos: " + this.xPos + ", yPos: " + this.yPos + ", isAlive: " + this.alive;
    }
}
