package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.OrderDAO;
import lk.ijse.dep.pos.entity.Order;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAOImpl extends CrudDAOImpl<Order, Integer> implements OrderDAO {



    @Override
    public int getLastOrderId() throws Exception {

        Integer i = (Integer) session.createNativeQuery("SELECT id FROM `Order` ORDER BY id DESC LIMIT 1")
                .uniqueResult();
        return (i == null) ? 0 : i;
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return  session.createNativeQuery("SELECT * FROM `Order` WHERE customer_id=?1").setParameter(1,customerId).uniqueResult() != null;
    }
}
