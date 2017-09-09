package net.kariis.aplicacioncontactos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Karii on 08/09/2017.
 */

public class Contacto implements Parcelable {
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(Date fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    private String Email;
    private String twitter;
    private String telefono;

    public Contacto(String usuario, String email, String twitter, String telefono, Date fechaNaciemiento) {
        this.usuario = usuario;
        Email = email;
        this.twitter = twitter;
        this.telefono = telefono;
        this.fechaNaciemiento = fechaNaciemiento;
    }

    private Date fechaNaciemiento;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.usuario);
        dest.writeString(this.Email);
        dest.writeString(this.twitter);
        dest.writeString(this.telefono);
        dest.writeLong(this.fechaNaciemiento != null ? this.fechaNaciemiento.getTime() : -1);
    }

    public Contacto() {
    }

    protected Contacto(Parcel in) {
        this.usuario = in.readString();
        this.Email = in.readString();
        this.twitter = in.readString();
        this.telefono = in.readString();
        long tmpFechaNaciemiento = in.readLong();
        this.fechaNaciemiento = tmpFechaNaciemiento == -1 ? null : new Date(tmpFechaNaciemiento);
    }

    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel source) {
            return new Contacto(source);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };
}
