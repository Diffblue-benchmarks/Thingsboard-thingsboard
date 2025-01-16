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
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmCommentEntityDiffblueTest {
  /**
   * Test {@link AlarmCommentEntity#equals(Object)}, and
   * {@link AlarmCommentEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentEntity#equals(Object)}
   *   <li>{@link AlarmCommentEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}, and
   * {@link AlarmCommentEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentEntity#equals(Object)}
   *   <li>{@link AlarmCommentEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity.hashCode());
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.randomUUID());
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(mock(JsonNode.class));
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, null);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, "Different type to AlarmCommentEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentEntity#AlarmCommentEntity()}
   *   <li>{@link AlarmCommentEntity#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity();

    // Assert
    assertEquals("AlarmCommentEntity()", actualAlarmCommentEntity.toString());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getAlarmId());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Type is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  public void testNewAlarmCommentEntity_givenAlarmIdWithIdIsNull_uuid_thenReturnTypeIsNull() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmCommentEntity.getAlarmId().toString());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
    assertEquals(alarmComment, actualAlarmCommentEntity.toData());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmCommentInfo)}.
   * <ul>
   *   <li>Given {@code SYSTEM}.</li>
   *   <li>Then return toData Type is {@code SYSTEM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentEntity#AlarmCommentEntity(AlarmCommentInfo)}
   */
  @Test
  public void testNewAlarmCommentEntity_givenSystem_thenReturnToDataTypeIsSystem() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setType(AlarmCommentType.SYSTEM);
    AlarmId alarmId = new AlarmId(ModelConstants.NULL_UUID);
    alarmCommentInfo.setAlarmId(alarmId);

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmCommentInfo);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmCommentEntity.getAlarmId().toString());
    AlarmComment toDataResult = actualAlarmCommentEntity.toData();
    assertNull(toDataResult.getComment());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(toDataResult.getUuidId());
    assertNull(toDataResult.getId().getId());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(toDataResult.getUserId());
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, toDataResult.getType());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentEntity.getType());
    assertEquals(alarmId, toDataResult.getAlarmId());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   * <ul>
   *   <li>Given {@code SYSTEM}.</li>
   *   <li>Then return Type is {@code SYSTEM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  public void testNewAlarmCommentEntity_givenSystem_thenReturnTypeIsSystem() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setType(AlarmCommentType.SYSTEM);
    alarmComment.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmCommentEntity.getAlarmId().toString());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentEntity.getType());
    assertEquals(alarmComment, actualAlarmCommentEntity.toData());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmCommentInfo)}.
   * <ul>
   *   <li>Then return toData Type is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentEntity#AlarmCommentEntity(AlarmCommentInfo)}
   */
  @Test
  public void testNewAlarmCommentEntity_thenReturnToDataTypeIsNull() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    AlarmId alarmId = new AlarmId(ModelConstants.NULL_UUID);
    alarmCommentInfo.setAlarmId(alarmId);

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmCommentInfo);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmCommentEntity.getAlarmId().toString());
    AlarmComment toDataResult = actualAlarmCommentEntity.toData();
    assertNull(toDataResult.getComment());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(toDataResult.getUuidId());
    assertNull(toDataResult.getId().getId());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(toDataResult.getType());
    assertNull(actualAlarmCommentEntity.getType());
    assertNull(toDataResult.getUserId());
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
    assertEquals(alarmId, toDataResult.getAlarmId());
  }

  /**
   * Test {@link AlarmCommentEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmCommentEntity#AlarmCommentEntity()}.</li>
   *   <li>Then return Comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmCommentEntity_thenReturnCommentIsNull() {
    // Arrange and Act
    AlarmComment actualToDataResult = (new AlarmCommentEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getComment());
    assertNull(actualToDataResult.getUuidId());
    AlarmId alarmId = actualToDataResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(alarmId.isNullUid());
  }

  /**
   * Test {@link AlarmCommentEntity#toData()}.
   * <ul>
   *   <li>Then Comment iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentEntity#toData()}
   */
  @Test
  public void testToData_thenCommentIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);

    // Act
    AlarmComment actualToDataResult = alarmCommentEntity.toData();

    // Assert
    JsonNode comment = actualToDataResult.getComment();
    Iterator<JsonNode> iteratorResult = comment.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(comment instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = comment.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\"isPublic\":true}", actualToDataResult.getName());
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
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, comment.getNodeType());
    UserId userId = actualToDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(AlarmCommentType.SYSTEM, actualToDataResult.getType());
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
    AlarmId alarmId = actualToDataResult.getAlarmId();
    assertTrue(alarmId.isNullUid());
    assertTrue(userId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, alarmId.getId());
    assertSame(uuidId, actualToDataResult.getId().getId());
    assertSame(uuidId, userId.getId());
  }
}
