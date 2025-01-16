package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UplinkMsgDiffblueTest {
  /**
   * Test {@link UplinkMsg#equals(Object)}, and {@link UplinkMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UplinkMsg#equals(Object)}
   *   <li>{@link UplinkMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UplinkMsg defaultInstance = UplinkMsg.getDefaultInstance();
    UplinkMsg defaultInstance2 = UplinkMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link UplinkMsg#equals(Object)}, and {@link UplinkMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UplinkMsg#equals(Object)}
   *   <li>{@link UplinkMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UplinkMsg defaultInstance = UplinkMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link UplinkMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UplinkMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link UplinkMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UplinkMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link UplinkMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UplinkMsg.getDefaultInstance(), "Different type to UplinkMsg");
  }

  /**
   * Test {@link UplinkMsg#getAlarmCommentUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getAlarmCommentUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAlarmCommentUpdateMsgCount()")
  void testGetAlarmCommentUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAlarmCommentUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getAlarmUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getAlarmUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAlarmUpdateMsgCount()")
  void testGetAlarmUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAlarmUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getAssetProfileUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getAssetProfileUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAssetProfileUpdateMsgCount()")
  void testGetAssetProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAssetProfileUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getAssetUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getAssetUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAssetUpdateMsgCount()")
  void testGetAssetUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAssetUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getAttributesRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getAttributesRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getAttributesRequestMsgCount()")
  void testGetAttributesRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAttributesRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDashboardUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDashboardUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDashboardUpdateMsgCount()")
  void testGetDashboardUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDashboardUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    UplinkMsg defaultInstance = UplinkMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link UplinkMsg#getDeviceCredentialsRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDeviceCredentialsRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsRequestMsgCount()")
  void testGetDeviceCredentialsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceCredentialsRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDeviceCredentialsUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDeviceCredentialsUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsUpdateMsgCount()")
  void testGetDeviceCredentialsUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceCredentialsUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDeviceProfileDevicesRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDeviceProfileDevicesRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceProfileDevicesRequestMsgCount()")
  void testGetDeviceProfileDevicesRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceProfileDevicesRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDeviceProfileUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDeviceProfileUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceProfileUpdateMsgCount()")
  void testGetDeviceProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceProfileUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDeviceRpcCallMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDeviceRpcCallMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceRpcCallMsgCount()")
  void testGetDeviceRpcCallMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceRpcCallMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getDeviceUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getDeviceUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceUpdateMsgCount()")
  void testGetDeviceUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getEntityDataCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getEntityDataCount()}
   */
  @Test
  @DisplayName("Test getEntityDataCount()")
  void testGetEntityDataCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getEntityDataCount());
  }

  /**
   * Test {@link UplinkMsg#getEntityViewUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getEntityViewUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getEntityViewUpdateMsgCount()")
  void testGetEntityViewUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getEntityViewUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getEntityViewsRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getEntityViewsRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getEntityViewsRequestMsgCount()")
  void testGetEntityViewsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getEntityViewsRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getRelationRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getRelationRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getRelationRequestMsgCount()")
  void testGetRelationRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getRelationRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getRelationUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getRelationUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getRelationUpdateMsgCount()")
  void testGetRelationUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getRelationUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getResourceUpdateMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getResourceUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getResourceUpdateMsgCount()")
  void testGetResourceUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getResourceUpdateMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getRuleChainMetadataRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getRuleChainMetadataRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getRuleChainMetadataRequestMsgCount()")
  void testGetRuleChainMetadataRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getRuleChainMetadataRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link UplinkMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link UplinkMsg#getUserCredentialsRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getUserCredentialsRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getUserCredentialsRequestMsgCount()")
  void testGetUserCredentialsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getUserCredentialsRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#getWidgetBundleTypesRequestMsgCount()}.
   * <p>
   * Method under test: {@link UplinkMsg#getWidgetBundleTypesRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getWidgetBundleTypesRequestMsgCount()")
  void testGetWidgetBundleTypesRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getWidgetBundleTypesRequestMsgCount());
  }

  /**
   * Test {@link UplinkMsg#isInitialized()}.
   * <p>
   * Method under test: {@link UplinkMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UplinkMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link UplinkMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link UplinkMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    UplinkMsg defaultInstance = UplinkMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof UplinkMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UplinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UplinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> UplinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UplinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UplinkMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UplinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UplinkMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link UplinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UplinkMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UplinkMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link UplinkMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UplinkMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UplinkMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UplinkMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UplinkMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UplinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UplinkMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UplinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UplinkMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UplinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    UplinkMsg actualParseFromResult = UplinkMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(UplinkMsg.ALARMCOMMENTUPDATEMSG_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UplinkMsg.ALARMCOMMENTUPDATEMSG_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertSame(file, messageType.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(UplinkMsg.DEVICEPROFILEUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType2 = getResult3.getMessageType();
    assertSame(file, messageType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(UplinkMsg.RESOURCEUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType3 = getResult4.getMessageType();
    assertSame(file, messageType3.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor getResult8 = messageTypes.get(57);
    assertSame(file, getResult8.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, messageType2.getOptions());
    assertSame(options4, messageType3.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link UplinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UplinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UplinkMsg actualParseFromResult = UplinkMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(UplinkMsg.ALARMCOMMENTUPDATEMSG_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UplinkMsg.ALARMCOMMENTUPDATEMSG_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertSame(file, messageType.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(UplinkMsg.DEVICEPROFILEUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType2 = getResult3.getMessageType();
    assertSame(file, messageType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(UplinkMsg.RESOURCEUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType3 = getResult4.getMessageType();
    assertSame(file, messageType3.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor getResult8 = messageTypes.get(57);
    assertSame(file, getResult8.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, messageType2.getOptions());
    assertSame(options4, messageType3.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
