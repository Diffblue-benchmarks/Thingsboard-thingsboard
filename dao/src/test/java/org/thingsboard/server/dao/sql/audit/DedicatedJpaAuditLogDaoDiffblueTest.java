package org.thingsboard.server.dao.sql.audit;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.repository.CrudRepository;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sqlts.insert.sql.DedicatedEventsSqlPartitioningRepository;

public class DedicatedJpaAuditLogDaoDiffblueTest {
  /**
   * Test {@link DedicatedJpaAuditLogDao#removeById(TenantId, UUID)}.
   * <p>
   * Method under test: {@link DedicatedJpaAuditLogDao#removeById(TenantId, UUID)}
   */
  @Test
  public void testRemoveById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).flush();
    doNothing().when(auditLogRepository).deleteById(Mockito.<UUID>any());

    // Act
    (new DedicatedJpaAuditLogDao(auditLogRepository, mock(DedicatedEventsSqlPartitioningRepository.class)))
        .removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(auditLogRepository).flush();
    verify(auditLogRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}.
   * <ul>
   *   <li>Then calls {@link CrudRepository#deleteById(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}
   */
  @Test
  public void testRemoveAllByIds_thenCallsDeleteById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).deleteById(Mockito.<UUID>any());
    doNothing().when(auditLogRepository).flush();
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao = new DedicatedJpaAuditLogDao(auditLogRepository,
        mock(DedicatedEventsSqlPartitioningRepository.class));

    ArrayList<UUID> ids = new ArrayList<>();
    ids.add(ModelConstants.NULL_UUID);

    // Act
    dedicatedJpaAuditLogDao.removeAllByIds(ids);

    // Assert
    verify(auditLogRepository).flush();
    verify(auditLogRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}.
   * <ul>
   *   <li>Then calls {@link CrudRepository#deleteById(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}
   */
  @Test
  public void testRemoveAllByIds_thenCallsDeleteById2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).deleteById(Mockito.<UUID>any());
    doNothing().when(auditLogRepository).flush();
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao = new DedicatedJpaAuditLogDao(auditLogRepository,
        mock(DedicatedEventsSqlPartitioningRepository.class));

    ArrayList<UUID> ids = new ArrayList<>();
    ids.add(ModelConstants.NULL_UUID);
    ids.add(ModelConstants.NULL_UUID);

    // Act
    dedicatedJpaAuditLogDao.removeAllByIds(ids);

    // Assert
    verify(auditLogRepository).flush();
    verify(auditLogRepository, atLeast(1)).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}
   */
  @Test
  public void testRemoveAllByIds_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).flush();
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao = new DedicatedJpaAuditLogDao(auditLogRepository,
        mock(DedicatedEventsSqlPartitioningRepository.class));

    // Act
    dedicatedJpaAuditLogDao.removeAllByIds(new ArrayList<>());

    // Assert that nothing has changed
    verify(auditLogRepository).flush();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DedicatedJpaAuditLogDao#getEntityManager()}
   *   <li>{@link DedicatedJpaAuditLogDao#getJdbcTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao = new DedicatedJpaAuditLogDao(mock(AuditLogRepository.class),
        mock(DedicatedEventsSqlPartitioningRepository.class));

    // Act
    EntityManager actualEntityManager = dedicatedJpaAuditLogDao.getEntityManager();

    // Assert
    assertNull(actualEntityManager);
    assertNull(dedicatedJpaAuditLogDao.getJdbcTemplate());
  }
}
