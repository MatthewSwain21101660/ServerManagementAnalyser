package uk.ac.hope.mcse.segh.servermanagement.exception;

import io.micrometer.core.instrument.distribution.StepBucketHistogram;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    //public ResourceNotFoundException(Long id) {
     //   super("Could not find employee " + id);
    //}

}
