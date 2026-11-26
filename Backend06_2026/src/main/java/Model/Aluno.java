package Model;

import java.util.Date;

public class Aluno extends Pessoa {
    private String matricula;
    private Date dataMatricula;
    private String curso;
    private int semestre;

    public Aluno(String codigo) {
        super(codigo);
    }

    public Aluno(String codigo, String nome) {
        super(codigo, nome);
    }

    public Aluno(String codigo, String nome, Date dataNascimento,
                 String email, String telefone) {
        super(codigo, nome, dataNascimento, email, telefone);
    }

    public Aluno(String codigo, String nome, Date dataNascimento,
                 String email, String telefone, String matricula,
                 Date dataMatricula, String curso, int semestre) {
        super(codigo, nome, dataNascimento, email, telefone);
        this.matricula = matricula;
        this.dataMatricula = dataMatricula;
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao()
                + " | Matrícula: " + getMatricula()
                + " | Data de Matrícula: " + getDataMatricula()
                + " | Curso: " + getCurso()
                + " | Semestre: " + getSemestre();
    }
}