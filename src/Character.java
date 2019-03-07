public abstract class Character{
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected int velX;
    protected int Vely;
    protected boolean dir;
    protected int life;


    public Character() {
    }

    public Character(int posX, int posY, int width, int height, int velX, int Vely, boolean dir, int life) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.Vely = Vely;
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

    public int getVely() {
        return this.Vely;
    }

    public void setVely(int Vely) {
        this.Vely = Vely;
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

    public Character posX(int posX) {
        this.posX = posX;
        return this;
    }

    public Character posY(int posY) {
        this.posY = posY;
        return this;
    }

    public Character width(int width) {
        this.width = width;
        return this;
    }

    public Character height(int height) {
        this.height = height;
        return this;
    }

    public Character velX(int velX) {
        this.velX = velX;
        return this;
    }

    public Character Vely(int Vely) {
        this.Vely = Vely;
        return this;
    }

    public Character dir(boolean dir) {
        this.dir = dir;
        return this;
    }

    public Character life(int life) {
        this.life = life;
        return this;
    }

    public String toString() {
        return "{" +
            " posX='" + getPosX() + "'" +
            ", posY='" + getPosY() + "'" +
            ", width='" + getWidth() + "'" +
            ", height='" + getHeight() + "'" +
            ", velX='" + getVelX() + "'" +
            ", Vely='" + getVely() + "'" +
            ", dir='" + isDir() + "'" +
            ", life='" + getLife() + "'" +
            "}";
    }

    public abstract void mover();

    public abstract void paint();

    
}