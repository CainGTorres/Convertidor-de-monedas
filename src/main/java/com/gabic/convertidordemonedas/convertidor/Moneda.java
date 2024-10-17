
package com.gabic.convertidordemonedas.convertidor;

public class Moneda {
  
  private double valorMonedaOriginal=0.0; //moneda sin convertir
    private double valorMonedaConvertida=0.0;
    private String divisaACambiar;
    private String divisaARecibir;

    public String getDivisaACambiar() {
        return divisaACambiar;
    }

    public void setDivisaACambiar(String divisaACambiar) {
        this.divisaACambiar = divisaACambiar;
    }

    public String getDivisaARecibir() {
        return divisaARecibir;
    }

    public void setDivisaARecibir(String divisaARecibir) {
        this.divisaARecibir = divisaARecibir;
    }

    public double getvalorMonedaOriginal() {
        return valorMonedaOriginal;
    }

    public void setvalorMonedaOriginal(double monedaOriginal) {
        this.valorMonedaOriginal = monedaOriginal;
    }

    public double getvalorMonedaConvertida() {
        return valorMonedaConvertida;
    }

    public void setvalorMonedaConvertida(double monedaConvertida) {
        this.valorMonedaConvertida = monedaConvertida;
    }

    public String menu(){

        return("""
               -----------------------JEO CONVERSOR DE MONEDAS-------------------------
               1- D\u00c3\u00b3lar            ---> Peso Argentino
               2- Peso Argentino   ---> D\u00c3\u00b3lar
               3- Dolar            ---> Real brasile\u00c3\u00b1o
               4- Real brasile\u00c3\u00b1o   ---> Dolar
               5- Dolar            ---> Peso Colombiano
               6- Peso Colombiano  ---> Dolar
               9- SALIR DE CONVERSOR""");
    }
}
