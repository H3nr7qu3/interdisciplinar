package DAO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class ConexaoSockets extends view.View {

    public ConexaoSockets() {
        this(12345); // Porta padrão
    }

    public ConexaoSockets(int port) {
        getPortaLabel().setText(Integer.toString(port));
        iniciarServidorEmBackground(port); // Inicia o servidor em uma thread separada
    }

    // Método para iniciar o servidor em background
    private void iniciarServidorEmBackground(int port) {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                SwingUtilities.invokeLater(() -> {
                    atualizarStatus("Servidor aguardando conexões na porta " + port + "...");
                });

                while (true) {
                    Socket socket = serverSocket.accept();
                    SwingUtilities.invokeLater(() -> {
                        atualizarStatus("Cliente conectado: " + socket.getInetAddress());
                    });

                    // Processa a conexão em uma thread separada
                    new Thread(() -> processarConexao(socket)).start();
                }
            } catch (IOException e) {
                SwingUtilities.invokeLater(() -> {
                    atualizarStatus("Erro no servidor: " + e.getMessage());
                });
                e.printStackTrace();
            }
        }).start();
    }

    // Processa a conexão do cliente
    private void processarConexao(Socket socket) {
        try (InputStream inputStream = socket.getInputStream()) {
            // Recebe o tamanho da imagem (4 bytes)
            byte[] sizeBytes = new byte[4];
            inputStream.read(sizeBytes);
            int imageSize = bytesToInt(sizeBytes);

            // Recebe os bytes da imagem
            byte[] imageBytes = new byte[imageSize];
            int bytesRead = 0;
            while (bytesRead < imageSize) {
                int result = inputStream.read(imageBytes, bytesRead, imageSize - bytesRead);
                if (result == -1) {
                    break; // Se não há mais bytes, sai do loop
                }
                bytesRead += result;
            }

            // Converte os bytes em uma BufferedImage
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

            // Atualiza a UI com as informações da imagem
            SwingUtilities.invokeLater(() -> {
                File outputFile = new File("imagem_recebida.jpg");
                try {
                    ImageIO.write(image, "jpg", outputFile);
                } catch (IOException ex) {
                    Logger.getLogger(ConexaoSockets.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Imagem salva com sucesso!");
                exibirImagem(image);
// Método hipotético para exibir a imagem na UI 
                
            });

        } catch (IOException e) {
            SwingUtilities.invokeLater(() -> {
                atualizarStatus("Erro ao processar conexão: " + e.getMessage());
            });
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para converter bytes em inteiro (big-endian)
    private int bytesToInt(byte[] bytes) {
        return (bytes[0] << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
    }

    // Método para atualizar o status na UI
    private void atualizarStatus(String mensagem) {
        // Substitua com o componente real da sua UI (ex: JLabel)
        System.out.println(mensagem);
    }

    // Método para exibir a imagem na UI
    private void exibirImagem(BufferedImage image) {
        // Implemente a exibição da imagem (ex: em um JLabel ou JPanel)

        if (image != null) {
            // Converte BufferedImage para ImageIcon redimensionando para o tamanho do label
            BufferedImage imagemMaior = (BufferedImage) image.getScaledInstance(600, 835, image.SCALE_SMOOTH);

            // Atualiza o label na thread de interface gráfica
            SwingUtilities.invokeLater(() -> {
                getImagemLabel().setIcon((Icon) imagemMaior);
                getImagemLabel().revalidate();
                getImagemLabel().repaint();
            });
        } else {
            SwingUtilities.invokeLater(() -> {
                getImagemLabel().setIcon(null); // Remove a imagem se for nula
                getImagemLabel().setText("Nenhuma imagem para exibir");
            });
        }
    }
}
