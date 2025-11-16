/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.sql.audit;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sqlts.insert.sql.DedicatedEventsSqlPartitioningRepository;

public class DedicatedJpaAuditLogDaoDiffblueTest {
  /**
   * Test {@link DedicatedJpaAuditLogDao#removeById(TenantId, UUID)}.
   *
   * <p>Method under test: {@link DedicatedJpaAuditLogDao#removeById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DedicatedJpaAuditLogDao.removeById(TenantId, UUID)"})
  public void testRemoveById() {
    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).flush();
    doNothing().when(auditLogRepository).deleteById(Mockito.<UUID>any());
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao =
        new DedicatedJpaAuditLogDao(
            auditLogRepository, mock(DedicatedEventsSqlPartitioningRepository.class));

    // Act
    dedicatedJpaAuditLogDao.removeById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(auditLogRepository).flush();
    verify(auditLogRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link AuditLogRepository#deleteById(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DedicatedJpaAuditLogDao.removeAllByIds(Collection)"})
  public void testRemoveAllByIds_thenCallsDeleteById() {
    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).deleteById(Mockito.<UUID>any());
    doNothing().when(auditLogRepository).flush();
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao =
        new DedicatedJpaAuditLogDao(
            auditLogRepository, mock(DedicatedEventsSqlPartitioningRepository.class));

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DedicatedJpaAuditLogDao#removeAllByIds(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DedicatedJpaAuditLogDao.removeAllByIds(Collection)"})
  public void testRemoveAllByIds_whenArrayList() {
    // Arrange
    AuditLogRepository auditLogRepository = mock(AuditLogRepository.class);
    doNothing().when(auditLogRepository).flush();
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao =
        new DedicatedJpaAuditLogDao(
            auditLogRepository, mock(DedicatedEventsSqlPartitioningRepository.class));

    // Act
    dedicatedJpaAuditLogDao.removeAllByIds(new ArrayList<>());

    // Assert
    verify(auditLogRepository).flush();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DedicatedJpaAuditLogDao#getEntityManager()}
   *   <li>{@link DedicatedJpaAuditLogDao#getJdbcTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityManager DedicatedJpaAuditLogDao.getEntityManager()",
    "org.springframework.jdbc.core.JdbcTemplate DedicatedJpaAuditLogDao.getJdbcTemplate()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DedicatedJpaAuditLogDao dedicatedJpaAuditLogDao =
        new DedicatedJpaAuditLogDao(
            mock(AuditLogRepository.class), mock(DedicatedEventsSqlPartitioningRepository.class));

    // Act
    EntityManager actualEntityManager = dedicatedJpaAuditLogDao.getEntityManager();

    // Assert
    assertNull(actualEntityManager);
    assertNull(dedicatedJpaAuditLogDao.getJdbcTemplate());
  }
}
