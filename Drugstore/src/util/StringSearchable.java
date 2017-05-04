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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Sergio Pastor
 */
public class StringSearchable implements Searchable<String, String> {

    private List<String> terms = new ArrayList<>();

    public StringSearchable(List<String> terms) {
        this.terms.addAll(terms);
    }

    @Override
    public Collection<String> search(String value) {
        List<String> founds = new ArrayList<>();

        for (String s : terms) {
            if (s.indexOf(value) == 0) {
                founds.add(s);
            }
        }
        return founds;
    }

}
