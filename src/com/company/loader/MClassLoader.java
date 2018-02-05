package com.company.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MClassLoader extends ClassLoader {

    private static final String PATH_JAR = "C:\\Users\\Alexander\\IdeaProjects\\Lab01_Java\\out\\artifacts\\Lab01_Java_jar";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            JarFile jarFile = new JarFile(PATH_JAR);
            JarEntry jarEntry =
                    new JarEntry(name.replace(".", "/") + ".class");
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            byte[] classBytes = new byte[(int) jarEntry.getSize()];
            if (inputStream.read(classBytes) != classBytes.length)
                throw new IOException("No class.");

            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return super.findClass(name);
    }
}
