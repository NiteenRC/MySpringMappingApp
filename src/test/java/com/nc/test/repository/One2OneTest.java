package com.nc.test.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nc.repository.one2one.AddressRepository;
import com.nc.repository.one2one.UserDetailsRepository;
import com.nc.repository.one2one.UserRepository;

@SpringBootTest
public class One2OneTest {

	private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Test
	void testFetchAllUsers() {
		assertTrue(userRepository.findAll().size() >= 1);
		LOGGER.info("userRepository ::" + userRepository.findAll());

		assertTrue(addressRepository.findAll().size() >= 1);
		LOGGER.info("addressRepository ::" + addressRepository.findAll());

		assertTrue(userDetailsRepository.findAll().size() >= 1);
		LOGGER.info("userDetailsRepository ::" + userDetailsRepository.findAll());

	}
}
