public class LinearSearch{
    public static void search(Product[] p1, int target){

        boolean found = false;

        for(int i = 0; i < p1.length; i++){

            if(p1[i].productId == target){

                found = true;
                System.out.println("Product Found!");
                System.out.println("Product Id: " + p1[i].productId);
                System.out.println("Product Name: " + p1[i].productName);
                System.out.println("Category: " + p1[i].category);

                break;
            }
        }
        if(!found){
            System.out.println("Not Found!");
        }
    }
}