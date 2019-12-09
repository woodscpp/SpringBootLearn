package com.woods.www.db.repo.master;

import com.woods.www.db.model.master.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: woods
 * @date: 2019/12/8
 * @description:
 */
@Repository
public interface BankRepo extends JpaRepository<Bank, Long>, JpaSpecificationExecutor<Bank> {

}
