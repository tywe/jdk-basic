#spring mvc基本框架

##spring 配置

自动扫描非web层的所有bean，注入容器管理

    @Configuration
    @Import(DataConfig.class)
    @ComponentScan(basePackages = {"spittr"},
        excludeFilters = {
                @Filter(type = FilterType.CUSTOM, value = WebPackage.class)
        })
    public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
    }



##web mvc配置
1.省web.xml配置


    public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    }


##数据源和JdbcTemplate模板配置

    数据源配置
    @Configuration
    public class DataConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .build();
    }

    JdbcTemplate配置
    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    }

    数据映射
     private static class SpitterRowMapper implements RowMapper<Spitter> {
            public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Spitter(
                        rs.getLong("id"),
                        rs.getString("username"),
                        null,
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));
            }
        }

##参数验证

    javax.validation包下验证器
    @NotNull
    @Size(min = 5, max = 16)
    private String username;

    @NotNull
    @Size(min = 5, max = 25)
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    org.hibernate.validator包下验证器
    @NotNull
    @Email
    private String email;

##mock测试

      @Test
      public void shouldShowRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
               .andExpect(view().name("registerForm"));
      }