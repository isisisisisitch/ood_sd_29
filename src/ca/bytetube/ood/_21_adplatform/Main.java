package ca.bytetube.ood._21_adplatform;

public class Main {
    public static void main(String[] args) {
        AdRegister register = AdRegister.defaultService();
        register.insertAd("laptop discount", 50);
        register.insertAd("phone launch", 80);
        register.insertAd("grocery coupons", 50);

        System.out.println("First ad:" + register.getAd());
        System.out.println("Second ad:" + register.getAd());
        System.out.println("Third ad:" + register.getAd());
        System.out.println("No more ad:" + register.getAd());
    }
}
