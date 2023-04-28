package test.BUS;

import BUS.Account_BUS;
import DAO.Account_DAO;
import DTO.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Account_BUSTest {
    Account_BUS accountBus;

    @BeforeEach
    void setUp(){
        accountBus = new Account_BUS();
    }

    /**
     * Search common
     */

    @ParameterizedTest
    @CsvSource({
            "nhamgiaphat,         Tên tài khoản",
            "ASDASDASSDASD,        Mã tài khoản",
            "AC01, Mã tài khoản",
            "123456,    Mật khẩu",
            "AA01,Mã nhân viên"
    })
    void searchCommon(String keyword,String filter){
        List<Account> account =accountBus.searchAccount(keyword,filter);
        System.out.println(account);
    }
    /**
     *case filter equals Mã tài khoản
     */
    @Test
    void searchAccountWithID() {
        List<Account> account1 =accountBus.searchAccount("AC01","Mã tài khoản");
        assertEquals(1,account1.size());
    }
    /**
     *case filter equals Tên tài khoản
     */
    @Test
    void searchAccountWithName() {
        List<Account> accounts =accountBus.searchAccount("nhamgiaphat","Tên tài khoản");
        assertEquals(1,accounts.size());
    }
    /**
     *case filter equals Mã tài khoản
     */
    @Test
    void searchAccountWithPassword() {
        List<Account> accounts =accountBus.searchAccount("123456","Mật khẩu");
        assertEquals(1,accounts.size());
    }
    /**
     *case filter equals Loại
     */
    @Test
    void searchAccountWithCate() {
        List<Account> accounts =accountBus.searchAccount("DC01","Loại");
        assertEquals(3,accounts.size());
    }
    /**
     *case filter equals Mã nhân viên
     */
    @Test
    void searchAccountWithStaffID() {
        List<Account> accounts =accountBus.searchAccount("AA01","Mã nhân viên");
        assertEquals(3,accounts.size());
    }
}