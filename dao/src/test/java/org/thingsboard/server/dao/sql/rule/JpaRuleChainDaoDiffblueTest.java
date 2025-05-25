package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleChainEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleChainDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRuleChainDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRuleChainDao jpaRuleChainDao;

  @MockBean
  private RuleChainRepository ruleChainRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRuleChainDao#getEntityClass()}
   *   <li>{@link JpaRuleChainDao#getEntityType()}
   *   <li>{@link JpaRuleChainDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaRuleChainDao.getEntityClass()", "EntityType JpaRuleChainDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaRuleChainDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleChainDao jpaRuleChainDao = new JpaRuleChainDao();

    // Act
    Class<RuleChainEntity> actualEntityClass = jpaRuleChainDao.getEntityClass();
    EntityType actualEntityType = jpaRuleChainDao.getEntityType();

    // Assert
    assertNull(jpaRuleChainDao.getRepository());
    assertEquals(EntityType.RULE_CHAIN, actualEntityType);
    Class<RuleChainEntity> expectedEntityClass = RuleChainEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRuleChainDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaRuleChainDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(ruleChainRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaRuleChainDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }
}
