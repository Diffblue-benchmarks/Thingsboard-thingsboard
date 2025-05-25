package org.thingsboard.server.service.edge.rpc.constructor.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.TenantProfileUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class TenantMsgConstructorV1DiffblueTest {
  /**
   * Test {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}.
   * <p>
   * Method under test: {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TenantProfileUpdateMsg TenantMsgConstructorV1.constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)"})
  void testConstructTenantProfileUpdateMsg() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    TenantProfile tenantProfile = new TenantProfile(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenantProfile.setDescription("The characteristics of someone or something");
    tenantProfile.setName("entityType");

    // Act
    TenantProfileUpdateMsg actualConstructTenantProfileUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantProfileUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenantProfile, EdgeVersion.V_3_6_2);

    // Assert
    ByteString entityBytes = actualConstructTenantProfileUpdateMsgResult.getEntityBytes();
    assertEquals("", entityBytes.toStringUtf8());
    ByteString descriptionBytes = actualConstructTenantProfileUpdateMsgResult.getDescriptionBytes();
    assertEquals("The characteristics of someone or something", descriptionBytes.toStringUtf8());
    assertEquals("The characteristics of someone or something",
        actualConstructTenantProfileUpdateMsgResult.getDescription());
    assertEquals(1986, actualConstructTenantProfileUpdateMsgResult.getSerializedSize());
    assertEquals(5, actualConstructTenantProfileUpdateMsgResult.getAllFields().size());
    assertFalse(descriptionBytes.isEmpty());
    assertFalse(entityBytes.iterator().hasNext());
    assertTrue(entityBytes.isEmpty());
    assertTrue(descriptionBytes.iterator().hasNext());
    assertTrue(actualConstructTenantProfileUpdateMsgResult.hasDescription());
    TenantProfileUpdateMsg defaultInstanceForType = actualConstructTenantProfileUpdateMsgResult
        .getDefaultInstanceForType();
    assertEquals(entityBytes, defaultInstanceForType.getDescriptionBytes());
    assertEquals(entityBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(entityBytes, defaultInstanceForType.getNameBytes());
    assertEquals(entityBytes, defaultInstanceForType.getProfileDataBytes());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TenantProfileUpdateMsg TenantMsgConstructorV1.constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)"})
  void testConstructTenantProfileUpdateMsg_givenA() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    TenantProfile tenantProfile = new TenantProfile(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenantProfile.setProfileDataBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});
    tenantProfile.setName("entityType");

    // Act
    TenantProfileUpdateMsg actualConstructTenantProfileUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantProfileUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenantProfile, EdgeVersion.V_3_6_2);

    // Assert
    assertEquals(1941, actualConstructTenantProfileUpdateMsgResult.getSerializedSize());
    assertEquals(4, actualConstructTenantProfileUpdateMsgResult.getAllFields().size());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TenantProfileUpdateMsg TenantMsgConstructorV1.constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)"})
  void testConstructTenantProfileUpdateMsg_givenEmptyArrayOfByte() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    TenantProfile tenantProfile = new TenantProfile(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenantProfile.setProfileDataBytes(new byte[]{});
    tenantProfile.setName("entityType");

    // Act
    TenantProfileUpdateMsg actualConstructTenantProfileUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantProfileUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenantProfile, EdgeVersion.V_3_6_2);

    // Assert
    assertEquals(1941, actualConstructTenantProfileUpdateMsgResult.getSerializedSize());
    assertEquals(4, actualConstructTenantProfileUpdateMsgResult.getAllFields().size());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}.
   * <ul>
   *   <li>Then return DescriptorForType Oneofs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion); then return DescriptorForType Oneofs size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TenantProfileUpdateMsg TenantMsgConstructorV1.constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)"})
  void testConstructTenantProfileUpdateMsg_thenReturnDescriptorForTypeOneofsSizeIsOne() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    TenantProfile tenantProfile = new TenantProfile(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenantProfile.setName("entityType");

    // Act
    TenantProfileUpdateMsg actualConstructTenantProfileUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantProfileUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenantProfile, EdgeVersion.V_3_3_0);

    // Assert
    Descriptor descriptorForType = actualConstructTenantProfileUpdateMsgResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getOneofs().size());
    assertEquals(3, actualConstructTenantProfileUpdateMsgResult.getAllFields().size());
    assertEquals(33, actualConstructTenantProfileUpdateMsgResult.getSerializedSize());
    TenantProfileUpdateMsg defaultInstanceForType = actualConstructTenantProfileUpdateMsgResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructTenantProfileUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ByteString expectedProfileDataBytes = actualConstructTenantProfileUpdateMsgResult.getProfileDataBytes();
    assertSame(expectedProfileDataBytes, defaultInstanceForType.getProfileDataBytes());
  }

  /**
   * Test {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_6_2}.</li>
   *   <li>Then return SerializedSize is {@code 1941}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantMsgConstructorV1#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion); when 'V_3_6_2'; then return SerializedSize is '1941'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TenantProfileUpdateMsg TenantMsgConstructorV1.constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)"})
  void testConstructTenantProfileUpdateMsg_whenV362_thenReturnSerializedSizeIs1941() {
    // Arrange
    TenantMsgConstructorV1 tenantMsgConstructorV1 = new TenantMsgConstructorV1();

    TenantProfile tenantProfile = new TenantProfile(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tenantProfile.setName("entityType");

    // Act
    TenantProfileUpdateMsg actualConstructTenantProfileUpdateMsgResult = tenantMsgConstructorV1
        .constructTenantProfileUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tenantProfile, EdgeVersion.V_3_6_2);

    // Assert
    assertEquals(1941, actualConstructTenantProfileUpdateMsgResult.getSerializedSize());
    assertEquals(4, actualConstructTenantProfileUpdateMsgResult.getAllFields().size());
  }
}
