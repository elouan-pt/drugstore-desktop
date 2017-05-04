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

/**
 *
 * @author Pastor Tantalean
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
//        Connection connection = Database.getConnection();
//        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("report2.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, connection);
//        
//       
//        JasperViewer frame = new JasperViewer(jasperPrint);
//         try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//        SwingUtilities.updateComponentTreeUI(frame);
//        frame.setVisible(true);
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }
    
}
