package org.example.implementation;

import org.example.dataObject.CustomerDataObject;

import java.util.ArrayList;
import java.util.List;

public class CustomerObjectCreator {

    public List<CustomerDataObject> parseData(String input) {
        List<CustomerDataObject> customerDataList = new ArrayList<>();

        String[] inputLines = input.split("\n");

        for (String line : inputLines) {

            CustomerDataObject customerDataObject = createCustomerObjectFromSingleLineString(line);
            customerDataList.add(customerDataObject);
        }

        return customerDataList;
    }

    public CustomerDataObject createCustomerObjectFromSingleLineString(String inputString) {

        CustomerDataObject customerDataObject = new CustomerDataObject();
        String[] customerDetails = inputString.split(",");

        if (customerDetails.length != 6) {
            throw new RuntimeException("Invalid String");
        } else {
            try {
                customerDataObject.setCustomerId(Long.parseLong(customerDetails[0].trim()));
                customerDataObject.setContractId(Long.parseLong(customerDetails[1].trim()));
                customerDataObject.setGeozone(customerDetails[2].trim());
                customerDataObject.setTeamCode(customerDetails[3].trim());
                customerDataObject.setProjectCode(customerDetails[4].trim());
                customerDataObject.setBuildDuration(Long.parseLong(customerDetails[5].trim().replaceAll("s$", "")));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }

        }
        return customerDataObject;
    }

}
