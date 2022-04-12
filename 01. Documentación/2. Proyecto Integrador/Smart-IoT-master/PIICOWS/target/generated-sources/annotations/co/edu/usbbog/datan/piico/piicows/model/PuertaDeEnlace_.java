package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Auth;
import co.edu.usbbog.datan.piico.piicows.model.Mensajes;
import co.edu.usbbog.datan.piico.piicows.model.Nodo;
import co.edu.usbbog.datan.piico.piicows.model.Red;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(PuertaDeEnlace.class)
public class PuertaDeEnlace_ { 

    public static volatile SingularAttribute<PuertaDeEnlace, String> descripcion;
    public static volatile SingularAttribute<PuertaDeEnlace, String> direccionLogica;
    public static volatile ListAttribute<PuertaDeEnlace, Mensajes> mensajesList;
    public static volatile SingularAttribute<PuertaDeEnlace, Short> estado;
    public static volatile ListAttribute<PuertaDeEnlace, Nodo> nodoList;
    public static volatile ListAttribute<PuertaDeEnlace, Red> redList;
    public static volatile SingularAttribute<PuertaDeEnlace, String> id;
    public static volatile ListAttribute<PuertaDeEnlace, Auth> authList;
    public static volatile SingularAttribute<PuertaDeEnlace, String> protComunExt;
    public static volatile SingularAttribute<PuertaDeEnlace, String> puertoDeServicio;

}