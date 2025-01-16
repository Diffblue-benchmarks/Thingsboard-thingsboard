package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmCommentInfoEntityDiffblueTest {
  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and
   * {@link AlarmCommentInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
    int expectedHashCodeResult = alarmCommentInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and
   * {@link AlarmCommentInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity(new AlarmCommentEntity(), "Jane", "Doe",
        "jane.doe@example.org");
    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity(new AlarmCommentEntity(), "Jane", "Doe",
        "jane.doe@example.org");

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
    int expectedHashCodeResult = alarmCommentInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and
   * {@link AlarmCommentInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity);
    int expectedHashCodeResult = alarmCommentInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfoEntity.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity(new AlarmCommentEntity(), "Jane", "Doe",
        "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity,
        new AlarmCommentInfoEntity(new AlarmCommentEntity(), "Jane", "Doe", "jane.doe@example.org"));
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(mock(JsonNode.class));
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, alarmCommentEntity);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setAlarmId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfoEntity(), null);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfoEntity(), "Different type to AlarmCommentInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#AlarmCommentInfoEntity()}
   *   <li>{@link AlarmCommentInfoEntity#setEmail(String)}
   *   <li>{@link AlarmCommentInfoEntity#setFirstName(String)}
   *   <li>{@link AlarmCommentInfoEntity#setLastName(String)}
   *   <li>{@link AlarmCommentInfoEntity#toString()}
   *   <li>{@link AlarmCommentInfoEntity#getEmail()}
   *   <li>{@link AlarmCommentInfoEntity#getFirstName()}
   *   <li>{@link AlarmCommentInfoEntity#getLastName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity();
    actualAlarmCommentInfoEntity.setEmail("jane.doe@example.org");
    actualAlarmCommentInfoEntity.setFirstName("Jane");
    actualAlarmCommentInfoEntity.setLastName("Doe");
    String actualToStringResult = actualAlarmCommentInfoEntity.toString();
    String actualEmail = actualAlarmCommentInfoEntity.getEmail();
    String actualFirstName = actualAlarmCommentInfoEntity.getFirstName();

    // Assert that nothing has changed
    assertEquals("AlarmCommentInfoEntity(firstName=Jane, lastName=Doe, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return toData CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}
   */
  @Test
  public void testNewAlarmCommentInfoEntity_givenOne_thenReturnToDataCreatedTimeIsOne() throws IOException {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity);

    // Assert
    JsonNode comment = actualAlarmCommentInfoEntity.getComment();
    Iterator<JsonNode> iteratorResult = comment.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(comment instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = comment.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID alarmId = actualAlarmCommentInfoEntity.getAlarmId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarmId.toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    AlarmCommentInfo toDataResult = actualAlarmCommentInfoEntity.toData();
    assertEquals("{\"isPublic\":true}", toDataResult.getName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", comment.toPrettyString());
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
    assertNull(toDataResult.getEmail());
    assertNull(toDataResult.getFirstName());
    assertNull(toDataResult.getLastName());
    assertNull(actualAlarmCommentInfoEntity.getEmail());
    assertNull(actualAlarmCommentInfoEntity.getFirstName());
    assertNull(actualAlarmCommentInfoEntity.getLastName());
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
    assertEquals(1, comment.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, toDataResult.getCreatedTime());
    assertEquals(1L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, comment.getNodeType());
    AlarmId alarmId2 = toDataResult.getAlarmId();
    assertEquals(EntityType.ALARM, alarmId2.getEntityType());
    UserId userId = toDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(AlarmCommentType.SYSTEM, toDataResult.getType());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
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
    assertFalse(comment.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(comment.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(comment.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(comment.isBinary());
    assertFalse(comment.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(comment.isDouble());
    assertFalse(comment.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(comment.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(comment.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(comment.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(comment.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(comment.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(comment.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(comment.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(comment.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(comment.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(comment.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(comment.isTextual());
    assertFalse(comment.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(comment.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(comment.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(alarmId2.isNullUid());
    assertTrue(userId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(alarmId, toDataResult.getUuidId());
    assertSame(alarmId, alarmId2.getId());
    assertSame(alarmId, toDataResult.getId().getId());
    assertSame(alarmId, userId.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUserId());
    assertSame(comment, toDataResult.getComment());
  }

  /**
   * Test
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity, String, String, String)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return toData CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity, String, String, String)}
   */
  @Test
  public void testNewAlarmCommentInfoEntity_givenOne_thenReturnToDataCreatedTimeIsOne2() throws IOException {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity, "Jane", "Doe",
        "jane.doe@example.org");

    // Assert
    JsonNode comment = actualAlarmCommentInfoEntity.getComment();
    Iterator<JsonNode> iteratorResult = comment.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(comment instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = comment.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID alarmId = actualAlarmCommentInfoEntity.getAlarmId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarmId.toString());
    AlarmCommentInfo toDataResult = actualAlarmCommentInfoEntity.toData();
    assertEquals("Doe", toDataResult.getLastName());
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", toDataResult.getFirstName());
    assertEquals("Jane", actualAlarmCommentInfoEntity.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", toDataResult.getEmail());
    assertEquals("jane.doe@example.org", actualAlarmCommentInfoEntity.getEmail());
    assertEquals("{\"isPublic\":true}", toDataResult.getName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", comment.toPrettyString());
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
    assertEquals(1, comment.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, toDataResult.getCreatedTime());
    assertEquals(1L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, comment.getNodeType());
    AlarmId alarmId2 = toDataResult.getAlarmId();
    assertEquals(EntityType.ALARM, alarmId2.getEntityType());
    UserId userId = toDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(AlarmCommentType.SYSTEM, toDataResult.getType());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
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
    assertFalse(comment.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(comment.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(comment.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(comment.isBinary());
    assertFalse(comment.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(comment.isDouble());
    assertFalse(comment.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(comment.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(comment.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(comment.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(comment.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(comment.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(comment.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(comment.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(comment.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(comment.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(comment.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(comment.isTextual());
    assertFalse(comment.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(comment.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(comment.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(alarmId2.isNullUid());
    assertTrue(userId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(alarmId, toDataResult.getUuidId());
    assertSame(alarmId, alarmId2.getId());
    assertSame(alarmId, toDataResult.getId().getId());
    assertSame(alarmId, userId.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUserId());
    assertSame(comment, toDataResult.getComment());
  }

  /**
   * Test
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then return toData CreatedTime is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}
   */
  @Test
  public void testNewAlarmCommentInfoEntity_givenZero_thenReturnToDataCreatedTimeIsZero() throws IOException {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(0L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity);

    // Assert
    JsonNode comment = actualAlarmCommentInfoEntity.getComment();
    Iterator<JsonNode> iteratorResult = comment.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(comment instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = comment.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID alarmId = actualAlarmCommentInfoEntity.getAlarmId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarmId.toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    AlarmCommentInfo toDataResult = actualAlarmCommentInfoEntity.toData();
    assertEquals("{\"isPublic\":true}", toDataResult.getName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", comment.toPrettyString());
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
    assertNull(toDataResult.getEmail());
    assertNull(toDataResult.getFirstName());
    assertNull(toDataResult.getLastName());
    assertNull(actualAlarmCommentInfoEntity.getEmail());
    assertNull(actualAlarmCommentInfoEntity.getFirstName());
    assertNull(actualAlarmCommentInfoEntity.getLastName());
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
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(1, comment.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, comment.getNodeType());
    AlarmId alarmId2 = toDataResult.getAlarmId();
    assertEquals(EntityType.ALARM, alarmId2.getEntityType());
    UserId userId = toDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(AlarmCommentType.SYSTEM, toDataResult.getType());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
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
    assertFalse(comment.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(comment.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(comment.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(comment.isBinary());
    assertFalse(comment.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(comment.isDouble());
    assertFalse(comment.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(comment.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(comment.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(comment.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(comment.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(comment.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(comment.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(comment.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(comment.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(comment.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(comment.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(comment.isTextual());
    assertFalse(comment.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(comment.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(comment.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(alarmId2.isNullUid());
    assertTrue(userId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(alarmId, toDataResult.getUuidId());
    assertSame(alarmId, alarmId2.getId());
    assertSame(alarmId, toDataResult.getId().getId());
    assertSame(alarmId, userId.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUserId());
    assertSame(comment, toDataResult.getComment());
  }

  /**
   * Test
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity, String, String, String)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then return toData CreatedTime is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity, String, String, String)}
   */
  @Test
  public void testNewAlarmCommentInfoEntity_givenZero_thenReturnToDataCreatedTimeIsZero2() throws IOException {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(0L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity, "Jane", "Doe",
        "jane.doe@example.org");

    // Assert
    JsonNode comment = actualAlarmCommentInfoEntity.getComment();
    Iterator<JsonNode> iteratorResult = comment.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(comment instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = comment.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID alarmId = actualAlarmCommentInfoEntity.getAlarmId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarmId.toString());
    AlarmCommentInfo toDataResult = actualAlarmCommentInfoEntity.toData();
    assertEquals("Doe", toDataResult.getLastName());
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", toDataResult.getFirstName());
    assertEquals("Jane", actualAlarmCommentInfoEntity.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", toDataResult.getEmail());
    assertEquals("jane.doe@example.org", actualAlarmCommentInfoEntity.getEmail());
    assertEquals("{\"isPublic\":true}", toDataResult.getName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", comment.toPrettyString());
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
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(1, comment.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, comment.getNodeType());
    AlarmId alarmId2 = toDataResult.getAlarmId();
    assertEquals(EntityType.ALARM, alarmId2.getEntityType());
    UserId userId = toDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(AlarmCommentType.SYSTEM, toDataResult.getType());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
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
    assertFalse(comment.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(comment.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(comment.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(comment.isBinary());
    assertFalse(comment.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(comment.isDouble());
    assertFalse(comment.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(comment.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(comment.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(comment.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(comment.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(comment.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(comment.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(comment.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(comment.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(comment.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(comment.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(comment.isTextual());
    assertFalse(comment.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(comment.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(comment.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(alarmId2.isNullUid());
    assertTrue(userId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(alarmId, toDataResult.getUuidId());
    assertSame(alarmId, alarmId2.getId());
    assertSame(alarmId, toDataResult.getId().getId());
    assertSame(alarmId, userId.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getId());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getUserId());
    assertSame(comment, toDataResult.getComment());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity()}.</li>
   *   <li>Then return UserId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmCommentInfoEntity_thenReturnUserIdIsNull() {
    // Arrange and Act
    AlarmCommentInfo actualToDataResult = (new AlarmCommentInfoEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getComment());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getFirstName());
    assertNull(actualToDataResult.getLastName());
    assertNull(actualToDataResult.getUuidId());
    AlarmId alarmId = actualToDataResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#toData()}.
   * <ul>
   *   <li>Then return UserId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUserIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setUserId(ModelConstants.NULL_UUID);

    // Act
    AlarmCommentInfo actualToDataResult = alarmCommentInfoEntity.toData();

    // Assert
    UserId userId = actualToDataResult.getUserId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", userId.getId().toString());
    assertNull(actualToDataResult.getComment());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getFirstName());
    assertNull(actualToDataResult.getLastName());
    assertNull(actualToDataResult.getUuidId());
    AlarmId alarmId = actualToDataResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertEquals(EntityType.USER, userId.getEntityType());
    assertFalse(alarmId.isNullUid());
    assertTrue(userId.isNullUid());
  }
}
