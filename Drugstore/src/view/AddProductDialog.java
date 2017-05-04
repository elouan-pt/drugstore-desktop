/*
 * Copyright (c) 2015 Pastor Tantalean.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pastor Tantalean - initial API and implementation and/or initial documentation
 */
package view;

import controller.ProductDAO;
import controller.UserDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import model.Product;
import model.SaleProductDetail;
import model.User;
import util.IntegerDocumentFilter;
import util.MathUtils;

/**
 *
 * @author Pastor Tantalean
 */
public class AddProductDialog extends java.awt.Dialog {

    /**
     * Creates new form AddProductDialog
     */
    String search;
    SaleProductDetail spd;
    DefaultTableModel dtm;
    Product productSelected;
    NewSalePanel dad;

    public AddProductDialog(java.awt.Frame parent, boolean modal, String search, SaleProductDetail spd, NewSalePanel dad) {
        super(parent, modal);
        initComponents();
        this.search = search;
        this.spd = spd;
        dtm = (DefaultTableModel) productTable.getModel();
        this.dad = dad;
        fillTable();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        completePanel = new javax.swing.JPanel();
        productTableScrollPane = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        descriptionTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        ((AbstractDocument) quantityTextField.getDocument()).setDocumentFilter(
            new IntegerDocumentFilter());
        totalTextField = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPCION", "FORMA", "PRECIO DE VENTA", "STOCK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productTableMousePressed(evt);
            }
        });
        productTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productTableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productTableKeyTyped(evt);
            }
        });
        productTableScrollPane.setViewportView(productTable);

        descriptionTextField.setEditable(false);
        descriptionTextField.setEnabled(false);

        priceTextField.setEditable(false);
        priceTextField.setEnabled(false);

        priceLabel.setText("Precio:");

        quantityLabel.setText("Cantidad:");

        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyReleased(evt);
            }
        });

        totalTextField.setEditable(false);
        totalTextField.setEnabled(false);

        totalLabel.setText("Total:");

        cancelButton.setText("CANCELAR");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("ACEPTAR");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout completePanelLayout = new javax.swing.GroupLayout(completePanel);
        completePanel.setLayout(completePanelLayout);
        completePanelLayout.setHorizontalGroup(
            completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completePanelLayout.createSequentialGroup()
                .addGroup(completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(productTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(priceLabel)
                        .addGap(100, 100, 100)
                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(quantityLabel)
                        .addGap(86, 86, 86)
                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(totalLabel)
                        .addGap(105, 105, 105)
                        .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        completePanelLayout.setVerticalGroup(
            completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completePanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(productTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(priceLabel))
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(quantityLabel))
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(totalLabel))
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(completePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(completePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(completePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void productTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTableKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            getProductSelected();
        }
    }//GEN-LAST:event_productTableKeyReleased

    private void productTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMousePressed
        getProductSelected();
    }//GEN-LAST:event_productTableMousePressed

    private void quantityTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyReleased
        if (descriptionTextField.getText().isEmpty() || quantityTextField.getText().isEmpty()) {
            return;
        }
        int quantity = Integer.parseInt(quantityTextField.getText().trim());
        double price = Double.parseDouble(priceTextField.getText());
        totalTextField.setText(MathUtils.round(price * quantity, 2) + "");

    }//GEN-LAST:event_quantityTextFieldKeyReleased

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if (!quantityTextField.getText().isEmpty()) {
            int quantity = Integer.parseInt(quantityTextField.getText());
            if (quantity < 0 || quantity > productSelected.getStock()) {
                JOptionPane.showMessageDialog(this, "La cantidad ingresada es inválida o no está en stock.");
            } else {
                productSelected.setStock(-quantity);
                spd.setProduct(productSelected);
                spd.setQuantity(quantity);
                spd.setSalePrice(spd.getProduct().getSalePrice());
                spd.setSaleTotalPrice(spd.getQuantity() * spd.getSalePrice());
                dad.list.add(spd);

                dispose();
            }
        }

    }//GEN-LAST:event_acceptButtonActionPerformed

    private void productTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTableKeyTyped

    }//GEN-LAST:event_productTableKeyTyped

    private void productTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            quantityTextField.requestFocus();
        }
    }//GEN-LAST:event_productTableKeyPressed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void quantityTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            acceptButton.doClick();
        }
    }//GEN-LAST:event_quantityTextFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel completePanel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTable productTable;
    private javax.swing.JScrollPane productTableScrollPane;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
        List<Product> list = ProductDAO.listOfProductsByDescription(search);
        if (list != null) {
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }

            for (Product p : list) {
                dtm.addRow(new Object[]{p, p.getForm(), p.getSalePrice(), p.getStock()});
            }
        }

    }

    private void getProductSelected() {
        int selectedIndex = productTable.getSelectedRow();
        if (selectedIndex == -1) {
            return;
        }
        productSelected = (Product) dtm.getValueAt(selectedIndex, 0);
        descriptionTextField.setText(productSelected.getDescription() + " " + productSelected.getForm().getDetail());
        priceTextField.setText(productSelected.getSalePrice() + "");

    }
}
