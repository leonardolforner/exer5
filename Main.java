public class Main {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Esportivo("Esportivo", TipoCombustivel.GASOLINA, 6, 45);
        Carro utilitario = new Utilitario("Utilitario", TipoCombustivel.DIESEL, 5, 70);
        Carro suv = new Carro("SUV", TipoCombustivel.GASOLINA, 8, 55);
        Carro suvFlex = new Carro ("SUVFlex", TipoCombustivel.GASOLINA, 8, 65);
        Carro econo = new Carro ("Econo", TipoCombustivel.GASOLINA, 20, 55);


        System.out.println("Tipos de veiculos:");
        System.out.println(basico);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);
    }
}
