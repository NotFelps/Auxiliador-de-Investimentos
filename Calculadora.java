import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Calculadora {

    public void calcula() {
        imprimeEnum();
        Scanner teclado = new Scanner(System.in);
        int opcao = teclado.nextInt(); 
            switch(opcao) {
                case 0 :
                    valorFuturo();
                    break;
            }
    }
    

    public void imprimeEnum() {
        System.out.println("\n=============================================================================================");
        System.out.println("\n\t\tBem-vindo ao calculador de investimentos do FeWps!");
        System.out.println("\n0 - Verificar rendimento em relacao a um valor futuro\n");
        System.out.print("Selecione a opcao desejada : ");
    }

    public void valorFuturo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n------------------------------------------------------");
        System.out.println("\nCaso escolhido : 0\n");
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
