package jedi.project;

import java.io.*;

/***
 * Listar arquivo: File [] arquivos = arquivo.listFiles();
 * Excluir arquivos: arquivo.delete();
 */
public class Application {

    static File arquivoApp;

    public static void main(String[] args) throws IOException {

        criarArquivo();

//        Carro carro = new Carro();

//        carro.ano = 2000;
//        carro.modelo = "Fiat";
//        carro.placa = "PAZDECRISTO";
//
//        escreverEmArquivo(carro);

        lerArquivo();

    }


    public static void criarArquivo() throws IOException {

        File diretorio = new File("/home/matheus/Documents/Projeto Jedi/Matheus");
        File arquivo = new File(diretorio.getPath() + "/teste.txt");

        if (!diretorio.exists()) {
            diretorio.mkdir();
        }

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        Application.arquivoApp = arquivo;
    }

    public static void escreverEmArquivo(Carro carro) throws IOException {

        FileWriter fw = new FileWriter(arquivoApp);
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println(carro.toString());
        bw.write(carro.toString());
        bw.newLine();

        bw.close();
        fw.close();
    }

    public static void lerArquivo() throws IOException {

        FileReader fr = new FileReader(arquivoApp);

        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            String linha = br.readLine();
            String[] atributosCarro =  linha.split("-");

//            Carro carro = new Carro(atributosCarro[0], Integer.valueOf(atributosCarro[1]), atributosCarro[2]);
//            System.out.println(carro);
        }

        br.close();
        fr.close();
    }

}
