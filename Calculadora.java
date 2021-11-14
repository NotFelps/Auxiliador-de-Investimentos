import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Calculadora {

    List<Float> resultados = new LinkedList<>();
    int numAportes;

    public void calcula() {
        int aux = 0;
        while(aux == 0) {
            System.out.println("\n1 - Verificar rendimento em relacao a uma cotacao futura\n");
            System.out.println("99 - Gerar relatorio\n");
            System.out.println("0 - Encerrar programa\n");
            System.out.print("Selecione a opcao desejada : ");
            Scanner teclado = new Scanner(System.in);
            try {
                int opcao = teclado.nextInt(); 
                
                switch(opcao) {
                    case 0 :
                        aux = 1;
                        break;

                    case 99:
                        relatorio();
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

    public void relatorio() {
        float total = 0;
        for(Float a : resultados) {
            total += a;
        }
        System.out.println("\n======================================");
        System.out.println("Numero de aportes : "+numAportes);
        if(total>0) {
            System.out.println("Lucro total de : R$ "+new DecimalFormat("0.##").format(total));
        } else if(total==0) {
            System.out.println("Sem mudancas de capital (R$ 0)");
        } else System.out.println("Prejuizo de : R$ "+new DecimalFormat("0.##").format(total));
        System.out.println("======================================");
    }

    public void valorFuturo() {
        int i = 0;
        while (i==0) {
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
            resultados.add(lucro);
            numAportes++;
            if(cotIni < cotFim) {
                System.out.println("Lucro de : R$ "+new DecimalFormat("0.##").format(lucro)+" ("+new DecimalFormat("0.##").format(porcentagem-100)+"%)\n");
            } else {
                System.out.println("Prejuizo de : R$ "+new DecimalFormat("0.##").format(lucro)+" ("+new DecimalFormat("0.##").format(porcentagem-100)+"%)\n");
            }
            teclado.nextLine();
            System.out.print("Deseja realizar novo aporte?(sim/nao) : ");
            String resp = teclado.nextLine();
            if(resp.equals("nao")) i = 1;
        }
    }
}
