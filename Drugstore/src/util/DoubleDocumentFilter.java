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
public class DoubleDocumentFilter extends DocumentFilter {

    @Override
    public void insertString(DocumentFilter.FilterBypass fp, int offset, String string, AttributeSet aset)
            throws BadLocationException {

        if (isValid(string)) {
            super.insertString(fp, offset, string, aset);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fp, int offset, int length, String string, AttributeSet aset)
            throws BadLocationException {

        if (isValid(string)) {
            super.replace(fp, offset, length, string, aset);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private boolean isValid(String s) {
        int len = s.length();
        int index = s.indexOf('.');
        if (index != -1) {
            if (s.length() - index - 1 > 7) {
                return false;
            }
        }

        boolean dot = false;

        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '.') {
                dot = true;
                continue;
            }
            if (c == '.' && dot) {
                return false;
            }

            if (c != '.' && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
