package DAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfByte;
//import org.opencv.imgcodecs.Imgcodecs;

public class Servidor {
    
    private JLabel labelImagem; // JLabel que será atualizado com a imagem recebida
    private int porta;
    // Construtor que recebe um JLabel como parâmetro
    public Servidor(JLabel labelImagem, int porta) {
        this.labelImagem = labelImagem;
        this.porta = porta;
    }

    // Método para iniciar o servidor
    public void iniciarServidor() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(porta)) {
                System.out.println("Servidor aguardando conexão...");
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                StringBuilder base64Builder = new StringBuilder();
                String linha;

                while ((linha = input.readLine()) != null) {
                    if (linha.equals("FIM")) {
                        mostrarImagem(base64Builder.toString());
                        base64Builder.setLength(0); // Limpa o StringBuilder para a próxima imagem
                    } else {
                        base64Builder.append(linha);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Método para exibir a imagem no JLabel
   private void mostrarImagem(String base64) {
       
    try {
       // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // Decodifica a imagem Base64
        byte[] imageBytes = Base64.getDecoder().decode(base64);
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        BufferedImage imagem = ImageIO.read(bais);
//        MatOfByte matOfByte = new MatOfByte(imageBytes);
//        Mat mat = Imgcodecs.imdecode(matOfByte, Imgcodecs.IMREAD_COLOR);

        if (imagem != null) {
            // Redimensiona a imagem para 450x450 pixels
            Image imagemRedimensionada = imagem.getScaledInstance(450, 450, Image.SCALE_SMOOTH);
//            FaceDetector face = new FaceDetector(mat);
            ImageIcon icon = new ImageIcon(imagemRedimensionada);

            // Atualiza o JLabel com a nova imagem
            labelImagem.setPreferredSize(new Dimension(450, 450));
            labelImagem.setIcon(icon);
           
        
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
//    // Método main para teste
//    public static void main(String[] args) {
//        // Configura a interface gráfica
//        JFrame frame = new JFrame("Recebendo Imagem em Tempo Real");
//        JLabel labelImagem = new JLabel();
//        frame.add(labelImagem);
//        frame.setSize(640, 480);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//        // Cria o servidor e passa o JLabel como parâmetro
//        ServidorImagens servidor = new ServidorImagens(labelImagem);
//        servidor.iniciarServidor(); // Inicia o servidor
//    }
}