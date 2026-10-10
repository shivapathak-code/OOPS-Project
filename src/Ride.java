public class Ride {
    // here is Attribute(states) to our project;
    String pickupLocation;
    String dropLocation;
    double distanceInKm;

    // here is crete constructor;that is parametrized constructor;
    Ride(String pickupLocation , String dropLocation , double distanceInKm)
    {
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distanceInKm = distanceInKm;
    }
    // that is method also called behavior;
    public void startRide()
    {
        System.out.println("Ride started from "+pickupLocation+" to "+dropLocation);
    }

}
class start
{
    public static void main(String[] args)
    {
        //here is create a object;
        Ride R1 = new Ride("IPEC" , "HazratNizamuddeen" , 12);
        R1.startRide();
        Ride R2 = new Ride("IPEC" , "Vaishali" , 2);
        R2.startRide();
        Ride R3 = new Ride("IPEC" , "KashmeriGate" , 20);
        R3.startRide();
    }
}
