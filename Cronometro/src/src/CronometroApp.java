import javax.swing.*;
import java.awt.*;

public class CronometroApp {

    private int segundos = 0;
    private Timer timer;
    private JLabel tiempoLabel;


    public CronometroApp() {

        //Esqueleto de la interfaz
        JFrame frame = new JFrame("Cronómetro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);



        tiempoLabel = new JLabel("00:00:00");
        tiempoLabel.setFont(new Font("Arial", Font.BOLD, 26));
        tiempoLabel.setHorizontalAlignment(SwingConstants.CENTER);


        JButton iniciarBtn  = new JButton("Iniciar");
        JButton reiniciarBtn = new JButton("Reiniciar");
        JButton pausarBtn = new JButton("Pausar");

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(iniciarBtn);
        panelBotones.add(reiniciarBtn);
        panelBotones.add(pausarBtn);



        frame.add(tiempoLabel, BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);


        timer = new Timer(1000, e -> {
            segundos++;
            actualizarTiempo();
        });

        // Asignar acciones a los botones
        iniciarBtn.addActionListener(e -> {
            iniciarCronometro();
        });
        reiniciarBtn.addActionListener(e -> {
            reiniciarCronometro();
        });
        pausarBtn.addActionListener(e -> {
            pausarCronometro();
        });

        frame.setVisible(true);

    }

    public void iniciarCronometro() {
        if (!timer.isRunning()){
            timer.start();
        }
    }

    public void pausarCronometro() {
        if (timer.isRunning()){
            timer.stop();
        }
    }

    public void reiniciarCronometro() {
            timer.stop();
            segundos = 0;
            actualizarTiempo();
    }

    private void actualizarTiempo() {
        int h = segundos / 3600;
        int m = (segundos % 3600) / 60;
        int s = segundos % 60;

        tiempoLabel.setText(String.format("%02d:%02d:%02d", h, m, s));
    }

}
