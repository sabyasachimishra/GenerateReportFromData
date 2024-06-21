package ReportGenerationTest;
import org.example.dataObject.CustomerDataObject;
import org.example.implementation.CustomerObjectCreator;
import org.junit.jupiter.api.Test;
import org.example.ReportGenerator.GenerateReport;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateReportTest {

    private final GenerateReport generateReport = new GenerateReport();
    private final CustomerObjectCreator customerObjectCreator = new CustomerObjectCreator();

    private List<CustomerDataObject> createTestCustomerData() {
        String input = "2343225, 2345, us_east, RedTeam, ProjectApple, 3446s\n2343226, 2345, us_east, BlueTeam, ProjectOrange, 3448s\n3244132, 2346, eu_west, YellowTeam3, ProjectEgg, 5555s";
        List<CustomerDataObject> customerDataList = customerObjectCreator.parseData(input);
        return customerDataList;
    }

    @Test
    public void testGetUniqueCustomersByContract() {
        List<CustomerDataObject> customerDataList = createTestCustomerData();

        Map<Long, Set<Long>> result = generateReport.getUniqueCustomersByContract(customerDataList);

        assertEquals(2, result.size());
        assertEquals(Set.of(2343225L, 2343226L), result.get(2345L));
        assertEquals(Set.of(3244132L), result.get(2346L));
    }

    @Test
    public void testGetUniqueCustomersByGeoZone() {
        List<CustomerDataObject> customerDataList = createTestCustomerData();

        Map<String, Set<Long>> result = generateReport.getUniqueCustomersByGeoZone(customerDataList);

        assertEquals(2, result.size());
        assertEquals(Set.of(2343225L, 2343226L), result.get("us_east"));
        assertEquals(Set.of(3244132L), result.get("eu_west"));
    }

    @Test
    public void testGetAverageBuildDurationByGeozone() {
        List<CustomerDataObject> customerDataList = createTestCustomerData();

        Map<String, Double> result = generateReport.getAverageBuildDurationByGeozone(customerDataList);

        assertEquals(2, result.size());
        assertEquals(3447.0, result.get("us_east"));
        assertEquals(5555.0, result.get("eu_west"));
    }
}

