package com.company.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MClassLoader extends ClassLoader {

    /**
     * УКАЖИТЕ ПУТЬ К JAR ФАЙЛУ ЗДЕСЬ!
     * Файл находится в папке SUM, которая находится в корневой папке проекта.
     */
    private static final String PATH_JAR = "Lab01_Java\\sum\\Lab01_Java.jar";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            JarFile jarFile = new JarFile(PATH_JAR);
            JarEntry jarEntry = jarFile.getJarEntry(
                    name.replace(".", "/") + ".class");
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
