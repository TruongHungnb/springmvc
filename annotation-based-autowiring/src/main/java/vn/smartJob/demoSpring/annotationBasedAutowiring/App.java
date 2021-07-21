package vn.smartJob.demoSpring.annotationBasedAutowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);

        System.out.println("Trước khi chuyển tiền");
        System.out.println("Số dư trong tài khoản Truong Van A:" + accountService.getAccount(1).getBalance());
        System.out.println("Số dư trong tài khoản Nguyễn Văn B:" + accountService.getAccount(2).getBalance());

        accountService.transferMoney(1, 2, 1200000.0);

        System.out.println("---------------------------------------------------");
        System.out.println("Sau khi chuyển tiền");
        System.out.println("Số dư trong tài khoản Truong Van A:" + accountService.getAccount(1).getBalance());
        System.out.println("Số dư trong tài khoản Nguyễn Văn B:" + accountService.getAccount(2).getBalance());
    }

}

