package org.thingsboard.server.dao;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.component.ComponentDescriptorInsertRepository;
import org.thingsboard.server.dao.sql.component.ComponentDescriptorRepository;
import org.thingsboard.server.dao.sql.component.JpaBaseComponentDescriptorDao;

@ContextConfiguration(classes = {JpaBaseComponentDescriptorDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DaoDiffblueTest {
  @MockBean private ComponentDescriptorInsertRepository componentDescriptorInsertRepository;

  @MockBean private ComponentDescriptorRepository componentDescriptorRepository;

  @Autowired private Dao<ComponentDescriptor> dao;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link Dao#getEntityType()}.
   *
   * <p>Method under test: {@link Dao#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.EntityType Dao.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertNull(dao.getEntityType());
  }
}
