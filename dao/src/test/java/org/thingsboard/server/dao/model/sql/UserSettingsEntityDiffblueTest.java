package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserSettingsEntityDiffblueTest {
  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and
   * {@link UserSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and
   * {@link UserSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(null);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(null);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and
   * {@link UserSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType(null);
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType(null);
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and
   * {@link UserSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(null);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(null);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and
   * {@link UserSettingsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(MissingNode.getInstance());
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(null);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(mock(JsonNode.class));
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType(null);
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("org.thingsboard.server.dao.model.sql.UserSettingsEntity");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.randomUUID());

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(null);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, null);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, "Different type to UserSettingsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEntity#UserSettingsEntity()}
   *   <li>{@link UserSettingsEntity#setSettings(JsonNode)}
   *   <li>{@link UserSettingsEntity#setType(String)}
   *   <li>{@link UserSettingsEntity#setUserId(UUID)}
   *   <li>{@link UserSettingsEntity#toString()}
   *   <li>{@link UserSettingsEntity#getSettings()}
   *   <li>{@link UserSettingsEntity#getType()}
   *   <li>{@link UserSettingsEntity#getUserId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity();
    JsonNode settings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserSettingsEntity.setSettings(settings);
    actualUserSettingsEntity.setType("Type");
    UUID userId = ModelConstants.NULL_UUID;
    actualUserSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserSettingsEntity.toString();
    JsonNode actualSettings = actualUserSettingsEntity.getSettings();
    String actualType = actualUserSettingsEntity.getType();
    UUID actualUserId = actualUserSettingsEntity.getUserId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("Type", actualType);
    assertEquals(
        "UserSettingsEntity(userId=13814000-1dd2-11b2-8080-808080808080, type=Type, settings={\"isPublic" + "\":true})",
        actualToStringResult);
    assertSame(settings, actualSettings);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   * <p>
   * Method under test:
   * {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  public void testNewUserSettingsEntity() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity(userSettings);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserSettingsEntity.getUserId().toString());
    assertEquals("GENERAL", actualUserSettingsEntity.getType());
    assertNull(actualUserSettingsEntity.getSettings());
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   *   <li>Then Settings return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  public void testNewUserSettingsEntity_givenEmptyArrayOfByte_thenSettingsReturnMissingNode() throws IOException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[]{});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    JsonNode settings = (new UserSettingsEntity(userSettings)).getSettings();
    assertTrue(settings instanceof MissingNode);
    JsonParser traverseResult = settings.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", settings.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, settings.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, settings.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(settings.isArray());
    assertFalse(settings.isBigDecimal());
    assertFalse(settings.isBigInteger());
    assertFalse(settings.isBinary());
    assertFalse(settings.isBoolean());
    assertFalse(settings.isContainerNode());
    assertFalse(settings.isDouble());
    assertFalse(settings.isFloat());
    assertFalse(settings.isFloatingPointNumber());
    assertFalse(settings.isInt());
    assertFalse(settings.isIntegralNumber());
    assertFalse(settings.isLong());
    assertFalse(settings.isNull());
    assertFalse(settings.isNumber());
    assertFalse(settings.isObject());
    assertFalse(settings.isPojo());
    assertFalse(settings.isShort());
    assertFalse(settings.isTextual());
    assertFalse(settings.isValueNode());
    assertFalse(settings.iterator().hasNext());
    assertTrue(settings.isEmpty());
    assertTrue(settings.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   * <ul>
   *   <li>When {@link UserSettings} (default constructor) SettingsBytes is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  public void testNewUserSettingsEntity_whenUserSettingsSettingsBytesIsNull() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(null);
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity(userSettings);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserSettingsEntity.getUserId().toString());
    assertEquals("GENERAL", actualUserSettingsEntity.getType());
    assertNull(actualUserSettingsEntity.getSettings());
  }

  /**
   * Test {@link UserSettingsEntity#toData()}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * {@code null}.</li>
   *   <li>Then return SettingsBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#toData()}
   */
  @Test
  public void testToData_givenUserSettingsGetSettingsReturnNull_thenReturnSettingsBytesIsNull() {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(null);
    when(userSettings.getType()).thenReturn(UserSettingsType.GENERAL);
    UserId userId = new UserId(ModelConstants.NULL_UUID);
    when(userSettings.getUserId()).thenReturn(userId);

    // Act
    UserSettings actualToDataResult = (new UserSettingsEntity(userSettings)).toData();

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).getType();
    verify(userSettings).getUserId();
    assertNull(actualToDataResult.getSettingsBytes());
    assertNull(actualToDataResult.getSettings());
    assertEquals(UserSettingsType.GENERAL, actualToDataResult.getType());
    assertEquals(userId, actualToDataResult.getUserId());
  }

  /**
   * Test {@link UserSettingsEntity#toData()}.
   * <ul>
   *   <li>Then Settings iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEntity#toData()}
   */
  @Test
  public void testToData_thenSettingsIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(userSettings.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserSettings actualToDataResult = (new UserSettingsEntity(userSettings)).toData();

    // Assert
    verify(userSettings, atLeast(1)).getSettings();
    verify(userSettings).getType();
    verify(userSettings).getUserId();
    JsonNode settings = actualToDataResult.getSettings();
    Iterator<JsonNode> iteratorResult = settings.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(settings instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = settings.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", settings.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, settings.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, settings.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(settings.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(settings.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(settings.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(settings.isBinary());
    assertFalse(settings.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(settings.isDouble());
    assertFalse(settings.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(settings.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(settings.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(settings.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(settings.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(settings.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(settings.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(settings.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(settings.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(settings.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(settings.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(settings.isTextual());
    assertFalse(settings.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(settings.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(settings.isObject());
    assertTrue(nextResult.isValueNode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    byte[] expectedSettingsBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedSettingsBytes, actualToDataResult.getSettingsBytes());
  }
}
