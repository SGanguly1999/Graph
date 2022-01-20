public class WaterJugData extends Data {
    int x;
    int y;

    public WaterJugData(int x, int y) {
        super(0);
        this.x = x;
        this.y = y;
    }

    public boolean validate(Data obj) {
        WaterJugData obj1 = (WaterJugData) obj;
        if (obj1.x == x && obj1.y == y) {
            return true;
        } else
            return false;
    }
    public String toString(){
        return "\""+this.x+" "+this.y+"\"";
    }
}
