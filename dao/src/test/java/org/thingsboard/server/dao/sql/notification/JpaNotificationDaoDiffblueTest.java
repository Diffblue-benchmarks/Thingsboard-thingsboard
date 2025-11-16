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
package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaNotificationDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaNotificationDao jpaNotificationDao;

  @MockBean private NotificationRepository notificationRepository;

  @MockBean private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}.
   *
   * <ul>
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)"
  })
  public void testCountUnreadByDeliveryMethodAndRecipientId_thenCallsGetId() {
    // Arrange
    NotificationRepository notificationRepository = mock(NotificationRepository.class);
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any()))
        .thenReturn(1);
    JpaNotificationDao jpaNotificationDao =
        new JpaNotificationDao(notificationRepository, mock(SqlPartitioningRepository.class));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult =
        jpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .countByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)"
  })
  public void testCountUnreadByDeliveryMethodAndRecipientId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult =
        jpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository)
        .countByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaNotificationDao#getEntityClass()}
   *   <li>{@link JpaNotificationDao#getEntityType()}
   *   <li>{@link JpaNotificationDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaNotificationDao.getEntityClass()",
    "EntityType JpaNotificationDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaNotificationDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationDao jpaNotificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    // Act
    Class<NotificationEntity> actualEntityClass = jpaNotificationDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationDao.getEntityType();
    jpaNotificationDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION, actualEntityType);
    Class<NotificationEntity> expectedEntityClass = NotificationEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
