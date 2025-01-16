package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.UUID;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class TbResourceInfoDiffblueTest {
  /**
   * Test {@link TbResourceInfo#equals(Object)}, and
   * {@link TbResourceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo2);
    int expectedHashCodeResult = tbResourceInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfo2.hashCode());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}, and
   * {@link TbResourceInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo);
    int expectedHashCodeResult = tbResourceInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfo.hashCode());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertNotEquals(tbResource, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo(
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResource());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResource);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), null);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), "Different type to TbResourceInfo");
  }

  /**
   * Test {@link TbResourceInfo#getExternalId()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#TbResourceInfo()}
   *   <li>{@link TbResourceInfo#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfo#setEtag(String)}
   *   <li>{@link TbResourceInfo#setExternalId(TbResourceId)}
   *   <li>{@link TbResourceInfo#setFileName(String)}
   *   <li>{@link TbResourceInfo#setPublic(boolean)}
   *   <li>{@link TbResourceInfo#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceSubType(ResourceSubType)}
   *   <li>{@link TbResourceInfo#setResourceType(ResourceType)}
   *   <li>{@link TbResourceInfo#setSearchText(String)}
   *   <li>{@link TbResourceInfo#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfo#setTitle(String)}
   *   <li>{@link TbResourceInfo#toString()}
   *   <li>{@link TbResourceInfo#getDescriptor()}
   *   <li>{@link TbResourceInfo#getEtag()}
   *   <li>{@link TbResourceInfo#getFileName()}
   *   <li>{@link TbResourceInfo#getName()}
   *   <li>{@link TbResourceInfo#getPublicResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceSubType()}
   *   <li>{@link TbResourceInfo#getResourceType()}
   *   <li>{@link TbResourceInfo#getSearchText()}
   *   <li>{@link TbResourceInfo#getTenantId()}
   *   <li>{@link TbResourceInfo#getTitle()}
   *   <li>{@link TbResourceInfo#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo();
    MissingNode descriptor = MissingNode.getInstance();
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualTbResourceInfo.setExternalId(externalId);
    actualTbResourceInfo.setFileName("foo.txt");
    actualTbResourceInfo.setPublic(true);
    actualTbResourceInfo.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfo.setResourceKey("Resource Key");
    actualTbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);
    actualTbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);
    actualTbResourceInfo.setSearchText("Search Text");
    actualTbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualTbResourceInfo.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfo.toString();
    JsonNode actualDescriptor = actualTbResourceInfo.getDescriptor();
    String actualEtag = actualTbResourceInfo.getEtag();
    String actualFileName = actualTbResourceInfo.getFileName();
    String actualName = actualTbResourceInfo.getName();
    String actualPublicResourceKey = actualTbResourceInfo.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfo.getResourceKey();
    ResourceSubType actualResourceSubType = actualTbResourceInfo.getResourceSubType();
    ResourceType actualResourceType = actualTbResourceInfo.getResourceType();
    String actualSearchText = actualTbResourceInfo.getSearchText();
    TenantId actualTenantId = actualTbResourceInfo.getTenantId();
    String actualTitle = actualTbResourceInfo.getTitle();
    boolean actualIsPublicResult = actualTbResourceInfo.isPublic();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
        + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
        + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=, externalId=784f394c-42b6-435a-983c"
        + "-b7beff2784f9)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceInfo.getCreatedTime());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(descriptor, actualDescriptor);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#TbResourceInfo(TbResourceId)}
   *   <li>{@link TbResourceInfo#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfo#setEtag(String)}
   *   <li>{@link TbResourceInfo#setExternalId(TbResourceId)}
   *   <li>{@link TbResourceInfo#setFileName(String)}
   *   <li>{@link TbResourceInfo#setPublic(boolean)}
   *   <li>{@link TbResourceInfo#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceSubType(ResourceSubType)}
   *   <li>{@link TbResourceInfo#setResourceType(ResourceType)}
   *   <li>{@link TbResourceInfo#setSearchText(String)}
   *   <li>{@link TbResourceInfo#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfo#setTitle(String)}
   *   <li>{@link TbResourceInfo#toString()}
   *   <li>{@link TbResourceInfo#getDescriptor()}
   *   <li>{@link TbResourceInfo#getEtag()}
   *   <li>{@link TbResourceInfo#getFileName()}
   *   <li>{@link TbResourceInfo#getName()}
   *   <li>{@link TbResourceInfo#getPublicResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceSubType()}
   *   <li>{@link TbResourceInfo#getResourceType()}
   *   <li>{@link TbResourceInfo#getSearchText()}
   *   <li>{@link TbResourceInfo#getTenantId()}
   *   <li>{@link TbResourceInfo#getTitle()}
   *   <li>{@link TbResourceInfo#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo(id);
    MissingNode descriptor = MissingNode.getInstance();
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualTbResourceInfo.setExternalId(externalId);
    actualTbResourceInfo.setFileName("foo.txt");
    actualTbResourceInfo.setPublic(true);
    actualTbResourceInfo.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfo.setResourceKey("Resource Key");
    actualTbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);
    actualTbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);
    actualTbResourceInfo.setSearchText("Search Text");
    actualTbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualTbResourceInfo.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfo.toString();
    JsonNode actualDescriptor = actualTbResourceInfo.getDescriptor();
    String actualEtag = actualTbResourceInfo.getEtag();
    String actualFileName = actualTbResourceInfo.getFileName();
    String actualName = actualTbResourceInfo.getName();
    String actualPublicResourceKey = actualTbResourceInfo.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfo.getResourceKey();
    ResourceSubType actualResourceSubType = actualTbResourceInfo.getResourceSubType();
    ResourceType actualResourceType = actualTbResourceInfo.getResourceType();
    String actualSearchText = actualTbResourceInfo.getSearchText();
    TenantId actualTenantId = actualTbResourceInfo.getTenantId();
    String actualTitle = actualTbResourceInfo.getTitle();
    boolean actualIsPublicResult = actualTbResourceInfo.isPublic();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
        + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
        + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=, externalId=784f394c-42b6-435a-983c"
        + "-b7beff2784f9)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceInfo.getCreatedTime());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(id, actualTbResourceInfo.getId());
    assertSame(descriptor, actualDescriptor);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return Descriptor is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); given Instance; then return Descriptor is Instance")
  void testNewTbResourceInfo_givenInstance_thenReturnDescriptorIsInstance() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    MissingNode descriptor = MissingNode.getInstance();
    resourceInfo.setDescriptor(descriptor);

    // Act and Assert
    assertSame(descriptor, (new TbResourceInfo(resourceInfo)).getDescriptor());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>Given {@code Resource Info}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); given 'Resource Info'; then Descriptor return TextNode")
  void testNewTbResourceInfo_givenResourceInfo_thenDescriptorReturnTextNode() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue("Resource Info");

    // Act and Assert
    JsonNode descriptor = (new TbResourceInfo(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Resource Info\"", descriptor.toPrettyString());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); then Descriptor return ObjectNode")
  void testNewTbResourceInfo_thenDescriptorReturnObjectNode() throws IOException {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = (new TbResourceInfo(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("\"784f394c-42b6-435a-983c-b7beff2784f9\"", nextResult2.toPrettyString());
    assertEquals("\"TB_RESOURCE\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"entityType\" : \"TB_RESOURCE\",\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}",
        descriptor.toPrettyString());
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
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
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
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>When {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); when TbResourceInfo(); then return TbResourceInfo()")
  void testNewTbResourceInfo_whenTbResourceInfo_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();

    // Act and Assert
    assertEquals(resourceInfo, new TbResourceInfo(resourceInfo));
  }

  /**
   * Test {@link TbResourceInfo#getId()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getId());
  }

  /**
   * Test {@link TbResourceInfo#getCreatedTime()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TbResourceInfo()).getCreatedTime());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink()")
  void testGetLink() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResourceInfo.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} ResourceType is
   * {@code IMAGE}.</li>
   *   <li>Then return {@code /api/images/tenant/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); given TbResourceInfo() ResourceType is 'IMAGE'; then return '/api/images/tenant/null'")
  void testGetLink_givenTbResourceInfoResourceTypeIsImage_thenReturnApiImagesTenantNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResourceInfo.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); given TbResourceInfo(); then return 'null'")
  void testGetLink_givenTbResourceInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <ul>
   *   <li>Then return {@code /api/images/system/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); then return '/api/images/system/null'")
  void testGetLink_thenReturnApiImagesSystemNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/system/null", tbResourceInfo.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Public is
   * {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo() Public is 'false'; then return 'null'")
  void testGetPublicLink_givenTbResourceInfoPublicIsFalse_thenReturnNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);
    tbResourceInfo.setPublic(false);

    // Act and Assert
    assertNull(tbResourceInfo.getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Public is
   * {@code true}.</li>
   *   <li>Then return {@code /api/images/public/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo() Public is 'true'; then return '/api/images/public/null'")
  void testGetPublicLink_givenTbResourceInfoPublicIsTrue_thenReturnApiImagesPublicNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);
    tbResourceInfo.setPublic(true);

    // Act and Assert
    assertEquals("/api/images/public/null", tbResourceInfo.getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo(); then return 'null'")
  void testGetPublicLink_givenTbResourceInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} DescriptorValue is
   * {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given TbResourceInfo() DescriptorValue is '42'; then return '42'")
  void testGetDescriptorWithClass_givenTbResourceInfoDescriptorValueIs42_thenReturn42() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("42");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("42", tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given TbResourceInfo(); when 'java.lang.Object'; then return 'null'")
  void testGetDescriptorWithClass_givenTbResourceInfo_whenJavaLangObject_thenReturnNull()
      throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return 'Value'")
  void testGetDescriptorWithClass_thenReturnValue() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("Value");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("Value", tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  void testUpdateDescriptor() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(DataConstants.DEFAULT_SECRET_KEY);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"\"", descriptor.toPrettyString());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
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
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.iterator().hasNext());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  void testUpdateDescriptor2() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  void testUpdateDescriptor3() throws JsonProcessingException, UnsupportedEncodingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given BigDecimal(String) with '2.3'")
  void testUpdateDescriptor_givenBigDecimalWith23() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new DecimalNode(new BigDecimal("2.3")));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given 'null'; then TbResourceInfo() Descriptor is 'null'")
  void testUpdateDescriptor_givenNull_thenTbResourceInfoDescriptorIsNull() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    assertNull(tbResourceInfo.getDescriptor());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is
   * {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given one; then TbResourceInfo() Descriptor toPrettyString is '1'")
  void testUpdateDescriptor_givenOne_thenTbResourceInfoDescriptorToPrettyStringIs1() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(1);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("1", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is False.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given TbResourceInfo() Descriptor is False")
  void testUpdateDescriptor_givenTbResourceInfoDescriptorIsFalse() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(BooleanNode.getFalse());
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given TbResourceInfo() Descriptor is Instance")
  void testUpdateDescriptor_givenTbResourceInfoDescriptorIsInstance() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(NullNode.getInstance());
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is valueOf
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given TbResourceInfo() Descriptor is valueOf ten")
  void testUpdateDescriptor_givenTbResourceInfoDescriptorIsValueOfTen() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(DoubleNode.valueOf(10.0d));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is valueOf
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given TbResourceInfo() Descriptor is valueOf ten")
  void testUpdateDescriptor_givenTbResourceInfoDescriptorIsValueOfTen2() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(FloatNode.valueOf(10.0f));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} DescriptorValue is
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given TbResourceInfo() DescriptorValue is forty-two")
  void testUpdateDescriptor_givenTbResourceInfoDescriptorValueIsFortyTwo() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue(42);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor NodeType is
   * {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor NodeType is 'STRING'")
  void testUpdateDescriptor_thenTbResourceInfoDescriptorNodeTypeIsString() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("Value");
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor toPrettyString is '42'")
  void testUpdateDescriptor_thenTbResourceInfoDescriptorToPrettyStringIs42() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(42);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("42", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor traverse
   * {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor traverse TreeTraversingParser")
  void testUpdateDescriptor_thenTbResourceInfoDescriptorTraverseTreeTraversingParser() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
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
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.iterator().hasNext());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object)")
  void testSetDescriptorValue() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(DataConstants.DEFAULT_SECRET_KEY);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"\"", descriptor.toPrettyString());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); then TbResourceInfo() Descriptor toPrettyString is '42'")
  void testSetDescriptorValue_thenTbResourceInfoDescriptorToPrettyStringIs42() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(42);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("42", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is
   * {@code "Value"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); then TbResourceInfo() Descriptor toPrettyString is '\"Value\"'")
  void testSetDescriptorValue_thenTbResourceInfoDescriptorToPrettyStringIsValue() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue("Value");

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Value\"", descriptor.toPrettyString());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); when 'null'; then TbResourceInfo() Descriptor is 'null'")
  void testSetDescriptorValue_whenNull_thenTbResourceInfoDescriptorIsNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(null);

    // Assert
    assertNull(tbResourceInfo.getDescriptor());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is
   * {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); when one; then TbResourceInfo() Descriptor toPrettyString is '1'")
  void testSetDescriptorValue_whenOne_thenTbResourceInfoDescriptorToPrettyStringIs1() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(1);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("1", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }
}
