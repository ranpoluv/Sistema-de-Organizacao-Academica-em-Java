import java.util.ArrayList;
import java.util.List;

public class RegistroDeMaterias {
    private List<Aluno> alunos;

    public RegistroDeMaterias() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
            return;
        }
        for (Aluno aluno : alunos) {
            System.out.println("Nome do Aluno: " + aluno.getNome());
            for (Materia materia : aluno.getMaterias()) {
                System.out.println("  Matéria: " + materia.getNome() + ", Nota: " + materia.getNota());
            }
        }
    }

    // Novo método para pesquisar uma matéria e listar todos os alunos que escolheram essa matéria
    public void pesquisarMateria(String nomeMateria) {
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            for (Materia materia : aluno.getMaterias()) {
                if (materia.getNome().equalsIgnoreCase(nomeMateria)) {
                    if (!encontrado) {
                        System.out.println("Alunos que escolheram a matéria '" + nomeMateria + "':");
                        encontrado = true;
                    }
                    System.out.println("  Nome do Aluno: " + aluno.getNome() + ", Nota: " + materia.getNota());
                }
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum aluno escolheu a matéria '" + nomeMateria + "'.");
        }
    }
}