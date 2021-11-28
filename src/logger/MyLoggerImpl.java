package logger;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyLoggerImpl implements MyLogger {
    private final String DEFAULT_LOG_D_PATH = "default/logD/path";
    private final String DEFAULT_LOG_W_PATH = "default/logW/path";
    private final String DEFAULT_LOG_E_PATH = "default/logE/path";
    private final String DEFAULT_TAG = "defaultTag";

    @Override
    public void logD(String path, String fileName, String data, String tag) {
        if (path == null) {
            path = DEFAULT_LOG_D_PATH;
        }
        if (tag == null) {
            tag = DEFAULT_TAG;
        }

        try {
            // проверяем данные на null, чтобы не писать мусор
            checkNotNull(data);

            writeToFile(
                    getLogFile(path, getFileName(fileName)),
                    tag + " " + data);
        } catch (IOException | NullPointerException e) {
            System.out.println(e);
        }
    }

    @Override
    public void logW(String path, String fileName, String data, String tag) {
        if (path == null) {
            path = DEFAULT_LOG_W_PATH;
        }

        try {
            writeToFile(
                    getLogFile(path, getFileName(fileName)),
                    tag + " " + data);
        } catch (IOException | NullPointerException e) {
            System.out.println(e);
        }
    }

    @Override
    public void logE(String path, String fileName, String data, String tag) {
        if (path == null) {
            path = DEFAULT_LOG_E_PATH;
        }

        try {
            writeToFile(
                    getLogFile(path, getFileName(fileName)),
                    tag + " " + data);
        } catch (IOException | NullPointerException e) {
            System.out.println(e);
        }
    }

    private File getLogFile(String path, String fileName) {
        //возможно такой файл уже существует, не буду вдаваться в реазилацию
        File foundFile = findFile(path + "/" + fileName);
        if (foundFile != null)
            return foundFile;
        else
            return new File(path, fileName);
    }

    private File findFile(String filePathWithName) {
        return new File(filePathWithName);
    }

    private void writeToFile(File file, String data) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(data);
    }

    Object checkNotNull(final Object obj) throws NullPointerException {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    /**
     * @param fileName
     * @return fileName+Date or Date
     */
    private String getFileName(String fileName) {
        //если новый день, то прибавим его дату, тем самым добьемся хранение логов в разных днях
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (fileName == null) {
            return LocalDate.now().format(formatter);
        } else {
            return fileName + "_" + LocalDate.now().format(formatter);
        }
    }
}

