/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EntryDAO;
import controller.ProductDAO;
import controller.ProofOfPaymentDAO;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Entry;
import model.Product;
import util.Constants;

/**
 *
 * @author Pastor Tantalean
 */
public class EntryListDialog extends java.awt.Dialog {

    /**
     * Creates new form ConsultProductEntryDialog
     */
    DefaultTableModel dtm;
    Product product;
    List<Entry> list;

    public EntryListDialog(java.awt.Frame parent, boolean modal, Product product) {
        super(parent, modal);
        initComponents();
        this.product = product;
        setLocationRelativeTo(null);
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entryTableScrollPane = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable();
        productTextField = new javax.swing.JTextField();
        totalTextField = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        noteLabel = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        entryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COMPROBANTE", "TIPO", "CANTIDAD", "PRECIO UNITARIO", "GANANCIA", "LOTE", "PROVEEDOR", "REGISTRO SANITARIO", "INGRESO", "VENCIMIENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dtm = (DefaultTableModel) entryTable.getModel();
        entryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entryTableMouseClicked(evt);
            }
        });
        entryTableScrollPane.setViewportView(entryTable);
        if (entryTable.getColumnModel().getColumnCount() > 0) {
            entryTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            entryTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            entryTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        productTextField.setEditable(false);
        productTextField.setEnabled(false);

        totalLabel.setText("Total:");

        exitButton.setText("SALIR");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        noteLabel.setText("* Para actualizar la cantidad o eliminar una entrada, haga doble click sobre esta en la tabla.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(productTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(entryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(noteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(productTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entryTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel)
                    .addComponent(noteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void entryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMouseClicked
        if (evt.getClickCount() == 2) {
            int selectedIndex = entryTable.getSelectedRow();
            if (selectedIndex == -1) {
                return;
            }
            Entry e = (Entry) dtm.getValueAt(selectedIndex, 0);
            int op = JOptionPane.showOptionDialog(null, "¿Está seguro de actualizar la cantidad o eliminar la entrada del producto " + productTextField.getText() + ":\n\n" + "Comprobante: " + e + "\nTipo: " + e.getProofOfPayment().getType() + "\nCantidad: " + e.getQuantity() + "\nPrecio unitario: " + e.getEntryUnitPrice() + "\nGanancia: " + e.getEntryProfitPercentage() + "%\nLote: " + e.getBatch() + "\nProveedor: " + e.getSupplier() + "\nIngreso: " + getDateForm(e.getArrivalDate()) + "\nVencimiento: " + getDateForm(e.getExpiryDate()) + " ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Actualizar cantidad", "Eliminar"}, "Actualizar cantidad");
            if (op == JOptionPane.NO_OPTION) {
                int ans = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la entrada?");
                if (ans == JOptionPane.YES_OPTION) {
                    product.setStock(-e.getQuantity());
                    boolean check = ProductDAO.getProduct(product);
                    check &= ProofOfPaymentDAO.deleteProofOfPayment(e.getProofOfPayment(), Constants.getUserLoged());
                    fillTable();
                }
            } else {
                String ans = JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad para la entrada: ");
                if (ans != null) {
                    int quantity = Integer.parseInt(ans);
                    product.setStock(-e.getQuantity() + quantity);
                    boolean check = ProductDAO.getProduct(product);
                    e.setQuantity(quantity);
                    check &= EntryDAO.updateEntry(e);
                    fillTable();
                }
            }
        }
    }//GEN-LAST:event_entryTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable entryTable;
    private javax.swing.JScrollPane entryTableScrollPane;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JTextField productTextField;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
        list = EntryDAO.listEntriesOfProduct(product.getProductID());
        productTextField.setText(product.getDescription() + " - " + product.getForm());
        if (list != null) {
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            int total = 0;
            for (Entry e : list) {
                dtm.addRow(new Object[]{e, e.getProofOfPayment().getType(), e.getQuantity(), e.getEntryUnitPrice(), e.getEntryProfitPercentage() + "%", e.getBatch(), e.getSupplier(), e.getSanitaryRegister(), getDateForm(e.getArrivalDate()), getDateForm(e.getExpiryDate())});
                total += e.getQuantity();
            }
            totalTextField.setText("" + total);
        }
    }

    private String getDateForm(Date d) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        String day = "0" + gc.get(GregorianCalendar.DAY_OF_MONTH), month = "0" + (gc.get(GregorianCalendar.MONTH) + 1), year = "0" + gc.get(GregorianCalendar.YEAR);
        String date = day.substring(day.length() - 2) + "/" + month.substring(month.length() - 2) + "/" + year.substring(year.length() - 4);
        return date;
    }
}
