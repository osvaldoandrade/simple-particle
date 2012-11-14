package particles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainPanel extends JPanel {


    private final JTextField txtDiametro = new JTextField(5);
    private final JTextField txtVelocidade = new JTextField(5);
    private final JTextField txtGravidade = new JTextField(5);
    private final JTextField txtVento = new JTextField(15);
    private final JTextField txtIdade = new JTextField(15);

    public ScenePanel scene;

    public MainPanel(ParticleSystem ps) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        scene = new ScenePanel(ps);
        this.setLayout(new BorderLayout());

        this.add(scene, BorderLayout.CENTER);
        this.add(createModificationPanel(), BorderLayout.SOUTH);

        txtDiametro.setText(String.valueOf(getParticleSystem().diameter));
        txtVelocidade.setText(String.valueOf(getParticleSystem().speed));
        txtGravidade.setText(String.valueOf(getParticleSystem().gravity));
        txtVento.setText(String.valueOf(getParticleSystem().wind));
        txtIdade.setText(String.valueOf(getParticleSystem().maxage));
        this.setVisible(true);
    }

    public ParticleSystem getParticleSystem() {
        return scene.getParticleSystem();
    }

    @Override
    public void update(Graphics g) {
        txtDiametro.setText(String.valueOf(getParticleSystem().diameter));
        txtVelocidade.setText(String.valueOf(getParticleSystem().speed));
        txtGravidade.setText(String.valueOf(getParticleSystem().gravity));
        txtVento.setText(String.valueOf(getParticleSystem().wind));
        txtIdade.setText(String.valueOf(getParticleSystem().maxage));
    }

    private JPanel createModificationPanel() {
        JPanel modificationPanel = new JPanel();
        modificationPanel.setLayout(new BorderLayout());
        modificationPanel.setVisible(true);


        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new GridLayout(1, 3));

        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new GridLayout(1, 5));


        txtVelocidade.setEditable(false);
        txtVelocidade.setBorder(BorderFactory.createTitledBorder("Vel:"));
        txtVelocidade.setSize(new Dimension(50, 30));

        txtGravidade.setEditable(false);
        txtGravidade.setBorder(BorderFactory.createTitledBorder("Grav:"));
        txtGravidade.setSize(new Dimension(50, 30));

        txtDiametro.setEditable(false);
        txtDiametro.setBorder(BorderFactory.createTitledBorder("Diam:"));
        txtDiametro.setSize(new Dimension(50, 30));

        txtVento.setEditable(false);
        txtVento.setBorder(BorderFactory.createTitledBorder("Vento:"));
        txtVento.setSize(new Dimension(50, 30));

        txtIdade.setEditable(false);
        txtIdade.setBorder(BorderFactory.createTitledBorder("Idade:"));
        txtIdade.setSize(new Dimension(50, 30));

        JButton button1 = new JButton("Cenario 1");
        button1.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent me) {
                setBackground(Color.blue);
                getParticleSystem().setup(0.2, 0.2, 10, 500, 2, Color.BLACK, Color.BLACK);
                getParticleSystem().setTheme(0);

                update(getGraphics());
            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });
        JButton button2 = new JButton("Cenario 2");
        button2.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent me) {
                setBackground(Color.white);
                getParticleSystem().setup(0,0,0,0,0,Color.RED,Color.BLUE);
                getParticleSystem().setTheme(1);
                update(getGraphics());
            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });
        JButton button3 = new JButton("Cenario 3");
        button3.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent me) {
                setBackground(Color.black);
                getParticleSystem().setTheme(2);
                update(getGraphics());
            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });


        subPanel1.add(button1);
        subPanel1.add(button2);
        subPanel1.add(button3);

        subPanel2.add(txtDiametro);
        subPanel2.add(txtVelocidade);
        subPanel2.add(txtGravidade);
        subPanel2.add(txtVento);
        subPanel2.add(txtIdade);


        modificationPanel.add(subPanel1, BorderLayout.CENTER);
        modificationPanel.add(subPanel2, BorderLayout.SOUTH);

        return modificationPanel;
    }

    private JPanel createControlPanel() {
        JPanel control = new JPanel();
        control.setLayout(new GridLayout(1, 3));
        control.setBackground(Color.GRAY);
        control.setVisible(true);

        JButton button1 = new JButton("Cenário 1");
        button1.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent me) {
            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });

        JButton button2 = new JButton("Planta 2");
        button2.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent me) {

            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });

        JButton button3 = new JButton("Planta 3");
        button2.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent me) {

            }

            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }
        });


        control.add(button1);
        control.add(button2);
        control.add(button3);

        return control;
    }


}
