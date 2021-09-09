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
        int anoAtual;

        //Definindo o tamanho do array a partir dos anos que quero trabalhar
        Double[] salarios = new Double[(anoFinal.getYear()-anoInicial)+1];
        //Controlando a taxa de reajuste e salário atualizado
        Double reajuste=0.0;
        Double salarioAtual=0.0;

        //Inicializando o controle do anoAtual (1995)
        anoAtual=anoInicial;

        //A partir de 1997 (inclusive), os aumentos salariais sempre corresponderam ao
        //dobro do percentual do ano anterior.
        for(int i=0;i<salarios.length;i++) {
            if(anoAtual==1995) {
                //Definindo o salário inicial
                //Esse funcionário foi contratado em 1995, com o salário inicial de R$1000,00;
                salarios[i]=1000.00;
                anoAtual++;
                continue;
            } else if (anoAtual==1996) {
                //Em 1996 recebeu um aumento de 1,5% sobre o seu salário inicial;
                reajuste=0.015; //1,5%
            } else {
                // para os outros anos, dobrar o percentual de reajuste
                reajuste = reajuste * 2;
            }
            //atualizar o salário do ano, aplicando a nova taxa de reajuste
            //sobre o salário anterior
            salarios[i]=salarios[i-1]*(1+reajuste);
            //atualizar o salário atual para exibir para o usuário
            salarioAtual=salarios[i];
            //Incrementa o ano atual
            anoAtual++;
        }

        //Reinicializando o controle do anoAtual (1995)
        anoAtual=anoInicial;

        // Imprimir todos os salários
        for(int i=0;i<salarios.length;i++) {
            System.out.println("Salário ano " + anoAtual + ": " + NumberFormat.getCurrencyInstance().format(salarios[i]));
            anoAtual++;
        }

        System.out.println("Salário atual: " + NumberFormat.getCurrencyInstance().format(salarioAtual));
    }
}
