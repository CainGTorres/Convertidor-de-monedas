
package com.gabic.convertidordemonedas.convertidor;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDeApi {
  
  private double valorMonedaOriginal=0.0; //moneda sin convertir
    private double valorMonedaConvertida=0.0;
    private String divisaACambiar;
    private String divisaARecibir;

    @Override
    public String toString() {
        return "Divisa a cambiar='" + divisaACambiar + '\'' +
                ", Divisa a recibir='" + divisaARecibir + '\'' +
                ", Valor de cambio= $ " + valorMonedaOriginal +" "+divisaARecibir+ " equivale a $1 " +divisaACambiar +
                ", total a recibir=$ " + valorMonedaConvertida + " " + divisaARecibir ;
    }

    public ConsultaDeApi() {

    }


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

        public ConsultaDeApi (Convertidor datoAPI){

            this.divisaACambiar=datoAPI.base_code();
            this.divisaARecibir= datoAPI.target_code();
            this.valorMonedaOriginal = datoAPI.conversion_rate();
            this.valorMonedaConvertida = datoAPI.conversion_result();

          }
    public ConsultaDeApi buscaDivisas(String divisa1, String divisa2, double cantidad){

        BigDecimal cantidad2 = new BigDecimal(cantidad); //para soportar grandes cantidades
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/fb3917dedfb0e8000ff9aeb5/latest/USD"+divisa1+"/"+divisa2+"/"+cantidad2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Convertidor datosAPI = new Gson().fromJson(response.body(), Convertidor.class);
            ConsultaDeApi resultadosConversion= new ConsultaDeApi(datosAPI);
            return resultadosConversion;

        } catch (JsonSyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException("No se encontrÃ³ divisa ingresada.");
        }


    }
}
