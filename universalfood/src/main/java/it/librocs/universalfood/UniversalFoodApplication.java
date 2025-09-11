package it.librocs.universalfood;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.Desktop;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class UniversalFoodApplication implements ApplicationListener<WebServerInitializedEvent> {

    private int port;

	public static void main(String[] args) {
		// Quella sotto è la riga standard per avviare l'applicazione SpringBoot
		SpringApplication.run(UniversalFoodApplication.class, args);

		// le due righe sotto mi servono per evitare che parta in modalita headless
		// cosi posso usare il desktop per aprire il browser e aprire una finestra
		// con le informazioni sul server e la possibilità di chiuderlo
		// le lascio commentate perché in sviluppo mi fa più comodo usare
		// il terminale, poi uso "-Djava.awt.headless=false" quando creo l'applicazione
		// SpringApplicationBuilder builder = new SpringApplicationBuilder(UniversalFoodApplication.class);
    	// builder.headless(false).run(args);
	}

 	@Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
		this.port = event.getWebServer().getPort();

		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI("http://localhost:"+port));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("non hai un desktop!");
		}


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Info Server");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
			 frame.setLayout(new GridLayout(2, 1));

            JLabel label = new JLabel("Applicazione disponibile su: http://localhost:" + port, SwingConstants.CENTER);
            frame.add(label);
			JLabel l2 = new JLabel("Chiudi questa finestra per terminare l'applicazione", SwingConstants.CENTER);
			frame.add(l2);
            frame.setVisible(true);
        });
    }
}

