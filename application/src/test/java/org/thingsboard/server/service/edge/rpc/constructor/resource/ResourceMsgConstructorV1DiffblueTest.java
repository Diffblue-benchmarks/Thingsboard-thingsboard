package org.thingsboard.server.service.edge.rpc.constructor.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.gen.edge.v1.ResourceUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class ResourceMsgConstructorV1DiffblueTest {
  /**
   * Test {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   * <ul>
   *   <li>Given {@code Etag}.</li>
   *   <li>Then return {@code Etag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName("Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); given 'Etag'; then return 'Etag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ResourceUpdateMsg ResourceMsgConstructorV1.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"})
  void testConstructResourceUpdatedMsg_givenEtag_thenReturnEtag() {
    // Arrange
    ResourceMsgConstructorV1 resourceMsgConstructorV1 = new ResourceMsgConstructorV1();

    TbResource tbResource = new TbResource();
    tbResource.setEtag("Etag");
    tbResource.setFileName("foo.txt");
    tbResource.setResourceType(ResourceType.LWM2M_MODEL);
    tbResource.setResourceKey("");
    tbResource.setTitle("Dr");
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ResourceUpdateMsg actualConstructResourceUpdatedMsgResult = resourceMsgConstructorV1
        .constructResourceUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource);

    // Assert
    assertEquals("Etag", actualConstructResourceUpdatedMsgResult.getEtag());
    ByteString etagBytes = actualConstructResourceUpdatedMsgResult.getEtagBytes();
    assertFalse(etagBytes.isEmpty());
    ByteIterator iteratorResult = etagBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('E', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals("Etag", etagBytes.toStringUtf8());
    assertTrue(actualConstructResourceUpdatedMsgResult.hasEtag());
  }

  /**
   * Test {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   * <ul>
   *   <li>Given {@code foo.txt}.</li>
   *   <li>Then return Data is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName("Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); given 'foo.txt'; then return Data is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ResourceUpdateMsg ResourceMsgConstructorV1.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"})
  void testConstructResourceUpdatedMsg_givenFooTxt_thenReturnDataIsEmptyString() {
    // Arrange
    ResourceMsgConstructorV1 resourceMsgConstructorV1 = new ResourceMsgConstructorV1();

    TbResource tbResource = new TbResource();
    tbResource.setFileName("foo.txt");
    tbResource.setResourceType(ResourceType.LWM2M_MODEL);
    tbResource.setResourceKey("");
    tbResource.setTitle("Dr");
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ResourceUpdateMsg actualConstructResourceUpdatedMsgResult = resourceMsgConstructorV1
        .constructResourceUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource);

    // Assert
    assertEquals("", actualConstructResourceUpdatedMsgResult.getData());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getEtag());
    assertEquals(47, actualConstructResourceUpdatedMsgResult.getSerializedSize());
    assertEquals(5, actualConstructResourceUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructResourceUpdatedMsgResult.hasData());
    assertFalse(actualConstructResourceUpdatedMsgResult.hasEtag());
  }

  /**
   * Test {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   * <ul>
   *   <li>Given {@code IMAGE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName("Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); given 'IMAGE'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ResourceUpdateMsg ResourceMsgConstructorV1.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"})
  void testConstructResourceUpdatedMsg_givenImage_thenReturnNull() {
    // Arrange
    ResourceMsgConstructorV1 resourceMsgConstructorV1 = new ResourceMsgConstructorV1();

    TbResource tbResource = new TbResource();
    tbResource.setFileName("foo.txt");
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setResourceKey("");
    tbResource.setTitle("Dr");
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNull(
        resourceMsgConstructorV1.constructResourceUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource));
  }

  /**
   * Test {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   * <ul>
   *   <li>Then return EntityBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName("Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); then return EntityBytes toStringUtf8 is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ResourceUpdateMsg ResourceMsgConstructorV1.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"})
  void testConstructResourceUpdatedMsg_thenReturnEntityBytesToStringUtf8IsEmptyString() {
    // Arrange
    ResourceMsgConstructorV1 resourceMsgConstructorV1 = new ResourceMsgConstructorV1();

    TbResource tbResource = new TbResource();
    tbResource.setEncodedData("Data");
    tbResource.setFileName("foo.txt");
    tbResource.setResourceType(ResourceType.LWM2M_MODEL);
    tbResource.setResourceKey("");
    tbResource.setTitle("Dr");
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ResourceUpdateMsg actualConstructResourceUpdatedMsgResult = resourceMsgConstructorV1
        .constructResourceUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource);

    // Assert
    ByteString entityBytes = actualConstructResourceUpdatedMsgResult.getEntityBytes();
    assertEquals("", entityBytes.toStringUtf8());
    ByteString dataBytes = actualConstructResourceUpdatedMsgResult.getDataBytes();
    assertEquals("Data", dataBytes.toStringUtf8());
    assertEquals("Data", actualConstructResourceUpdatedMsgResult.getData());
    assertEquals(11, actualConstructResourceUpdatedMsgResult.getDescriptorForType().getFields().size());
    assertFalse(dataBytes.isEmpty());
    assertFalse(entityBytes.iterator().hasNext());
    assertTrue(entityBytes.isEmpty());
    assertTrue(dataBytes.iterator().hasNext());
    assertTrue(actualConstructResourceUpdatedMsgResult.hasData());
    ResourceUpdateMsg defaultInstanceForType = actualConstructResourceUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(entityBytes, defaultInstanceForType.getDataBytes());
    assertEquals(entityBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(entityBytes, defaultInstanceForType.getEtagBytes());
    assertEquals(entityBytes, actualConstructResourceUpdatedMsgResult.getEtagBytes());
    assertEquals(entityBytes, defaultInstanceForType.getFileNameBytes());
    assertEquals(entityBytes, defaultInstanceForType.getResourceKeyBytes());
    assertEquals(entityBytes, actualConstructResourceUpdatedMsgResult.getResourceKeyBytes());
    assertEquals(entityBytes, defaultInstanceForType.getResourceTypeBytes());
    assertEquals(entityBytes, defaultInstanceForType.getTitleBytes());
  }
}
