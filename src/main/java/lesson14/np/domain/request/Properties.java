package lesson14.np.domain.request;

import java.util.List;

public class Properties {
    private final List<DocumentRequest> Documents;

    public Properties(List<DocumentRequest> documentRequests) {
        this.Documents = documentRequests;
    }
}
