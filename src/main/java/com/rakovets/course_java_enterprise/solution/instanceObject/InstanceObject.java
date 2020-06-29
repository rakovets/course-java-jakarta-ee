package com.rakovets.course_java_enterprise.solution.instanceObject;

import java.util.ArrayList;

public class InstanceObject {
    private static final Object LOCK = new Object();
    private static ArrayList artistList = null;

    public static ArrayList getInstanceArtistsList() {
        if (artistList == null) {
            synchronized (LOCK) {
                if (artistList == null) {
                    artistList = new ArrayList();
                }
            }
        }
        return artistList;
    }
}