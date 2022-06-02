package com.company.gamestoreinvoicing.repository;

import com.company.gamestoreinvoicing.model.ProcessingFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeRepositoryTest {

    @Autowired
    ProcessingFeeRepository processingFeeRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        processingFeeRepository.deleteAll();
    }

    @Test
    public void getProcessingFee() {
        // Arrange
        ProcessingFee tShirtProcessingFee = new ProcessingFee();
        tShirtProcessingFee.setProductType("T-Shirt");
        tShirtProcessingFee.setFee(new BigDecimal("1.98"));

        ProcessingFee consoleProcessingFee = new ProcessingFee();
        consoleProcessingFee.setProductType("Console");
        consoleProcessingFee.setFee(new BigDecimal("14.99"));

        ProcessingFee gameProcessingFee = new ProcessingFee();
        gameProcessingFee.setProductType("Game");
        gameProcessingFee.setFee(new BigDecimal("1.49"));

        // Act
        processingFeeRepository.save(tShirtProcessingFee);
        processingFeeRepository.save(consoleProcessingFee);
        processingFeeRepository.save(gameProcessingFee);

        // Assert
        Optional<ProcessingFee> foundFee;

        foundFee = processingFeeRepository.findById("T-Shirt");
        assertTrue(foundFee.isPresent());
        assertEquals(foundFee.get().getFee(), new BigDecimal("1.98"));

        foundFee = processingFeeRepository.findById("Console");
        assertTrue(foundFee.isPresent());
        assertEquals(foundFee.get().getFee(), new BigDecimal("14.99"));

        foundFee = processingFeeRepository.findById("Game");
        assertTrue(foundFee.isPresent());
        assertEquals(foundFee.get().getFee(), new BigDecimal("1.49"));
    }

    @Test
    public void getProcessingFeeObject() {
        // Arrange
        ProcessingFee tShirtProcessingFee = new ProcessingFee();
        tShirtProcessingFee.setProductType("T-Shirt");
        tShirtProcessingFee.setFee(new BigDecimal("1.98"));

        ProcessingFee consoleProcessingFee = new ProcessingFee();
        consoleProcessingFee.setProductType("Console");
        consoleProcessingFee.setFee(new BigDecimal("14.99"));

        ProcessingFee gameProcessingFee = new ProcessingFee();
        gameProcessingFee.setProductType("Game");
        gameProcessingFee.setFee(new BigDecimal("1.49"));

        // Act
        processingFeeRepository.save(tShirtProcessingFee);
        processingFeeRepository.save(consoleProcessingFee);
        processingFeeRepository.save(gameProcessingFee);

        // Assert
        Optional<ProcessingFee> foundProcessingFee = processingFeeRepository.findById(tShirtProcessingFee.getProductType());
        assertTrue(foundProcessingFee.isPresent());
        assertEquals(tShirtProcessingFee, foundProcessingFee.get());

        foundProcessingFee = processingFeeRepository.findById(consoleProcessingFee.getProductType());
        assertTrue(foundProcessingFee.isPresent());
        assertEquals(consoleProcessingFee, foundProcessingFee.get());

        foundProcessingFee = processingFeeRepository.findById(gameProcessingFee.getProductType());
        assertTrue(foundProcessingFee.isPresent());
        assertEquals(gameProcessingFee,foundProcessingFee.get());
    }
}
