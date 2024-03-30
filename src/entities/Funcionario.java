package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.entities_enum.NivelFuncionario;

public class Funcionario {
    // Atributos:
    private String nome;
    private NivelFuncionario nivel;
    private Double salarioBase;

    // Associações:
    private Departamento departamento;
    private List<HorasContrato> contratos = new ArrayList<>();

    // Construtores:    
    public Funcionario(){}

    public Funcionario(String nome, NivelFuncionario nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    // Getters e Setters:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelFuncionario getNivel() {
        return nivel;
    }

    public void setNivel(NivelFuncionario nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HorasContrato> getContratos() {
        return contratos;
    }

    // Metodos:

    public void adicionarContrato(HorasContrato contrato){
        contratos.add(contrato);
    }
    public void removerContrato(HorasContrato contrato){
        contratos.remove(contrato);
    }
    public double receber(int year, int month){
        double somaSalario = salarioBase;
        Calendar calendario = Calendar.getInstance();
        for(HorasContrato contratoFuncionario : contratos){
            calendario.setTime(contratoFuncionario.getData());
            int c_ano = calendario.get(Calendar.YEAR);
            int c_mes = 1 + calendario.get(Calendar.MONTH);
            if(year == c_ano && month == c_mes){
                somaSalario += contratoFuncionario.valorTotal();
            }
        }
        return somaSalario;
    }


    
}
