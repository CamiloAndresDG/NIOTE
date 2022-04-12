package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Institucion;
import co.edu.usbbog.datan.piico.piicows.model.Red;
import co.edu.usbbog.datan.piico.piicows.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile SingularAttribute<Proyecto, String> tipo;
    public static volatile ListAttribute<Proyecto, Usuario> usuarioList;
    public static volatile SingularAttribute<Proyecto, Date> fechaInicio;
    public static volatile ListAttribute<Proyecto, Institucion> institucionList;
    public static volatile ListAttribute<Proyecto, Red> redList;
    public static volatile SingularAttribute<Proyecto, Integer> id;
    public static volatile SingularAttribute<Proyecto, String> nombre;

}