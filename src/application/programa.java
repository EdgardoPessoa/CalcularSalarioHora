package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.Funcionario;
import entities.HorasContrato;
import entities.entities_enum.NivelFuncionario;

public class programa {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o nome do departamento: ");
        String nomeDepartamento = scan.nextLine();
        System.out.println("Entre com os dados do funcionario: ");
        System.out.print("Nome: ");
        String nomeFuncionario = scan.nextLine();
        System.out.print("Nivel: ");
        String nomeNivel = scan.nextLine();
        System.out.print("Salario Base: R$ ");
        double salarioBase = scan.nextDouble();
        Funcionario funcionario = new Funcionario(nomeFuncionario, NivelFuncionario.valueOf(nomeNivel), salarioBase, new Departamento(nomeDepartamento));

        System.out.print("Quantidade de contratos: ");
        int quantidadeContratos = scan.nextInt();

        for (int i = 0; i < quantidadeContratos; i++){
            System.out.println("Entre com os dados do contrato #" + (i+1) + ":");
            System.out.print("Data (DD/MM/AAAA): ");
            Date DataContrato = dataSimples.parse(scan.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = scan.nextDouble();
            System.out.print("Duração (Horas): ");
            int horas = scan.nextInt();
            HorasContrato contrato = new HorasContrato(DataContrato, valorPorHora, horas);
            funcionario.adicionarContrato(contrato);
        }

        System.out.println();
        System.out.print("Entre com mês e ano do contrato a ser calculado (MM/AAAA): ");
        String mes_e_ano = scan.next();
        int mes = Integer.parseInt(mes_e_ano.substring(0, 2));
        int ano = Integer.parseInt(mes_e_ano.substring(3));
        System.out.println("Nome: " + nomeFuncionario);
        System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
        System.out.println("Salario á receber por " + mes_e_ano + ": " + String.format("%.2f", funcionario.receber(ano, mes)));

        scan.close();
    }
}
