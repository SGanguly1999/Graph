public class StateNode {
    double x,y;
    public StateNode(double x) {
        this.x = x;
        this.y = func(x);
    }
    public  double func(double x) {
        y = Math.pow(x,2);
        return y;
    }

    @Override
    public String toString() {
        return ""+x;
    }
}
