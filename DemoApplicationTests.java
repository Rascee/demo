package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.PricingDetailRepository;
import com.example.demo.repository.PricingHandlingFeeRepository;
import com.example.demo.repository.PricingMasterTableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PricingHandlingFeeRepository pricingHandlingFeeRepository;

	@Autowired
	private PricingMasterTableRepository pricingMasterTableRepository;

	@Autowired
	private PricingDetailRepository pricingDetailRepository;

	@Test
	void testJpa() {
		PricingMasterTable masterTable = new PricingMasterTable();
		PricingDetail pricingDetail = new PricingDetail();

		PricingHandlingFeePK pricingHandlingFeePK = new PricingHandlingFeePK();
		pricingHandlingFeePK.setTenor(3);

		PricingHandlingFee pricingHandlingFee = new PricingHandlingFee();
		pricingHandlingFee.setFee(BigDecimal.valueOf(50));
		pricingHandlingFee.setPricingHandlingFeePK(pricingHandlingFeePK);
		pricingHandlingFee.setPricingDetailByUuid(pricingDetail);

		List<PricingHandlingFee> list = new ArrayList<>();
		list.add(pricingHandlingFee);

		pricingDetail.setFromAmount(BigDecimal.valueOf(500));
		pricingDetail.setToAmount(BigDecimal.valueOf(5000));
		pricingDetail.setPricingHandlingFeeByUuid(list);
		pricingDetail.setPricingMasterTableByTableId(masterTable);

		List<PricingDetail> list2 = new ArrayList<>();
		list2.add(pricingDetail);

		masterTable.setPricingDetailById(list2);

		pricingMasterTableRepository.save(masterTable);
	}

	@Test
	void delete() {
		pricingMasterTableRepository.findById(4).ifPresent(e -> pricingMasterTableRepository.delete(e));
	}

	@Test
	void find() {
		PricingDetail pricingDetail = pricingDetailRepository.findById(5).get();

		System.out.println("2");
	}

}
