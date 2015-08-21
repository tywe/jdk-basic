package org.teng.jdk.problems.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/21
 */
public class VarParamTest {
    @Test
    public void testVarParam() {
        int a = 0;

        /*
        case1:传递赋值为null的变量
        varParam type is String[]
        varParam is not null
        varParam size:1
         */
        String vars1 = null;

        /*
        case2:传递赋值为非null元素变量
        varParam type is String[]
        varParam is not null
        varParam size:1
         */
        String vars2 = "a";

        /*
        case3:传递赋值为非null元素数组变量
        varParam type is String[]
        varParam is not null
        varParam size:2
         */
        String[] vars3 = new String[]{"a", "b"};

        /*
        case4:传递赋值为null元素数组变量
        varParam type is String[]
        varParam is not null
        varParam size:2
         */
        String[] vars4 = new String[]{null, null};

        /*
        case5: 不传值
        varParam type is String[]
        varParam is not null
        varParam size:0
         */

        /*
        case6: 传null值
        varParam type is null
         */

        /*
        case7: 传类型为数组的变量null值
        varParam type is null
         */

        /*
         总结：可变变量本身是数组的变形，编译器会对可变变量进行如下类型转换：
          string... varArgs  ---> new String[]{var1, var2}
          故，当传入String var = null时，等价于new String[]{null};
              当传入String[] var = null时，varArgs = null;
         */
        String[] vars7 = null;

        VarParam.checkVarParamUsage(a, vars7);
    }
}