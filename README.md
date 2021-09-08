# Liberty EJB 2 remote example with EJB JAR, EJB Client JAR, WAR, EAR and App Client

This repository shows an EJB 2 remote example running on WebSphere Liberty/Open Liberty. The sample code includes an EJB JAR, EJB Client JAR, WAR, EAR and App Client:

You may use the default unsecured server.xml and client.xml files for this example. However, you can also opt to use the secure versions of configuration. If you do use the secure configuration, the client and server SSL configurations must match. The easiest way to ensure this is having the Liberty server generate them and copying over the configuration files to the client.

Just run the server successfully first with the deployed EAR. Then copy over the key.p12 and ltpa.keys files from the server's resources/security directory to the client's resources/security directory before running the client.
