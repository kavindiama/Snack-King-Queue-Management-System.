//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package task_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SnackKingFoodCenter {
    public static String[] queue_one = new String[]{"X", "X"};
    public static String[] customers_queue_one = new String[]{"", ""};
    public static String[] queue_two = new String[]{"X", "X", "X"};
    public static String[] customers_queue_two = new String[]{"", "", ""};
    public static String[] queue_three = new String[]{"X", "X", "X", "X", "X"};
    public static String[] customers_queue_three = new String[]{"", "", "", "", ""};
    public static String customerName;
    public static boolean toLoop = true;
    public static int pizzaStock = 100;
    public static boolean controller = true;

    public SnackKingFoodCenter() {
    }

    public static void main(String[] args) {
        showmenu();

        while(controller) {
            System.out.println("\nEnter the command: ");
            Scanner input = new Scanner(System.in);
            String option = input.next();
            System.out.println();
            switch (option.toUpperCase().trim()) {
                case "100":
                case "VFQ":
                    viewAllQueues();
                    break;
                case "101":
                case "VEQ":
                    viewAllEmptyQueues();
                    break;
                case "102":
                case "ACQ":
                    addCustomerToQueue();
                    break;
                case "103":
                case "RCQ":
                    removeCustomerFromSpecificLocation();
                    break;
                case "104":
                case "PCQ":
                    removeServedcustomer();
                    break;
                case "105":
                case "VCS":
                    sortedNameList();
                    break;
                case "106":
                case "SPD":
                    storeData();
                    break;
                case "107":
                case "LPD":
                    loadProgramData();
                    break;
                case "108":
                case "STK":
                    viewRemainingPizza();
                    break;
                case "109":
                case "AFS":
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

    public static void viewAllQueues() {
        System.out.println("*".repeat(20));
        System.out.println("* Cashier *");
        System.out.println("*".repeat(20));
        String var10001 = queue_one[0];
        System.out.println("  " + var10001 + "   " + queue_two[0] + "   " + queue_three[0] + " ");
        var10001 = queue_one[1];
        System.out.println("  " + var10001 + "   " + queue_two[1] + "   " + queue_three[1] + " ");
        var10001 = queue_two[2];
        System.out.println("      " + var10001 + "   " + queue_three[2] + " ");
        System.out.println("          " + queue_three[3] + " ");
        System.out.println("          " + queue_three[4] + " ");
    }

    public static void viewAllEmptyQueues() {
        System.out.print(" Queue 1: ");
        checkEmpty(queue_one);
        System.out.print(" Queue 2: ");
        checkEmpty(queue_two);
        System.out.print(" Queue 3: ");
        checkEmpty(queue_three);
    }

    private static void checkEmpty(String[] Array) {
        for(int index = 0; index < Array.length; ++index) {
            if (Array[index].equals("X")) {
                System.out.print(index + 1 + ",");
            }
        }

        System.out.println();
    }

    private static boolean checkFull(String[] Array) {
        for(int index = 0; index < Array.length; ++index) {
            if (!Array[index].equals("O")) {
                System.out.println("this queue has empty positions");
                return false;
            }
        }

        System.out.println("this queue is full.");
        return true;
    }

    public static void addCustomerToQueue() {
        System.out.print("\nselect a queue(1,2,3) :");
        Scanner queueNumber = new Scanner(System.in);

        try {
            int number = queueNumber.nextInt();
            switch (number) {
                case 1:
                    functionAdd(queue_one, customers_queue_one);
                    break;
                case 2:
                    functionAdd(queue_two, customers_queue_two);
                    break;
                case 3:
                    functionAdd(queue_three, customers_queue_three);
                    break;
                default:
                    System.out.println("invalid input");
            }
        } catch (InputMismatchException var2) {
            System.out.println("input a integer between 1 to 3");
        }

    }

    private static boolean nameValidation(String CustomerName) {
        for(int letter = 0; letter < CustomerName.length(); ++letter) {
            if (CustomerName.charAt(letter) > 'z' || CustomerName.charAt(letter) < 'a' || CustomerName.charAt(letter) <= 'Z' && CustomerName.charAt(letter) > 'A') {
                System.out.println("invalid name");
                return true;
            }
        }

        return false;
    }

    private static void addingCustomerName(String[] Array, String[] ArrayNames) {
        int index;
        for(index = 0; index < Array.length; ++index) {
            if (Array[index].equals("X")) {
                Array[index] = "O";
                break;
            }
        }

        for(index = 0; index < ArrayNames.length; ++index) {
            if (ArrayNames[index] == "") {
                ArrayNames[index] = customerName;
                System.out.println("customer " + customerName + " added to queue ");
                break;
            }
        }

    }

    private static void functionAdd(String[] Array, String[] nameArray) {
        if (checkFull(Array)) {
            System.out.println("Queue is full");
        } else {
            do {
                Scanner name = new Scanner(System.in);
                System.out.print("enter customer name: ");
                customerName = name.nextLine();
            } while(nameValidation(customerName));

            addingCustomerName(Array, nameArray);
        }

    }

    public static void removeServedcustomer() {
        boolean toLoop = true;
        System.out.println("for which queue would you like to serve: ");
        Scanner input = new Scanner(System.in);
        switch (input.next()) {
            case "1":
                findServedCustomer(queue_one, customers_queue_one);
                break;
            case "2":
                findServedCustomer(queue_two, customers_queue_two);
                break;
            case "3":
                findServedCustomer(queue_three, customers_queue_three);
                break;
            default:
                System.out.println("invalid queue value!!!");
        }

        showError();
    }

    private static void findServedCustomer(String[] array, String[] nameArray) {
        if (array[0].equals("O")) {
            array[0] = "X";
            System.out.println("customer served sucessfully");
            pizzaStock -= 10;

            int place;
            for(place = 0; place < nameArray.length - 1; ++place) {
                if (!nameArray[place + 1].equals("")) {
                    nameArray[place] = nameArray[place + 1];
                    nameArray[place + 1] = "";
                }
            }

            for(place = 0; place < array.length - 1; ++place) {
                if (array[place + 1].equals("O")) {
                    array[place] = "O";
                    array[place + 1] = "X";
                }
            }
        } else {
            System.out.println("queue is empty");
        }

        toLoop = !toLoop;
    }

    public static void removeCustomerFromSpecificLocation() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the queue: ");

        try {
            int Queue = input.nextInt();
            if (Queue <= 3 && Queue > 0) {
                switch (Queue) {
                    case 1:
                        getPosition(queue_one, customers_queue_one);
                        break;
                    case 2:
                        getPosition(queue_two, customers_queue_two);
                        break;
                    case 3:
                        getPosition(queue_three, customers_queue_three);
                        break;
                    default:
                        System.out.println("input valid queue");
                }
            } else {
                System.out.println("invalid queue");
                removeServedcustomer();
            }
        } catch (InputMismatchException var2) {
            System.out.println("input an integer");
        }

    }

    private static void getPosition(String[] array, String[] nameArray) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter queue position: ");
        int position = input.nextInt();
        if (0 < position && position < array.length) {
            if (array[position - 1].equals("X")) {
                System.out.println("the place is already empty");
            } else {
                int name;
                for(name = position - 1; name < array.length - 1; ++name) {
                    if (array[name + 1].equals("O")) {
                        array[name] = "O";
                        array[name + 1] = "X";
                    }
                }

                for(name = position - 1; name < nameArray.length - 1; ++name) {
                    if (!nameArray[name + 1].equals("")) {
                        nameArray[name] = nameArray[name + 1];
                        nameArray[name + 1] = "";
                    }
                }
            }
        } else {
            System.out.println("invalid position");
            getPosition(array, nameArray);
        }

    }

    public static void showError() {
        if (pizzaStock <= 20) {
            System.out.println("-".repeat(20));
            System.out.println("pizza stock is below 20\nadd more pizza to stock");
            System.out.println("-".repeat(20));
        }

    }

    public static void viewRemainingPizza() {
        System.out.println("available stock is : " + pizzaStock);
    }

    public static void addPizzaToStock() {
        try {
            Scanner input = new Scanner(System.in);
            int pizzaTobeAdd = 0;
            int MaxAdded = 100 - pizzaStock;


            do {
                System.out.println("enter the pizza amount to be added: ");
                pizzaTobeAdd = input.nextInt();
                if (pizzaTobeAdd > MaxAdded && MaxAdded <= 0) {
                    System.out.println("pizza amount should be less than 0 or more than 100");
                } else {
                    pizzaStock += pizzaTobeAdd;
                    System.out.println("pizza amount is added");
                }
            } while(pizzaTobeAdd > MaxAdded);
        } catch (InputMismatchException var3) {
            System.out.println("input a integer");
        }

    }

    public static void bubbleSort(String[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = 0; j < arr.length - i - 1; ++j) {
                if (compareNames(arr[j], arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int compareNames(String name1, String name2) {
        for(int i = 0; i < Math.min(name1.length(), name2.length()); ++i) {
            if (name1.charAt(i) != name2.charAt(i)) {
                return name1.charAt(i) - name2.charAt(i);
            }
        }

        return name1.length() - name2.length();
    }

    public static void sortedNameList() {
        bubbleSort(customers_queue_one);
        bubbleSort(customers_queue_two);
        bubbleSort(customers_queue_three);
    }

    public static void storeData() {
        try {
            File myFile = new File("SavedData.txt");
            boolean isFileCrated = myFile.createNewFile();
            if (myFile.exists()) {
                System.out.println(myFile.getName() + "File is already exists");
            } else if (isFileCrated) {
                System.out.printf(myFile.getName() + "Created  Succesfully");
            }

            FileWriter fileWriter = new FileWriter("SavedData.txt", false);
            fileWriter.write("Name of Customers  in Queue One " + Arrays.toString(customers_queue_one) + "\n");
            fileWriter.write("Name of Customers  in Queue Two " + Arrays.toString(customers_queue_two) + "\n");
            fileWriter.write("Name of Customers  in Queue Three " + Arrays.toString(customers_queue_three) + "\n");
            fileWriter.write("Number of Burgers in Stock : " + pizzaStock + "\n");
            String var10001 = queue_one[0];
            fileWriter.write("  " + var10001 + "   " + queue_two[0] + "   " + queue_three[0] + "\n  " + queue_one[1] + "   " + queue_two[1] + "   " + queue_three[1] + "\n      " + queue_two[2] + "   " + queue_three[2] + "\n          " + queue_three[3] + "\n          " + queue_three[4] + "\nX - Not Occupied, O - Occupied\n");
            fileWriter.close();
        } catch (IOException var3) {
            System.out.println("IOException");
        }

    }

    private static void exitProgram() {
        System.out.println("Thank you");
        toLoop = false;
    }

    public static void loadProgramData() {
        try {
            FileReader fileReader = new FileReader("SavedData.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
        } catch (IOException var3) {
            System.out.println("An error occurred while loading the program data: " + var3.getMessage());
        }

    }
}
