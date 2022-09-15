
package Modelo;

public class Administrador {
    
    private String admin_cod;
    private String admin_nombre;
    private String admin_apepat;
    private String admin_apemat;
    private String admin_fec_ing;
    private String admin_LOC;
    private String admin_password;
    private String admin_estado;
    
    public Administrador(){
        
    }

    public Administrador(String admin_cod, String admin_nombre, String admin_apepat, String admin_apemat, String admin_fec_ing, String admin_LOC, String admin_password, String admin_estado) {
        this.admin_cod = admin_cod;
        this.admin_nombre = admin_nombre;
        this.admin_apepat = admin_apepat;
        this.admin_apemat = admin_apemat;
        this.admin_fec_ing = admin_fec_ing;
        this.admin_LOC = admin_LOC;
        this.admin_password = admin_password;
        this.admin_estado = admin_estado;
    }

    public String getAdmin_cod() {
        return admin_cod;
    }

    public void setAdmin_cod(String admin_cod) {
        this.admin_cod = admin_cod;
    }

    public String getAdmin_nombre() {
        return admin_nombre;
    }

    public void setAdmin_nombre(String admin_nombre) {
        this.admin_nombre = admin_nombre;
    }

    public String getAdmin_apepat() {
        return admin_apepat;
    }

    public String getAdmin_apemat() {
        return admin_apemat;
    }

    public void setAdmin_apepat(String admin_apepat) {
        this.admin_apepat = admin_apepat;
    }

    public void setAdmin_apemat(String admin_apemat) {
        this.admin_apemat = admin_apemat;
    }

    public String getAdmin_fec_ing() {
        return admin_fec_ing;
    }

    public void setAdmin_fec_ing(String admin_fec_ing) {
        this.admin_fec_ing = admin_fec_ing;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_estado() {
        return admin_estado;
    }

    public void setAdmin_estado(String admin_estado) {
        this.admin_estado = admin_estado;
    }

    public String getAdmin_LOC() {
        return admin_LOC;
    }

    public void setAdmin_LOC(String admin_LOC) {
        this.admin_LOC = admin_LOC;
    }
    
    
}
