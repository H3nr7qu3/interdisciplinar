package DAO;

import java.io.*;
import java.net.*;

public class ConexaoPlaca {
    private Socket socket;
    private PrintWriter saida;
    private final String IP;
    private final int porta;

    public ConexaoPlaca(String IP, int porta) {
        this.IP = IP;
        this.porta = porta;
        conectarServidor();
    }

    private void conectarServidor() {
        try {
            socket = new Socket(IP, porta);
            saida = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Conectado ao servidor!");
        } catch (IOException e) {
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }

    public void enviarComando(String comando) {
        if (saida != null) {
            saida.println(comando);
            System.out.println("Comando enviado: " + comando);
        } else {
            System.err.println("Erro: Conexão não estabelecida.");
        }
    }

    public void formKeyPressed(java.awt.event.KeyEvent evt) {
        char tecla = Character.toUpperCase(evt.getKeyChar());

        switch (tecla) {
            case 'A' -> enviarComando("A");
            case 'D' -> enviarComando("D");
            case 'R' -> enviarComando("R");
            case 'G' -> enviarComando("G");
            case 'B' -> enviarComando("B");
            default -> System.out.println("Tecla não reconhecida: " + tecla);
        }
    }

    public void fecharConexao() {
        try {
            if (saida != null) saida.close();
            if (socket != null) socket.close();
            System.out.println("Conexão fechada.");
        } catch (IOException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
