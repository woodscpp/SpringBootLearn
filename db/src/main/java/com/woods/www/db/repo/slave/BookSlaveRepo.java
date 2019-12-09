package com.woods.www.db.repo.slave;

import com.woods.www.db.model.slave.BookSlave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: woods
 * @date: 2019/12/8
 * @description:
 */
@Repository
public interface BookSlaveRepo extends JpaRepository<BookSlave, Long>, JpaSpecificationExecutor<BookSlave> {
}
