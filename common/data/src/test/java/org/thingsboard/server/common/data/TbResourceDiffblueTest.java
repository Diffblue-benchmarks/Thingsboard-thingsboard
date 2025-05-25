package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;

class TbResourceDiffblueTest {
  /**
   * Test {@link TbResource#equals(Object)}, and {@link TbResource#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#equals(Object)}
   *   <li>{@link TbResource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResource tbResource = new TbResource();
    TbResource tbResource2 = new TbResource();

    // Act and Assert
    assertEquals(tbResource, tbResource2);
    int expectedHashCodeResult = tbResource.hashCode();
    assertEquals(expectedHashCodeResult, tbResource2.hashCode());
  }

  /**
   * Test {@link TbResource#equals(Object)}, and {@link TbResource#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#equals(Object)}
   *   <li>{@link TbResource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertEquals(tbResource, tbResource);
    int expectedHashCodeResult = tbResource.hashCode();
    assertEquals(expectedHashCodeResult, tbResource.hashCode());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setEncodedData("Data");

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setEncodedPreview("Preview");

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), null);
  }

  /**
   * Test {@link TbResource#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResource.equals(Object)", "int TbResource.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), "Different type to TbResource");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#TbResource(TbResourceId)}
   *   <li>{@link TbResource#setData(byte[])}
   *   <li>{@link TbResource#setPreview(byte[])}
   *   <li>{@link TbResource#toString()}
   *   <li>{@link TbResource#getData()}
   *   <li>{@link TbResource#getPreview()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>()", "void TbResource.<init>(TbResourceId)", "byte[] TbResource.getData()",
      "byte[] TbResource.getPreview()", "void TbResource.setData(byte[])", "void TbResource.setPreview(byte[])",
      "String TbResource.toString()"})
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbResource actualTbResource = new TbResource(id);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setData(data);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setPreview(preview);
    String actualToStringResult = actualTbResource.toString();
    byte[] actualData = actualTbResource.getData();
    byte[] actualPreview = actualTbResource.getPreview();

    // Assert
    assertEquals("TbResourceInfo(tenantId=null, title=null, resourceType=null, resourceSubType=null, resourceKey=null,"
        + " isPublic=false, publicResourceKey=null, searchText=null, etag=null, fileName=null, descriptor=null,"
        + " externalId=null)", actualToStringResult);
    assertNull(actualTbResource.getDescriptor());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getTenantId());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
    assertSame(id, actualTbResource.getId());
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPreview);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#TbResource()}
   *   <li>{@link TbResource#setData(byte[])}
   *   <li>{@link TbResource#setPreview(byte[])}
   *   <li>{@link TbResource#toString()}
   *   <li>{@link TbResource#getData()}
   *   <li>{@link TbResource#getPreview()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>()", "void TbResource.<init>(TbResourceId)", "byte[] TbResource.getData()",
      "byte[] TbResource.getPreview()", "void TbResource.setData(byte[])", "void TbResource.setPreview(byte[])",
      "String TbResource.toString()"})
  void testGettersAndSetters_thenReturnIdIsNull() throws UnsupportedEncodingException {
    // Arrange and Act
    TbResource actualTbResource = new TbResource();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setData(data);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setPreview(preview);
    String actualToStringResult = actualTbResource.toString();
    byte[] actualData = actualTbResource.getData();
    byte[] actualPreview = actualTbResource.getPreview();

    // Assert
    assertEquals("TbResourceInfo(tenantId=null, title=null, resourceType=null, resourceSubType=null, resourceKey=null,"
        + " isPublic=false, publicResourceKey=null, searchText=null, etag=null, fileName=null, descriptor=null,"
        + " externalId=null)", actualToStringResult);
    assertNull(actualTbResource.getDescriptor());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getId());
    assertNull(actualTbResource.getTenantId());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPreview);
  }

  /**
   * Test {@link TbResource#TbResource(TbResourceInfo)}.
   * <ul>
   *   <li>Given {@code Resource Info}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResourceInfo); given 'Resource Info'; then Descriptor return TextNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>(TbResourceInfo)"})
  void testNewTbResource_givenResourceInfo_thenDescriptorReturnTextNode() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue("Resource Info");

    // Act and Assert
    JsonNode descriptor = (new TbResource(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Resource Info\"", descriptor.toPrettyString());
    assertEquals(0, descriptor.size());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResource#TbResource(TbResource)}.
   * <ul>
   *   <li>Given {@code Resource}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResource); given 'Resource'; then Descriptor return TextNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>(TbResource)"})
  void testNewTbResource_givenResource_thenDescriptorReturnTextNode() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue("Resource");

    // Act and Assert
    JsonNode descriptor = (new TbResource(resource)).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Resource\"", descriptor.toPrettyString());
    assertEquals(0, descriptor.size());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResource#TbResource(TbResource)}.
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResource); then Descriptor return ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>(TbResource)"})
  void testNewTbResource_thenDescriptorReturnObjectNode() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = (new TbResource(resource)).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals("{\r\n  \"entityType\" : \"TB_RESOURCE\",\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}",
        descriptor.toPrettyString());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertFalse(descriptor.isEmpty());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(descriptor.isObject());
  }

  /**
   * Test {@link TbResource#TbResource(TbResourceInfo)}.
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResourceInfo); then Descriptor return ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>(TbResourceInfo)"})
  void testNewTbResource_thenDescriptorReturnObjectNode2() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = (new TbResource(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals("{\r\n  \"entityType\" : \"TB_RESOURCE\",\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}",
        descriptor.toPrettyString());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertFalse(descriptor.isEmpty());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(descriptor.isObject());
  }

  /**
   * Test {@link TbResource#TbResource(TbResourceInfo)}.
   * <ul>
   *   <li>When {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResourceInfo); when TbResourceInfo(); then return Data is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>(TbResourceInfo)"})
  void testNewTbResource_whenTbResourceInfo_thenReturnDataIsNull() {
    // Arrange and Act
    TbResource actualTbResource = new TbResource(new TbResourceInfo());

    // Assert
    assertNull(actualTbResource.getData());
    assertNull(actualTbResource.getPreview());
    assertNull(actualTbResource.getDescriptor());
    assertNull(actualTbResource.getEncodedData());
    assertNull(actualTbResource.getEncodedPreview());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getLink());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicLink());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getUuidId());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getId());
    assertNull(actualTbResource.getTenantId());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
  }

  /**
   * Test {@link TbResource#TbResource(TbResource)}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  @DisplayName("Test new TbResource(TbResource); when TbResource(); then return TbResource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.<init>(TbResource)"})
  void testNewTbResource_whenTbResource_thenReturnTbResource() {
    // Arrange
    TbResource resource = new TbResource();

    // Act and Assert
    assertEquals(resource, new TbResource(resource));
  }

  /**
   * Test {@link TbResource#getEncodedData()}.
   * <p>
   * Method under test: {@link TbResource#getEncodedData()}
   */
  @Test
  @DisplayName("Test getEncodedData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResource.getEncodedData()"})
  void testGetEncodedData() {
    // Arrange, Act and Assert
    assertNull((new TbResource()).getEncodedData());
  }

  /**
   * Test {@link TbResource#setEncodedData(String)}.
   * <ul>
   *   <li>When {@code Data}.</li>
   *   <li>Then {@link TbResource#TbResource()} EncodedData is {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#setEncodedData(String)}
   */
  @Test
  @DisplayName("Test setEncodedData(String); when 'Data'; then TbResource() EncodedData is 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.setEncodedData(String)"})
  void testSetEncodedData_whenData_thenTbResourceEncodedDataIsData() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act
    tbResource.setEncodedData("Data");

    // Assert
    assertEquals("Data", tbResource.getEncodedData());
    assertArrayEquals(new byte[]{'\r', -85, 'Z'}, tbResource.getData());
  }

  /**
   * Test {@link TbResource#getEncodedPreview()}.
   * <p>
   * Method under test: {@link TbResource#getEncodedPreview()}
   */
  @Test
  @DisplayName("Test getEncodedPreview()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResource.getEncodedPreview()"})
  void testGetEncodedPreview() {
    // Arrange, Act and Assert
    assertNull((new TbResource()).getEncodedPreview());
  }

  /**
   * Test {@link TbResource#setEncodedPreview(String)}.
   * <ul>
   *   <li>When {@code Preview}.</li>
   *   <li>Then {@link TbResource#TbResource()} EncodedPreview is {@code Preview=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResource#setEncodedPreview(String)}
   */
  @Test
  @DisplayName("Test setEncodedPreview(String); when 'Preview'; then TbResource() EncodedPreview is 'Preview='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResource.setEncodedPreview(String)"})
  void testSetEncodedPreview_whenPreview_thenTbResourceEncodedPreviewIsPreview() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act
    tbResource.setEncodedPreview("Preview");

    // Assert
    assertEquals("Preview=", tbResource.getEncodedPreview());
    assertArrayEquals(new byte[]{'>', -73, -81, -119, -20}, tbResource.getPreview());
  }
}
