package org.thingsboard.server.service.edge.rpc.constructor.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.gen.edge.v1.ProcessingStrategyProto;
import org.thingsboard.server.gen.edge.v1.QueueUpdateMsg;
import org.thingsboard.server.gen.edge.v1.SubmitStrategyProto;

class BaseQueueMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseQueueMsgConstructor#constructQueueDeleteMsg(QueueId)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueMsgConstructor#constructQueueDeleteMsg(QueueId)}
   */
  @Test
  @DisplayName("Test constructQueueDeleteMsg(QueueId); given randomUUID; then calls getId()")
  void testConstructQueueDeleteMsg_givenRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueMsgConstructorV2 queueMsgConstructorV2 = new QueueMsgConstructorV2();
    QueueId queueId = mock(QueueId.class);
    when(queueId.getId()).thenReturn(UUID.randomUUID());

    // Act
    QueueUpdateMsg actualConstructQueueDeleteMsgResult = queueMsgConstructorV2.constructQueueDeleteMsg(queueId);

    // Assert
    verify(queueId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructQueueDeleteMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(14, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualConstructQueueDeleteMsgResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualConstructQueueDeleteMsgResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(12);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(13);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    QueueUpdateMsg defaultInstanceForType2 = actualConstructQueueDeleteMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructQueueDeleteMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategy());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategyOrBuilder());
    assertSame(processingStrategy, actualConstructQueueDeleteMsgResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategy());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, actualConstructQueueDeleteMsgResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
  }

  /**
   * Test {@link BaseQueueMsgConstructor#constructQueueDeleteMsg(QueueId)}.
   * <ul>
   *   <li>When {@link QueueId#QueueId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueMsgConstructor#constructQueueDeleteMsg(QueueId)}
   */
  @Test
  @DisplayName("Test constructQueueDeleteMsg(QueueId); when QueueId(UUID) with id is randomUUID")
  void testConstructQueueDeleteMsg_whenQueueIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueMsgConstructorV2 queueMsgConstructorV2 = new QueueMsgConstructorV2();

    // Act
    QueueUpdateMsg actualConstructQueueDeleteMsgResult = queueMsgConstructorV2
        .constructQueueDeleteMsg(new QueueId(UUID.randomUUID()));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructQueueDeleteMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(14, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(14, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualConstructQueueDeleteMsgResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualConstructQueueDeleteMsgResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(12);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(13);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    QueueUpdateMsg defaultInstanceForType2 = actualConstructQueueDeleteMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructQueueDeleteMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategy());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategyOrBuilder());
    assertSame(processingStrategy, actualConstructQueueDeleteMsgResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategy());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, actualConstructQueueDeleteMsgResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
  }
}
