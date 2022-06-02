package jedi.project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppTeste {

    public static File arquivo;

    public static void main(String[] args) throws IOException {


        Carro carro = new Carro(1L, "Punto", 2014, "Pásdecristo");
        Carro carro2 = new Carro(2L, "Fiesta", 2014, "Pásdecristo");

        criarArquivo();

        List<Carro> carros = List.of(carro, carro2);

        escrever(carros);

        List<Carro> carrosSalvos = ler();

        for (Carro c : carrosSalvos){
            System.out.println(c);
        }

        Carro carroParaEdicao = new Carro();

        for(Carro carroSlv :  carrosSalvos){

            if(carroSlv.id == 2){
                carroParaEdicao = carroSlv;
            }
        }

        carroParaEdicao.placa = "3213030";
        carroParaEdicao.modelo = "Fusca";

        escrever(carrosSalvos);

        carrosSalvos = ler();

        for(Carro carroSlv :  carrosSalvos){

            if(carroSlv.id == 2){
                carroParaEdicao = carroSlv;
            }
        }

        carrosSalvos.remove(carroParaEdicao);
        escrever(carrosSalvos);

        carrosSalvos = ler();

        Long idMax = 0L;
        for(Carro carroSlv :  carrosSalvos){

            if(carroSlv.id > idMax){
                idMax = carroSlv.id;
            }
        }

        new Carro(idMax + 1, "Punot", 2023, "JesusTeAma");



    }

    public static void criarArquivo() throws IOException {

        File diretorio = new File("/home/matheus/Documents/Projeto Jedi/Matheus");
        File arquivo = new File(diretorio + "/teste.txt");

        if(!diretorio.exists()){
            diretorio.mkdir();
        }

        if(!arquivo.exists()){
            arquivo.createNewFile();
        }

        AppTeste.arquivo =  arquivo;
    }

    public static void escrever(List<Carro> carros) throws IOException {

        FileWriter fw = new FileWriter(AppTeste.arquivo);
        BufferedWriter bw = new BufferedWriter(fw);


        for(Carro carro : carros){

            bw.write(carro.toString());
            bw.newLine();

        }

        bw.close();
        fw.close();
    }

    public static List<Carro> ler() throws IOException {

        FileReader fr = new FileReader(AppTeste.arquivo);
        BufferedReader br = new BufferedReader(fr);

        List<Carro> listaCarros = new ArrayList<>();

        while(br.ready()){

            String linha = br.readLine();
            String[] linhaSplit = linha.split("-");

            Carro carro = new Carro(Long.valueOf(linhaSplit[0]), linhaSplit[1], Integer.valueOf(linhaSplit[2]), linhaSplit[3]);
            listaCarros.add(carro);

        }

        br.close();
        fr.close();

        return listaCarros;
    }



    }
