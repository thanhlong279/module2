import java.util.Random;

public class Demo {
    public Integer[] createRandom(){
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println(" danh sach phan tu cua mang: ");
        for(int i = 0; i < 100; i++){
            arr[i] = rd.nextInt(100);
            System.out.println(arr[i] + " ");
        }
        return arr;
    }
    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
    }
}
