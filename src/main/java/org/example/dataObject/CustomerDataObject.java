package org.example.dataObject;

public class CustomerDataObject {

    private long customerId;
    private long contractId;
    private String geozone;
    private String teamCode;
    private String projectCode;
    private long buildDuration;

    // constructers
    public CustomerDataObject() {
    }

    public CustomerDataObject(long customerId, long buildDuration, String projectCode, String teamCode, String geozone, long contractId) {
        this.customerId = customerId;
        this.buildDuration = buildDuration;
        this.projectCode = projectCode;
        this.teamCode = teamCode;
        this.geozone = geozone;
        this.contractId = contractId;
    }

    //Setters
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setBuildDuration(long buildDuration) {
        this.buildDuration = buildDuration;
    }

    //Getters
    public long getCustomerId() {
        return customerId;
    }

    public long getContractId() {
        return contractId;
    }

    public String getGeozone() {
        return geozone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public long getBuildDuration() {
        return buildDuration;
    }

    @Override
    public String toString() {
        return "Customer Information is{" +
                "customerId=" + customerId +
                ", contractId=" + contractId +
                ", geozone='" + geozone + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", buildDuration=" + buildDuration +
                '}';
    }
}
