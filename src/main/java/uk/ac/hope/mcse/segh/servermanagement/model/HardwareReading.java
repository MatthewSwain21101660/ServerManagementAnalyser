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

    public void set_id(BigInteger _id) {
        this._id = _id;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

}