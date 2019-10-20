package lesson14.np;

import lesson14.np.domain.request.DocumentRequest;

import java.util.ArrayList;
import java.util.List;

public class DocumentsGenerator {
    public List<DocumentRequest> generate(long initialNumber) {
        List<DocumentRequest> result = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            String number = String.valueOf(initialNumber + i);
            result.add(new DocumentRequest(number));
        }

        return result;
    }
}
