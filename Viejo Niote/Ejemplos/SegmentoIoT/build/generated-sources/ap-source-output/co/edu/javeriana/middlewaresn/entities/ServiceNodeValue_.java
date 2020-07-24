package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(ServiceNodeValue.class)
public class ServiceNodeValue_ { 

    public static volatile SingularAttribute<ServiceNodeValue, Date> date;
    public static volatile SingularAttribute<ServiceNodeValue, ServiceNode> serviceNode;
    public static volatile SingularAttribute<ServiceNodeValue, String> value;
    public static volatile SingularAttribute<ServiceNodeValue, Integer> idServiceNodeValue;

}