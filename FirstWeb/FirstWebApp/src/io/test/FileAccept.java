package io.test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by yu on 2018/7/23
 */
public class FileAccept implements FilenameFilter {
    private String extendName;

    public void setExtendName(String s) {
        this.extendName = "." + s;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extendName);
    }
}
