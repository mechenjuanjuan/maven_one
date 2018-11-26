package it.chen.dao;

import it.chen.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * 持久层
 */

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 修改
     * @param account
     */
    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    void updateAccountDao(Account account);

    /**
     * 根据名字查询
     * @param byname
     */
    @Select("select * from account where name=#{name}")
    Account transfer(String byname);
}
