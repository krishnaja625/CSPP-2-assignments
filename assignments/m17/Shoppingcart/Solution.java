
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart scart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] token = scan.nextLine().split(" ");
            switch (token[0]) {
                case "Item":
                String[] data = token[1].split(",");
                scart.addToCatalog(new Item(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2])));
                break;
                case "catalog":
                scart.showCatalog();
                break;
                case "add":
                String[] data1 = token[1].split(",");
                scart.addToCart(new Item(data1[0], Integer.parseInt(data1[1])));
                break;
                case "remove":
                String[] data2 = token[1].split(",");
                scart.addToCart(new Item(data2[0], Integer.parseInt(data2[1])));
                break;
                case "show":
                scart.showCart();
                break;
                case "totalAmount":
                System.out.println("totalAmount:" + scart.getTotalAmount());
                break;
                case "payableAmount":
                System.out.println("Payable amount:" + scart.getPayableAmount());
                break;
                case "print":
                scart.printInvoice();
                case "coupon":
                scart.applyCoupon(token[1]);
                break;
                default:
            }
        }
    }
}
