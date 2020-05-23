package mashup.backend.etc.our.common.util;

import java.util.Random;

public class RandomCode {
    private static Random random = new Random();
    private static StringBuffer stringBufferCode = new StringBuffer();

    private RandomCode() {}

    public static String generateRandomCode() {
        stringBufferCode.setLength(0);

        for (int i = 0; i < 20; i++) {
            if (random.nextBoolean()) {
                stringBufferCode.append((char) ((int) (random.nextInt(26)) + 97));
            } else {
                stringBufferCode.append((random.nextInt(10)));
            }
        }
        return stringBufferCode.toString();
    }
}