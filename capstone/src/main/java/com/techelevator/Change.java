package com.techelevator;


public class Change extends Money {

       public static int dollars;
        public static int quarters;
        public static int dimes;
        public static int nickels;

        public int countDollars() {
            double currentBalance = getBalance();

            while (currentBalance > 99) {
                dollars++;
                currentBalance -= 100;

            }
            setBalance(currentBalance);
            return dollars;
        }

        public int countQuarters() {
            double currentBalance = getBalance();

            while (currentBalance > 24) {
                quarters++;
                currentBalance -= 25;
            }
            setBalance(currentBalance);
            return quarters;
        }

        public int countDimes() {
            double currentBalance = getBalance();

            while (currentBalance > 9) {
                dimes++;
                currentBalance -= 10;
            }
            setBalance(currentBalance);
            return dimes;
        }

        public int countNickels() {
            double currentBalance = getBalance();

            while (currentBalance > 4) {
                nickels++;
                currentBalance -= 5;
            }
            setBalance(currentBalance);
            return nickels;
        }


        private void clearBalance() {
            setBalance(0.0);
        }

        public void printChange(){
            System.out.println(countDollars());
            System.out.println(countQuarters());
            System.out.println(countDimes());
            System.out.println(countNickels());

        }

//    public static void main(String[] args) {
//            Change balance = new Change();
//        balance.setBalance(970);
//        System.out.println(balance.getBalance());
//        balance.printChange();
//    }



} /** End of Class **/
