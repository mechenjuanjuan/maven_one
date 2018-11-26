package it.chen.service;

import it.chen.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * ��ѯ����
     * @return
     */
    List<Account> findAll();

    /**
     * �޸�
     * @param account
     */
    void updateAccount(Account account);

    /**
     * ת��
     * @param sourceName    ת������
     * @param tragetName    ת������
     * @param money         ���
     */
    String transfer(String sourceName,String tragetName,Float money);
}
