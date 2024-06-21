package org.example;

import org.example.ReportGenerator.GenerateReport;
import org.example.dataObject.CustomerDataObject;
import org.example.implementation.CustomerObjectCreator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String input = "2343225, 2345, us_east, RedTeam, ProjectApple, 3445s\n" +
                "1223456, 2345, us_west, BlueTeam, ProjectBanana, 2211\n" +
                "3244332, 2346, eu_west, YellowTeam3, ProjectCarrot, 4322s\n" +
                "1233456, 2345, us_west, BlueTeam, ProjectDate, 2221s\n" +
                "3244132, 2346, eu_west, YellowTeam3, ProjectEgg, 5555s";

        CustomerObjectCreator parser = new CustomerObjectCreator();
        List<CustomerDataObject> dataList = parser.parseData(input);

        GenerateReport generator = new GenerateReport();
        generator.generateReport(dataList);

    }
}