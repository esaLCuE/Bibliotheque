package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static fr.pompey.dev.afpa.classes.Abonne.abonnes;
import static fr.pompey.dev.afpa.classes.Abonne.afficherAbonnes;
import static fr.pompey.dev.afpa.classes.Livre.afficherLivres;
import static fr.pompey.dev.afpa.classes.Pret.afficherPrets;

public class MenuSwing extends JFrame {

    private JButton ajouterAbonneButton;
    private JButton ajouterLivreButton;
    private JButton ajouterPretButton;
    private JButton voirAbonnesButton;
    private JButton voirLivresButton;
    private JButton voirPretsButton;
    private JButton quitterButton;
    private JLabel queVoulezVousFaireLabel;
    private JPanel contentPane;

    public MenuSwing() {
        this.setTitle("Menu principal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        this.setResizable(false);
        this.pack();

        setVisible(true);

        JFrame frame = new JFrame();
        setLocationRelativeTo(null);

        ajouterAbonneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                creerAbonneSwi();
                //setVisible(true);
            }
        });
        ajouterLivreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                creerLivreSwi();
            }
        });
        ajouterPretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                creerPretSwi();
            }
        });
        voirAbonnesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherAbonnes();
            }
        });

        voirLivresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherLivres();
            }
        });

        voirPretsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherPrets();
            }
        });

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitterProgramme();
            }
        });
    }

    private void creerAbonneSwi() {
        AbonneSwing aboSwing = new AbonneSwing(this);
        // ICI ET AILLEURS REPARER CA. INTEGRER CORRECTEMENT LES NOUVEAUX ABONNES/LIVRES/PRETS A LEURS LISTES
        aboSwing.setVisible(true);
    }
    private void creerLivreSwi() {
        LivreSwing livSwi = new LivreSwing(this);
        livSwi.setVisible(true);
    }
    private void creerPretSwi() {
        PretSwing preSwi = new PretSwing(this);
        preSwi.setVisible(true);
    }
    private void quitterProgramme() {
        System.exit(0);
    }
}
