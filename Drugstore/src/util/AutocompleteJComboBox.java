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
package util;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Sergio Pastor
 */
public class AutocompleteJComboBox extends JComboBox {
    static final long serialVersionUID = 4321421L;
    
    private final Searchable<String, String> searchable;

    public AutocompleteJComboBox(Searchable<String, String> s) {
        super();
        this.searchable = s;
        setEditable(true);
        Component c = getEditor().getEditorComponent();
        if (c instanceof JTextComponent) {
            final JTextComponent tc = (JTextComponent) c;
            tc.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    update();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    update();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    
                }
                
                public void update() {
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            List<String> founds = new ArrayList<>(searchable.search(tc.getText()));
                            Set<String> foundSet = new HashSet<>();
                            for (String s : founds) {
                                foundSet.add(s.toLowerCase());
                            }
                            Collections.sort(founds);
                            
                            setEditable(false);
                            removeAllItems();
                            
                            if (!foundSet.contains(tc.getText().toLowerCase())) {
                                addItem(tc.getText());
                            }
                            
                            for (String s : founds) {
                                addItem(s);
                            }
                            setEditable(true);
                            setPopupVisible(true);
                            tc.requestFocus();
                        }
                    });
                }
            });
            
            tc.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    if (tc.getText().length() > 0) {
                        setPopupVisible(true);
                        tc.setCaretPosition(tc.getText().length());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    
                }
            });
        } else {
            throw new IllegalStateException("Editing component is not a JTextComponent!");
        }
    }
    
    
}
