package Contenedores;

import javax.swing.*;


public class Panel2  extends JFrame {


    private JPanel panel2;
    private JTextField textIdent;
    private JTextField textToneladas;
    private JTextField textPais;
    private JRadioButton prioridad1;
    private JRadioButton prioridad2;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JTextField textRemitente;
    private JTextField textReceptora;
    private JTextArea textDescrip;
    private JRadioButton prioridad3;

    public Panel2(String ident,String peso,String descrip,String remitente,String recept,String pais, int prioridad,boolean aduana){
        setTitle("Gestión de contenedores");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(panel2);

        ButtonGroup G = new ButtonGroup();
        G.add(prioridad1);
        G.add(prioridad2);
        G.add(prioridad3);
        textIdent.setText(ident);
        textToneladas.setText(peso);
        textDescrip.setText(descrip);
        textReceptora.setText(recept);
        textRemitente.setText(remitente);
        textPais.setText(pais);

        textIdent.setEditable(false);
        textDescrip.setEditable(false);
        textPais.setEditable(false);
        textRemitente.setEditable(false);
        prioridad1.setEnabled(false);
        prioridad2.setEnabled(false);
        prioridad3.setEnabled(false);
        textReceptora.setEditable(false);
        textToneladas.setEditable(false);
        inspeccionadoEnAduanasCheckBox.setEnabled(false);

        if(prioridad==1){
          prioridad1.setSelected(true);
        } else if (prioridad==2) {
            prioridad2.setSelected(true);
        } else if (prioridad==3) {
            prioridad3.setSelected(true);
        }

        if(aduana==true){
            inspeccionadoEnAduanasCheckBox.setSelected(true);
        } else if (aduana==false) {
            inspeccionadoEnAduanasCheckBox.setSelected(false);

        }



    }


}
