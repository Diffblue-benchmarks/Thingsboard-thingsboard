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
package org.thingsboard.server.dao.user;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;

@ContextConfiguration(classes = {UserSettingsServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class UserSettingsServiceImplDiffblueTest {
  @MockBean
  private TbTransactionalCache<UserSettingsCompositeKey, UserSettings> tbTransactionalCache;

  @MockBean private UserSettingsDao userSettingsDao;

  @Autowired private UserSettingsServiceImpl userSettingsServiceImpl;

  /**
   * Test {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Serializable)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings UserSettingsServiceImpl.saveUserSettings(TenantId, UserSettings)"
  })
  public void testSaveUserSettings_givenTbTransactionalCacheEvictThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<UserSettingsCompositeKey>any());

    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> userSettingsServiceImpl.saveUserSettings(ModelConstants.SYSTEM_TENANT, userSettings));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}.
   *
   * <ul>
   *   <li>Given {@link UserId} {@link UserId#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings UserSettingsServiceImpl.saveUserSettings(TenantId, UserSettings)"
  })
  public void testSaveUserSettings_givenUserIdGetIdThrowRuntimeException_thenCallsGetId() {
    // Arrange
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new RuntimeException());

    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(userId);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> userSettingsServiceImpl.saveUserSettings(ModelConstants.SYSTEM_TENANT, userSettings));
    verify(userId).getId();
  }

  /**
   * Test {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}.
   *
   * <ul>
   *   <li>Given {@link UserSettingsDao} {@link UserSettingsDao#save(TenantId, UserSettings)} throw
   *       {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link UserSettingsDao#save(TenantId, UserSettings)}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings UserSettingsServiceImpl.saveUserSettings(TenantId, UserSettings)"
  })
  public void testSaveUserSettings_givenUserSettingsDaoSaveThrowRuntimeException_thenCallsSave() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    when(userSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new RuntimeException());

    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> userSettingsServiceImpl.saveUserSettings(ModelConstants.SYSTEM_TENANT, userSettings));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettingsDao).save(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId, UserSettingsType,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link UserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId,
   * UserSettingsType, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsServiceImpl.updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)"
  })
  public void testUpdateUserSettings_thenCallsFindById() {
    // Arrange
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.updateUserSettings(
                ModelConstants.SYSTEM_TENANT,
                new UserId(ModelConstants.NULL_UUID),
                UserSettingsType.GENERAL,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId, UserSettingsType,
   * JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId,
   * UserSettingsType, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsServiceImpl.updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)"
  })
  public void testUpdateUserSettings_thenCallsGetId() {
    // Arrange
    UserSettingsServiceImpl userSettingsServiceImpl =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.updateUserSettings(
                ModelConstants.SYSTEM_TENANT,
                userId,
                UserSettingsType.GENERAL,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(userId).getId();
  }

  /**
   * Test {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId, UserSettingsType)}.
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId,
   * UserSettingsType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings UserSettingsServiceImpl.findUserSettings(TenantId, UserId, UserSettingsType)"
  })
  public void testFindUserSettings() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<UserSettingsCompositeKey>any(),
            Mockito.<Supplier<UserSettings>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.findUserSettings(
                ModelConstants.SYSTEM_TENANT,
                new UserId(ModelConstants.NULL_UUID),
                UserSettingsType.GENERAL));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(UserSettingsCompositeKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId, UserSettingsType)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId,
   * UserSettingsType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings UserSettingsServiceImpl.findUserSettings(TenantId, UserId, UserSettingsType)"
  })
  public void testFindUserSettings_givenRuntimeException_thenCallsGetId() {
    // Arrange
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.findUserSettings(
                ModelConstants.SYSTEM_TENANT, userId, UserSettingsType.GENERAL));
    verify(userId).getId();
  }

  /**
   * Test {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId, UserSettingsType)}.
   *
   * <ul>
   *   <li>Then return {@link UserSettings} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId,
   * UserSettingsType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserSettings UserSettingsServiceImpl.findUserSettings(TenantId, UserId, UserSettingsType)"
  })
  public void testFindUserSettings_thenReturnUserSettings() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<UserSettingsCompositeKey>any(),
            Mockito.<Supplier<UserSettings>>any(),
            anyBoolean()))
        .thenReturn(userSettings);

    // Act
    UserSettings actualFindUserSettingsResult =
        userSettingsServiceImpl.findUserSettings(
            ModelConstants.SYSTEM_TENANT,
            new UserId(ModelConstants.NULL_UUID),
            UserSettingsType.GENERAL);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(UserSettingsCompositeKey.class), isA(Supplier.class), eq(true));
    assertSame(userSettings, actualFindUserSettingsResult);
  }

  /**
   * Test {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId,
   * UserSettingsType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsServiceImpl.deleteUserSettings(TenantId, UserId, UserSettingsType, List)"
  })
  public void testDeleteUserSettings_givenRuntimeException_thenCallsGetId() {
    // Arrange
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new RuntimeException());

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("Executing deleteUserSettings for user [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.deleteUserSettings(
                ModelConstants.SYSTEM_TENANT, userId, UserSettingsType.GENERAL, jsonPaths));
    verify(userId).getId();
  }

  /**
   * Test {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType,
   * List)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserSettingsDao#findById(TenantId, UserSettingsCompositeKey)}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId,
   * UserSettingsType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsServiceImpl.deleteUserSettings(TenantId, UserId, UserSettingsType, List)"
  })
  public void testDeleteUserSettings_whenUserIdWithIdIsNull_uuid_thenCallsFindById() {
    // Arrange
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenThrow(new RuntimeException());
    UserId userId = new UserId(ModelConstants.NULL_UUID);

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("Executing deleteUserSettings for user [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.deleteUserSettings(
                ModelConstants.SYSTEM_TENANT, userId, UserSettingsType.GENERAL, jsonPaths));
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)} with {@code
   * UserSettingsEvictEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSettingsServiceImpl.handleEvictEvent(UserSettingsEvictEvent)"})
  public void testHandleEvictEventWithUserSettingsEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    // Act
    userSettingsServiceImpl.handleEvictEvent(
        new UserSettingsEvictEvent(new UserSettingsCompositeKey()));

    // Assert
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)} with {@code
   * UserSettingsEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSettingsServiceImpl.handleEvictEvent(UserSettingsEvictEvent)"})
  public void testHandleEvictEventWithUserSettingsEvictEvent_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<UserSettingsCompositeKey>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            userSettingsServiceImpl.handleEvictEvent(
                new UserSettingsEvictEvent(new UserSettingsCompositeKey())));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>When {@link JsonNode} {@link JsonNode#fieldNames()} return {@link ArrayList#ArrayList()}
   *       iterator.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserSettingsServiceImpl.update(JsonNode, JsonNode)"})
  public void testUpdate_givenArrayListIterator_whenJsonNodeFieldNamesReturnArrayListIterator() {
    // Arrange
    DoubleNode mainNode = DoubleNode.valueOf(10.0d);

    JsonNode updateNode = mock(JsonNode.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(updateNode.fieldNames()).thenReturn(stringList.iterator());

    // Act
    JsonNode actualUpdateResult = userSettingsServiceImpl.update(mainNode, updateNode);

    // Assert
    verify(updateNode).fieldNames();
    assertSame(mainNode, actualUpdateResult);
  }

  /**
   * Test {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserSettingsServiceImpl.update(JsonNode, JsonNode)"})
  public void testUpdate_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    DoubleNode mainNode = DoubleNode.valueOf(10.0d);

    JsonNode updateNode = mock(JsonNode.class);
    when(updateNode.fieldNames()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> userSettingsServiceImpl.update(mainNode, updateNode));
    verify(updateNode).fieldNames();
  }

  /**
   * Test {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserSettingsServiceImpl.update(JsonNode, JsonNode)"})
  public void testUpdate_thenReturnPublic_customer_additional_info_json() {
    // Arrange
    JsonNode updateNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonNode actualUpdateResult =
        userSettingsServiceImpl.update(
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON, updateNode);

    // Assert
    assertSame(updateNode, actualUpdateResult);
  }

  /**
   * Test {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserSettingsServiceImpl.update(JsonNode, JsonNode)"})
  public void testUpdate_whenValueOfTen_thenReturnValueOfTen() {
    // Arrange
    DoubleNode mainNode = DoubleNode.valueOf(10.0d);

    // Act
    JsonNode actualUpdateResult =
        userSettingsServiceImpl.update(mainNode, DoubleNode.valueOf(10.0d));

    // Assert
    assertSame(mainNode, actualUpdateResult);
  }
}
