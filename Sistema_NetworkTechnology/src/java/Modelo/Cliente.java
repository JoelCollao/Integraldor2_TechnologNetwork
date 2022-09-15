
package Modelo;

public class Cliente {
    protected String cli_codigo;
    protected String cli_nombre;
    protected String cli_apepat;
    protected String cli_apemat;
    protected String cli_doi;
    protected String cli_direccion;
    protected String cli_distrito;
    protected String cli_telefono;
    protected String cli_email;
    protected String cli_password;

    public Cliente(String cli_codigo, String cli_nombre, String cli_apepat, String cli_apemat, String cli_doi, String cli_direccion, String cli_distrito, String cli_telefono, String cli_email, String cli_password) {
        this.cli_codigo = cli_codigo;
        this.cli_nombre = cli_nombre;
        this.cli_apepat = cli_apepat;
        this.cli_apemat = cli_apemat;
        this.cli_doi = cli_doi;
        this.cli_direccion = cli_direccion;
        this.cli_distrito = cli_distrito;
        this.cli_telefono = cli_telefono;
        this.cli_email = cli_email;
        this.cli_password = cli_password;
    }

    public Cliente() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getCli_codigo() {
        return cli_codigo;
    }

    public void setCli_codigo(String cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apepat() {
        return cli_apepat;
    }
    
    public String getCli_apemat() {
        return cli_apemat;
    }

    public void setCli_apepat(String cli_apepat) {
        this.cli_apepat = cli_apepat;
    }
    
    public void setCli_apemat(String cli_apemat) {
        this.cli_apemat = cli_apemat;
    }

    public String getCli_doi() {
        return cli_doi;
    }

    public void setCli_doi(String cli_doi) {
        this.cli_doi = cli_doi;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public String getCli_distrito() {
        return cli_distrito;
    }

    public void setCli_distrito(String cli_distrito) {
        this.cli_distrito = cli_distrito;
    }

    public String getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_password() {
        return cli_password;
    }

    public void setCli_password(String cli_password) {
        this.cli_password = cli_password;
    }
    
    
}
