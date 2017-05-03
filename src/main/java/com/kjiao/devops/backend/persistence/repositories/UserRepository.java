package com.kjiao.devops.backend.persistence.repositories;

import com.kjiao.devops.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kjiao on 03/05/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
