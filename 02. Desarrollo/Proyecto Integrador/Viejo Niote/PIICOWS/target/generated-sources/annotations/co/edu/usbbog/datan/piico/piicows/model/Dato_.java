package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Sensor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Dato.class)
public class Dato_ { 

    public static volatile SingularAttribute<Dato, Date> fecha;
    public static volatile SingularAttribute<Dato, String> ubicacion;
    public static volatile SingularAttribute<Dato, String> valor;
    public static volatile SingularAttribute<Dato, Sensor> sensor;
    public static volatile SingularAttribute<Dato, Integer> id;

}