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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserSettingsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaUserSettingsDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaUserSettingsDao jpaUserSettingsDao;

  @MockBean private TransactionTemplate transactionTemplate;

  @MockBean private UserSettingsRepository userSettingsRepository;

  /**
   * Test {@link JpaUserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}.
   *
   * <ul>
   *   <li>Given {@link UserSettingsRepository} {@link UserSettingsRepository#findById(Object)}
   *       return empty.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings JpaUserSettingsDao.findById(TenantId, UserSettingsCompositeKey)"
  })
  public void testFindById_givenUserSettingsRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<UserSettingsEntity> emptyResult = Optional.empty();
    when(userSettingsRepository.findById(Mockito.<UserSettingsCompositeKey>any()))
        .thenReturn(emptyResult);

    // Act
    UserSettings actualFindByIdResult =
        jpaUserSettingsDao.findById(ModelConstants.SYSTEM_TENANT, new UserSettingsCompositeKey());

    // Assert
    verify(userSettingsRepository).findById(isA(UserSettingsCompositeKey.class));
    assertNull(actualFindByIdResult);
  }

  /**
   * Test {@link JpaUserSettingsDao#removeById(TenantId, UserSettingsCompositeKey)}.
   *
   * <p>Method under test: {@link JpaUserSettingsDao#removeById(TenantId, UserSettingsCompositeKey)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserSettingsDao.removeById(TenantId, UserSettingsCompositeKey)"})
  public void testRemoveById() {
    // Arrange
    doNothing().when(userSettingsRepository).deleteById(Mockito.<UserSettingsCompositeKey>any());

    // Act
    jpaUserSettingsDao.removeById(ModelConstants.SYSTEM_TENANT, new UserSettingsCompositeKey());

    // Assert
    verify(userSettingsRepository).deleteById(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserSettingsDao.removeByUserId(TenantId, UserId)"})
  public void testRemoveByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userSettingsRepository).deleteByUserId(Mockito.<UUID>any());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserSettingsDao.removeByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId).getId();
    verify(userSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserSettingsRepository#deleteByUserId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserSettingsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserSettingsDao.removeByUserId(TenantId, UserId)"})
  public void testRemoveByUserId_whenUserIdWithIdIsNull_uuid_thenCallsDeleteByUserId() {
    // Arrange
    doNothing().when(userSettingsRepository).deleteByUserId(Mockito.<UUID>any());

    // Act
    jpaUserSettingsDao.removeByUserId(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType, String[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaUserSettingsDao.findByTypeAndPath(TenantId, UserSettingsType, String[])"
  })
  public void testFindByTypeAndPath_thenReturnEmpty() {
    // Arrange
    when(userSettingsRepository.findByTypeAndPathExisting(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<UserSettings> actualFindByTypeAndPathResult =
        jpaUserSettingsDao.findByTypeAndPath(
            ModelConstants.SYSTEM_TENANT, UserSettingsType.GENERAL, "Path");

    // Assert
    verify(userSettingsRepository).findByTypeAndPathExisting(eq("GENERAL"), isA(String[].class));
    assertTrue(actualFindByTypeAndPathResult.isEmpty());
  }
}
