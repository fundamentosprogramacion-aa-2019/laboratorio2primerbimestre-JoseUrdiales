/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author Jose Luis
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String cadena = "";
        String nombres = "";
        String apellidos = "";
        String tipoEmpleado = "";
        double incentivo = 0;
        double total = 0;
        int hijos = 0;
        int bono = 0;
        int edad = 0;
        double sueldoMensual = 0;
        double descuento = 0;
        double seguroSocial = 0;
        double totalIncentivo = 0;
        double totalEmpresa = 0;
        int totalHijos = 0;
        boolean bandera = true;
        String valorUsuario = "";
        cadena = String.format("%s%s\n", cadena, 
                "\n\n-------REPARTO DE ROL DE PAGOS POR EMPLEADO-------\n\n");
        do{ 
            System.out.println("Ingrese sus nombres: ");
            nombres = entrada.nextLine();
            
            System.out.println("Ingrese sus apellidos: ");
            apellidos = entrada.nextLine();
            
            System.out.println("Ingrese su edad: ");
            edad = entrada.nextInt();
            entrada.nextLine();
            
            System.out.println("Ingrese el tipo de empleado que sea usted "
                    + "(tipo 1, tipo 2, tipo 3 o tipo 4) ");
            tipoEmpleado = entrada.nextLine();
            
            System.out.println("¿Cuantos hijos tiene usted?: ");
            hijos = entrada.nextInt();
            /*
             * Ifs que utilizo para determinar el valor del sueldo mensual y 
             * del incentivo de acuerdo al tipo de empleo que la persona posee
             */
            if (tipoEmpleado.equals ("Tipo 1") || 
                    tipoEmpleado.equals ("tipo 1")){
                sueldoMensual = 340;
                incentivo = (sueldoMensual * 5)/100;
            } else {
                if (tipoEmpleado.equals ("Tipo 2") || 
                        tipoEmpleado.equals ("tipo 2")){
                    sueldoMensual = 460;
                    incentivo = (sueldoMensual * 10)/100;
                } else {
                    if (tipoEmpleado.equals ("Tipo 3") || 
                            tipoEmpleado.equals ("tipo 3")){
                        sueldoMensual = 580;
                        incentivo = (sueldoMensual * 15)/100;
                    } else {
                        if (tipoEmpleado.equals ("Tipo 4") || 
                                tipoEmpleado.equals ("tipo 4")){
                            sueldoMensual = 600;
                            incentivo = (sueldoMensual * 15)/100;
                        }
                    }
                }
            }
            /*
             * if que utilizo para determinar el valor del bono de acuerdo al 
             * numero de hijos que tiene la persona
             */
            if (hijos >= 1) {
                bono = hijos * 10;
            }
             /*
             * if que utilizo para determinar el valor del descuento del seguro 
             * y del valor total de acuerdo a la edad de la persona.
             */
            if (edad <= 20){
                descuento = sueldoMensual - 15;
                total = descuento + incentivo + bono;
            } else {
                if ((edad > 20) && (edad <= 30)){
                    descuento = sueldoMensual - 25;
                    total = descuento + incentivo + bono;
                } else {
                    if (edad > 31){
                        descuento = sueldoMensual - 25;
                        total = descuento + incentivo + bono;
                    }
                }
            }
            cadena = String.format("%s NOMBRE: %s %s, (%d años)\n\t "
                    + "SUELDO MENSUAL: %.2f$\n\t INCENTIVO-1: %.2f$\n\t "
                    + "HIJOS: %d\n\t DESCUENTO: SS %.2f$ \n\t "
                    + "TOTAL A PAGAR: %.2f$\n\n", 
                    cadena, nombres, apellidos, edad, sueldoMensual, 
                    incentivo, hijos, descuento, total);
            entrada.nextLine();
            
            seguroSocial = descuento + seguroSocial;
            totalIncentivo = incentivo + totalIncentivo;
            totalHijos = bono + totalHijos;
            totalEmpresa = total + totalEmpresa;
            
            System.out.println("¿Desea salir? ingrese 'si' "
                    + "en caso de que quiera salir, ingrese 'no' "
                    + "en caso de que quiera seguir.");
            valorUsuario = entrada.nextLine();
            
            if (valorUsuario.equals ("si") || valorUsuario.equals ("Si") || 
                    valorUsuario.equals ("SI")){
                bandera = false;
            }
            
        }while (bandera == true) ;
        
        cadena = String.format("%s%s\n", cadena, 
                "\n\n----Reporte de Rol de Pagos de la Empresa(Totales)----\n");
        
        cadena = String.format("%s DESCUENTO SEGURO SOCIAL = %.2f$\n "
                + "TOTAL INCENTIVO = %.2f$\n PAGO POR HIJOS = %d$\n "
                + "TOTAL PAGO DE LA EMPRESA = %.2f$\n", 
                    cadena, seguroSocial, totalIncentivo, totalHijos, 
                    totalEmpresa);
        
        System.out.printf("%s", cadena);
    }
}
