package basicas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Funcionario {

    private int codigo;
    private String nome;
    private double salario;
    private Date dataNascimento;

    public Funcionario(String nome, String idade, String dataNascimento) {
        this.setNome(nome);
        this.setSalario(idade);
        this.setDataNascimento(dataNascimento);
    }

    public Funcionario(String nome, int idade, Date dataNascimento) {
        this.setNome(nome);
        this.setSalario(idade);
        this.setDataNascimento(dataNascimento);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setSalario(String salario) {
        double temp = Double.parseDouble(salario);
        this.setSalario(temp);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        Calendar calendar = new GregorianCalendar();
        String[] data = dataNascimento.split("/");
        int date = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);
        calendar.set(year, month - 1, date);
        this.setDataNascimento(calendar.getTime());
    }

    @Override
    public boolean equals(Object o) {
        Funcionario f = (Funcionario) o;
        if (f.getCodigo() == this.codigo) {
            return true;
        } else {
            return false;
        }
    }
}
