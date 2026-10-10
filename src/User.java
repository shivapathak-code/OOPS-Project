public class User {
    protected String name;
    protected String phone;

    public User(String name ,String phone)
    {
        this.name = name;
        this.phone = phone;
    }
    public void displayProfile()
    {
        System.out.println("Name : "+name+"Phone : "+phone);
    }
}
//  class Rider extends User{
//    private UserWallet wallet; // rider "has A relation" wallet;
//     public Rider(String name, String phone , double initialBalance) {
//         super(name, phone);
//         this.wallet = new UserWallet(initialBalance);
//     }
//     public UserWallet getWallet()
//     {
//         return wallet;
//     }
// }
//  class Driver extends User
// {
//     private String licenseNumber;
//     private String vehicalModal;
//
//     public Driver(String name, String phone ,String licenseNumber ,String vehicalModal ) {
//         super(name, phone);
//         this.licenseNumber = licenseNumber;
//         this.vehicalModal = vehicalModal;
//     }
//     public void acceptRide()
//     {
//         System.out.println(name+"accepted the ride in a "+vehicalModal);
//     }
//
// }
