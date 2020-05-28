package com.ww.cassandrax.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CrudRepository 方式
 */

@Repository
public interface EMPRes extends CrudRepository<Emp,Integer> {
}
