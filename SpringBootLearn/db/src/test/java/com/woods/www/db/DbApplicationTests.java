package com.woods.www.db;

import com.woods.www.db.model.master.Bank;
import com.woods.www.db.model.slave.BookSlave;
import com.woods.www.db.repo.master.BankRepo;
import com.woods.www.db.repo.slave.BookSlaveRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DbApplicationTests {

    @Autowired
    private BankRepo bankRepo;

    @Autowired
    private BookSlaveRepo bookSlaveRepo;

    @Test
    public void master() {
        Optional<Bank> bankOptional = bankRepo.findById(45L);
        if (bankOptional.isPresent())
        {
            Bank bank = bankOptional.get();
            log.info(bank.getBankName());
        }else {
            log.error("bank not found");
        }
    }

    @Test
    public void slave(){
        BookSlave bookSlave = new BookSlave();
        bookSlave.setUserId(123L);
        bookSlave.setFullName("测试");
        bookSlave = bookSlaveRepo.save(bookSlave);
        log.info("new book slave >>", bookSlave.getId());
    }

}
