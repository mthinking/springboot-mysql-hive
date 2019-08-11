package com.mao.mysqlhive.demomh.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ProjectName
 * @Description: 后台数据源配置类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "hive.datasource.druid")
public class HiveDataBaseConfig {

    @Value("${hive.datasource.druid.filters}")
    private String filters;
    @Value("${hive.datasource.druid.driverClassName}")
    private String url;
    @Value("${hive.datasource.druid.url}")
    private String username;
    @Value("${hive.datasource.druid.username}")
    private String password;
    @Value("${hive.datasource.druid.password}")
    private String driverClassName;
    @Value("${hive.datasource.druid.initialSize}")
    private int initialSize;
    @Value("${hive.datasource.druid.minIdle}")
    private int minIdle;
    @Value("${hive.datasource.druid.maxActive}")
    private int maxActive;
    @Value("${hive.datasource.druid.maxWait}")
    private long maxWait;
    @Value("${hive.datasource.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${hive.datasource.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${hive.datasource.druid.validationQuery}")
    private String validationQuery;
    @Value("${hive.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${hive.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${hive.datasource.druid.testOnReturn}")
    private boolean testOnReturn;
    @Value("${hive.datasource.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${hive.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;


    @Bean(name = "hiveDruidDataSource")
    @Qualifier("hiveDruidDataSource")
    public DataSource hiveDataSource() throws SQLException {
        DruidDataSource druid = new DruidDataSource();
        // 监控统计拦截的filters
        druid.setFilters(filters);

        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);

        //初始化时建立物理连接的个数
        druid.setInitialSize(initialSize);
        //最大连接池数量
        druid.setMaxActive(maxActive);
        //最小连接池数量
        druid.setMinIdle(minIdle);
        //获取连接时最大等待时间，单位毫秒。
        druid.setMaxWait(maxWait);
        //间隔多久进行一次检测，检测需要关闭的空闲连接
        druid.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //一个连接在池中最小生存的时间
        druid.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        //用来检测连接是否有效的sql
        druid.setValidationQuery(validationQuery);
        //建议配置为true，不影响性能，并且保证安全性。
        druid.setTestWhileIdle(testWhileIdle);
        //申请连接时执行validationQuery检测连接是否有效
        druid.setTestOnBorrow(testOnBorrow);
        druid.setTestOnReturn(testOnReturn);
        //是否缓存preparedStatement，也就是PSCache，oracle设为true，mysql设为false。分库分表较多推荐设置为false
        druid.setPoolPreparedStatements(poolPreparedStatements);
        // 打开PSCache时，指定每个连接上PSCache的大小
        druid.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return druid;
    }

    @Bean(name = "hiveJdbcTemplate")
    public JdbcTemplate hiveJdbcTemplate(@Qualifier("hiveDruidDataSource") DataSource dataSource){
    return new JdbcTemplate(dataSource);
    }

}
