package com.kjiao.devops.backend.persistence.repositories;

import com.kjiao.devops.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kjiao on 03/05/2017.
 */
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
