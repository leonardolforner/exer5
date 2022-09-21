public class Main {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico");
        Carro esportivo = new Carro("Esportivo");
        Carro utilitario = new Carro("Utilitario");
        Carro suv = new Carro("SUV");
        Carro suvFlex = new Carro ("SUVFlex");
        Carro econo = new Carro ("Econo");


        System.out.println("Tipos de veiculos:");
        System.out.println(basico);
        System.out.println(suvFlex);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        suvFlex.abastece(TipoCombustivel.ALCOOL,40);
        System.out.println(basico);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);
    }
}
