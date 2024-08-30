package Swing;

import fr.pompey.dev.afpa.classes.Abonne;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.time.LocalDate;
import java.util.Objects;

import static fr.pompey.dev.afpa.classes.Abonne.abonnes;
import static fr.pompey.dev.afpa.classes.Saisie.afficher;
import static javax.swing.JOptionPane.showConfirmDialog;

public class AbonneSwing extends JFrame {
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JComboBox sexeComboBox;
    private JButton annulerButton;
    private JButton confirmerButton;
    private JPanel contentPane;
    private JFrame appelant;

    public AbonneSwing(JFrame frame) {
        this.appelant = frame;

        setTitle("Création d'un abonné");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(null);

        confirmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelChanges();
            }
        });

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                cancelChanges();
            }
        });

    }

    private void saveChanges(){

        // Faire les exceptions quand l'import fonctionnera

        Abonne abo = new Abonne(prenomField.getText(), nomField.getText(), emailField.getText(), LocalDate.now());
        abonnes.add(abo);

        // AJOUTER LE SEXE PLUS TARD
        // String sexeSwi = Objects.requireNonNull(sexeComboBox.getSelectedItem()).toString();

        //Faire un Abonnes.addAbonne(abo), mais pour ça doit changer le fonctionnement des listes actuelles

        showConfirmDialog(this, "Abonné ajouté", "Information", JOptionPane.OK_CANCEL_OPTION);

        /*
        String nomSwi = nomField.getText();
        String prenomSwi = prenomField.getText();
        String emailSwi = emailField.getText();

        nomField.setText("");
        prenomField.setText("");
        emailField.setText("");
        sexeComboBox.setSelectedItem(0);
        */

        afficher(prenomField.getText()+" "+nomField.getText());
        afficher(emailField.getText());
        afficher(LocalDate.now().toString());

        this.dispose();
        appelant.setVisible(true);
    }

    private void cancelChanges(){
        this.dispose();
        appelant.setVisible(true);
    }
}
