package it.chen.service.impl;

import it.chen.dao.IAccountDao;
import it.chen.domain.Account;
import it.chen.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ҵ���
 */
@Service("iAccountService")
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountDao iAccountDao;

    /**
     * ��ѯ����
     * @return
     */
    public List<Account> findAll() {
        System.out.println("����ҵ��㡣����");
        iAccountDao.findAll();
        return null;
    }

    /**
     * �޸�
     * @param account
     */
    public void updateAccount(Account account) {
        iAccountDao.updateAccountDao(account);
    }

    /**
     * ת��
     * @param sourceName    ת������
     * @param tragetName    ת������
     * @param money         ���
     */
    public String transfer(String sourceName, String tragetName, Float money){
//        �������Ʋ�ѯת���˻�
        Account source = iAccountDao.transfer(sourceName);
//        �������Ʋ�ѯת���˻�
        Account traget = iAccountDao.transfer(tragetName);
        if(money>=source.getMoney()||money>traget.getMoney()){
            System.out.println("���㡣����");
            String remind = "�������㡣����";
            return remind;
        }
//       ��Ǯ
        source.setMoney(source.getMoney()-money);
//       ��Ǯ
        traget.setMoney(traget.getMoney()+money);
//       ����
        iAccountDao.updateAccountDao(source);

        int i = 1/0;
        iAccountDao.updateAccountDao(traget);

        return null;
    }


}
