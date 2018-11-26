package it.chen.dao;

import it.chen.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * �־ò�
 */

public interface IAccountDao {
    /**
     * ��ѯ����
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * �޸�
     * @param account
     */
    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    void updateAccountDao(Account account);

    /**
     * �������ֲ�ѯ
     * @param byname
     */
    @Select("select * from account where name=#{name}")
    Account transfer(String byname);
}
