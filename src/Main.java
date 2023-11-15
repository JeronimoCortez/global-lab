import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cantSecuencias = 1;
        String adn [] = new String[6];
        String secuencia;
        boolean letraInvalida;
        char caracter;
        int posicion = 0;
        Scanner read = new Scanner(System.in);
        System.out.println("Debe ingresar 6 secuencias de 6 letras");
        System.out.println("Las letras permitidas en la base nitrogenada son A,T,C,G");
        while(cantSecuencias <= 6){
            System.out.println("Ingrese la secuencia de 6 letras " + cantSecuencias +"/6");
            secuencia = read.nextLine();
            letraInvalida = false;
            if (secuencia.length() == 6){
                for (int i = 0; i < secuencia.length(); i++) {
                    caracter = Character.toUpperCase(secuencia.charAt(i));
                    if(caracter != 'A'&& caracter != 'T' && caracter != 'C' && caracter != 'G'){
                        letraInvalida = true;
                        break;
                    }
                }
                if (letraInvalida == true){
                    System.out.println("No ingreso letras permitidas");
                }else{
                    adn[posicion] = secuencia.toUpperCase();
                    posicion++;
                    cantSecuencias++;
                }
            }else{
                System.out.println("La secuencia debe tener 6 letras");
            }
        }
        boolean verificarMutante = esMutante(adn);
        if(verificarMutante == true){
            System.out.println("El humano es mutante");
        }else{
            System.out.println("El hummano no es mutante");
        }
        //adn['ATCGTG','CCCCGT','TATGTT','TCGTTC','TGACCT','GTCATG'] en esta secuencia hay presencia de genes mutantes
        //adn = ['ATCCGT','TATGGT','CAGCTA','TCTAGT','GCTAGT','TACGTA'] en esta secuencia no hay presencia de genes mutantes
    }
    public static boolean esMutante(String [] adn){
        for (int row = 0; row < adn.length-3; row++) {
            for (int col = 0; col < adn.length-3; col++) {
                if (adn[row].charAt(col) == adn[row + 1].charAt(col + 1) &&
                        adn[row + 1].charAt(col + 1) == adn[row + 2].charAt(col + 2) &&
                        adn[row + 2].charAt(col + 2) == adn[row + 3].charAt(col + 3)) {
                    return true; // Verifica las diagonales principales
                }
                if (adn[row].charAt(col + 3) == adn[row + 1].charAt(col + 2) &&
                        adn[row + 1].charAt(col + 2) == adn[row + 2].charAt(col + 1) &&
                        adn[row + 2].charAt(col + 1) == adn[row + 3].charAt(col)) {
                    return true; // Verifica diagonales secundarias
                }
                if (adn[row].charAt(col) == adn[row].charAt(col + 1) &&
                        adn[row].charAt(col + 1) == adn[row].charAt(col + 2) &&
                        adn[row].charAt(col + 2) == adn[row].charAt(col + 3)) {
                    return true; // Verifica de manera vertical
                }
                if (adn[row].charAt(col) == adn[row + 1].charAt(col) &&
                        adn[row + 1].charAt(col) == adn[row + 2].charAt(col) &&
                        adn[row + 2].charAt(col) == adn[row + 3].charAt(col)) {
                    return true; // Verifica de manera horizontal
                }
            }
        }
        return false;
    }
}