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

import model.User;

/**
 *
 * @author Sergio Pastor
 */
public class Constants {
    
    private static double IGV = 18.0;
    private static User userLoged;

    public static double getIGV() {
        return IGV;
    }

    public static void setIGV(double IGV) {
        Constants.IGV = IGV;
    }

    public static User getUserLoged() {
        return userLoged;
    }

    public static void setUserLoged(User userLoged) {
        Constants.userLoged = userLoged;
    }
    
    
}
