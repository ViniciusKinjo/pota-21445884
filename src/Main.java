import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

//Rafael Oliveira de Araújo RA: 21452978
//Thiago Diniz Cabral RA: 21442918
//Vinicius Hidenori Kinjo RA: 21445884

public class Main {
    public static String removerAcentos(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try{
            File file = new File("arquivoDados.csv");
            Scanner entrada = new Scanner(file);
            ArrayList<String> nome = new ArrayList<>();
            ArrayList<String> sexo = new ArrayList<>();
            ArrayList<String> endereco = new ArrayList<>();
            ArrayList<String> cidade = new ArrayList<>();
            ArrayList<String> email = new ArrayList<>();
            ArrayList<String> telefone = new ArrayList<>();
            ArrayList<String> idade = new ArrayList<>();



            while(entrada.hasNextLine()){
                String linha = entrada.nextLine();

                String[] partes = linha.split(",");
                nome.add(removerAcentos(partes[0]));
                sexo.add(removerAcentos(partes[1]));
                endereco.add(removerAcentos(partes[2]));
                cidade.add(removerAcentos(partes[3]));
                email.add(removerAcentos(partes[4]));
                telefone.add(removerAcentos(partes[5]));
                idade.add(removerAcentos(partes[6]));


                System.out.println();
            }

            Pesquisa pesquisa = new Pesquisa(nome, sexo, endereco, cidade, email, telefone, idade);

            String nomeChave;
            while (true) {
                System.out.println("Digite um nome: ");
                nomeChave = input.nextLine();;
                if (nomeChave.equals("exit")) {
                    break;
                }else {
                    System.out.println(pesquisa.pesquisaBinaria(removerAcentos(nomeChave)));
                    System.out.println("Comparações: " + pesquisa.getContCompara());
                }
            }


            entrada.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }



}

