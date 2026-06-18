
import java.io.*;
import javax.swing.*;
import java.util.Random;

public class ClasseMetodoTransito {

    public ArquivoEstatistica[] CadastraAcidente(ArquivoEstatistica[] estatistica) throws IOException { 
        //opção 1 - cadastro de acidentes
        //coletar dados a partir desta opção, gerar o arquivo .txt para manipulação nas próximas opções

        String fileName = "ArquivoEstatistica.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));


        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            estatistica[i] = new ArquivoEstatistica(); //instancia a classe 
            estatistica[i].CodigoCidade = rand.nextInt(199) + 1; //informa o código da cidade aleatoriamente
            estatistica[i].NomeCidade = JOptionPane.showInputDialog("Nome da cidade " + (i + 1) + ":"); //insere o nome da cidade
            estatistica[i].QtdAcidentes = rand.nextInt(750); //informa a quantidade de acidentes na cidade aleatoriamente

            // GRAVAÇÃO EM UMA ÚNICA LINHA: Codigo;Nome;Quantidade
            gravar.write(estatistica[i].CodigoCidade + ";"
                    + estatistica[i].NomeCidade + ";"
                    + estatistica[i].QtdAcidentes);
            gravar.newLine();
        }

        System.out.println("GRAVAÇÃO FEITA COM SUCESSO!");
        gravar.close();
        return estatistica;
    }

    public void ConsultaQuantidade(ArquivoEstatistica[] estatistica) throws IOException {
        //manipulação dos dados através da leitura do arquivo .txt
        int i;
        String fileName = "ArquivoEstatistica.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));

        for (i = 0; i < 10; i++) {
            String linha = ler.readLine(); // Lê a linha completa
            if (linha != null) {
                String[] dados = linha.split(";"); // Quebra a linha onde tiver ";"

                estatistica[i] = new ArquivoEstatistica();
                estatistica[i].CodigoCidade = Integer.parseInt(dados[0]);
                estatistica[i].NomeCidade = dados[1];
                estatistica[i].QtdAcidentes = Integer.parseInt(dados[2]);
            }
        }
     
        System.out.println("As cidades que obtiveram mais de 100 acidentes e menos de 500 foram:");
        for (i = 0; i < 10; i++) {
            if (estatistica[i].QtdAcidentes > 100 && estatistica[i].QtdAcidentes < 500) {
                System.out.println("Codigo: " + estatistica[i].CodigoCidade + " - "
                        + estatistica[i].NomeCidade + " - "
                        + estatistica[i].QtdAcidentes + " acidentes.");
            }
            ler.close();
        }
    }

    public void ConsultaEstatistica(ArquivoEstatistica[] estatistica) throws IOException {
        int i, menor = 0, maior = 0;
        String fileName = "ArquivoEstatistica.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));

        for (i = 0; i < 10; i++) {
            String linha = ler.readLine(); // Lê a linha completa
            if (linha != null) {
                String[] dados = linha.split(";"); // Quebra a linha onde tiver ";"

                estatistica[i] = new ArquivoEstatistica();
                estatistica[i].CodigoCidade = Integer.parseInt(dados[0]);
                estatistica[i].NomeCidade = dados[1];
                estatistica[i].QtdAcidentes = Integer.parseInt(dados[2]);
            }
        }

        for (i = 0; i < 10; i++) {
            if (i == 0) {
                maior = estatistica[i].QtdAcidentes; //insere a quantidade da primeira cidade a ser localizada no loop
                menor = estatistica[i].QtdAcidentes;
            } else if (estatistica[i].QtdAcidentes < menor) {
                menor = estatistica[i].QtdAcidentes; //faz a comparação com a proxima cidade, se for menor substitui
            } else if (estatistica[i].QtdAcidentes > maior) {
                maior = estatistica[i].QtdAcidentes; //faz a comparação com a proxima cidade, se for maior substitui
            }
        }
        System.out.println("O maior número de acidentes registrado foi " + maior);
        System.out.println("O menor número de acidentes registrado foi " + menor);
        ler.close();
    }

    public void ConsultaAcimaMedia(ArquivoEstatistica[] estatistica) throws IOException {
        int i, ctmd = 0;
        float somamd = 0, media = 0;
        String fileName = "ArquivoEstatistica.txt";
        BufferedReader ler = new BufferedReader(new FileReader(fileName));

        for (i = 0; i < 10; i++) {
            String linha = ler.readLine(); // Lê a linha completa
            if (linha != null) { //se a linha não estiver vazia
                String[] dados = linha.split(";"); // Quebra a linha onde tiver ";"

                estatistica[i] = new ArquivoEstatistica();
                estatistica[i].CodigoCidade = Integer.parseInt(dados[0]);
                estatistica[i].NomeCidade = dados[1];
                estatistica[i].QtdAcidentes = Integer.parseInt(dados[2]);
            }
        }

        for (i = 0; i < 10; i++) {
            somamd += estatistica[i].QtdAcidentes;
            ctmd++;
        }
        media = somamd / ctmd;
        System.out.println("A media de acidentes foi de" + media);

        System.out.println("A(s) cidade(s) com dados acima da media: ");
        for (i = 0; i < 10; i++) {
            if (estatistica[i].QtdAcidentes > media) {
                System.out.println(estatistica[i].NomeCidade + " - " + estatistica[i].QtdAcidentes + " acidentes.");
            }
        }
        ler.close();
    }
}
