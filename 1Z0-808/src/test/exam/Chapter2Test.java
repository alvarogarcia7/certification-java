package exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Chapter2Test {

    @Test
    public void side_effects_in_ternary_operator(){
        int y = 1;
        int z = 1;
        final int x;
        x = y >= 10 ? y++ : z++;
        assertEquals(1, y);
        assertEquals(2, z);
    }

    @Test
    public void finally_block_after_return_statement() {
        assertEquals(1, finally_after_return_statement_by_value());
        assertEquals((Integer)1, finally_after_return_statement_by_wrapped_value());
        assertEquals(1, finally_after_return_statement_by_value_in_an_array()[0]);

        assertEquals(2, finally_after_return_statement_by_reference_pre_increment()[0]);
        assertEquals(2, finally_after_return_statement_by_reference_post_increment()[0]);
    }

//    Does not compile because we redefine the variable x
//    public notCompiles for_1() {
//        int x = 0;
//        for (int y = 0, x = 1; true; y++) {
//        }
//    }

//Does not compile because we redefine the variable x, not because it is redefined with another type
//    public notCompiles for_2() {
//        long x = 0;
//        for (int y = 0, x = 1; true; y++) {
//        }
//    }

    @Test
    public void the_continue_statement() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            if (i == 1) {
                continue;
            }
            result.add(i);
        }

        assertTrue(result.contains(0));
        assertFalse(result.contains(1));
        assertTrue(result.contains(2));
    }

    private int finally_after_return_statement_by_value() {
        int x = 0;
        try {
            x = 1;
            return x;
        } finally {
            ++x;
        }
    }

    private Integer finally_after_return_statement_by_wrapped_value() {
        Integer x = 0;
        try {
            x = 1;
            return x;
        } finally {
            x = x + 1;
        }
    }

    private int[] finally_after_return_statement_by_value_in_an_array() {
        Integer x = 0;
        try {
            x = 1;
            int[] x_ = new int[1];
            x_[0] = x;
            return x_;
        } finally {
            ++x;
        }
    }

    private int[] finally_after_return_statement_by_reference_pre_increment() {
        int[] result = new int[1];
        try {
            result[0] = 1;
            return result;
        } finally {
            ++result[0];
        }
    }

    private int[] finally_after_return_statement_by_reference_post_increment() {
        int[] result = new int[1];
        try {
            result[0] = 1;
            return result;
        } finally {
            result[0]++;
        }
    }
}
