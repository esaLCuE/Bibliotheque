package Swing;

import fr.pompey.dev.afpa.classes.Pret;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static javax.swing.JOptionPane.showConfirmDialog;

public class PretSwing extends JFrame {
    private JTextField aboPretField;
    private JTextField titPretField;
    private JButton confirmerButton;
    private JButton annulerButton;
    private JLabel pretArea;
    private JLabel aboPretArea;
    private JLabel titPretArea;
    private JLabel autPretArea;
    private JTextField autPretField;
    private JPanel contentPane;
    private JFrame appelant;

    public PretSwing(JFrame frame){
        this.appelant = frame;

        this.setTitle("Enregistrement d'un prêt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        Pret pre = new Pret(aboPretField.getText(), titPretField.getText(), autPretField.getText(), LocalDate.now(),
                LocalDate.now().plusDays(7));

        //Prets.addPret(pre);

        showConfirmDialog(this, "Prêt enregistré", "Information", JOptionPane.OK_CANCEL_OPTION);

        this.dispose();
        appelant.setVisible(true);
    }

    private void cancelChanges(){
        this.dispose();
        appelant.setVisible(true);
    }

}
