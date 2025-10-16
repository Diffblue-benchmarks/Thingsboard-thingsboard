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
package org.thingsboard.server.dao.sql.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserCredentialsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserCredentialsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaUserCredentialsDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaUserCredentialsDao jpaUserCredentialsDao;

  @MockBean private TransactionTemplate transactionTemplate;

  @MockBean private UserCredentialsRepository userCredentialsRepository;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaUserCredentialsDao#getEntityClass()}
   *   <li>{@link JpaUserCredentialsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaUserCredentialsDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaUserCredentialsDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaUserCredentialsDao jpaUserCredentialsDao = new JpaUserCredentialsDao();

    // Act
    Class<UserCredentialsEntity> actualEntityClass = jpaUserCredentialsDao.getEntityClass();

    // Assert
    assertNull(jpaUserCredentialsDao.getRepository());
    Class<UserCredentialsEntity> expectedEntityClass = UserCredentialsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaUserCredentialsDao#findByUserId(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#findByUserId(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials JpaUserCredentialsDao.findByUserId(TenantId, UUID)"})
  public void testFindByUserId() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userCredentialsRepository.findByUserId(Mockito.<UUID>any()))
        .thenReturn(userCredentialsEntity);
    UUID userId = ModelConstants.NULL_UUID;

    // Act
    UserCredentials actualFindByUserIdResult =
        jpaUserCredentialsDao.findByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userCredentialsRepository).findByUserId(isA(UUID.class));
    assertTrue(actualFindByUserIdResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("ABC123", actualFindByUserIdResult.getActivateToken());
    assertEquals("ABC123", actualFindByUserIdResult.getResetToken());
    assertEquals("iloveyou", actualFindByUserIdResult.getPassword());
    assertEquals(1, actualFindByUserIdResult.getFailedLoginAttempts().intValue());
    assertEquals(1L, actualFindByUserIdResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualFindByUserIdResult.getLastLoginTs().longValue());
    assertEquals(1L, actualFindByUserIdResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualFindByUserIdResult.getCreatedTime());
    assertTrue(actualFindByUserIdResult.isEnabled());
    assertSame(userId, actualFindByUserIdResult.getUuidId());
  }

  /**
   * Test {@link JpaUserCredentialsDao#findByActivateToken(TenantId, String)}.
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#findByActivateToken(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials JpaUserCredentialsDao.findByActivateToken(TenantId, String)"})
  public void testFindByActivateToken() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userCredentialsRepository.findByActivateToken(Mockito.<String>any()))
        .thenReturn(userCredentialsEntity);

    // Act
    UserCredentials actualFindByActivateTokenResult =
        jpaUserCredentialsDao.findByActivateToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsRepository).findByActivateToken("ABC123");
    assertTrue(actualFindByActivateTokenResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("ABC123", actualFindByActivateTokenResult.getActivateToken());
    assertEquals("ABC123", actualFindByActivateTokenResult.getResetToken());
    assertEquals("iloveyou", actualFindByActivateTokenResult.getPassword());
    assertEquals(1, actualFindByActivateTokenResult.getFailedLoginAttempts().intValue());
    assertEquals(1L, actualFindByActivateTokenResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualFindByActivateTokenResult.getLastLoginTs().longValue());
    assertEquals(1L, actualFindByActivateTokenResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualFindByActivateTokenResult.getCreatedTime());
    assertTrue(actualFindByActivateTokenResult.isEnabled());
  }

  /**
   * Test {@link JpaUserCredentialsDao#findByResetToken(TenantId, String)}.
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#findByResetToken(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials JpaUserCredentialsDao.findByResetToken(TenantId, String)"})
  public void testFindByResetToken() {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userCredentialsRepository.findByResetToken(Mockito.<String>any()))
        .thenReturn(userCredentialsEntity);

    // Act
    UserCredentials actualFindByResetTokenResult =
        jpaUserCredentialsDao.findByResetToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsRepository).findByResetToken("ABC123");
    assertTrue(actualFindByResetTokenResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("ABC123", actualFindByResetTokenResult.getActivateToken());
    assertEquals("ABC123", actualFindByResetTokenResult.getResetToken());
    assertEquals("iloveyou", actualFindByResetTokenResult.getPassword());
    assertEquals(1, actualFindByResetTokenResult.getFailedLoginAttempts().intValue());
    assertEquals(1L, actualFindByResetTokenResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualFindByResetTokenResult.getLastLoginTs().longValue());
    assertEquals(1L, actualFindByResetTokenResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualFindByResetTokenResult.getCreatedTime());
    assertTrue(actualFindByResetTokenResult.isEnabled());
  }

  /**
   * Test {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserCredentialsDao.removeByUserId(TenantId, UserId)"})
  public void testRemoveByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userCredentialsRepository).removeByUserId(Mockito.<UUID>any());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserCredentialsDao.removeByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId).getId();
    verify(userCredentialsRepository).removeByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserCredentialsRepository#removeByUserId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserCredentialsDao.removeByUserId(TenantId, UserId)"})
  public void testRemoveByUserId_whenUserIdWithIdIsNull_uuid_thenCallsRemoveByUserId() {
    // Arrange
    doNothing().when(userCredentialsRepository).removeByUserId(Mockito.<UUID>any());

    // Act
    jpaUserCredentialsDao.removeByUserId(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userCredentialsRepository).removeByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserCredentialsDao.setLastLoginTs(TenantId, UserId, long)"})
  public void testSetLastLoginTs_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(userCredentialsRepository)
        .updateLastLoginTsByUserId(Mockito.<UUID>any(), anyLong());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserCredentialsDao.setLastLoginTs(ModelConstants.SYSTEM_TENANT, userId, 1L);

    // Assert
    verify(userId).getId();
    verify(userCredentialsRepository).updateLastLoginTsByUserId(isA(UUID.class), eq(1L));
  }

  /**
   * Test {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserCredentialsDao.setLastLoginTs(TenantId, UserId, long)"})
  public void testSetLastLoginTs_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    doNothing()
        .when(userCredentialsRepository)
        .updateLastLoginTsByUserId(Mockito.<UUID>any(), anyLong());

    // Act
    jpaUserCredentialsDao.setLastLoginTs(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), 1L);

    // Assert
    verify(userCredentialsRepository).updateLastLoginTsByUserId(isA(UUID.class), eq(1L));
  }

  /**
   * Test {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId,
   * UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaUserCredentialsDao.incrementFailedLoginAttempts(TenantId, UserId)"})
  public void testIncrementFailedLoginAttempts_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(userCredentialsRepository.incrementFailedLoginAttemptsByUserId(Mockito.<UUID>any()))
        .thenReturn(1);

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualIncrementFailedLoginAttemptsResult =
        jpaUserCredentialsDao.incrementFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId).getId();
    verify(userCredentialsRepository).incrementFailedLoginAttemptsByUserId(isA(UUID.class));
    assertEquals(1, actualIncrementFailedLoginAttemptsResult);
  }

  /**
   * Test {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId, UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId,
   * UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaUserCredentialsDao.incrementFailedLoginAttempts(TenantId, UserId)"})
  public void testIncrementFailedLoginAttempts_whenUserIdWithIdIsNull_uuid_thenReturnOne() {
    // Arrange
    when(userCredentialsRepository.incrementFailedLoginAttemptsByUserId(Mockito.<UUID>any()))
        .thenReturn(1);

    // Act
    int actualIncrementFailedLoginAttemptsResult =
        jpaUserCredentialsDao.incrementFailedLoginAttempts(
            ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userCredentialsRepository).incrementFailedLoginAttemptsByUserId(isA(UUID.class));
    assertEquals(1, actualIncrementFailedLoginAttemptsResult);
  }

  /**
   * Test {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId, int)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserCredentialsDao.setFailedLoginAttempts(TenantId, UserId, int)"})
  public void testSetFailedLoginAttempts_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(userCredentialsRepository)
        .updateFailedLoginAttemptsByUserId(Mockito.<UUID>any(), anyInt());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserCredentialsDao.setFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, userId, 1);

    // Assert
    verify(userId).getId();
    verify(userCredentialsRepository).updateFailedLoginAttemptsByUserId(isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId, int)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserCredentialsDao.setFailedLoginAttempts(TenantId, UserId, int)"})
  public void testSetFailedLoginAttempts_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    doNothing()
        .when(userCredentialsRepository)
        .updateFailedLoginAttemptsByUserId(Mockito.<UUID>any(), anyInt());

    // Act
    jpaUserCredentialsDao.setFailedLoginAttempts(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), 1);

    // Assert
    verify(userCredentialsRepository).updateFailedLoginAttemptsByUserId(isA(UUID.class), eq(1));
  }
}
