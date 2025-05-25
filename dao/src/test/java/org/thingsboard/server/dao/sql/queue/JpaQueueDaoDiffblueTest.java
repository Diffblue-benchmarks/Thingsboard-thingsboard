package org.thingsboard.server.dao.sql.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.QueueEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaQueueDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaQueueDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaQueueDao jpaQueueDao;

  @MockBean
  private QueueRepository queueRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaQueueDao#getEntityClass()}
   *   <li>{@link JpaQueueDao#getEntityType()}
   *   <li>{@link JpaQueueDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaQueueDao.getEntityClass()", "EntityType JpaQueueDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaQueueDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaQueueDao jpaQueueDao = new JpaQueueDao();

    // Act
    Class<QueueEntity> actualEntityClass = jpaQueueDao.getEntityClass();
    EntityType actualEntityType = jpaQueueDao.getEntityType();

    // Assert
    assertNull(jpaQueueDao.getRepository());
    assertEquals(EntityType.QUEUE, actualEntityType);
    Class<QueueEntity> expectedEntityClass = QueueEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaQueueDao#findAllByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueDao.findAllByTenantId(TenantId)"})
  public void testFindAllByTenantId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllByTenantIdResult = jpaQueueDao.findAllByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueRepository).findByTenantId(isA(UUID.class));
    assertTrue(actualFindAllByTenantIdResult.isEmpty());
  }
}
