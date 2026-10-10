public class Rider extends User {

        private UserWallet wallet; // rider "has A relation" wallet;
        public Rider(String name, String phone , double initialBalance) {
            super(name, phone);
            this.wallet = new UserWallet(initialBalance);
        }
        public UserWallet getWallet()
        {
            return wallet;
        }
}
