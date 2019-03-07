public abstract class Character{
    
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected int velX;
    protected int velY;
    protected boolean dir;
    protected int life;


    public Character() {
    }

    public Character(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.velY = velY;
        this.dir = dir;
        this.life = life;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVelX() {
        return this.velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return this.velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public boolean isDir() {
        return this.dir;
    }

    public boolean getDir() {
        return this.dir;
    }

    public void setDir(boolean dir) {
        this.dir = dir;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String toString() {
        return "{" +
            " posX='" + getPosX() + "'" +
            ", posY='" + getPosY() + "'" +
            ", width='" + getWidth() + "'" +
            ", height='" + getHeight() + "'" +
            ", velX='" + getVelX() + "'" +
            ", velY='" + getVelY() + "'" +
            ", dir='" + isDir() + "'" +
            ", life='" + getLife() + "'" +
            "}";
    }

    public abstract void mover();
    public abstract void paint();
    public abstract void ataca();

}