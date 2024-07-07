package uk.ac.hope.mcse.segh.servermanagement.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagement.repo.HardwareReadingRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class TakeHardwareReadingServiceImpl implements TakeHardwareReadingService{
    private final HardwareReadingRepository repository;

    @Autowired
    public TakeHardwareReadingServiceImpl(HardwareReadingRepository repository) {this.repository = repository;}

    @Override
    public void takeReading() {
        //Initialise variables required for hardware readings
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        //Get processor details
        CentralProcessor processor = hal.getProcessor();
        //Get the current CPU usage. Works by taking a sample of CPU tick counters, waits one second, takes another and works out the difference to find the current whole CPU usage. Then multiplies by 100 to get a more human-readable number
        double currentCpuUsage = (double) (processor.getSystemCpuLoad(1000) * 100);
        //Rounds the reading to two decimal places
        currentCpuUsage = Math.round(currentCpuUsage * 100);
        currentCpuUsage = currentCpuUsage/100;

        //Gets a reading of the current RAM usage
        GlobalMemory currentUnconvertedRamUsage = hal.getMemory();
        //As the value provided by getMemory is of type GlobalMemory and the value provided is in the format "Available: 15.5 GiB/31.9 GiB", the following converts it to the format "15.5" and into a double
        int start = currentUnconvertedRamUsage.toString().indexOf(" ");
        int end = currentUnconvertedRamUsage.toString().indexOf("G");
        double currentConvertedRamUsage = Double.parseDouble(currentUnconvertedRamUsage.toString().substring(start + 1, end - 1));

        //Gets the current date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        //Print values to console for debugging purposes
        System.out.println(currentCpuUsage);
        System.out.println(currentUnconvertedRamUsage);
        System.out.println(currentConvertedRamUsage);

        //Save all the read values into the MongoDB database
        HardwareReading HardwareReading = new HardwareReading();
        HardwareReading.setDateTime(dtf.format(now));
        HardwareReading.setCpu(currentCpuUsage);
        HardwareReading.setRam(currentConvertedRamUsage);
        repository.save(HardwareReading);
    }
}
