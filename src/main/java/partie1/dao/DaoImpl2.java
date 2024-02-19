package partie1.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("ws")
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version web service ");
        double data = 55;
        return data;
    }
}
