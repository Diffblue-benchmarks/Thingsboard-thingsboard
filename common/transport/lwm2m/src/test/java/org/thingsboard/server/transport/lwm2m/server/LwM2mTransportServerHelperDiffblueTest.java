package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LwM2mTransportServerHelperDiffblueTest {
  @InjectMocks private LwM2mTransportServerHelper lwM2mTransportServerHelper;

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong(long)} with one.
   *   <li>Then {@link HashMap#HashMap()} empty string is two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given AtomicLong(long) with one; then HashMap() empty string is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenAtomicLongWithOne_thenHashMapEmptyStringIsTwo() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", new AtomicLong(1L));

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(2L, keyTsLatestMap.get("").get());
    assertEquals(2L, actualTsByKey);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong(long)} with zero.
   *   <li>Then {@link HashMap#HashMap()} empty string is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given AtomicLong(long) with zero; then HashMap() empty string is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenAtomicLongWithZero_thenHashMapEmptyStringIsOne() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", new AtomicLong(0L));

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("").get());
    assertEquals(1L, actualTsByKey);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then {@link HashMap#HashMap()} {@code Key} is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName("Test getTsByKey(String, Map, long); when 'Key'; then HashMap() 'Key' is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_whenKey_thenHashMapKeyIsOne() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("Key").get());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>Then {@link AtomicLong#AtomicLong(long)} with five is six.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); then AtomicLong(long) with five is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_thenAtomicLongWithFiveIsSix() {
    // Arrange
    AtomicLong tsLatestAtomic = new AtomicLong(5L);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(6L, tsLatestAtomic.get());
    assertEquals(6L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>Then {@link AtomicLong#AtomicLong(long)} with minus one is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); then AtomicLong(long) with minus one is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_thenAtomicLongWithMinusOneIsFive() {
    // Arrange
    AtomicLong tsLatestAtomic = new AtomicLong(-1L);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
    assertEquals(5L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>Then {@link AtomicLong#AtomicLong(long)} with one is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); then AtomicLong(long) with one is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_thenAtomicLongWithOneIsFive() {
    // Arrange
    AtomicLong tsLatestAtomic = new AtomicLong(1L);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
    assertEquals(5L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>Then {@link AtomicLong#AtomicLong(long)} with zero is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); then AtomicLong(long) with zero is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_thenAtomicLongWithZeroIsFive() {
    // Arrange
    AtomicLong tsLatestAtomic = new AtomicLong(0L);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
    assertEquals(5L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[],
   * String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String); when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"
  })
  void testParseFromXmlToObjectModel_whenA() {
    // Arrange, Act and Assert
    assertNull(
        lwM2mTransportServerHelper.parseFromXmlToObjectModel(
            new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "Stream Name"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[],
   * String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"
  })
  void testParseFromXmlToObjectModel_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        lwM2mTransportServerHelper.parseFromXmlToObjectModel(
            "AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'BOOLEAN'; then return 'BOOLEAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenBoolean_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(
        Type.BOOLEAN,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.BOOLEAN, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'FLOAT'; then return 'FLOAT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenFloat_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(
        Type.FLOAT,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.FLOAT, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return {@code INTEGER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'INTEGER'; then return 'INTEGER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenInteger_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(
        Type.INTEGER,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.INTEGER, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code NONE}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'NONE'; then throw CodecException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenNone_thenThrowCodecException() {
    // Arrange, Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
                Type.NONE, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'STRING'; then return 'STRING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(
        Type.STRING,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.STRING, "Resource Path"));
  }
}
