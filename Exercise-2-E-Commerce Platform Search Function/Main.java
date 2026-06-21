import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Product[]  p1 = {
                new Product(1,"Laptop","Electronics"),
                new Product(6,"Mobile", "Electronics"),
                new Product(3,"Watch","Electronics"),
                new Product(2,"Dress","Fashion"),
                new Product(5,"Shoe","Fashion"),
                new Product(4,"Necklace","Fashion")
        };

        int target = 4;

        System.out.println("Linear Search:");
        LinearSearch.search(p1,target);
        System.out.println();

        Arrays.sort(p1,(a,b)->a.productId - b.productId);
        System.out.println("Binary Search: ");
        BinarySearch.search(p1,target);
    }
}