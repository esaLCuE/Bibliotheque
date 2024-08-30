package Swing;

import fr.pompey.dev.afpa.classes.Livre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static fr.pompey.dev.afpa.classes.Livre.livres;
import static fr.pompey.dev.afpa.classes.Saisie.afficher;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class LivreSwing extends JFrame {
    private JTextField titreField;
    private JTextField auteurField;
    private JTextField parutionField;
    private JLabel entrezTitreArea;
    private JLabel entrezAuteurArea;
    private JLabel entrezParutionArea;
    private JLabel entrezLeNombreDLabel;
    private JButton annulerButton;
    private JButton confirmerButton;
    private JLabel livreArea;
    private JTextField quantiteField;
    private JPanel contentPane;
    private JFrame appelant;

    public LivreSwing(JFrame frame) {
        this.appelant = frame;

        this.setTitle("Création d'un livre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane); //Je l'ai mis en nom du JPanel mais jsp si c'est ça
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

    private void saveChanges() {

        try {
            Livre liv = new Livre(titreField.getText(), auteurField.getText(), Integer.parseInt(quantiteField.getText()));

            boolean dejaPres = false;
            for (int i = 0; i < livres.size(); i++) {
                if ((livres.get(i).getTitre().equals(titreField.getText())) && (livres.get(i).getAuteur().equals(auteurField.getText()))) {
                    Livre.augmenterQtt(i, Integer.parseInt(quantiteField.getText()));
                    dejaPres = true;
                }
            }
            if (!dejaPres) {
                livres.add(liv);
            }
            showConfirmDialog(this, "Livre ajouté", "Information", JOptionPane.OK_CANCEL_OPTION);
        } catch (InputMismatchException | NullPointerException e) {
            afficher(e.getMessage());
        } catch (IllegalArgumentException e) {
            afficher("Valeur numérique invalide.");
        }

        this.dispose();
        appelant.setVisible(true);
    }

    private void cancelChanges() {
        this.dispose();
        appelant.setVisible(true);
    }
}
