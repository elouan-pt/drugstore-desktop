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

import java.util.Collection;

/**
 *
 * @author Pastor Tantalean
 *
 * @param <E>
 * @param <V>
 */
public interface Searchable<E, V> {

    public Collection<E> search(V value);

}
