package com.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.entity.MobileRepairOrder;
import com.phone.repo.MobileRepairOrderRepo;

@Service
public class MobileRepairOrderService {
	@Autowired
	MobileRepairOrderRepo mobileRepairRepo;
	public MobileRepairOrder mobileRepair(MobileRepairOrder orderData)
	{
		return mobileRepairRepo.save(orderData);
	}
	
	public List<MobileRepairOrder> getservice()
	{
		return mobileRepairRepo.findAll();
	}

}
