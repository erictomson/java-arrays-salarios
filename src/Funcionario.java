import java.text.NumberFormat;
import java.time.LocalDate;

public class Funcionario {

    public static void main(String[] args) {

        // Um funcionário de uma empresa recebe aumento salarial anualmente.
        // Faça um programa que determine o salário atual desse funcionário.

        //Definir faixa de anos estudado
        //Ano Inicial: 1995
        int anoInicial = 1995;
        //Ano Final = Ano Atual (2021)
        LocalDate anoFinal = LocalDate.now();

        //Definindo o tamanho do array a partir dos anos que quero trabalhar
        Double[] salarios = new Double[(anoFinal.getYear()-anoInicial)+1];
        //Controlando a taxa de reajuste e salário atualizado
        Double reajuste;
        Double salarioAtual=0.0;

        //Definindo o salário inicial
        //Esse funcionário foi contratado em 1995, com o salário inicial de R$1000,00;
        salarios[0]=1000.00;

        //Em 1996 recebeu um aumento de 1,5% sobre o seu salário inicial;
        reajuste=0.015; //1,5%
        salarios[1]=salarios[0]*(1+reajuste);

        //A partir de 1997 (inclusive), os aumentos salariais sempre corresponderam ao
        //dobro do percentual do ano anterior.
        for(int i=2;i<salarios.length;i++) {
            //dobrar o percentual
            reajuste=reajuste*2;
            //atualizar o salário do ano, aplicando a nova taxa de reajuste
            //sobre o salário anterior
            salarios[i]=salarios[i-1]*(1+reajuste);
            //atualizar o salário atual para exibir para o usuário
            salarioAtual=salarios[i];
        }

        // Imprimir todos os salários
        for(int i=0;i<salarios.length;i++) {
            System.out.println("Salário ano " + anoInicial + ": " + NumberFormat.getCurrencyInstance().format(salarios[i]));
            anoInicial++;
        }

        System.out.println("Salário atual: " + NumberFormat.getCurrencyInstance().format(salarioAtual));
    }
}
