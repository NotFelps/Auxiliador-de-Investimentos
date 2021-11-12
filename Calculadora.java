import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Calculadora {

    public void calcula() {
        imprimeEnum();
        int aux = 0;
        while(aux == 0) {
            System.out.println("\n1 - Verificar rendimento em relacao a uma cotacao futura\n");
            System.out.println("0 - Encerrar programa\n");
            System.out.print("Selecione a opcao desejada : ");
            Scanner teclado = new Scanner(System.in);
            try {
                int opcao = teclado.nextInt(); 
                
                switch(opcao) {
                    case 0 :
                        aux = 1;
                        break;

                    case 1 :
                        valorFuturo();
                        break;
                }
            } catch (java.util.NoSuchElementException e) {
                System.out.println("\nNenhuma opcao correspondida.");
            }
        }
    }
    

    public void imprimeEnum() {
        System.out.println("\n=============================================================================================");
        System.out.println("\n\t\tBem-vindo ao calculador de investimentos do FeWps!");
        System.out.println("\n=============================================================================================");
    }

    public void valorFuturo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n------------------------------------------------------");
        System.out.println("\nCaso escolhido : 1\n");
        System.out.print("Digite a cotacao inicial : ");
        float cotIni = teclado.nextFloat();  //cotacao inicial
        System.out.print("\nDigite o valor investido (em reais) : ");
        float valorIni = teclado.nextFloat();  //valor investido no inicio em reais
        System.out.print("\nDigite a cotacao final desejada : ");
        float cotFim = teclado.nextFloat();
        System.out.println("\nNa cotacao "+cotFim+" voce tera :\n");
        float div = cotFim/cotIni;
        float porcentagem = div*100;
        float lucro = (valorIni*div)-valorIni;
        if(cotIni < cotFim) {
            System.out.println("Lucro de : R$ "+new DecimalFormat("0.##").format(lucro)+" ("+new DecimalFormat("0.##").format(porcentagem-100)+"%)\n");
        } else System.out.println("Prejuizo de : R$ "+new DecimalFormat("0.##").format(lucro)+" ("+new DecimalFormat("0.##").format(porcentagem-100)+"%)\n");
    }
}
