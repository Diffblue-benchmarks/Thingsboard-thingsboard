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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
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
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserAuthSettings;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserAuthSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserAuthSettingsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaUserAuthSettingsDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaUserAuthSettingsDao jpaUserAuthSettingsDao;

  @MockBean private TransactionTemplate transactionTemplate;

  @MockBean private UserAuthSettingsRepository userAuthSettingsRepository;

  /**
   * Test {@link JpaUserAuthSettingsDao#findByUserId(UserId)}.
   *
   * <ul>
   *   <li>Then return UserId EntityType is {@code USER}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserAuthSettingsDao#findByUserId(UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings JpaUserAuthSettingsDao.findByUserId(UserId)"})
  public void testFindByUserId_thenReturnUserIdEntityTypeIsUser() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(NullNode.getInstance());
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsRepository repository = mock(UserAuthSettingsRepository.class);
    when(repository.findByUserId(Mockito.<UUID>any())).thenReturn(userAuthSettingsEntity);
    JpaUserAuthSettingsDao jpaUserAuthSettingsDao = new JpaUserAuthSettingsDao(repository);

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    UserAuthSettings actualFindByUserIdResult = jpaUserAuthSettingsDao.findByUserId(userId);

    // Assert
    verify(userId).getId();
    verify(repository).findByUserId(isA(UUID.class));
    UUID uuidId = actualFindByUserIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertNull(actualFindByUserIdResult.getTwoFaSettings());
    assertEquals(1L, actualFindByUserIdResult.getCreatedTime());
    UserId userId2 = actualFindByUserIdResult.getUserId();
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertTrue(userId2.isNullUid());
    assertSame(uuidId, actualFindByUserIdResult.getId().getId());
    assertSame(uuidId, userId2.getId());
  }

  /**
   * Test {@link JpaUserAuthSettingsDao#findByUserId(UserId)}.
   *
   * <ul>
   *   <li>Then return UserId is {@link UserId#UserId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserAuthSettingsDao#findByUserId(UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings JpaUserAuthSettingsDao.findByUserId(UserId)"})
  public void testFindByUserId_thenReturnUserIdIsUserIdWithIdIsNull_uuid() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(NullNode.getInstance());
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userAuthSettingsRepository.findByUserId(Mockito.<UUID>any()))
        .thenReturn(userAuthSettingsEntity);
    UserId userId = new UserId(ModelConstants.NULL_UUID);

    // Act
    UserAuthSettings actualFindByUserIdResult = jpaUserAuthSettingsDao.findByUserId(userId);

    // Assert
    verify(userAuthSettingsRepository).findByUserId(isA(UUID.class));
    UUID uuidId = actualFindByUserIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertNull(actualFindByUserIdResult.getTwoFaSettings());
    assertEquals(1L, actualFindByUserIdResult.getCreatedTime());
    assertEquals(userId, actualFindByUserIdResult.getUserId());
    assertSame(uuidId, actualFindByUserIdResult.getId().getId());
  }

  /**
   * Test {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserAuthSettingsDao.removeByUserId(UserId)"})
  public void testRemoveByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userAuthSettingsRepository).deleteByUserId(Mockito.<UUID>any());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserAuthSettingsDao.removeByUserId(userId);

    // Assert
    verify(userId).getId();
    verify(userAuthSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserAuthSettingsRepository#deleteByUserId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaUserAuthSettingsDao#removeByUserId(UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaUserAuthSettingsDao.removeByUserId(UserId)"})
  public void testRemoveByUserId_whenUserIdWithIdIsNull_uuid_thenCallsDeleteByUserId() {
    // Arrange
    doNothing().when(userAuthSettingsRepository).deleteByUserId(Mockito.<UUID>any());

    // Act
    jpaUserAuthSettingsDao.removeByUserId(new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userAuthSettingsRepository).deleteByUserId(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaUserAuthSettingsDao#getEntityClass()}
   *   <li>{@link JpaUserAuthSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaUserAuthSettingsDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaUserAuthSettingsDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaUserAuthSettingsDao jpaUserAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));

    // Act
    Class<UserAuthSettingsEntity> actualEntityClass = jpaUserAuthSettingsDao.getEntityClass();
    jpaUserAuthSettingsDao.getRepository();

    // Assert
    Class<UserAuthSettingsEntity> expectedEntityClass = UserAuthSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
