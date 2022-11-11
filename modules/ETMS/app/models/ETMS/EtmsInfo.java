package models.ETMS;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="etmsinfo")
public class EtmsInfo extends GenericModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String netticketid; //联网售票平台netticketid

    public String etmsid; //电子客票平台netticketid
    @Temporal(TemporalType.TIMESTAMP)
    public Date created;

    public Integer status;

    public String statusrs;

    public String orderno;

    public String qrcode;
}
