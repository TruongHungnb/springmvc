package vn.smartJob.demoSpring.annotationBasedAutowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    @Autowired
    @Qualifier("accountDao")
    public void setAccountDao(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
        Account sourceAccount = accountDAO.find(sourceAccountId);
        Account targetAccount = accountDAO.find(targetAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountDAO.update(sourceAccount);
        accountDAO.update(targetAccount);
    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account account = accountDAO.find(accountId);
        account.setBalance(account.getBalance() + amount);
        accountDAO.update(account);
    }

    @Override
    public Account getAccount(long accountId) {
        return accountDAO.find(accountId);
    }

}
