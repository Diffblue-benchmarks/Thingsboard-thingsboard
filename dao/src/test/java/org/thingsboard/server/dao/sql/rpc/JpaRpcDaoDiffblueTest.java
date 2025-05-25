package org.thingsboard.server.dao.sql.rpc;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
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
import org.thingsboard.server.dao.model.sql.RpcEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRpcDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRpcDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRpcDao jpaRpcDao;

  @MockBean
  private RpcRepository rpcRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRpcDao#getEntityClass()}
   *   <li>{@link JpaRpcDao#getEntityType()}
   *   <li>{@link JpaRpcDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaRpcDao.getEntityClass()", "EntityType JpaRpcDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaRpcDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaRpcDao jpaRpcDao = new JpaRpcDao(mock(RpcRepository.class));

    // Act
    Class<RpcEntity> actualEntityClass = jpaRpcDao.getEntityClass();
    EntityType actualEntityType = jpaRpcDao.getEntityType();
    jpaRpcDao.getRepository();

    // Assert
    assertEquals(EntityType.RPC, actualEntityType);
    Class<RpcEntity> expectedEntityClass = RpcEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRpcDao#deleteOutdatedRpcByTenantId(TenantId, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaRpcDao.deleteOutdatedRpcByTenantId(TenantId, Long)"})
  public void testDeleteOutdatedRpcByTenantId_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(rpcRepository.deleteOutdatedRpcByTenantId(Mockito.<UUID>any(), Mockito.<Long>any())).thenReturn(1);

    // Act
    int actualDeleteOutdatedRpcByTenantIdResult = jpaRpcDao.deleteOutdatedRpcByTenantId(ModelConstants.SYSTEM_TENANT,
        1L);

    // Assert
    verify(rpcRepository).deleteOutdatedRpcByTenantId(isA(UUID.class), eq(1L));
    assertEquals(1, actualDeleteOutdatedRpcByTenantIdResult);
  }
}
