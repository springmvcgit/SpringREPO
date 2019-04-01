package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.entity.MobileRepairOrder;

@Repository
public interface MobileRepairOrderRepo extends JpaRepository<MobileRepairOrder, Integer>  {

}
