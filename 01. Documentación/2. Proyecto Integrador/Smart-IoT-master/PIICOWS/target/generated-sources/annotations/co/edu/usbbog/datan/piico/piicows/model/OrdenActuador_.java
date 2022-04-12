package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Actuador;
import co.edu.usbbog.datan.piico.piicows.model.Orden;
import co.edu.usbbog.datan.piico.piicows.model.OrdenActuadorPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(OrdenActuador.class)
public class OrdenActuador_ { 

    public static volatile SingularAttribute<OrdenActuador, Short> confirmacion;
    public static volatile SingularAttribute<OrdenActuador, Date> fecha;
    public static volatile SingularAttribute<OrdenActuador, Actuador> actuador;
    public static volatile SingularAttribute<OrdenActuador, OrdenActuadorPK> ordenActuadorPK;
    public static volatile SingularAttribute<OrdenActuador, Orden> orden;

}