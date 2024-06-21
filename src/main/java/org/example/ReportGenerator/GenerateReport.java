package org.example.ReportGenerator;

import org.example.dataObject.CustomerDataObject;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateReport {

    public void generateReport(List<CustomerDataObject> customerDataList) {
        // Unique customers for each contractId
        Map<Long, Set<Long>> uniqueCustomersByContract = getUniqueCustomersByContract(customerDataList);

        // Unique customers for each geozone
        Map<String, Set<Long>> uniqueCustomersByGeozone = getUniqueCustomersByGeoZone(customerDataList);


        // Average build duration for each geozone
        Map<String, Double> averageBuildDurationByGeozone = getAverageBuildDurationByGeozone(customerDataList);


        // Print the report
        System.out.println("The number of unique customers for each contract Id:");
        uniqueCustomersByContract.forEach((k, v) -> System.out.println(k + ": " + v.size()));

        System.out.println("\nThe number of unique customers for each Geozone:");
        uniqueCustomersByGeozone.forEach((k, v) -> System.out.println(k + ": " + v.size()));

        System.out.println("\nAverage build duration for each Geozone:");
        averageBuildDurationByGeozone.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nList of unique customers for each Geozone:");
        uniqueCustomersByGeozone.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public Map<Long, Set<Long>> getUniqueCustomersByContract(List<CustomerDataObject> customerDataList){
        Map<Long, Set<Long>> uniqueCustomersByContract = customerDataList.stream()
                .collect(Collectors.groupingBy(CustomerDataObject::getContractId,
                        Collectors.mapping(CustomerDataObject::getCustomerId, Collectors.toSet())));

        return uniqueCustomersByContract;
    }

    public Map<String, Set<Long>> getUniqueCustomersByGeoZone(List<CustomerDataObject> customerDataList){
        Map<String, Set<Long>> uniqueCustomersByGeozone = customerDataList.stream()
                        .collect(Collectors.groupingBy(CustomerDataObject::getGeozone,
                                    Collectors.mapping(CustomerDataObject::getCustomerId, Collectors.toSet())));

        return uniqueCustomersByGeozone;
    }

    public Map<String, Double> getAverageBuildDurationByGeozone(List<CustomerDataObject> customerDataList){
        Map<String, Double> averageBuildDurationByGeozone = customerDataList.stream()
                .collect(Collectors.groupingBy(CustomerDataObject::getGeozone,
                        Collectors.averagingDouble(data -> {
                           return Double.valueOf(data.getBuildDuration());
                        })));

        return averageBuildDurationByGeozone;

    }



}
