package org.teng.jdk.problems.array;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/21
 */
public class VarParam {
    /**
     * problem:
     * 怎么判断可变变量的是不是有可取的值？
     * 1.如果没有给可变变量传递值，可变变量默认是size:0空数组；
     * 2.如果给可变量传递null，则可变变量的引用是null；
     * 3.如果可变变量传递多个null，则可变变量为size:n的null数组；
     * 4.如果给可变变量传递为n（n>=1）值，则可变变量为size：n的值类型数组。
     *
     * 综上：判断可变变量有可取的传递值的完整条件为：
     * varParm != null && varParam.length > 0
     * 一般来说，可变数组两种用法：
     * 1.传递值，大小为传递值数量
     * 2.不传递值，大小为0
     *
     * @param a
     * @param varParam
     */
    public static void checkVarParamUsage(int a, String... varParam){
        if(varParam instanceof String[]){
            System.out.println("varParam type is String[]");
        }else{
            if(varParam == null){
                System.out.println("varParam type:null");
            }else{
                System.out.println("varParam type:" + varParam.getClass());
            }
        }

        if(varParam != null){
            System.out.println("varParam is not null");
            if (varParam.length > 0){
                System.out.println("varParam size:" + varParam.length);
            }else{
                System.out.println("varParam size:" + varParam.length);
            }

        }

        System.out.println("a:" + a);
    }
}
