package uk.ac.hope.mcse.segh.servermanagement.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "HardwareReadings")
public class HardwareReading {

    @Id
    private BigInteger _id;

    private String dateTime;

    private String cpu;

    private String ram;

    private String ramTotal;

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setRamTotal(String ramTotal) {
        this.ramTotal = ramTotal;
    }

}