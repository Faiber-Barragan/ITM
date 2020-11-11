package reto_empresas;

public class Empresa {
    private String razonSocial;
    private int idCuentaAhorros = 1000;
    private int idCuentaCorriente = 5000;
    private double saldoAhorros;
    private double saldoCorriente;
    
    public Empresa(String razonSocial, double saldoAhorros, double saldoCorriente){
        this.razonSocial = razonSocial;
        this.saldoAhorros = saldoAhorros;
        this.saldoCorriente = saldoCorriente;
        idCuentaAhorros += 100;
        idCuentaCorriente += 100;
        System.out.println("#El numero de la cuenta de ahorros es: " + idCuentaAhorros);
        System.out.println("#El numero de la cuenta corriente es: " + idCuentaCorriente);
        System.out.println("");
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getIdCuentaAhorros() {
        return idCuentaAhorros;
    }

    public void setIdCuentaAhorros(int idCuentaAhorros) {
        this.idCuentaAhorros = idCuentaAhorros;
    }

    public int getIdCuentaCorriente() {
        return idCuentaCorriente;
    }

    public void sumarIdCuentaCorriente(int idCuentaCorriente) {
        this.idCuentaCorriente = idCuentaCorriente;
    }

    public double getSaldoAhorros() {
        return saldoAhorros;
    }

    public void sumarSaldoAhorros(double saldoAhorros) {
        this.saldoAhorros += saldoAhorros;
    }

    public double getSaldoCorriente() {
        return saldoCorriente;
    }

    public void sumarSaldoCorriente(double saldoCorriente) {
        this.saldoCorriente += saldoCorriente;
    }
    

}
