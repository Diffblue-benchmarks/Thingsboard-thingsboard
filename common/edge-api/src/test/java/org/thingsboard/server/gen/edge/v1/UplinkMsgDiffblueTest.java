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
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UplinkMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UplinkMsg#equals(Object)}
   *   <li>{@link UplinkMsg#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link UplinkMsg#equals(Object)}
   *   <li>{@link UplinkMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UplinkMsg defaultInstance = UplinkMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link UplinkMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UplinkMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link UplinkMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UplinkMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link UplinkMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UplinkMsg.getDefaultInstance(), "Different type to UplinkMsg");
  }

  /**
   * Method under test: {@link UplinkMsg#getAlarmCommentUpdateMsgCount()}
   */
  @Test
  void testGetAlarmCommentUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAlarmCommentUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getAlarmUpdateMsgCount()}
   */
  @Test
  void testGetAlarmUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAlarmUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getAssetProfileUpdateMsgCount()}
   */
  @Test
  void testGetAssetProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAssetProfileUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getAssetUpdateMsgCount()}
   */
  @Test
  void testGetAssetUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAssetUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getAttributesRequestMsgCount()}
   */
  @Test
  void testGetAttributesRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getAttributesRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDashboardUpdateMsgCount()}
   */
  @Test
  void testGetDashboardUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDashboardUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    UplinkMsg defaultInstance = UplinkMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link UplinkMsg#getDeviceCredentialsRequestMsgCount()}
   */
  @Test
  void testGetDeviceCredentialsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceCredentialsRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDeviceCredentialsUpdateMsgCount()}
   */
  @Test
  void testGetDeviceCredentialsUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceCredentialsUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDeviceProfileDevicesRequestMsgCount()}
   */
  @Test
  void testGetDeviceProfileDevicesRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceProfileDevicesRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDeviceProfileUpdateMsgCount()}
   */
  @Test
  void testGetDeviceProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceProfileUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDeviceRpcCallMsgCount()}
   */
  @Test
  void testGetDeviceRpcCallMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceRpcCallMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getDeviceUpdateMsgCount()}
   */
  @Test
  void testGetDeviceUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getDeviceUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getEntityDataCount()}
   */
  @Test
  void testGetEntityDataCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getEntityDataCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getEntityViewUpdateMsgCount()}
   */
  @Test
  void testGetEntityViewUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getEntityViewUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getEntityViewsRequestMsgCount()}
   */
  @Test
  void testGetEntityViewsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getEntityViewsRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getRelationRequestMsgCount()}
   */
  @Test
  void testGetRelationRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getRelationRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getRelationUpdateMsgCount()}
   */
  @Test
  void testGetRelationUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getRelationUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getResourceUpdateMsgCount()}
   */
  @Test
  void testGetResourceUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getResourceUpdateMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getRuleChainMetadataRequestMsgCount()}
   */
  @Test
  void testGetRuleChainMetadataRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getRuleChainMetadataRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link UplinkMsg#getUserCredentialsRequestMsgCount()}
   */
  @Test
  void testGetUserCredentialsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getUserCredentialsRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#getWidgetBundleTypesRequestMsgCount()}
   */
  @Test
  void testGetWidgetBundleTypesRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, UplinkMsg.getDefaultInstance().getWidgetBundleTypesRequestMsgCount());
  }

  /**
   * Method under test: {@link UplinkMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UplinkMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link UplinkMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
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
   * Method under test: {@link UplinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UplinkMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link UplinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link UplinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test:
   * {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UplinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
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
   * Method under test:
   * {@link UplinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test: {@link UplinkMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UplinkMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link UplinkMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UplinkMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link UplinkMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UplinkMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link UplinkMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> UplinkMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
