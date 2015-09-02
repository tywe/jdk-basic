#数据源配置

##java配置数据源
使用profile配置不同环境下的数据源，通过ActiveProfiles确定激活使用特定的数据源

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("dev")
    public static class DevDataSourceTest {
        @Autowired
        private DataSource embeddedDataSource;

        @Test
        public void shouldBeEmbeddedDatasource() {
            assertNotNull(embeddedDataSource);
            JdbcTemplate jdbc = new JdbcTemplate(embeddedDataSource);
            List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getLong("id") + ":" + rs.getString("name");
                }
            });

            assertEquals(1, results.size());
            assertEquals("1:A", results.get(0));
        }
    }

1.开发测试环境数据源


    @Bean(destroyMethod = "shutdown")
    @Profile("dev")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

2.生产环境数据源


    @Bean
    @Profile("prod")
    public DataSource jndiDataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

##xml配置数据源
1.开发测试环境数据源


    <beans profile="dev">
        <jdbc:embedded-database id="dataSource-dev" type="H2">
            <jdbc:script location="classpath:schema.sql"/>
            <jdbc:script location="classpath:test-data.sql"/>
        </jdbc:embedded-database>
    </beans>

2.生产环境数据源


    <beans profile="prod">
        <jee:jndi-lookup id="dataSource-prod"
                         lazy-init="true"
                         jndi-name="jdbc/myDatabase"
                         resource-ref="true"
                         proxy-interface="javax.sql.DataSource"/>
    </beans>


##jdbcTemplate使用
传入数据源，创建JdbcTemplate对象；传入sql和RowMapper接口实现，返回数据库操作数据。

            JdbcTemplate jdbc = new JdbcTemplate(dataSource);
            List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getLong("id") + ":" + rs.getString("name");
                }
            });