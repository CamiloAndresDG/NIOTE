package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(NodeType.class)
public class NodeType_ { 

    public static volatile ListAttribute<NodeType, ServiceNode> serviceNodeList;
    public static volatile SingularAttribute<NodeType, String> description;
    public static volatile SingularAttribute<NodeType, Integer> nodeTypeId;

}