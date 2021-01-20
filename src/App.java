package com.testexamples.app;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
                try (CqlSession session = CqlSession.builder()
                        .addContactPoint(new InetSocketAddress("172.16.238.3", 9042))
                        .withLocalDatacenter("DC1")
                        .build()) {
                ResultSet rs = session.execute("select release_version from system.local");
                Row row = rs.one();
                System.out.println(row.getString("release_version"));
                }
    }
}