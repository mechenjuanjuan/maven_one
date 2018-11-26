package it.chen.service.impl;

import it.chen.dao.IAccountDao;
import it.chen.domain.Account;
import it.chen.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 */
@Service("iAccountService")
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountDao iAccountDao;

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll() {
        System.out.println("我是业务层。。。");
        iAccountDao.findAll();
        return null;
    }

    /**
     * 修改
     * @param account
     */
    public void updateAccount(Account account) {
        iAccountDao.updateAccountDao(account);
    }

    /**
     * 转账
     * @param sourceName    转出名称
     * @param tragetName    转入名称
     * @param money         金额
     */
    public String transfer(String sourceName, String tragetName, Float money){
//        根据名称查询转出账户
        Account source = iAccountDao.transfer(sourceName);
//        根据名称查询转入账户
        Account traget = iAccountDao.transfer(tragetName);
        if(money>=source.getMoney()||money>traget.getMoney()){
            System.out.println("余额不足。。。");
            String remind = "您的余额不足。。。";
            return remind;
        }
//       减钱
        source.setMoney(source.getMoney()-money);
//       加钱
        traget.setMoney(traget.getMoney()+money);
//       更新
        iAccountDao.updateAccountDao(source);

        int i = 1/0;
        iAccountDao.updateAccountDao(traget);

        return null;
    }


}
