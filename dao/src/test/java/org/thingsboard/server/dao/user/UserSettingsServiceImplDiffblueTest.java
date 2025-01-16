package org.thingsboard.server.dao.user;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
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
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {UserSettingsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class UserSettingsServiceImplDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private TbTransactionalCache<UserSettingsCompositeKey, UserSettings> tbTransactionalCache;

  @MockBean
  private UserSettingsDao userSettingsDao;

  @Autowired
  private UserSettingsServiceImpl userSettingsServiceImpl;

  /**
   * Test
   * {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  public void testSaveUserSettings_givenArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    when(userSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new RuntimeException("Executing saveUserSettings for user [{}], [{}]"));
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(userSettings.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> userSettingsServiceImpl.saveUserSettings(ModelConstants.SYSTEM_TENANT, userSettings));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings).getSettings();
    verify(userSettings).getType();
    verify(userSettings, atLeast(1)).getUserId();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).save(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}.
   * <ul>
   *   <li>Then return {@link UserSettings} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  public void testSaveUserSettings_thenReturnUserSettings() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserSettings>any())).thenReturn(userSettings);
    UserSettings userSettings2 = mock(UserSettings.class);
    when(userSettings2.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(userSettings2.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings2.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));
    doNothing().when(userSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings2).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings2).setType(Mockito.<UserSettingsType>any());
    userSettings2.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings2.setType(UserSettingsType.GENERAL);
    userSettings2.setUserId(null);

    // Act
    UserSettings actualSaveUserSettingsResult = userSettingsServiceImpl.saveUserSettings(ModelConstants.SYSTEM_TENANT,
        userSettings2);

    // Assert
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings2).getSettings();
    verify(userSettings2).getType();
    verify(userSettings2, atLeast(1)).getUserId();
    verify(userSettings2).setSettingsBytes(isA(byte[].class));
    verify(userSettings2).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings2).setUserId(isNull());
    verify(userSettingsDao).save(isA(TenantId.class), isA(UserSettings.class));
    assertSame(userSettings, actualSaveUserSettingsResult);
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  public void testSaveUserSettings_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    when(userSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new RuntimeException("Executing saveUserSettings for user [{}], [{}]"));
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(userSettings.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> userSettingsServiceImpl.saveUserSettings(ModelConstants.SYSTEM_TENANT, userSettings));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings).getSettings();
    verify(userSettings).getType();
    verify(userSettings, atLeast(1)).getUserId();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).save(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)}
   */
  @Test
  public void testUpdateUserSettings_thenThrowDataValidationException() {
    // Arrange
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userSettingsServiceImpl.updateUserSettings(ModelConstants.SYSTEM_TENANT,
            new UserId(ModelConstants.NULL_UUID), UserSettingsType.GENERAL,
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId, UserSettingsType)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#findUserSettings(TenantId, UserId, UserSettingsType)}
   */
  @Test
  public void testFindUserSettings_whenUserIdWithIdIsNull_uuid_thenCallsGetAndPutInTransaction()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<UserSettingsCompositeKey>any(),
        Mockito.<Supplier<UserSettings>>any(), anyBoolean())).thenReturn(userSettings);

    // Act
    userSettingsServiceImpl.findUserSettings(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID),
        UserSettingsType.GENERAL);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(UserSettingsCompositeKey.class), isA(Supplier.class),
        eq(true));
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  public void testDeleteUserSettings() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenReturn(userSettings);
    UserId userId = new UserId(ModelConstants.NULL_UUID);

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("Executing deleteUserSettings for user [{}]");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> userSettingsServiceImpl.deleteUserSettings(ModelConstants.SYSTEM_TENANT,
        userId, UserSettingsType.GENERAL, jsonPaths));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  public void testDeleteUserSettings_givenUserSettingsGetSettingsReturnInstance() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(MissingNode.getInstance());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenReturn(userSettings);
    UserId userId = new UserId(ModelConstants.NULL_UUID);

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("Executing deleteUserSettings for user [{}]");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> userSettingsServiceImpl.deleteUserSettings(ModelConstants.SYSTEM_TENANT,
        userId, UserSettingsType.GENERAL, jsonPaths));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  public void testDeleteUserSettings_givenUserSettingsGetSettingsReturnInstance2() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(NullNode.getInstance());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenReturn(userSettings);
    UserId userId = new UserId(ModelConstants.NULL_UUID);

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("Executing deleteUserSettings for user [{}]");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> userSettingsServiceImpl.deleteUserSettings(ModelConstants.SYSTEM_TENANT,
        userId, UserSettingsType.GENERAL, jsonPaths));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * {@link JsonNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  public void testDeleteUserSettings_givenUserSettingsGetSettingsReturnJsonNode() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(mock(JsonNode.class));
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UserSettingsCompositeKey>any()))
        .thenReturn(userSettings);
    UserId userId = new UserId(ModelConstants.NULL_UUID);

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("Executing deleteUserSettings for user [{}]");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> userSettingsServiceImpl.deleteUserSettings(ModelConstants.SYSTEM_TENANT,
        userId, UserSettingsType.GENERAL, jsonPaths));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findById(isA(TenantId.class), isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)}
   * with {@code UserSettingsEvictEvent}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithUserSettingsEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    // Act
    userSettingsServiceImpl.handleEvictEvent(new UserSettingsEvictEvent(new UserSettingsCompositeKey()));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)}
   * with {@code UserSettingsEvictEvent}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsServiceImpl#handleEvictEvent(UserSettingsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithUserSettingsEvictEvent_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(tbTransactionalCache).evict(Mockito.<UserSettingsCompositeKey>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> userSettingsServiceImpl.handleEvictEvent(new UserSettingsEvictEvent(new UserSettingsCompositeKey())));
    verify(tbTransactionalCache).evict(isA(UserSettingsCompositeKey.class));
  }

  /**
   * Test {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link JsonNode#fieldNames()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  public void testUpdate_givenArrayListIterator_thenCallsFieldNames() {
    // Arrange
    MissingNode mainNode = MissingNode.getInstance();
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
   * <ul>
   *   <li>Then return
   * {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  public void testUpdate_thenReturnPublic_customer_additional_info_json() {
    // Arrange
    JsonNode updateNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act and Assert
    assertSame(updateNode,
        userSettingsServiceImpl.update(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON, updateNode));
  }

  /**
   * Test {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsServiceImpl#update(JsonNode, JsonNode)}
   */
  @Test
  public void testUpdate_whenInstance_thenReturnInstance() {
    // Arrange
    MissingNode mainNode = MissingNode.getInstance();
    MissingNode updateNode = MissingNode.getInstance();

    // Act and Assert
    assertSame(updateNode, userSettingsServiceImpl.update(mainNode, updateNode));
  }
}
