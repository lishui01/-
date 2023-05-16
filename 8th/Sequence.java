import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author tiger
 * date  2022-09-16 7:10
 */
public class Sequence {
    public Integer getMaxSum(final List<Integer> values) {
        // 卫语句
        if (null == values || values.isEmpty()) {
            return null;
        }
        Integer max = Integer.MIN_VALUE;
        Integer currentSum = 0;
        for (int i = 0; i < values.size(); ++i) {
            // 当前子串之和小于0，则开始新的子串
            if (currentSum <= 0) {
                currentSum = values.get(i);
            } else { // 子串继续增长
                currentSum += values.get(i);
            }
            // 记录当前最大子序列值
            if (currentSum > max) {
                max = currentSum;
            }
        }
        return max;
    }
}
class SequenceTest {
    Sequence sequence;

    @BeforeEach
    void setup() {
        sequence = new Sequence();
    }

    @Test
    @DisplayName("当序列为null，则子序列之和返回null")
    public void get_null_with_null_sequence() {
        assertEquals(null, sequence.getMaxSum(null));
    }

    @Test
    @DisplayName("当序列为空时，则子序列之和返回0")
    public void get_null_with_empty_sequence() {
        List<Integer> list = new ArrayList<>();
        assertEquals(null, sequence.getMaxSum(list));
    }

    @Test
    @DisplayName("全负数")
    public void get_sum_with_all_below() {
        List<Integer> list = asList(-23, -3, -5);
        assertEquals(-3, sequence.getMaxSum(list));
    }
    @Test
    @DisplayName("全正数")
    public void get_sum_with_all_hight() {
        List<Integer> list = asList(5, 3,9,11,22);
        assertEquals(50, sequence.getMaxSum(list));
    }
    @Test
    @DisplayName("正负都有")
    public void get_sum_with_hight_and_low() {
        List<Integer> list = asList(-5, 3,-9,11,1,-22,1,2);
        assertEquals(12, sequence.getMaxSum(list));
    }
}
