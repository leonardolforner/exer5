public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;
    private boolean isFlex = false;
    private boolean isFlexTanque = false;
    private boolean isEconomico = false;

    public Carro(String modelo) {
        this.modelo = modelo;
        switch(modelo){
            case "Basico":
            motor = new Motor(TipoCombustivel.GASOLINA, 10);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 55);
            break;
           
            case "Esportivo":
            motor = new Motor(TipoCombustivel.GASOLINA, 6);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 45);
            break;

            case "Utilitario":
            motor = new Motor(TipoCombustivel.DIESEL, 5);
            tanque = new TanqueCombustivel(TipoCombustivel.DIESEL, 70);
            break;

            case "SUV":
            motor = new Motor(TipoCombustivel.GASOLINA, 8);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 55);
            this.isFlex = true;
            break;

            case "SUVFlex":
            motor = new Motor(TipoCombustivel.GASOLINA, 8);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 65);
            this.isFlexTanque = true;
            break;

            case "Econo":
            motor = new Motor(TipoCombustivel.GASOLINA, 20);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 55);
            this.isEconomico = true;
            break;

            default:
            this.modelo = "Basico";
            motor = new Motor(TipoCombustivel.GASOLINA, 10);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 55);

        }        
    }

    public Carro(String modelo, TipoCombustivel tipoCombustivel) {
        
        this.modelo = modelo;
        this.isFlexTanque = true;

        switch(tipoCombustivel){
            case GASOLINA:
            motor = new Motor(TipoCombustivel.GASOLINA, 8);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 65);
            break;

            case ALCOOL:
            motor = new Motor(TipoCombustivel.ALCOOL, 6);
            tanque = new TanqueCombustivel(TipoCombustivel.ALCOOL, 65);
            break;

            default:
            motor = new Motor(TipoCombustivel.GASOLINA, 8);
            tanque = new TanqueCombustivel(TipoCombustivel.GASOLINA, 65);
            break;
        }
    
    }

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if(this.isFlexTanque == true&&tanque.getCombustivelDisponivel() == 0){
            switch(tipoCombustivel){
                case GASOLINA:
                motor.setMotor(TipoCombustivel.GASOLINA, 8);
                tanque.setTipoCombustivel(TipoCombustivel.GASOLINA);
                break;
    
                case ALCOOL:
                motor.setMotor(TipoCombustivel.ALCOOL, 6);
                tanque.setTipoCombustivel(TipoCombustivel.ALCOOL);;
                break;
    
                default:
                motor.setMotor(TipoCombustivel.GASOLINA, 8);
                tanque.setTipoCombustivel(TipoCombustivel.GASOLINA);
                break;
            }
        }
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }
    public void mudarMotor(TipoCombustivel tipoMotor, int consumo){
        if(this.isFlex == true){
            this.motor.setMotor(tipoMotor, consumo);
        }       
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
