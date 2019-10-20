package lesson14.np;

import lesson14.np.domain.request.DocumentRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class DocumentsGenerator {
    public List<DocumentRequest> generate(long initialNumber) {
        List<DocumentRequest> result = new ArrayList<>(100);

        LongStream.range(0, 100).map(x -> x + initialNumber)
                .mapToObj(String::valueOf)
                .forEach(x -> result.add(new DocumentRequest(x)));

        return result;
    }
}
