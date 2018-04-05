package com.ns.bsb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ns.bsb.entity.BranchDetails;

public interface BranchDetailsRepository extends CrudRepository<BranchDetails, Long> {
	List<BranchDetails>	findBybsbNumber(String bsbNumber);
}
