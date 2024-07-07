package uk.ac.hope.mcse.segh.servermanagement.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import oshi.hardware.GlobalMemory;

import java.math.BigInteger;

@Document(collection = "HardwareReadings")
public class HardwareReading {

    @Id

    private BigInteger _id;

    private String dateTime;

    private double cpu;

    private double ram;


    public BigInteger get_id() {
        return _id;
    }

    public void set_id(BigInteger _id) {
        this._id = _id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

}