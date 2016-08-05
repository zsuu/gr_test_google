import hu.bir.spec.KioskSpec
import org.apache.commons.io.IOUtils
import spock.util.EmbeddedSpecRunner

class Main {

    static void main(String[] args) {
        if ( args.length < 1 ) {
            System.out.println("Please specify KIOSK base url as first argument, eg. http://localhost:8095")
            System.exit(1)
        }

        String baseUrl = args[0]

        if ( args.length > 1 ) {
            KioskSpec.delay = Integer.parseInt(args[1]) * 1000
        }

        File chromeDriver = getTempfile("/chromedriver.exe")

        System.setProperty("geb.build.reportsDir", "C:\\tmp");
        System.setProperty("geb.env", "chrome");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getPath());
        System.setProperty("geb.build.baseUrl", baseUrl)

        EmbeddedSpecRunner embeddedSpecRunner = new EmbeddedSpecRunner()
        embeddedSpecRunner.runClass(KioskSpec)
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
