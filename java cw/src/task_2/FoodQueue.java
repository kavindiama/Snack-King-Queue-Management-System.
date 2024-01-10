//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package task_2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodQueue {
    private List<Customer> Queue;
    private int maxLength;

    public FoodQueue(int maxLength) {
        this.Queue = new ArrayList();
        this.maxLength = maxLength;
    }

    public FoodQueue() {
    }

    public Boolean isFull() {
        return this.Queue.size() == this.maxLength;
    }

    public Boolean isEmpty() {
        return this.Queue.isEmpty();
    }

    public int length() {
        return this.Queue.size();
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void addCustomer(Customer customer) {
        if (this.Queue.size() < this.maxLength) {
            this.Queue.add(customer);
        }

    }

    public Customer replaceEmptyWithNull(int index) {
        return index >= this.Queue.size() ? null : (Customer)this.Queue.get(index);
    }

    public int getPizzaAmount(int position) {
        return ((Customer)this.Queue.get(position)).getNumberOfPizza();
    }

    public void RemoveServedCustomer() {
        this.Queue.remove(0);
    }

    public void RemoveCustomerFromAnIndex(int index) {
        if (index <= 0 || index > this.Queue.size()) {
            System.out.println("inseert a valid location");
        }

        for(int i = 0; i <= this.Queue.size(); ++i) {
            if (i == index - 1) {
                String var10000 = ((Customer)this.Queue.get(i)).getFirstName();
                Object var10001 = this.Queue.get(i);
                var10000.concat(" " + ((Customer)var10001).getLastName());
                System.out.println("Element removed");
                this.Queue.remove(i);
                return;
            }
        }

    }

    public List<Customer> getQueue() {
        return this.Queue;
    }

    public void setQueue(List<Customer> queue) {
        this.Queue = queue;
    }

    public int getQueueIncome() {
        int total = 0;

        Customer customer;
        for(Iterator var2 = this.Queue.iterator(); var2.hasNext(); total += customer.getNumberOfPizza() * 1350) {
            customer = (Customer)var2.next();
        }

        System.out.println(" number Of Customers :" + total / 1350);
        return total;
    }

    public void saveCustomer(FileWriter writer) throws IOException {
        Iterator var2 = this.Queue.iterator();

        while(var2.hasNext()) {
            Customer customer = (Customer)var2.next();
            if (customer == null) {
                writer.write("**\n");
            } else {
                String var10001 = customer.getFirstName();
                writer.write(var10001 + "-" + customer.getLastName() + "-" + customer.getId() + "-" + customer.getNumberOfPizza() + "\n");
            }
        }

    }

    public void loadCustomer(BufferedReader reader) throws IOException {
        this.Queue.clear();

        String line;
        while((line = reader.readLine()) != null) {
            if (line.equals("**")) {
                this.Queue.add(null);
            } else {
                String[] parts = line.split("-");
                if (parts.length == 4) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    int customerID = Integer.parseInt(parts[2]);
                    int noOfPizza = Integer.parseInt(parts[3]);
                    Customer customer = new Customer(firstName, lastName, customerID, noOfPizza);
                    this.Queue.add(customer);
                }
            }
        }

    }
}
