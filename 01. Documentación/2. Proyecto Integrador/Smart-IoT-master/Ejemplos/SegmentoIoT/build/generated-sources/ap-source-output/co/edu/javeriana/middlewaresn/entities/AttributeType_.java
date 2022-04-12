package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.ServiceAttribute;
import co.edu.javeriana.middlewaresn.entities.ServiceNodeAttribute;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(AttributeType.class)
public class AttributeType_ { 

    public static volatile SingularAttribute<AttributeType, Integer> attributeTypeId;
    public static volatile SingularAttribute<AttributeType, String> description;
    public static volatile ListAttribute<AttributeType, ServiceNodeAttribute> serviceNodeAttributeList;
    public static volatile ListAttribute<AttributeType, ServiceAttribute> serviceAttributeList;

}