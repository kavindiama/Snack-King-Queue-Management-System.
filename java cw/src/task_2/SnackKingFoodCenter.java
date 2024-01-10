//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class SnackKingFoodCenter {
    public static int pizzaStock = 100;
    FoodQueue Cashier_one = new FoodQueue(2);
    FoodQueue Cashier_Two = new FoodQueue(3);
    FoodQueue Cashier_Three = new FoodQueue(5);
    FoodQueue[] foodQueues;
    CircularQueue circularQueue;
    Customer customer;
    private static boolean controller = true;
    private static boolean toLoop = true;
    static SnackKingFoodCenter program = new SnackKingFoodCenter();

    public SnackKingFoodCenter() {
        this.foodQueues = new FoodQueue[]{this.Cashier_one, this.Cashier_Two, this.Cashier_Three};
        this.circularQueue = new CircularQueue();
        this.customer = new Customer();
    }


    public static void main(String[] args) {
        showmenu();
        while(controller) {

            program.alertPizza();
            System.out.println("\nEnter the command: ");
            Scanner input = new Scanner(System.in);
            String option = input.next();
            System.out.println();
            SnackKingFoodCenter var10000;
            switch (option.toUpperCase().trim()) {
                case "100":
                case "VFQ":
                    program.ViewAllQueues(program.foodQueues);
                    break;
                case "101":
                case "VEQ":
                    program.viewAllEmptyQueues();
                    break;
                case "102":
                case "ACQ":
                    program.addCustomerToQueue();
                    break;
                case "103":
                case "RCQ":
                    program.removeCustomerFromSpecificLocation();
                    break;
                case "104":
                case "PCQ":
                    program.removeServedcustomer();
                    break;
                case "105":
                case "VCS":
                    program.sortedNameList();
                    break;
                case "106":
                case "SPD":
                    program.saveDataFile();
                    break;
                case "107":
                case "LPD":
                    program.loadProgramData();
                    break;
                case "108":
                case "STK":
                    var10000 = program;
                    viewRemainingPizza();
                    break;
                case "110":
                case "IFQ":
                    program.IncomeByeachCashier();
                    break;
                case "109":
                case "AFS":
                    var10000 = program;
                    addPizzaToStock();
                    break;
                case "999":
                case "EXT":
                    exitProgram();
                    break;
                default:
                    System.out.println("Input a valid option");
            }
        }

    }

    private static void showmenu() {
        System.out.println("Welcome to Snack King Food Center");
        System.out.println("*".repeat(25));
        System.out.println("*\t\tCashiers\t\t*");
        System.out.println("*".repeat(25));
        System.out.println("100. VFQ :View all queues.");
        System.out.println("101. VEQ :View Empty Queues.");
        System.out.println("102. ACQ :Add customer to queue.");
        System.out.println("103. RCQ :Remove a customer from a queue.");
        System.out.println("104. PCQ :Remove a served customer.");
        System.out.println("105. VCS :View customer sorted in alphabetical order.");
        System.out.println("106. SPD :Store program data into file.");
        System.out.println("107. LPd :Load program data from file.");
        System.out.println("108. STK :View remaining burgers to stock.");
        System.out.println("109. AFS :Add burgers to stock.");
        System.out.println("999. AXT :Exit the program.");
    }

    public void ViewAllQueues(FoodQueue[] array) {
        PrintStream var10000 = System.out;
        String var10001 = "*".repeat(20);
        var10000.println(var10001 + "\n* Cashiers *\n" + "*".repeat(20));
        int MaxLengthQueue = array[array.length - 1].getMaxLength();

        for(int i = 0; i < MaxLengthQueue; ++i) {
            StringBuilder row = new StringBuilder();
            FoodQueue[] var5 = this.foodQueues;
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                FoodQueue queue = var5[var7];
                if (i < queue.getMaxLength()) {
                    row.append("  ");
                    row.append(queue.replaceEmptyWithNull(i) != null ? "O" : "X");
                } else {
                    row.append("   ");
                }
            }

            System.out.println(row);
        }

        var10000 = System.out;
        var10001 = "-".repeat(30);
        var10000.println(var10001 + "\nX - Not Occupied, O - Occupied\n" + "-".repeat(30));
    }

    public void viewAllEmptyQueues() {
        if (this.Cashier_one.isEmpty()) {
            System.out.println("Cashier 1 is Empty \n");
        } else if (this.Cashier_one.isFull()) {
            System.out.println("Cashier 1 is Empty \n");
        } else {
            System.out.println("Cashier 1 got More Spaces \n");
        }

        if (this.Cashier_Two.isEmpty()) {
            System.out.println("Cashier 2 is Empty \n");
        } else if (this.Cashier_Two.isFull()) {
            System.out.println("Cashier 2 is Empty \n");
        } else {
            System.out.println("Cashier 2 got More Spaces \n");
        }

        if (this.Cashier_Three.isEmpty()) {
            System.out.println("Cashier 3 is Empty \n");
        } else if (this.Cashier_Three.isFull()) {
            System.out.println("Cashier 3 is Empty \n");
        } else {
            System.out.println("Cashier 3 got More Spaces \n");
        }

    }

    public void addCustomerToQueue() {
        Customer customer = new Customer();
        customer.gettingNames();
        customer.getId();
        customer.gettingNumberOfPizza();
        this.circularQueue.enQueue(customer);
        FoodQueue[] var2 = this.foodQueues;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            FoodQueue queue = var2[var4];
            if (!queue.isFull()) {
                PrintStream var10000 = System.out;
                int var10001 = customer.getId();
                var10000.println("" + var10001 + " :" + customer.getFirstName() + " :" + customer.getLastName() + " : added");
                queue.addCustomer(customer);
                this.circularQueue.deQueue();
                return;
            }
        }

    }

    public void removeCustomerFromSpecificLocation() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("please enter the cashier number: ");
            int CashierLocation = input.nextInt();
            if (CashierLocation > 0 && CashierLocation <= this.foodQueues.length) {
                FoodQueue selectedQueue = this.foodQueues[CashierLocation - 1];
                if (selectedQueue.isEmpty()) {
                    System.out.println("the queue is empty");
                } else {
                    System.out.println("please enter the customer position: ");
                    int CustomerPosition = input.nextInt();
                    if (CustomerPosition > 0 && CustomerPosition <= selectedQueue.getQueue().size()) {
                        PrintStream var10000;
                        int var10001;
                        if (this.circularQueue.isEmpty()) {
                            selectedQueue.RemoveCustomerFromAnIndex(CustomerPosition);
                            var10000 = System.out;
                            var10001 = this.customer.getId();
                            var10000.println("" + var10001 + " :" + this.customer.getFirstName() + " :" + this.customer.getLastName() + " : Removed");
                        } else if (!this.circularQueue.isEmpty()) {
                            selectedQueue.RemoveCustomerFromAnIndex(CustomerPosition);
                            Customer replaceCustomer = (Customer)this.circularQueue.deQueue();
                            selectedQueue.addCustomer(replaceCustomer);
                            var10000 = System.out;
                            var10001 = this.customer.getId();
                            var10000.println("" + var10001 + " :" + this.customer.getFirstName() + " :" + this.customer.getLastName() + " : Is");
                            System.out.println("customer moved from circular waitingQueue");
                        }
                    }
                }
            } else {
                System.out.println("invalid queue");
            }
        } catch (InputMismatchException var6) {
            System.out.println("input an integer");
            input.nextLine();
        } catch (ArrayIndexOutOfBoundsException var7) {
            System.out.println("invalid queue");
        }

    }

    public void removeServedcustomer() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("please enter the cashier number: ");
            int CashierLocation = input.nextInt();
            if (CashierLocation > 0 && CashierLocation <= this.foodQueues.length) {
                FoodQueue selectedQueue = this.foodQueues[CashierLocation - 1];
                if (selectedQueue.isEmpty()) {
                    System.out.println("the queue is empty");
                } else if (this.circularQueue.isEmpty()) {
                    pizzaStock -= selectedQueue.getPizzaAmount(0);
                    selectedQueue.RemoveServedCustomer();
                } else if (!this.circularQueue.isEmpty()) {
                    selectedQueue.RemoveServedCustomer();
                    PrintStream var10000 = System.out;
                    int var10001 = this.customer.getId();
                    var10000.println("" + var10001 + " :" + this.customer.getFirstName() + " :" + this.customer.getLastName());
                    System.out.println("customer removed");
                    Customer replacecustomer = (Customer)this.circularQueue.deQueue();
                    selectedQueue.addCustomer(replacecustomer);
                    System.out.println("customer moved from circular waitingQueue");
                } else {
                    System.out.println("input a valid queue number");
                }
            }
        } catch (InputMismatchException var5) {
            System.out.println("input an integer");
            input.nextLine();
        }

    }

    public void sortedNameList() {
        FoodQueue[] var1 = this.foodQueues;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            FoodQueue foodQueue = var1[var3];
            ArrayList<String> CustomerFullName = new ArrayList();
            Iterator var6 = foodQueue.getQueue().iterator();

            while(var6.hasNext()) {
                Customer customer = (Customer)var6.next();
                String var10001 = customer.getFirstName();
                CustomerFullName.add(var10001 + " " + customer.getLastName());
            }

            int n = CustomerFullName.size();

            for(int i = 0; i < n - 1; ++i) {
                for(int j = 0; j < n - i - 1; ++j) {
                    if (((String)CustomerFullName.get(j)).compareTo((String)CustomerFullName.get(j + 1)) > 0) {
                        String temp = (String)CustomerFullName.get(j);
                        CustomerFullName.set(j, (String)CustomerFullName.get(j + 1));
                        CustomerFullName.set(j + 1, temp);
                    }
                }
            }

            System.out.println(CustomerFullName);
        }

    }

    public static void viewRemainingPizza() {
        System.out.println("available stock is : " + pizzaStock);
    }

    public static void addPizzaToStock() {
        try {
            Scanner input = new Scanner(System.in);
            int pizzaTobeAdded =0;
            int MaxAdded = 100 - pizzaStock;


            do {
                System.out.println("Eneter the PIZZA AMOUNT TO BE ADDED :");
                pizzaTobeAdded = input.nextInt();
                if (pizzaTobeAdded > MaxAdded && MaxAdded <= 0) {
                    System.out.println(" Pizza amout Should be lessthan 0 or Morethan 100 ");
                } else {
                    pizzaStock += pizzaTobeAdded;
                    System.out.println("pizza  amont is added");
                }
            } while(pizzaTobeAdded > MaxAdded);
        } catch (InputMismatchException var3) {
            System.out.println("Input a Interger");
        }

    }

    public void IncomeByeachCashier() {
        System.out.println("Income By The 1st cashier " + this.Cashier_one.getQueueIncome());
        System.out.println("Income By The 2nd cashier " + this.Cashier_Two.getQueueIncome());
        System.out.println("Income By The 3rd cashier " + this.Cashier_Three.getQueueIncome());
    }

    public void alertPizza() {
        if (pizzaStock <= 20) {
            System.out.println("\t\tAlert !!! \n only " + pizzaStock + " pizza left!!!\n\t select 109 or AFS");
            if (pizzaStock <= 0) {
                System.out.println("pizza count reaches zero please add more\n");
            }
        }

    }

    private static void exitProgram() {
        System.out.println("Thank you");
        toLoop = false;
    }

    public void saveDataFile() {
        try {
            FileWriter writer = new FileWriter("Data.txt", false);
            writer.write(pizzaStock + "\n");
            this.Cashier_one.saveCustomer(writer);
            this.Cashier_Two.saveCustomer(writer);
            this.Cashier_Three.saveCustomer(writer);
            writer.close();
            System.out.println("Successfully, Data Added\n");
        } catch (IOException var2) {
            throw new RuntimeException(var2);
        }
    }

    public void loadProgramData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));

            try {
                String pizzaStockStr = reader.readLine();
                pizzaStock = Integer.parseInt(pizzaStockStr);
                this.Cashier_one.loadCustomer(reader);
                this.Cashier_Two.loadCustomer(reader);
                this.Cashier_Three.loadCustomer(reader);
                System.out.println("Data Loaded Successfully\n");
            } catch (Exception var5) {
                try {
                    reader.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            reader.close();
        } catch (IOException | NumberFormatException var6) {
            System.out.println("Error loading data from the file: " + var6.getMessage());
        }

    }
}
