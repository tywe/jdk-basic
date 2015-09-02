#bean属性字段配置

##构造参数配置
###无参数bean
<bean id="compactDisc" class="soundsystem.SgtPeppers"/>

###有参数bean
1.通过constructor-arg标签配置

    <bean id="compactDisc"
          class="soundsystem.BlankDisc">
        <constructor-arg value="Sgt. Pepper's Lonely Hearts Club Band"/>
        <constructor-arg value="The Beatles"/>
    </bean>

    <bean id="cdPlayer"
          class="soundsystem.CDPlayer">
        <constructor-arg ref="compactDisc"/>
    </bean>

     <bean id="compactDisc" class="soundsystem.collections.BlankDisc">
            <constructor-arg value="Sgt. Pepper's Lonely Hearts Club Band"/>
            <constructor-arg value="The Beatles"/>
            <constructor-arg>
                <list>
                    <value>Sgt. Pepper's Lonely Hearts Club Band</value>
                    <value>With a Little Help from My Friends</value>
                    <value>Lucy in the Sky with Diamonds</value>
                    <value>Getting Better</value>
                    <value>Fixing a Hole</value>
                    <value>She's Leaving Home</value>
                    <value>Being for the Benefit of Mr. Kite!</value>
                    <value>Within You Without You</value>
                    <value>When I'm Sixty-Four</value>
                    <value>Lovely Rita</value>
                    <value>Good Morning Good Morning</value>
                    <value>Sgt. Pepper's Lonely Hearts Club Band (Reprise)</value>
                    <value>A Day in the Life</value>
                </list>
            </constructor-arg>
        </bean>

2.通过c命名配置
  （1）名字引用
  <bean id="cdPlayer" class="soundsystem.CDPlayer"
          c:cd-ref="compactDisc"/>
  （2）下标引用
  <bean id="cdPlayer1" class="soundsystem.CDPlayer"
            c:_0-ref="compactDisc"/>
  （3）字段匹配
  <bean id="compactDisc" class="soundsystem.BlankDisc"
            c:_0="Sgt. Pepper's Lonely Hearts Club Band"
            c:_1="The Beatles"/>

##属性参数配置
1.通过property标签配置
<bean id="cdPlayer" class="soundsystem.properties.CDPlayer">
        <property name="compactDisc" ref="compactDisc"/>
    </bean>


2.通过p命名标签配置

  <bean id="compactDisc"
          class="soundsystem.properties.BlankDisc"
          p:title="Sgt. Pepper's Lonely Hearts Club Band"
          p:artist="The Beatles">
        <property name="tracks">
            <list>
                <value>Sgt. Pepper's Lonely Hearts Club Band</value>
                <value>With a Little Help from My Friends</value>
                <value>Lucy in the Sky with Diamonds</value>
                <value>Getting Better</value>
                <value>Fixing a Hole</value>
                <value>She's Leaving Home</value>
                <value>Being for the Benefit of Mr. Kite!</value>
                <value>Within You Without You</value>
                <value>When I'm Sixty-Four</value>
                <value>Lovely Rita</value>
                <value>Good Morning Good Morning</value>
                <value>Sgt. Pepper's Lonely Hearts Club Band (Reprise)</value>
                <value>A Day in the Life</value>
            </list>
        </property>
  </bean>

    <bean id="cdPlayer"
          class="soundsystem.properties.CDPlayer"
          p:compactDisc-ref="compactDisc"/>


  或

   <bean id="compactDisc"
              class="soundsystem.properties.BlankDisc"
              p:title="Sgt. Pepper's Lonely Hearts Club Band"
              p:artist="The Beatles"
              p:tracks-ref="trackList"/>

   <util:list id="trackList">
            <value>Sgt. Pepper's Lonely Hearts Club Band</value>
            <value>With a Little Help from My Friends</value>
            <value>Lucy in the Sky with Diamonds</value>
            <value>Getting Better</value>
            <value>Fixing a Hole</value>
            <value>She's Leaving Home</value>
            <value>Being for the Benefit of Mr. Kite!</value>
            <value>Within You Without You</value>
            <value>When I'm Sixty-Four</value>
            <value>Lovely Rita</value>
            <value>Good Morning Good Morning</value>
            <value>Sgt. Pepper's Lonely Hearts Club Band (Reprise)</value>
            <value>A Day in the Life</value>
   </util:list>


##@ContextConfiguration加载context配置文件约定
*-context是约定规则吗？