//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {
    private String firstName;
    private String lastName;
    private static int id = 0;
    private int numberOfPizza;
    private Scanner input;

    public int getId() {
        return id;
    }

    public Customer(String firstName, String lastName, int Id, int numberOfPizza) {
        this.input = new Scanner(System.in);
        this.firstName = firstName;
        this.lastName = lastName;
        id = Id;
        this.numberOfPizza = numberOfPizza;
    }

    public Customer() {
        this.input = new Scanner(System.in);
        ++id;
    }

    public void getFullName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    public String getname() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getNumberOfPizza() {
        return this.numberOfPizza;
    }

    public void gettingNames() {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("enter the first name: ");
            this.firstName = input.nextLine();
            nameValidation(this.firstName);
        } while(!nameValidation(this.firstName));

        do {
            System.out.println("enter the last name: ");
            this.lastName = input.nextLine();
            nameValidation(this.lastName);
        } while(!nameValidation(this.lastName));

    }

    private static boolean nameValidation(String CustomerName) {
        for(int letter = 0; letter < CustomerName.length(); ++letter) {
            if (CustomerName.charAt(letter) > 'z' || CustomerName.charAt(letter) < 'a' || CustomerName.charAt(letter) <= 'Z' && CustomerName.charAt(letter) > 'A') {
                System.out.println("invalid name");
                return false;
            }
        }

        return true;
    }

    public void gettingNumberOfPizza() {
        while(true) {
            try {
                System.out.println("enter the number of pizza: ");
                this.numberOfPizza = this.input.nextInt();
                if (this.numberOfPizza > 100 || this.numberOfPizza < 0) {
                    System.out.println("number of pizza more than 100 or less than 0");
                }

                if (this.numberOfPizza > 100 || this.numberOfPizza < 0) {
                    continue;
                }
            } catch (InputMismatchException var2) {
                System.out.println("input and integer");
            }

            return;
        }
    }
}
