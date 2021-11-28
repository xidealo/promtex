package logger;

public interface MyLogger {
    /**
     * 3 уровня логирования
     */
    void logD(String path, String fileName, String data, String tag);
    void logW(String path, String fileName, String data, String tag);
    void logE(String path, String fileName, String data, String tag);
}
