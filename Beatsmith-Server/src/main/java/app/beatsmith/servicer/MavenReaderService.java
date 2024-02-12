package app.beatsmith.servicer;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class MavenReaderService {

    public static final String LOCAL_POM_FILE = "pom.xml";
    public static final String CLASSPATH_POM_FILE = "/META-INF/maven/app.beatsmith.server/Beatsmith-Server/pom.xml";
    private final MavenXpp3Reader mavenXpp3Reader;

    /**
     * Stellt die eingelesene Maven Konfiguration dar.
     */
    private final Model model;

    public MavenReaderService() throws XmlPullParserException, IOException {
        this.mavenXpp3Reader = new MavenXpp3Reader();
        this.model = parseMavenFile();
    }

    /**
     * Diese Methode versucht die zur Laufzeit angewandte Maven Konfiguration einzulesen.
     * Dabei wird zuerst nach der lokal liegenden pom.xml Datei geschaut.
     * Sollte diese nicht existieren wird die Datei aus dem Classpath der gebauten Jar gelesen.
     *
     * @return {@link Model}
     */
    private Model parseMavenFile() throws XmlPullParserException, IOException {
        final File localPomFile = new File(LOCAL_POM_FILE);
        if (localPomFile.exists()) {
            final FileReader fileReader = new FileReader(LOCAL_POM_FILE);
            return mavenXpp3Reader.read(fileReader);
        } else {
            final InputStream inputStream = MavenReaderService.class.getResourceAsStream(
                    CLASSPATH_POM_FILE);

            if (inputStream == null) {
                return null;
            }

            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            return mavenXpp3Reader.read(inputStreamReader);
        }
    }

    /**
     * Diese Methode gibt die <code>artifactId</code> der pom.xml aus.
     *
     * @return {@link String}
     */
    public String getId() {
        if (model != null) {
            return model.getId();
        }
        return null;
    }

    /**
     * Diese Methode gibt die <code>version</code> der pom.xml aus.
     *
     * @return {@link String}
     */
    public String getVersion() {
        if (model != null) {
            return model.getVersion();
        }
        return null;
    }
}
