package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.AttributeType;
import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(ServiceNodeAttribute.class)
public class ServiceNodeAttribute_ { 

    public static volatile SingularAttribute<ServiceNodeAttribute, AttributeType> attributeType;
    public static volatile SingularAttribute<ServiceNodeAttribute, Integer> idServiceNodeAttribute;
    public static volatile SingularAttribute<ServiceNodeAttribute, String> description;
    public static volatile SingularAttribute<ServiceNodeAttribute, ServiceNode> serviceNode;
    public static volatile SingularAttribute<ServiceNodeAttribute, String> value;

}