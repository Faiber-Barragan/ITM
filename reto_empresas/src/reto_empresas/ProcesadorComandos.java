
package reto_empresas;

import java.util.Scanner;



public class ProcesadorComandos {
    private static Scanner sc = new Scanner(System.in);
    private static String comando[];
    private static Empresa listaEmpresas[] = new Empresa[3];
    private static String razonSocial;
    private static double saldoAhorros;
    private static double saldoCorriente;
    private static double dineroEntrante;
    private static int contadorEmpresas = 0;
    private static String tipoVenta;
    private static int idCuenta;
    private static Empresa empresa;
    private static boolean encontroCuenta;
    private static boolean salirPrograma = false;
    
    
    public static void comandos(){
        System.out.println("     ESTE PROGRAMA ES UNA CONSOLA DE COMANDOS");
        System.out.println("#Para ingresar una empresa use: 1&empresa&saldoAhorro&saldoCorriente");
        System.out.println("#Para realizar una consignación use: 2&tipoventa&numero-cuenta&valor");
        System.out.println("#Para mostrar el saldo de un numero de cuenta use: 3&numeroCuenta");
        System.out.println("#Para salir use: 4\n\n");
        do{
            System.out.print("#Ingrase el comando: ");
            comando = sc.nextLine().split("&");
            String opcion = comando[0];
            switch(opcion){
                case "1":
                    if(contadorEmpresas > 2){
                        System.out.println("#No hay espacio en memoria para agregar más empresas\n");
                        break;
                    }
                    razonSocial = comando[1];
                    saldoAhorros = Double.parseDouble(comando[2]);
                    saldoCorriente = Double.parseDouble(comando[3]);
                    empresa = new Empresa(razonSocial, saldoAhorros, saldoCorriente);
                    listaEmpresas[contadorEmpresas] = empresa;
                    contadorEmpresas += 1;
                    break;
                case "2":
                    if(listaEmpresas[0] == null){
                        System.out.println("#No hay empresas creadas/n");
                        break;
                    }
                    tipoVenta = comando[1];
                    idCuenta = Integer.parseInt(comando[2]);
                    dineroEntrante = Double.parseDouble(comando[3]);
                    encontroCuenta = false;
                    if(tipoVenta.equalsIgnoreCase("cobro")){
                        for(int i=0; i<contadorEmpresas; i++){
//                            System.out.println(listaEmpresas[i]);
                            if(listaEmpresas[i].getIdCuentaAhorros() == idCuenta){
                                listaEmpresas[i].sumarSaldoAhorros(dineroEntrante);
                                System.out.println("#Transacción éxitosa\n");
                                encontroCuenta = true;
                            }
                            break;
                        }
                        if(encontroCuenta == false){
                            System.out.println("#La cuenta no existe\n");
                        }
                    }else if(tipoVenta.equalsIgnoreCase("factura")){
                        for(int i=0; i<contadorEmpresas; i++){
                            if(listaEmpresas[i].getIdCuentaCorriente() == idCuenta){
                                listaEmpresas[i].sumarSaldoCorriente(dineroEntrante);
                                System.out.println("#Transacción éxitosa\n");
                                encontroCuenta = true;
                                break;
                            }
                        }
                        if(encontroCuenta == false){
                            System.out.println("#La cuenta no existe\n");
                        }
                    }else{
                        System.out.println("#Tipo de facturación incorrecta\n");
                    }
                    break;
                case "3":
                    if(listaEmpresas[0] == null){
                        System.out.println("#No hay empresas creadas/n");
                        break;
                    }
                    encontroCuenta = false;
                    idCuenta = Integer.parseInt(comando[1]);
                    for(int i=0; i<contadorEmpresas; i++){
                        if(listaEmpresas[i].getIdCuentaAhorros() == idCuenta){
                            System.out.println("#Su saldo disponible en la cuenta de ahorros"+ idCuenta +" es "+ listaEmpresas[i].getSaldoAhorros()+"\n");
                            encontroCuenta = true;
                            break;
                        }else if(listaEmpresas[i].getIdCuentaCorriente() == idCuenta){
                            System.out.println("#Su saldo disponible en la cuenta corriente"+ idCuenta +" es "+ listaEmpresas[i].getSaldoCorriente()+"\n");
                            encontroCuenta = true;
                            break;
                        }
                    }
                    if(encontroCuenta == false){
                        System.out.println("#La cuenta no existe\n");
                    }
                    break;
                case "4":
                    salirPrograma = true;
                    break;
                default:
                    System.out.println("#El comando ingresado no se reconoce, intente de nuevo.\n");
            }
            
        }while(salirPrograma == false);
    }
    
}
