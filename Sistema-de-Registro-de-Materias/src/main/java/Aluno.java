import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private List<Materia> materias;

    public Aluno(String nome) {
        this.nome = nome;
        this.materias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void adicionarMateria(Materia materia) {
        materias.add(materia);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Aluno: ").append(nome).append("\n");
        for (Materia materia : materias) {
            sb.append(materia.toString()).append("\n");
        }
        return sb.toString();
    }
}