package com.example.demoSpringBoot.controllers;

import com.example.demoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller to show customer info.
 *
 * @author Jorge Correyero
 */
@RestController
public class CustomerRestController {
    // Attributes
    private List<Customer> customerList = new ArrayList<>(Arrays.asList( // I create 4 customers to serve as an example
            new Customer(1, "Pablo", "pablo1", "password1234"),
            new Customer(2, "María", "maria2", "pass1234word"),
            new Customer(3, "Jorge", "jorge3", "1234password"),
            new Customer(4, "Paula", "paula4", "12password34")
    ));

    // Setters and getters
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    /**
     * Endpoint to show customers.
     *
     * @return the list of the customers.
     */
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.customerList;
    }

    /**
     * Endpoint to show one customer.
     *
     * @param username account name of the customer we are looking for.
     * @return the searched customer.
     */
    @GetMapping("/customers/{username}")
    public Customer getOneCustomer(@PathVariable String username) {
        for (Customer c: customerList) {
            if (c.getUsername().equals(username)) { // Search for a coincidence within the list of customers
                return c;
            }
        }
        return null; // WRONG ERROR MANAGEMENT
    }

    /**
     * Endpoint to add one customer. I use Postman to generate post requests.
     *
     * @param cust object type customer with all the information of the customer.
     * @return the added customer.
     */
    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer cust) {
        customerList.add(cust);
        return cust;
    }

    /**
     * Endpoint to modify one customer. I use Postman to generate post requests.
     *
     * @param cust object type customer with all the information of the customer.
     * @return the modified customer.
     */
    @PutMapping("/customers")
    public Customer putCustomer(@RequestBody Customer cust) {
        for (Customer c: customerList) {
            if (c.getId() == cust.getId()) { // Search for a coincidence within the list of customers
                c.setName(cust.getName());
                c.setUsername(cust.getUsername());
                c.setPassword(cust.getPassword());
                return c;
            }
        }
        return null;
    }

    /**
     * Endpoint to delete one customer. I use Postman to generate post requests.
     *
     * @param id identifier of the customer that's going to be removed.
     * @return the deleted customer.
     */
    @DeleteMapping("/customers/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for (Customer c: customerList) {
            if (c.getId() == id) { // Search for a coincidence within the list of customers
                customerList.remove(c);
                return c;
            }
        }
        return null;
    }

    /**
     * Endpoint to modify specific fields of one customer. I use Postman to generate post requests.
     *
     * @param cust customer that's going to be modified with it's new values.
     * @return the deleted customer.
     */
    @PatchMapping("/customers")
    public Customer patchCustomer(@RequestBody Customer cust) {
        for (Customer c: customerList) {
            if (c.getId() == cust.getId()) { // Search for the customer
                // if the field exists it's modified.
                if(c.getName() != null)
                    c.setName(cust.getName());
                if(c.getUsername() != null)
                    c.setUsername(cust.getUsername());
                if(c.getPassword() != null)
                    c.setName(cust.getPassword());

                return c;
            }
        }
        return null;
    }
}
