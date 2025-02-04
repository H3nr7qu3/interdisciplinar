/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaDeConexao;

/**
 *
 * @author Principal
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PegandoIP {

    private static String ip;

    public String PickIP() {
            int numeroDeVezes = 1;
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp 850 & ipconfig");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "CP850"));

            String line;
            int adapterCount = 0; // Conta os adaptadores encontrados
            boolean inAdapterSection = false; // Para saber se estamos em uma seção de adaptador

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove espaços extras

                // Verifica se encontrou um novo adaptador
                if (line.toLowerCase().startsWith("adaptador")) {
                    adapterCount++; // Conta o novo adaptador encontrado
                    inAdapterSection = true;
                } // Se já estamos no terceiro adaptador e encontramos o IPv4, pegamos ele
                else if (inAdapterSection && adapterCount >= numeroDeVezes && line.startsWith("Endereço IPv4")) {
                    String[] parts = line.split(":");
                    if (parts.length > 1) {
                        ip = parts[1].trim();
                        
                        break; // Finaliza após pegar o IP correto
                    }
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

}
