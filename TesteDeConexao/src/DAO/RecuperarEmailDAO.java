package DAO;

import fabricaDeConexao.EnvioDeEmail;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Address;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.Session;
import java.util.Random;

public class RecuperarEmailDAO {

    private int senhaGerada;

    public String getSenhaGerada() {
        return Integer.toString(senhaGerada);
    }

    public void setSenhaGerada(int senhaGerada) {
        this.senhaGerada = senhaGerada;
    }
    
    public void EnviarMensagem(String destino) {
        Session session = new EnvioDeEmail().criarSessionMail();
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("recuperarinterdisciplinar@gmail.com"));

            Address[] toUser = InternetAddress.parse(destino);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Seu código de recuperação");//Assunto
            message.setText("Utilize o seguinte código para atualizar sua senha: " + gerarSenha());
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    private int gerarSenha() {
        Random random = new Random();
        return senhaGerada = random.nextInt(1000, 10000);
    }
}
