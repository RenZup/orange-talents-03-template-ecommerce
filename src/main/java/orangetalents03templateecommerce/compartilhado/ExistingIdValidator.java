package orangetalents03templateecommerce.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistingIdValidator implements ConstraintValidator<ExistingId, Object> {

    private String field;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistingId params) {
        field = params.fieldName();
        klass = params.domainClass();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) {return true;}

        Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + field + " = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        return !(list.isEmpty());
    }




}