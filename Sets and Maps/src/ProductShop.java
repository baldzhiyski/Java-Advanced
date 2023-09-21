import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String,Map<String,Double>> shopMap = new LinkedHashMap<>();
        while(!input.equals("Revision")){
            String[] data = input.split(", ");
            String shopName = data[0];
            String productName = data[1];

            double price = Double.parseDouble(data[2]);
            shopMap.putIfAbsent(shopName,new LinkedHashMap<>());
            shopMap.get(shopName).put(productName,price);

            input=scan.nextLine();
        }
        shopMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(shop->{
                    System.out.println(shop.getKey() + "->");
                    shop.getValue().entrySet()
                            .forEach(product->
                                    System.out.printf("Product: %s, Price: %.1f%n",product.getKey(),product.getValue()));
                });


    }
}
