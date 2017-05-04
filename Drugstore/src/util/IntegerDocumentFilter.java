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

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Sergio Pastor
 */
public class IntegerDocumentFilter extends DocumentFilter {

    @Override
    public void insertString(DocumentFilter.FilterBypass fp, int offset, String string, AttributeSet aset)
            throws BadLocationException {
        
        fp.insertString(offset, string.replaceAll("\\D++", ""), aset);
        /*
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                isValidInteger = false;
                break;
            }
        }
        if (isValidInteger) {
            super.insertString(fp, offset, string, aset);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
        */
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fp, int offset, int length, String string, AttributeSet aset)
            throws BadLocationException {
        
        fp.replace(offset, length, string.replaceAll("\\D++", ""), aset);
        /*
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                isValidInteger = false;
                break;
            }
        }
        if (isValidInteger) {
            super.replace(fp, offset, length, string, aset);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
        */
    }
}
