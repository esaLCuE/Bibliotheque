package Swing;

import fr.pompey.dev.afpa.classes.Livre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class LivreSwing extends JFrame {
    private JTextField titreField;
    private JTextField auteurField;
    private JTextField parutionField;
    private JTextArea entrezTitreArea;
    private JTextArea entrezAuteurArea;
    private JTextArea entrezParutionArea;
    private JTextArea entrezLeNombreDTextArea;
    private JButton annulerButton;
    private JButton confirmerButton;
    private JTextArea livreArea;
    private JTextField quantiteField;
    private JPanel contentPane;

    public LivreSwing() {

        this.setTitle("jsp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane); //JE L'AI MIS EN NOM DU JPANEL MAIS JSP SI C'EST CA OU PAS
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
    }

    private void saveChanges() {

        //Il faudra ajouter les exceptions, ici l'import ne fonctionne pas

        Livre liv = new Livre(titreField.getText(), auteurField.getText(), Integer.parseInt(parutionField.getText()));

        //paramètres au pif, juste pour essayer
        showConfirmDialog(this, "Information", "Livre ajouté", JOptionPane.OK_CANCEL_OPTION);

        //Faire un Livres.addLivre(liv), mais pour ça doit changer le fonctionnement des listes actuelles

        /*
        auteurField.setText("");
        titreField.setText("");
        parutionField.setText("");
        */

        this.dispose();
    }

    private void cancelChanges() {
        this.dispose();
    }
}
