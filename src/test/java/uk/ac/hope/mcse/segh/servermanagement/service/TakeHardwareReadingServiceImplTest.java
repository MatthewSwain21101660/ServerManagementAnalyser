package uk.ac.hope.mcse.segh.servermanagement.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagement.repo.HardwareReadingRepository;

import static org.junit.jupiter.api.Assertions.*;

class TakeHardwareReadingServiceImplTest {

    private final HardwareReadingRepository repository;

    TakeHardwareReadingServiceImplTest(HardwareReadingRepository repository) {
        this.repository = repository;
    }

    @Test
    public void testTakeReading() {
        TakeHardwareReadingService takeHardwareReadingService = new TakeHardwareReadingServiceImpl(repository);

    }

}