package lesson14.np.domain.request;

public class Request {
    private final String modelName;
    private final String calledMethod;
    private final Properties methodProperties;

    public Request(String modelName, String calledMethod, Properties methodProperties) {
        this.modelName = modelName;
        this.calledMethod = calledMethod;
        this.methodProperties = methodProperties;
    }
}
