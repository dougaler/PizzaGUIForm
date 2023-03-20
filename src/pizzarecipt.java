import java.util.ArrayList;

public class pizzarecipt {
    private int yourResult;
    double topperPrice;
    double sizePrice;
    double taxMan;
    double totalSansTax;
    double totalWTax;
    String resultPrint;


    /**
     * Method to determine the results of the game
     */
    public double getSizePrice(String size) {
        switch (size) {
            case "Small":
                sizePrice = 8.00;
                break;
            case "Medium":
                sizePrice = 12.00;
                break;
            case "Large":
                sizePrice = 16.00;
                break;
            case "Super":
                sizePrice = 20.00;
                break;
        }
        return sizePrice;
    }
    public double getTotalSansTax(double sizePrice, ArrayList<String> toppers) {
        totalSansTax = sizePrice + toppers.size();
        return totalSansTax;
    }
    public double getTaxMan(double totalSansTax) {
        taxMan = totalSansTax*0.07;
        return taxMan;
    }
    public double getTotalWTax(double totalSansTax,double taxMan) {
        totalWTax = totalSansTax + taxMan;
        return totalWTax;
    }
}