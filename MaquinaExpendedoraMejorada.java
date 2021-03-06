public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Contar billetes
    private  int contarBilletesVendidos;
    // Dar premio
    private boolean maquinaPremio;
    // Indicar numero max billetes
    private int numeroMaximoDeBilletes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean recompensa, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        contarBilletesVendidos = 0;
        maquinaPremio = recompensa;
        numeroMaximoDeBilletes = maximoBilletes;
    }

    public int getcontarBilletesVendidos(){
        return contarBilletesVendidos;
    }

    /**
     * Devuelve el precio del billete
     */

    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida){
        if (contarBilletesVendidos >= numeroMaximoDeBilletes) {
            System.out.println("No hay billetes disponibles");
        }
        else {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }  
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (contarBilletesVendidos >= numeroMaximoDeBilletes) {
            System.out.println("No hay billetes disponibles");
        }
        else {
            if (cantidadDeDineroQueFalta <=0 ) {

                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println(); 

                contarBilletesVendidos = contarBilletesVendidos + 1 ;    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;

                if (maquinaPremio == true) {
                    if (contarBilletesVendidos%3 == 0 ){
                        System.out.println("##################");
                        System.out.println("?Descuento del 10% del coste del billete para compras en el CarGlass!"); 
                    }
                }
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");

            }
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    public int vaciarDineroDeLaMaquina () {
        int valorADevolver = 0;
        if (balanceClienteActual ==0 ) {
            valorADevolver = balanceClienteActual + totalDineroAcumulado;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            valorADevolver =-1;
            System.out.println("Finalizar oparaci?n en curso");

        }
        return valorADevolver;
    }

    public void imprimeNumeroBilletesVendidos () {
        int NumeroDeBilletes= contarBilletesVendidos;
        System.out.println("###############");
        System.out.println("Numero de billetes = " + NumeroDeBilletes);
    }
}

