package org.teng.jdk.simple.reflect;

import org.junit.Test;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/25
 */
public class ClassUtilsTest {

    //    @Test
    public void testGetDefaultClassLoader() throws Exception {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        Class clazz = classLoader.loadClass("java.lang.String");

        System.out.println("default classLoad" + classLoader.toString() + ", clazz:" + clazz.getName());
    }

    //    @Test
    public void testOverrideThreadContextClassLoader() throws Exception {
        ClassLoader defautlClassLoader = ClassUtils.getDefaultClassLoader();
        ClassLoader classLoader = ClassUtils.overrideThreadContextClassLoader(defautlClassLoader);
        ;
        Class clazz = classLoader.loadClass("java.lang.String");

        System.out.println("default classLoad" + classLoader.toString() + ", clazz:" + clazz.getName());
    }

    //    @Test
    public void testForName() throws Exception {
        ClassLoader defautlClassLoader = ClassUtils.getDefaultClassLoader();
        Class strClazz = ClassUtils.forName("java.lang.String", defautlClassLoader);
        String str = (String) strClazz.newInstance();
        System.out.println("for name clazz:" + strClazz.getName());
    }

    //    @Test
    public void testResolveClassName() throws Exception {
        ClassLoader defautlClassLoader = ClassUtils.getDefaultClassLoader();
        Class clazz = ClassUtils.resolveClassName("java.lang.Integer", defautlClassLoader);

        System.out.println("default classLoad" + defautlClassLoader.toString() + ", clazz:" + clazz.getName());
    }

    //    @Test
    public void testResolvePrimitiveClassName() throws Exception {
        Class clazz = ClassUtils.resolvePrimitiveClassName("int[]");
        System.out.println("clazz:" + clazz.getName());
    }

    //    @Test
    public void testIsPresent() throws Exception {
        ClassLoader defautlClassLoader = ClassUtils.getDefaultClassLoader();
        ClassUtils.isPresent("java.lang.Integer", defautlClassLoader);
    }

    @Test
    public void testGetUserClass() throws Exception {
        Class clazz = ClassUtils.getUserClass(String.class);
        System.out.println("clazz:" + clazz.getName());
    }

    @Test
    public void testGetUserClass1() throws Exception {
        Class clazz = ClassUtils.getUserClass(new String());
        System.out.println("clazz:" + clazz.getName());
    }

    @Test
    public void testGetShortName() throws Exception {

    }

    @Test
    public void testGetShortName1() throws Exception {

    }

    @Test
    public void testGetShortNameAsProperty() throws Exception {

    }

    @Test
    public void testGetClassFileName() throws Exception {

    }

    @Test
    public void testGetPackageName() throws Exception {

    }

    @Test
    public void testGetPackageName1() throws Exception {

    }

    @Test
    public void testGetQualifiedName() throws Exception {

    }

    @Test
    public void testGetQualifiedMethodName() throws Exception {

    }

    @Test
    public void testGetDescriptiveType() throws Exception {

    }

    @Test
    public void testMatchesTypeName() throws Exception {

    }

    @Test
    public void testHasConstructor() throws Exception {

    }

    @Test
    public void testGetConstructorIfAvailable() throws Exception {

    }

    @Test
    public void testHasMethod() throws Exception {

    }

    @Test
    public void testGetMethod() throws Exception {

    }

    @Test
    public void testGetMethodIfAvailable() throws Exception {

    }

    @Test
    public void testGetMethodCountForName() throws Exception {

    }

    @Test
    public void testHasAtLeastOneMethodWithName() throws Exception {

    }

    @Test
    public void testGetMostSpecificMethod() throws Exception {

    }

    @Test
    public void testIsUserLevelMethod() throws Exception {

    }

    @Test
    public void testGetStaticMethod() throws Exception {

    }

    @Test
    public void testIsPrimitiveWrapper() throws Exception {

    }

    @Test
    public void testIsPrimitiveOrWrapper() throws Exception {

    }

    @Test
    public void testIsPrimitiveArray() throws Exception {

    }

    @Test
    public void testIsPrimitiveWrapperArray() throws Exception {

    }

    @Test
    public void testResolvePrimitiveIfNecessary() throws Exception {

    }

    @Test
    public void testIsAssignable() throws Exception {

    }

    @Test
    public void testIsAssignableValue() throws Exception {

    }

    @Test
    public void testConvertResourcePathToClassName() throws Exception {

    }

    @Test
    public void testConvertClassNameToResourcePath() throws Exception {

    }

    @Test
    public void testAddResourcePathToPackagePath() throws Exception {

    }

    @Test
    public void testClassPackageAsResourcePath() throws Exception {

    }

    @Test
    public void testClassNamesToString() throws Exception {

    }

    @Test
    public void testClassNamesToString1() throws Exception {

    }

    @Test
    public void testToClassArray() throws Exception {

    }

    @Test
    public void testGetAllInterfaces() throws Exception {

    }

    @Test
    public void testGetAllInterfacesForClass() throws Exception {

    }

    @Test
    public void testGetAllInterfacesForClass1() throws Exception {

    }

    @Test
    public void testGetAllInterfacesAsSet() throws Exception {

    }

    @Test
    public void testGetAllInterfacesForClassAsSet() throws Exception {

    }

    @Test
    public void testGetAllInterfacesForClassAsSet1() throws Exception {

    }

    @Test
    public void testCreateCompositeInterface() throws Exception {

    }

    @Test
    public void testDetermineCommonAncestor() throws Exception {

    }

    @Test
    public void testIsVisible() throws Exception {

    }

    @Test
    public void testIsCglibProxy() throws Exception {

    }

    @Test
    public void testIsCglibProxyClass() throws Exception {

    }

    @Test
    public void testIsCglibProxyClassName() throws Exception {

    }
}