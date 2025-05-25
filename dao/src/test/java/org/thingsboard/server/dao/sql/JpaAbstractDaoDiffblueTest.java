package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmEntity;
import org.thingsboard.server.dao.sql.alarm.AlarmRepository;
import org.thingsboard.server.dao.sql.alarm.EntityAlarmRepository;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.sql.query.AlarmQueryRepository;

@ContextConfiguration(classes = {JpaAlarmDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAbstractDaoDiffblueTest {
  @MockBean
  private AlarmQueryRepository alarmQueryRepository;

  @MockBean
  private AlarmRepository alarmRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityAlarmRepository entityAlarmRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAbstractDao<AlarmEntity, Alarm> jpaAbstractDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#existsById(Object)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaAbstractDao.existsById(TenantId, UUID)"})
  public void testExistsById_givenAlarmRepositoryExistsByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByIdResult = jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertFalse(actualExistsByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#existsById(Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaAbstractDao.existsById(TenantId, UUID)"})
  public void testExistsById_givenAlarmRepositoryExistsByIdReturnTrue_thenReturnTrue() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByIdResult = jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(alarmRepository).existsById(isA(UUID.class));
    assertTrue(actualExistsByIdResult);
  }

  /**
   * Test {@link JpaAbstractDao#existsById(TenantId, UUID)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaAbstractDao.existsById(TenantId, UUID)"})
  public void testExistsById_thenThrowIllegalArgumentException() {
    // Arrange
    when(alarmRepository.existsById(Mockito.<UUID>any())).thenThrow(new IllegalArgumentException("Exists by key {}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jpaAbstractDao.existsById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    verify(alarmRepository).existsById(isA(UUID.class));
  }

  /**
   * Test {@link JpaAbstractDao#existsByIdAsync(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#existsByIdAsync(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture JpaAbstractDao.existsByIdAsync(TenantId, UUID)"})
  public void testExistsByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualExistsByIdAsyncResult = jpaAbstractDao.existsByIdAsync(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualExistsByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualExistsByIdAsyncResult);
  }

  /**
   * Test {@link JpaAbstractDao#find(TenantId)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link ListCrudRepository#findAll()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDao#find(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaAbstractDao.find(TenantId)"})
  public void testFind_givenAlarmRepositoryFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(alarmRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Alarm> actualFindResult = jpaAbstractDao.find(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(alarmRepository).findAll();
    assertTrue(actualFindResult.isEmpty());
  }
}
