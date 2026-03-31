package jour02.job03;

public class FiguresGeometriques{
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(6, 11, 8, 2);
        System.out.println(r1.Surface());

        Cercle c1 = new Cercle(3, 5, 8);
        System.out.printf("%b%n",c1.estInterieur(2, 6));

        RectangleColore r2 = new RectangleColore(8, 13, 12, 32, 2);
        System.out.println(r2.getColor());
    }
}

class Rectangle extends Figure {
    protected double largeur;
    protected double longueur;

    public Rectangle(double largeur, double longueur, double x, double y) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public double Surface() {
        return this.longueur * this.largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
}

class Cercle extends Figure{
    protected double rayon;

    public Cercle(double x, double y, double rayon) {
        super(x, y);
        this.rayon = rayon;
    }

    @Override
    public void affiche() {
        System.out.println("Cercle de centre (" + this.x + ", " + this.y + ") et de rayon " + this.rayon);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double surface(){
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distance <= this.rayon;
    }

    public double getRayon(){
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
}

class RectangleColore extends Rectangle {
    protected int couleur;
    
    public RectangleColore(double largeur, double longueur, double x, double y, int couleur) {
        super(largeur, longueur, x, y);
        this.couleur = couleur;
    }

    public int getColor() {
        return couleur;
    }

    public void setColor(int couleur) {
        this.couleur = couleur;
    }
}

class Figure {
    public double x;
    public double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void affiche(){
        System.out.println("Cercle de la gigure (" + this.x + ", " + this.y + ")");
    }

    public void setCentre(double x, double y){
        this.x = x;
        this.y = y;
    }
}