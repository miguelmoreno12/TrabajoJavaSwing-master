package Contenedores;

import PaqC08.Contenedor;
import PaqC08.Hub;
import PaqC08.Puerto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MiPanel extends JFrame {
    private JPanel MiPanel;
    private JRadioButton prioridad1;
    private JRadioButton prioridad3;
    private JRadioButton prioridad2;
    private JComboBox pais;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JTextField numeroDeColumnaTextField;
    private JButton mostrarDatosContenedorButton;
    private JTextField IDContenedorTextField;
    private JButton cuantosButton;
    private JComboBox contarpais;
    private JTextField textident;
    private JTextField textToneladas;
    private JPanel JPanel1;
    private JTextArea textDescrip;
    private JTextField textRemitente;
    private JTextField textRecep;
    private JTextArea textestado;


   String ident,peso,descripcion,remitente,receptora,paisselect,col, paiscontar
           ;
   Contenedor contenedor;
   int prioridad, numpais,id;
   boolean aduana;
    Puerto p = new Puerto();
    Hub h = new Hub();
    public MiPanel(){
        setTitle("Gestión de contenedores");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(MiPanel);


        ButtonGroup G = new ButtonGroup(); // Se crea un grupo para que solo se pueda marcar uno de estos 3 botones
        G.add(prioridad1);
        G.add(prioridad2);
        G.add(prioridad3);
        mostrarDatosContenedorButton.addActionListener(new ActionListener() {// no funciona

            @Override
            public void actionPerformed(ActionEvent e) {

                id=Integer.parseInt(IDContenedorTextField.getText());
                contenedor= h.mostrarContenedor(id);
                if (contenedor ==null){
                    JOptionPane.showMessageDialog(null,"El identificador no existe");
                }else{
                    new Panel2(Integer.toString(contenedor.getNIC()),Integer.toString(contenedor.getPeso()),contenedor.getDescripcion(),contenedor.getEmpresaDeEnvio(),contenedor.getEmpresaDeEntrega(),contenedor.getPais(),contenedor.getPrioridad(),contenedor.getControlAduanas());

                }


            }
        });


        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                boolean salida=false;
                ident = textident.getText();
                peso = textToneladas.getText();
                descripcion = textDescrip.getText();
                remitente = textRemitente.getText();
                receptora = textRecep.getText();
                paisselect = (String) pais.getSelectedItem();
                if (prioridad1.isSelected()) {
                    prioridad = 1;
                } else if (prioridad2.isSelected()) {
                    prioridad = 2;

                } else if (prioridad3.isSelected()) {
                    prioridad = 3;
                }


                if (inspeccionadoEnAduanasCheckBox.isSelected()) {
                    aduana = true;
                } else {
                    aduana = false;
                }
               Contenedor c =  new Contenedor(Integer.parseInt(ident) ,Integer.parseInt(peso),paisselect,aduana,prioridad,descripcion,receptora,remitente);
                //creamos un contenedor con todos los datos que hay introducidos
               salida= p.apilar_contenedor(c); // llamamos al metodo apilar

                 if (salida==true){ // sacar un mensaje si se ha conseguido apilar o no

                     JOptionPane.showMessageDialog(null,"Contenedor apilado correctamente");
                     textident.setText(" ");
                      textToneladas.setText(" ");
                     textDescrip.setText(" ");
                     textRemitente.setText(" ");
                     textRecep.setText(" ");
                     G.clearSelection();
                     inspeccionadoEnAduanasCheckBox.setSelected(false);


                 } else if (salida==false) {
                     JOptionPane.showMessageDialog(null,"No se ha podido apilar el contenedor");

                 }

            }


        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                col=numeroDeColumnaTextField.getText();
                p.desapilar(Integer.parseInt(col));
                if( p.desapilar(Integer.parseInt(col))==null){
                    JOptionPane.showMessageDialog(null,"No se ha podido desapilar");

                }else {
                    JOptionPane.showMessageDialog(null,"Columa desapilada");

                }

            }
        });
        cuantosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paiscontar = (String) contarpais.getSelectedItem();
                numpais=p.numPaisPuerto(paiscontar);
                JOptionPane.showMessageDialog(null,"Hay "+numpais+" contenedores en el pais "+paiscontar);

            }
        });
    }




}
