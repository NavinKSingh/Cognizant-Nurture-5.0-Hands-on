public class BinarySearch{
    public static void search(Product[] p1, int target){

        boolean found = false;

        int low = 0;
        int high = p1.length - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(p1[mid].productId == target){
                found = true;
                System.out.println("Product Found!");
                System.out.println("Product Id: " + p1[mid].productId);
                System.out.println("Product Name: " + p1[mid].productName);
                System.out.println("Category: " + p1[mid].category);

                break;

            }else if(p1[mid].productId < target){
                low = mid + 1;

            }else{
                high = mid - 1;
            }
        }
        if(!found){
            System.out.println("Not Found!");
        }
    }
}