package ImplementationTests;


import org.example.dataObject.CustomerDataObject;
import org.example.implementation.CustomerObjectCreator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerObjectCreatorTest {

    private final CustomerObjectCreator customerObjectCreator = new CustomerObjectCreator();

    @Test
    public void testParseData_ValidInput() {
        String input = "2343225, 2345, us_east, RedTeam, ProjectApple, 3445s\n2343226, 2345, eu_east, BlueTeam, ProjectOrange, 3448s\n";
        List<CustomerDataObject> result = customerObjectCreator.parseData(input);

        assertEquals(2, result.size());

        CustomerDataObject customer1 = result.get(0);
        assertEquals(2343225, customer1.getCustomerId());
        assertEquals(2345, customer1.getContractId());
        assertEquals("us_east", customer1.getGeozone());
        assertEquals("RedTeam", customer1.getTeamCode());
        assertEquals("ProjectApple", customer1.getProjectCode());
        assertEquals(3445, customer1.getBuildDuration());

        CustomerDataObject customer2 = result.get(1);
        assertEquals(2343226, customer2.getCustomerId());
        assertEquals(2345, customer2.getContractId());
        assertEquals("eu_east", customer2.getGeozone());
        assertEquals("BlueTeam", customer2.getTeamCode());
        assertEquals("ProjectOrange", customer2.getProjectCode());
        assertEquals(3448, customer2.getBuildDuration());
    }

    @Test
    public void testCreateCustomerObjectFromSingleLineString_ValidInput() {
        String input = "2343225, 2345, us_east, RedTeam, ProjectApple, 3445s";

        CustomerDataObject result = customerObjectCreator.createCustomerObjectFromSingleLineString(input);

        assertEquals(2343225, result.getCustomerId());
        assertEquals(2345, result.getContractId());
        assertEquals("us_east", result.getGeozone());
        assertEquals("RedTeam", result.getTeamCode());
        assertEquals("ProjectApple", result.getProjectCode());
        assertEquals(3445, result.getBuildDuration());
    }

    @Test
    public void testCreateCustomerObjectFromSingleLineString_InvalidInput() {
        String input = "13242432,2222,india,team_z,project1";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            customerObjectCreator.createCustomerObjectFromSingleLineString(input);
        });

        assertEquals("Invalid String", exception.getMessage());
    }



}

