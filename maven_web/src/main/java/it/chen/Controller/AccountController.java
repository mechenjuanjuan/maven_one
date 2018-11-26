package it.chen.Controller;

import it.chen.Exception.SysException;
import it.chen.domain.Account;
import it.chen.domain.Transfer;
import it.chen.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping("/findController")
    public String findController(Model model){
        System.out.println("我是表现层。。。");
        List<Account> all = iAccountService.findAll();
        model.addAttribute("list",all);
        return "success";
    }

    /**
     * 转账
     */
    @RequestMapping("/transferController")
    public String transferController(Transfer transfer,Model model) throws SysException{
        System.out.println("我是表现层。。。");
        String error = null;
        try {
            error = iAccountService.transfer(transfer.getSourceName(), transfer.getTragetName(), transfer.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("转账出现错误。。。");
        }
        model.addAttribute("error",error);
        if(error!=null){
          return "error";
        }
        if(error==null){
            return "success";
        }
        return null;
    }
}
