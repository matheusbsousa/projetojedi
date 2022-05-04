package jedi.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Calculo de imposto
        //TODO Que me peça o salário e calcule IR, INSS e mostre quanto estou pagando em cada um.
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o seu salário: ");
        int salario = scan.nextInt();

        System.out.println("Digite o salário de cálculo: ");
        double salarioCalculo = scan.nextInt();


//        01
        double inss = 0.14;
        double ir = 0;

        if(salario > salarioCalculo){
//            Imposto de renda: 1350.27
            ir = 0.27;
        }

        if(salario < salarioCalculo){
//            Imposto de renda: 749.85
            ir = 0.15;
        }

        if(salario == salarioCalculo){
//            Imposto de renda: 749.85
            ir = 0.20;
        }

//        01
        double descontoInss = salario * inss;
        double desccontoIr = salario * ir;
        double salarioComDesconto = salario - descontoInss - desccontoIr;
        double totalDesconto = descontoInss + desccontoIr;

        System.out.println("Salário bruto: R$ " + salario);
        System.out.println("INSS: " + descontoInss);
        System.out.println("Imposto de renda: " + desccontoIr);
        System.out.println("Está sendo descontado do salário: " + totalDesconto);
        System.out.println("Salaŕio liquido: " + salarioComDesconto);

    }
}
