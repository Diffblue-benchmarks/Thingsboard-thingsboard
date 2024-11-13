package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.function.BiFunction;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.UserAuthSettingsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserAuthSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserAuthSettingsEntityDiffblueTest {
  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and
   * {@link UserAuthSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and
   * {@link UserAuthSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(null);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(null);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and
   * {@link UserAuthSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(null);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and
   * {@link UserAuthSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(3L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(MissingNode.getInstance());
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(null);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(mock(JsonNode.class));
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.randomUUID());
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, null);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, "Different type to UserAuthSettingsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#UserAuthSettingsEntity()}
   *   <li>{@link UserAuthSettingsEntity#setTwoFaSettings(JsonNode)}
   *   <li>{@link UserAuthSettingsEntity#setUserId(UUID)}
   *   <li>{@link UserAuthSettingsEntity#toString()}
   *   <li>{@link UserAuthSettingsEntity#getTwoFaSettings()}
   *   <li>{@link UserAuthSettingsEntity#getUserId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity();
    JsonNode twoFaSettings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserAuthSettingsEntity.setTwoFaSettings(twoFaSettings);
    UUID userId = ModelConstants.NULL_UUID;
    actualUserAuthSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserAuthSettingsEntity.toString();
    JsonNode actualTwoFaSettings = actualUserAuthSettingsEntity.getTwoFaSettings();
    UUID actualUserId = actualUserAuthSettingsEntity.getUserId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals(
        "UserAuthSettingsEntity(userId=13814000-1dd2-11b2-8080-808080808080, twoFaSettings={\"isPublic\":true})",
        actualToStringResult);
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertSame(twoFaSettings, actualTwoFaSettings);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    UUID id = actualUserAuthSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} replaceAll
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity_givenLinkedHashMapReplaceAllBiFunction() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.replaceAll(mock(BiFunction.class));

    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(configs);

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    UUID id = actualUserAuthSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return CreatedTime is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity_givenMinusOne_thenReturnCreatedTimeIsZero() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.replaceAll(mock(BiFunction.class));

    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(configs);

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(-1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    UUID id = actualUserAuthSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <ul>
   *   <li>Given {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return UserId is Id.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity_givenUserIdWithIdIsNull_uuid_thenReturnUserIdIsId() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    UUID id = actualUserAuthSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
    assertSame(id, actualUserAuthSettingsEntity.getUserId());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <ul>
   *   <li>Then return TwoFaSettings is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity_thenReturnTwoFaSettingsIsNull() {
    // Arrange
    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(null);
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    assertNull(actualUserAuthSettingsEntity.getTwoFaSettings());
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertNull(actualUserAuthSettingsEntity.getUserId());
    assertEquals(1L, actualUserAuthSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <ul>
   *   <li>Then return TwoFaSettings is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity_thenReturnTwoFaSettingsIsNull2() {
    // Arrange
    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    UUID id = actualUserAuthSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualUserAuthSettingsEntity.getTwoFaSettings());
    assertNull(actualUserAuthSettingsEntity.getUserId());
    assertEquals(1L, actualUserAuthSettingsEntity.getCreatedTime());
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   * <ul>
   *   <li>When {@link UserAuthSettings} (default constructor) Id is
   * {@code null}.</li>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  public void testNewUserAuthSettingsEntity_whenUserAuthSettingsIdIsNull_thenReturnIdIsNull() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(null);
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   * <ul>
   *   <li>Given {@link UserAuthSettingsEntity#UserAuthSettingsEntity()}
   * TwoFaSettings is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  public void testToData_givenUserAuthSettingsEntityTwoFaSettingsIsInstance() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setTwoFaSettings(NullNode.getInstance());

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertNull(actualToDataResult.getUserId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(uuidId, actualToDataResult.getId().getId());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   * <ul>
   *   <li>Given {@link UserAuthSettingsEntity#UserAuthSettingsEntity()}.</li>
   *   <li>Then return UuidId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  public void testToData_givenUserAuthSettingsEntity_thenReturnUuidIdIsNull() {
    // Arrange and Act
    UserAuthSettings actualToDataResult = (new UserAuthSettingsEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   * <ul>
   *   <li>Then return UserId EntityType is {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUserIdEntityTypeIsUser() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(null);

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    UserId userId = actualToDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertTrue(userId.isNullUid());
    assertSame(uuidId, actualToDataResult.getId().getId());
    assertSame(uuidId, userId.getId());
  }
}
