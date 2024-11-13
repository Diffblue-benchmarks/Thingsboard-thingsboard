package org.thingsboard.server.service.edge.rpc.constructor.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class EntityViewMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}.
   * <p>
   * Method under test:
   * {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}
   */
  @Test
  @DisplayName("Test constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)")
  void testConstructEntityViewUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();
    EntityView entityView = mock(EntityView.class);
    when(entityView.getAdditionalInfo()).thenReturn(null);
    when(entityView.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");
    when(entityView.getId()).thenReturn(new EntityViewId(UUID.randomUUID()));
    when(entityView.getEntityId()).thenReturn(new AssetId(UUID.randomUUID()));

    // Act
    EntityViewUpdateMsg actualConstructEntityViewUpdatedMsgResult = entityViewMsgConstructorV1
        .constructEntityViewUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityView);

    // Assert
    verify(entityView).getAdditionalInfo();
    verify(entityView, atLeast(1)).getCustomerId();
    verify(entityView, atLeast(1)).getEntityId();
    verify(entityView, atLeast(1)).getId();
    verify(entityView).getName();
    verify(entityView).getType();
    ByteString additionalInfoBytes = actualConstructEntityViewUpdatedMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructEntityViewUpdatedMsgResult.getAdditionalInfo());
    Descriptors.Descriptor descriptorForType = actualConstructEntityViewUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    assertEquals(9, actualConstructEntityViewUpdatedMsgResult.getAllFields().size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructEntityViewUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(10).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(11).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    EntityViewUpdateMsg defaultInstanceForType2 = actualConstructEntityViewUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructEntityViewUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTypeBytes());
  }

  /**
   * Test
   * {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}
   */
  @Test
  @DisplayName("Test constructEntityViewUpdatedMsg(UpdateMsgType, EntityView); given AlarmId(UUID) with id is randomUUID")
  void testConstructEntityViewUpdatedMsg_givenAlarmIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();
    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityViewMsgConstructorV1
        .constructEntityViewUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityView));
    verify(entityView).getEntityId();
  }

  /**
   * Test
   * {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityViewMsgConstructorV1#constructEntityViewUpdatedMsg(UpdateMsgType, EntityView)}
   */
  @Test
  @DisplayName("Test constructEntityViewUpdatedMsg(UpdateMsgType, EntityView); given RuntimeException(String) with 'foo'")
  void testConstructEntityViewUpdatedMsg_givenRuntimeExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenThrow(new RuntimeException("foo"));
    when(entityView.getType()).thenReturn("Type");
    when(entityView.getName()).thenReturn("Name");
    when(entityView.getId()).thenReturn(new EntityViewId(UUID.randomUUID()));
    when(entityView.getEntityId()).thenReturn(new AssetId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityViewMsgConstructorV1
        .constructEntityViewUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityView));
    verify(entityView).getCustomerId();
    verify(entityView, atLeast(1)).getEntityId();
    verify(entityView, atLeast(1)).getId();
    verify(entityView).getName();
    verify(entityView).getType();
  }
}
