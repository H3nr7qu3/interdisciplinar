package fabricaDeConexao;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EnvioDeEmail {

    public Session criarSessionMail() {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session;
        session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("recuperarinterdisciplinar@gmail.com", "iijd ogmy mtht stbb");
                }
            }
        );

        session.setDebug(true);
        return session;
    }
}
