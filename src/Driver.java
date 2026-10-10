public class Driver extends User{

        private String licenseNumber;
        private String vehicalModal;

        public Driver(String name, String phone ,String licenseNumber ,String vehicalModal ) {
            super(name, phone);
            this.licenseNumber = licenseNumber;
            this.vehicalModal = vehicalModal;
        }
        public void acceptRide()
        {
            System.out.println(name+"accepted the ride in a "+vehicalModal);
        }

    }

