package Swing;

import fr.pompey.dev.afpa.classes.Bibliothecaire;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showConfirmDialog;

public class BibliothecaireSwing extends JFrame {
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField idField;
    private JButton annulerButton;
    private JButton confirmerButton;
    private JLabel entrezNomArea;
    private JLabel entrezPrenomArea;
    private JLabel entrezId;
    private JPanel contentPane;

    public BibliothecaireSwing() {
        setTitle("Enrgistrement du bibliothecaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    }

    private void saveChanges() {
        //ajouter try
        Bibliothecaire bib = new Bibliothecaire(nomField.getText(), prenomField.getText(), idField.getText());

        //un seul biblio, pas de liste

        showConfirmDialog(this, "Bibliothécaire enregistré", "Information", JOptionPane.OK_CANCEL_OPTION);

        this.dispose();
    }
    private void cancelChanges(){
        this.dispose();
    }
}
