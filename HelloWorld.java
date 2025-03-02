import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {

        int[] nums = {3, 5, 6, 7, 22, 56, 91, 270};
        int index = Arrays.binarySearch(nums, 7);
        System.out.println(index);
    }

}
