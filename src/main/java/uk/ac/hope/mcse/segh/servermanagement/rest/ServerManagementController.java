package uk.ac.hope.mcse.segh.servermanagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagement.repo.HardwareReadingRepository;
import uk.ac.hope.mcse.segh.servermanagement.service.TakeHardwareReadingService;

import java.io.IOException;
import java.util.List;


@RestController
class ServerManagementController {
    private final TakeHardwareReadingService takeHardwareReadingService;


    @Autowired
    public ServerManagementController(TakeHardwareReadingService takeHardwareReadingService) {
        this.takeHardwareReadingService = takeHardwareReadingService;
    }

    @Scheduled(fixedRate = 1000)
    @Async
    void takeReading(){
        takeHardwareReadingService.takeReading();
    }
}


