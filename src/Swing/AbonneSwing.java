package Swing;

import fr.pompey.dev.afpa.classes.Abonne;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.swing.JOptionPane.showConfirmDialog;

public class AbonneSwing extends JFrame {
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JComboBox sexeComboBox;
    private JButton annulerButton;
    private JButton confirmerButton;
    private JTextArea entrezNomArea;
    private JTextArea entrezPrenomArea;
    private JTextArea entrezEmailArea;
    private JTextArea entrezSexeComboBox;
    private JTextArea abonneArea;
    private JPanel contentPane;

    public AbonneSwing() {

        setTitle("Création d'un abonné");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(null);



    }

    private void saveChanges(){

        // Faire les exceptions quand l'import fonctionnera

        Abonne abo = new Abonne(nomField.getText(), prenomField.getText(), emailField.getText(), LocalDate.now());
        // AJOUTER LE SEXE PLUS TARD
        // String sexeSwi = Objects.requireNonNull(sexeComboBox.getSelectedItem()).toString();

        //Faire un Abonnes.addAbonne(abo), mais pour ça doit changer le fonctionnement des listes actuelles

        showConfirmDialog(this, "Information", "Abonné ajouté", JOptionPane.OK_CANCEL_OPTION);

        /*
        String nomSwi = nomField.getText();
        String prenomSwi = prenomField.getText();
        String emailSwi = emailField.getText();

        nomField.setText("");
        prenomField.setText("");
        emailField.setText("");
        sexeComboBox.setSelectedItem(0);
        */

        this.dispose();
    }

    private void cancelChanges(){
        this.dispose();
    }
}
