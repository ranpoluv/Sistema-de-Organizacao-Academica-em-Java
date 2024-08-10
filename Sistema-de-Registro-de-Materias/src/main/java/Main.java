import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroDeMaterias registro = new RegistroDeMaterias();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Registro de Alunos e Matérias");
            System.out.println("1. Adicionar Aluno e Matéria");
            System.out.println("2. Atualizar Matéria de um Aluno");
            System.out.println("3. Buscar Aluno e Suas Matérias");
            System.out.println("4. Listar Todos os Alunos");
            System.out.println("5. Pesquisar Matéria e Listar Alunos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();
                    Aluno aluno = registro.buscarAluno(nomeAluno);
                    if (aluno == null) {
                        aluno = new Aluno(nomeAluno);
                        registro.adicionarAluno(aluno);
                    }

                    System.out.print("Nome da Matéria: ");
                    String nomeMateria = scanner.nextLine();
                    System.out.print("Nota: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer

                    Materia materia = new Materia(nomeMateria, nota);
                    aluno.adicionarMateria(materia);
                    System.out.println("Matéria adicionada com sucesso.");
                    break;

                case 2:
                    System.out.print("Nome do Aluno: ");
                    String nomeAlunoAtualizar = scanner.nextLine();
                    Aluno alunoAtualizar = registro.buscarAluno(nomeAlunoAtualizar);
                    if (alunoAtualizar == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.print("Nome da matéria para atualizar: ");
                    String nomeMateriaAtualizar = scanner.nextLine();
                    Materia materiaAtualizar = null;
                    for (Materia m : alunoAtualizar.getMaterias()) {
                        if (m.getNome().equalsIgnoreCase(nomeMateriaAtualizar)) {
                            materiaAtualizar = m;
                            break;
                        }
                    }

                    if (materiaAtualizar == null) {
                        System.out.println("Matéria não encontrada.");
                        break;
                    }

                    System.out.print("Nova Nota: ");
                    double novaNota = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer

                    materiaAtualizar.setNota(novaNota);
                    System.out.println("Matéria atualizada com sucesso.");
                    break;

                case 3:
                    System.out.print("Nome do Aluno para buscar: ");
                    String nomeAlunoBuscar = scanner.nextLine();
                    Aluno alunoBuscar = registro.buscarAluno(nomeAlunoBuscar);
                    if (alunoBuscar != null) {
                        System.out.println(alunoBuscar);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de Alunos e Suas Notas:");
                    registro.listarAlunos();
                    break;

                case 5:
                    System.out.print("Nome da Matéria para pesquisar: ");
                    String nomeMateriaPesquisar = scanner.nextLine();
                    registro.pesquisarMateria(nomeMateriaPesquisar);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}