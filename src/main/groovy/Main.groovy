import com.zsu.spec.GoogleSpec
import org.apache.commons.io.IOUtils
import spock.util.EmbeddedSpecRunner

class Main {

    /* windows + chrome only yet */
    static void main(String[] args) {
        String baseUrl = "http://www.google.co.uk"

        if ( args.length > 0 ) {
            GoogleSpec.delay = Integer.parseInt(args[0]) * 1000
        } else {
            GoogleSpec.delay = 1000
        }

        File chromeDriver = getTempfile("/chromedriver.exe")

        System.setProperty("geb.build.reportsDir", "C:\\tmp");
        System.setProperty("geb.env", "chrome");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getPath());
        System.setProperty("geb.build.baseUrl", baseUrl)

        EmbeddedSpecRunner embeddedSpecRunner = new EmbeddedSpecRunner()
        embeddedSpecRunner.runClass(GoogleSpec)
    }

    private static File getTempfile(String path) throws IOException {
        File tempFile = File.createTempFile("chromedriver" + System.currentTimeMillis(), ".exe");
        InputStream ins = getClass().getResourceAsStream(path);
        FileOutputStream out = new FileOutputStream(tempFile);
        IOUtils.copy(ins, out);
        ins.close()
        out.close()
        return tempFile;
    }

}
