public class Data {
    int data;
    public Data(int data){
        this.data = data;
    }
    public boolean validate(Data obj) {
        if(obj.data == data) {
            return true;
        }
        else
            return false;
    }
    public String toString() {
        return ""+data;
    }
}
