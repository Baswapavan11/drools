package com.droolsruleengine.repository;

import com.droolsruleengine.model.Rules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RulesRepo extends JpaRepository<Rules, Long> {

}
