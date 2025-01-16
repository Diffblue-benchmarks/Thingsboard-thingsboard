package org.thingsboard.server.service.edge.rpc.constructor.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AttributeDeleteMsg;
import org.thingsboard.server.gen.edge.v1.EntityDataProto;
import org.thingsboard.server.gen.transport.TransportProtos;

class EntityDataMsgConstructorDiffblueTest {
  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)")
  void testConstructEntityDataMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("[{}][{}] Can't convert to telemetry proto, entityData [{}]", new JsonArray(3));
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code data} and
   * {@link JsonElement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) add 'data' and JsonElement")
  void testConstructEntityDataMsg_givenJsonObjectAddDataAndJsonElement() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code data} and
   * {@link JsonElement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) add 'data' and JsonElement")
  void testConstructEntityDataMsg_givenJsonObjectAddDataAndJsonElement2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", mock(JsonElement.class));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.ATTRIBUTES_DELETED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'ts' and '42'")
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyTsAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", "42");
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'ts' and 'true'")
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyTsAndTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", true);
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and
   * valueOf two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) addProperty 'ts' and valueOf two")
  void testConstructEntityDataMsg_givenJsonObjectAddPropertyTsAndValueOfTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", Integer.valueOf(2));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    assertEquals(2,
        actualConstructEntityDataMsgResult.getAttributeDeleteMsg().getDescriptorForType().getFields().size());
    assertEquals(2,
        actualConstructEntityDataMsgResult.getAttributesUpdatedMsg().getDescriptorForType().getFields().size());
    assertEquals(8, actualConstructEntityDataMsgResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code ts} and
   * {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) add 'ts' and JsonArray(int) with capacity is three")
  void testConstructEntityDataMsg_givenJsonObjectAddTsAndJsonArrayWithCapacityIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code ts} and
   * {@code null}.</li>
   *   <li>Then calls {@link JsonElement#getAsJsonObject()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor) add 'ts' and 'null'; then calls getAsJsonObject()")
  void testConstructEntityDataMsg_givenJsonObjectAddTsAndNull_thenCallsGetAsJsonObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", null);
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   *   <li>Then calls {@link JsonElement#getAsJsonObject()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given JsonObject (default constructor); then calls getAsJsonObject()")
  void testConstructEntityDataMsg_givenJsonObject_thenCallsGetAsJsonObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(new JsonObject());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link JsonElement} {@link JsonElement#getAsJsonObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'null'; when JsonElement getAsJsonObject() return 'null'")
  void testConstructEntityDataMsg_givenNull_whenJsonElementGetAsJsonObjectReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(null);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  void testConstructEntityDataMsg_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonArray entityData = new JsonArray(3);
    entityData.add(true);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Given valueOf two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); given valueOf two")
  void testConstructEntityDataMsg_givenValueOfTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonArray entityData = new JsonArray(3);
    entityData.add(Integer.valueOf(2));

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    assertEquals(2,
        actualConstructEntityDataMsgResult.getAttributeDeleteMsg().getDescriptorForType().getFields().size());
    assertEquals(2,
        actualConstructEntityDataMsgResult.getAttributesUpdatedMsg().getDescriptorForType().getFields().size());
    assertEquals(8, actualConstructEntityDataMsgResult.getDescriptorForType().getFields().size());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>Then calls {@link JsonElement#isJsonNull()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); then calls isJsonNull()")
  void testConstructEntityDataMsg_thenCallsIsJsonNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    JsonElement value = mock(JsonElement.class);
    when(value.isJsonNull()).thenReturn(true);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", value);
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(value).isJsonNull();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ADDED'")
  void testConstructEntityDataMsg_whenAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.ADDED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code ATTRIBUTES_DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_DELETED'")
  void testConstructEntityDataMsg_whenAttributesDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.ATTRIBUTES_DELETED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code ATTRIBUTES_UPDATED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_UPDATED'")
  void testConstructEntityDataMsg_whenAttributesUpdated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.ATTRIBUTES_UPDATED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code ATTRIBUTES_UPDATED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'ATTRIBUTES_UPDATED'")
  void testConstructEntityDataMsg_whenAttributesUpdated2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.ATTRIBUTES_UPDATED, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonArray(int) with capacity is three")
  void testConstructEntityDataMsg_whenJsonArrayWithCapacityIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonNull (default constructor)")
  void testConstructEntityDataMsg_whenJsonNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonNull());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonObject (default constructor)")
  void testConstructEntityDataMsg_whenJsonObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonObject());

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(Boolean) with bool is 'true'")
  void testConstructEntityDataMsg_whenJsonPrimitiveWithBoolIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonPrimitive(true));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Character)} with c is start of
   * text.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(Character) with c is start of text")
  void testConstructEntityDataMsg_whenJsonPrimitiveWithCIsStartOfText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonPrimitive('\u0002'));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when JsonPrimitive(String) with 'String'")
  void testConstructEntityDataMsg_whenJsonPrimitiveWithString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, new JsonPrimitive("String"));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'null'")
  void testConstructEntityDataMsg_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.TIMESERIES_UPDATED, null);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code POST_ATTRIBUTES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'POST_ATTRIBUTES'")
  void testConstructEntityDataMsg_whenPostAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.POST_ATTRIBUTES, new JsonArray(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}.
   * <ul>
   *   <li>When {@code POST_ATTRIBUTES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataMsgConstructor#constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement)}
   */
  @Test
  @DisplayName("Test constructEntityDataMsg(TenantId, EntityId, EdgeEventActionType, JsonElement); when 'POST_ATTRIBUTES'")
  void testConstructEntityDataMsg_whenPostAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDataMsgConstructor entityDataMsgConstructor = new EntityDataMsgConstructor();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray(3));
    JsonElement entityData = mock(JsonElement.class);
    when(entityData.getAsJsonObject()).thenReturn(jsonObject);

    // Act
    EntityDataProto actualConstructEntityDataMsgResult = entityDataMsgConstructor.constructEntityDataMsg(tenantId,
        entityId, EdgeEventActionType.POST_ATTRIBUTES, entityData);

    // Assert
    verify(entityData).getAsJsonObject();
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityDataMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualConstructEntityDataMsgResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualConstructEntityDataMsgResult
        .getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualConstructEntityDataMsgResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualConstructEntityDataMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityDataMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualConstructEntityDataMsgResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualConstructEntityDataMsgResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualConstructEntityDataMsgResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }
}
