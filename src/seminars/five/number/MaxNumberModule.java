package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxNumberModule {
    public List<Integer> getList() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }

}
