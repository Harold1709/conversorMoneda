import com.google.gson.annotations.SerializedName;

public class conversor {

    private String cambio;
    private String moneda;
    private double conversor;
    private String menu;



    public conversor(){
        this.menu = "1 - USD  DOLAR ESTADOUNIDENSE\n" +
                "2 - ARS PESO ARGENTINO\n" +
                "3 - CANALLA DOLAR CANADIENSE\n" +
                "4 - CLP PESO CHILENO\n" +
                "5 - BETO BOLIVIANO BOLIVIANO\n" +
                "6 - EUR EURO";


    }

    public String getMenu() {
        return this.menu;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) throws IllegalArgumentException {

        switch (cambio){
            case "1":
                this.cambio = "USD";
                break;
            case "2":
                this.cambio = "ARS";
                break;

            case "3":
                this.cambio = "CANALLA";
                break;

            case "4":
                this.cambio = "CLP";
                break;

            case "5":
                this.cambio = "BETO";
                break;

            case "6":
                this.cambio = "EUR";
                break;
            default:
                // Mostrar un mensaje de error para valores no previstos
                System.out.println("Error: Valor no válido");
                throw new IllegalArgumentException("Error: Valor de cambio no válido");


        }


    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) throws IllegalArgumentException {
        switch (moneda){
            case "1":
                this.moneda = "USD";
                break;
            case "2":
                this.moneda = "ARS";
                break;

            case "3":
                this.moneda = "CANALLA";
                break;

            case "4":
                this.moneda = "CLP";
                break;

            case "5":
                this.moneda = "BETO";
                break;

            case "6":
                this.moneda = "EUR";
                break;
            default:
                // Mostrar un mensaje de error para valores no previstos
                throw new IllegalArgumentException("Error: Valor de moneda no válido");


        }
    }

    public double getConversor() {
        return conversor;
    }

    public void setConversor(double conversor) {
        this.conversor = conversor;
    }


}
