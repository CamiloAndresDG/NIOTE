package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.PuertaDeEnlace;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Mensajes.class)
public class Mensajes_ { 

    public static volatile SingularAttribute<Mensajes, Date> fecha;
    public static volatile SingularAttribute<Mensajes, PuertaDeEnlace> puertaDeEnlace;
    public static volatile SingularAttribute<Mensajes, String> tipo;
    public static volatile SingularAttribute<Mensajes, Short> estado;
    public static volatile SingularAttribute<Mensajes, String> id;
    public static volatile SingularAttribute<Mensajes, String> mensaje;

}