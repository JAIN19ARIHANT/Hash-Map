import java.util.Arrays;

public class GenericsClient {
    public static void main(String[] args) {
        genric <String> gd = new genric<String>();
        gd.name = "abc";
        System.out.println(gd.name);

        Integer[] num = {1,2,3};
        String[] str = {"abc" , "def"};
//        gd.display(num);
        gd.display(str);

    }
}
class genric<T>{
    T name;
    public void display(T[] array){
        System.out.println(Arrays.toString(array));
    }
//    public void display(Object[] array) {
//        System.out.println(Arrays.toString(array));       // from copilot
//    }
}
