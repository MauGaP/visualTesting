package org.visualvalidation.util.firebase;

import java.io.IOException;

public class FirebaseCaller {
    public static void firebaseCaller(String[] args) throws IOException {
        Thread t = new Thread(new ShowDbChanges());

        t.run();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
