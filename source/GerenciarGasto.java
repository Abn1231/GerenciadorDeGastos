import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Scanner;


public class GerenciarGasto{
    public static double valorGastos;
    public static double valorSaldoInicial;
    public static double valorUltimoGasto;
    public static double saldoAtual;
    public static Scanner leia = new Scanner(System.in);
    public static Scanner leiaStr = new Scanner(System.in);
    public static ArrayList<Gasto> gastos = new ArrayList<Gasto>();

    public static void main(String[] args){
        int cmd = 0;
        do{
            System.out.println("-----------MENNU----------");
            System.out.println("1. Adicionar gasto -------");
            System.out.println("2. Editar gasto ----------");
            System.out.println("3. Salvar gasto ----------");
            System.out.println("4. Listar gastos ---------");
            System.out.println("5. Remover gasto ---------");
            System.out.println("6. Adicionar saldo inicial");
            System.out.println("7. Consultar saldo -------");
            System.out.println("8. Sair ------------------");
            cmd = leia.nextInt();

            if(cmd==1) {
                Gasto g = new Gasto();
                g = inserirValores();
                System.out.println(g.toString());
                gastos.add(g);
                System.out.println("Adicionar gasto efetuado com sucesso!");
            } else if (cmd == 2) {
                System.out.println("Digite o indice do objeto que deseja alterar");
                int indice = leia.nextInt();
                Gasto g = new Gasto();
                valorGastos -= valorUltimoGasto;
                g = inserirValores();
                valorGastos =  g.getValor();
                editarGasto(indice, g);
                
            } else if (cmd == 3) {
                salvarGastos();
            } else if (cmd == 4) {
                listarGastos();
            } else if (cmd == 5) {
                System.out.println("Digite o indice do objeto que deseja remover");
                int indice = leia.nextInt();
                removerGasto(indice);
                saldoAtual-= valorUltimoGasto;
            } else if (cmd == 6){
                System.out.println("Digite o valor do saldo inicial");
                valorSaldoInicial = leia.nextDouble();
            } else if (cmd == 7){
                saldoAtual = valorSaldoInicial - valorGastos;
                System.out.println("O valor do saldo atualmente é de: " + saldoAtual);
            } else {
                System.out.println("Sair!");
                break;
            }
        } while(true);
    }

    private static Gasto inserirValores(){
        System.out.println("Digite o nome do gasto");
        String nome = leiaStr.nextLine();
        System.out.println("Digite o valor do gasto");
        double valor = leia.nextDouble();
        System.out.println("Digite o tipo de gasto");
        String tipo = leiaStr.nextLine();
        Tipo t = new Tipo();
        t.setNome(tipo);
        Gasto g = new Gasto();
        g.setNome(nome);
        g.setValor(valor);
        g.setTipo(t);
        valorUltimoGasto = valor;
        valorGastos += valor;
        return g;
    }

    public static void salvarGastos(){
        try {
            FileWriter lista = new FileWriter("gastos.txt");
            lista.write(gastos.toString());
            lista.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarGasto(int indice, Gasto value){
        gastos.set(indice, value);
    }

    public static void removerGasto(int indice){
        gastos.remove(indice);
    }

    public static void listarGastos(){
        System.out.println(gastos.toString());
    }
}