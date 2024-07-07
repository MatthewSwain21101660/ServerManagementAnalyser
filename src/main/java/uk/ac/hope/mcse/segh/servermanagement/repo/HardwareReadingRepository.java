package uk.ac.hope.mcse.segh.servermanagement.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;

import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.util.Optional;

public interface HardwareReadingRepository extends MongoRepository <HardwareReading, BigInteger> {

}
