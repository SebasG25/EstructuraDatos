/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sebastian
 */
public class Lienzo extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo
     */
    private BinarySearchTree tree;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;
    private List<String> nodeList = new ArrayList<>();

    public Lienzo() {
        initComponents();
    }

    public void setBinarySearchTree(BinarySearchTree tree) {
        this.tree = tree;
        repaint();
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        pintar(grphcs, getWidth() / 2, 20, tree.getRoot());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(640, 360));
        setPreferredSize(new java.awt.Dimension(640, 360));

        jButton1.setText("Insertar");
        jButton1.setName("btnInsertar"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.setName("btnEliminar"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // CODIGO DE INSERTAR:
        String input = jTextPane1.getText();
        String[] arrayInput = input.split(",");
        arrayInput = cleanArray(arrayInput);
        if (arrayInput.length > 9) {
            jTextPane1.setText("");
            JOptionPane.showMessageDialog(null, "Puedes insertar máximo 9 nodos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (verifyNaturalNumbers(arrayInput)) {
            //Ya está la condición en el if
            jTextPane1.setText("");
        } else {
            nodeList = Arrays.asList(arrayInput);
            for (String i : nodeList) {
                tree.Add(Integer.parseInt(i.trim()));
            }
            setBinarySearchTree(tree);
//            EstructurasNoLineales main = new EstructurasNoLineales();
//            main.getVentana().setContentPane(this);
            jTextPane1.setText("");
            clearList();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // CODIGO DE ELIMINAR:
        String input = jTextPane2.getText();
        String[] arrayInput = input.split(",");
        arrayInput = cleanArray(arrayInput);
        if (!isNumeric(arrayInput)) {
            jTextPane2.setText("");
            JOptionPane.showMessageDialog(null, "Los datos tienen que ser númericos separados por coma", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            nodeList = Arrays.asList(arrayInput);
            for (String i : nodeList) {
                tree.Delete(Integer.parseInt(i.trim()));
            }
            setBinarySearchTree(tree);
//            EstructurasNoLineales main = new EstructurasNoLineales();
//            main.getVentana().setContentPane(this);
            jTextPane2.setText("");
            clearList();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean verifyNaturalNumbers(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (isNumeric(numbers)) {
                if (!(Integer.parseInt(numbers[i]) > 0 && Integer.parseInt(numbers[i]) <= 100)) {
                    JOptionPane.showMessageDialog(null, "Los datos tienen que estar entre 1 y 100", "Error", JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los datos tienen que ser númericos separados por coma", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }

    private boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isNumeric(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!isNumeric(array[i])) {
                return false;
            }
        }
        return true;
    }
    
    private void clearList(){
        for(String i : nodeList){
            nodeList.remove(i);
        }
    }
    
    private String[] cleanArray(String[] numbers){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = numbers[i].trim();
        }
        return numbers;
    }

    private void pintar(Graphics g, int x, int y, BinaryNode n) {
        if (n == null) {
        } else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.getData() + "", x + 12, y + 18);
            if (n.getLeft() != null) {
                g.drawLine(x, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO);
            }
            if (n.getRight() != null) {
                g.drawLine(x + DIAMETRO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO);
            }
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.getLeft());
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.getRight());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the nodeList
     */
    public List<String> getNodeList() {
        return nodeList;
    }

    /**
     * @param nodeList the nodeList to set
     */
    public void setNodeList(List<String> nodeList) {
        this.nodeList = nodeList;
    }
}
