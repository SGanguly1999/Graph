public class MazeProblemData extends Data {
    int x,y;
    public MazeProblemData(int x, int y) {
        super(0);
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "("+x+","+y+")";
    }
    public boolean validate(Data obj) {
        MazeProblemData obj1 = (MazeProblemData) obj;
        if (obj1.x == x && obj1.y == y) {
            return true;
        } else
            return false;
    }

}
