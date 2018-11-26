package it.chen.service;

import it.chen.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 修改
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 转账
     * @param sourceName    转出名称
     * @param tragetName    转入名称
     * @param money         金额
     */
    String transfer(String sourceName,String tragetName,Float money);
}
