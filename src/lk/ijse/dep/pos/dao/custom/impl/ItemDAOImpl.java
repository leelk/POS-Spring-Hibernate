package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.ItemDAO;
import lk.ijse.dep.pos.entity.Item;
import org.hibernate.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {


    @Override
    public String getLastItemCode() throws Exception {

        return (String) session.createNativeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1").uniqueResult();

    }
}
