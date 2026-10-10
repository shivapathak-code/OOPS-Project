public class RideNowApp {
    public static void main(String[] args)
    {

                System.out.println("--- Welcome to RideNow ---\n");

                // 1. Create Users (Inheritance & Encapsulation)
                Rider jay = new Rider("Jay ", "9876543210", 5000.0);
                Driver sanjay = new Driver("Sanjay", "1234567890", "LIC12345", "Toyota Hydrer");

                //2. New : 2nd rider (paying with UPI)
                Rider nancy=new Rider("Nancy","1239638782",3000.0);
                Driver naitik=new Driver("Naitik","7894563570","LIC12345","BMW");

                System.out.println("------ User Profile-------");
                System.out.println("Rider1 Information who booked the ride.");
                jay.displayProfile();
                System.out.println();

                System.out.println("Rider2 Information who booked the ride.");
                nancy.displayProfile();
                System.out.println();

                System.out.println("-------Driver Profile--------");
                System.out.println("Driver1 Profile who accepted the ride.");
                sanjay.displayProfile();
                System.out.println();

                System.out.println("Driver2 Profile who accepted the ride.");
                naitik.displayProfile();
                System.out.println();


                // 2. Book a Ride (Classes & Objects)
                System.out.println("----Jay's Ride-------");
                Ride morningCommute = new Ride("Connught Place", "IPEC, Sahibabad", 25.0);
                morningCommute.startRide();
                sanjay.acceptRide();

                // 3. Calculate Fare (Polymorphism)
                PremiumPricing pricing = new PremiumPricing();
                double fare = pricing.calculateFare(25.0, 20.0); // 10km with a ₹2 discount
                System.out.println("Total fare for the ride: ₹" + fare);

                // 4. Process Payment (Abstraction)
                if (jay.getWallet().deductMoney(fare)) {
                    // Using interface reference to hold an object
                    PaymentProcessor paymentMethod = new CreditCardPayment("4111222233334444");
                    paymentMethod.processPayment(fare);
                    System.out.println("Ride completed successfully! Remaining wallet balance: ₹" + jay.getWallet().getBalance());
                } else {
                    System.out.println("Insufficient funds in wallet.");
                }
                System.out.println("\n===================================\n");

                // 5. Book a Ride (Classes & Objects)
                System.out.println("----Nacny's Ride-------");
                Ride eveningRide = new Ride("Ramprastha ", "IPEC, Sahibabad", 25.0);
                eveningRide.startRide();
                naitik.acceptRide();

                // 6. Calculate Fare (Polymorphism)
                double fareNancy = pricing.calculateFare(18.0, 10.0); // 10km with a ₹2 discount
                System.out.println("Total fare for the ride: ₹" + fare);

                // 7. Process Payment (Abstraction)
                if (nancy.getWallet().deductMoney(fareNancy)) {
                    // Using interface reference to hold an object
                    PaymentProcessor paymentMethod = new UpiPayment("nancy@paytm");
                    paymentMethod.processPayment(fareNancy);
                    System.out.println("Ride completed successfully! Remaining wallet balance: ₹" + nancy.getWallet().getBalance());
                } else {
                    System.out.println("Insufficient funds in wallet.");
                }
                System.out.println("\n========================================\n");
                System.out.println("--- All rides completed! Thank you for choosing RideNow ---");
            }
}