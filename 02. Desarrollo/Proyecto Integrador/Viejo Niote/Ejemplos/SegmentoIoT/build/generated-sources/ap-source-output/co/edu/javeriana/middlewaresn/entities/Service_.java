package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.ServiceAttribute;
import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Integer> serviceState;
    public static volatile SingularAttribute<Service, Integer> idCatalog;
    public static volatile SingularAttribute<Service, String> lastValue;
    public static volatile ListAttribute<Service, ServiceNode> serviceNodeList;
    public static volatile SingularAttribute<Service, Date> dateLastValue;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile ListAttribute<Service, ServiceAttribute> serviceAttributeList;
    public static volatile SingularAttribute<Service, String> idSusn;

}