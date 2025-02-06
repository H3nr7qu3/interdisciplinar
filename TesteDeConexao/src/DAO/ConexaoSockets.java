package DAO;

import java.io.*;

import java.net.*;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ConexaoSockets {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader input;
    private JFrame frame;
    private JLabel label;

    public ConexaoSockets() {
        // Configura a interface gráfica
        frame = new JFrame("Transmissão ao Vivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        label = new JLabel();
        frame.add(label);
        frame.setVisible(true);
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Servidor iniciado na porta " + port);

        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Recebe as mensagens
            List<String> base64DataList = receiveMessage();

            // Processa os dados recebidos
            processReceivedData(base64DataList);

            // Fecha a conexão com o cliente
            clientSocket.close();
            System.out.println("Cliente desconectado.");
        }
    }

    public List<String> receiveMessage() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line;
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            line = input.readLine(); // Lê uma linha da mensagem
            if (line == null || line.equals("FIM") || line.isEmpty()) {
                break; // Finaliza o loop se a mensagem terminar
            }

            // Verifica se a linha começa com "FRAME|"
            if (line.startsWith("FRAME|")) {
                // Divide a mensagem em partes
                String[] parts = line.split("\\|");
                if (parts.length == 3) { // Verifica se a mensagem está no formato correto
                    String base64Data = parts[2]; // Pega a parte Base64 da mensagem
                    list.add(base64Data); // Adiciona à lista
                } else {
                    System.err.println("Formato de mensagem inválido: " + line);
                }
            } else {
                System.err.println("Mensagem ignorada: " + line);
            }
        }

        return list;
    }

    public void processReceivedData(List<String> base64DataList) {
        for (String base64Data : base64DataList) {
            try {
                // Decodifica o Base64 para bytes
                byte[] imageData = Base64.getDecoder().decode(base64Data);

                // Converte os bytes em uma imagem (BufferedImage)
                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                BufferedImage image = ImageIO.read(bis);

                // Exibe a imagem (ou faz o que for necessário)
                if (image != null) {
                    ImageIcon icon = new ImageIcon(image);
                    label.setIcon(icon); // Atualiza o JLabel com a nova imagem
                    frame.revalidate();
                    frame.repaint();
                }
            } catch (IOException e) {
                System.err.println("Erro ao decodificar Base64: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            ConexaoSockets server = new ConexaoSockets();
            server.start(12345); // Inicia o servidor na porta 12345
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
