package org.thingsboard.server.dao.model.sqlts.timescale.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimescaleTsKvCompositeKeyDiffblueTest {
  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and {@link
   * TimescaleTsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey();

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and {@link
   * TimescaleTsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey =
        new TimescaleTsKvCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 =
        new TimescaleTsKvCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}, and {@link
   * TimescaleTsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#equals(Object)}
   *   <li>{@link TimescaleTsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();

    // Act and Assert
    assertEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey);
    int expectedHashCodeResult = timescaleTsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, timescaleTsKvCompositeKey.hashCode());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey =
        new TimescaleTsKvCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey.setTs(1L);

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, new TimescaleTsKvCompositeKey());
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();

    TimescaleTsKvCompositeKey timescaleTsKvCompositeKey2 = new TimescaleTsKvCompositeKey();
    timescaleTsKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(timescaleTsKvCompositeKey, timescaleTsKvCompositeKey2);
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimescaleTsKvCompositeKey(), null);
  }

  /**
   * Test {@link TimescaleTsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTsKvCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TimescaleTsKvCompositeKey.equals(Object)",
    "int TimescaleTsKvCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimescaleTsKvCompositeKey(), "Different type to TimescaleTsKvCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#TimescaleTsKvCompositeKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TimescaleTsKvCompositeKey#setKey(int)}
   *   <li>{@link TimescaleTsKvCompositeKey#setTs(long)}
   *   <li>{@link TimescaleTsKvCompositeKey#toString()}
   *   <li>{@link TimescaleTsKvCompositeKey#getEntityId()}
   *   <li>{@link TimescaleTsKvCompositeKey#getKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvCompositeKey.<init>()",
    "void TimescaleTsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TimescaleTsKvCompositeKey.getEntityId()",
    "int TimescaleTsKvCompositeKey.getKey()",
    "long TimescaleTsKvCompositeKey.getTs()",
    "void TimescaleTsKvCompositeKey.setEntityId(UUID)",
    "void TimescaleTsKvCompositeKey.setKey(int)",
    "void TimescaleTsKvCompositeKey.setTs(long)",
    "String TimescaleTsKvCompositeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TimescaleTsKvCompositeKey actualTimescaleTsKvCompositeKey = new TimescaleTsKvCompositeKey();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTimescaleTsKvCompositeKey.setEntityId(entityId);
    actualTimescaleTsKvCompositeKey.setKey(1);
    actualTimescaleTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTimescaleTsKvCompositeKey.toString();
    UUID actualEntityId = actualTimescaleTsKvCompositeKey.getEntityId();
    int actualKey = actualTimescaleTsKvCompositeKey.getKey();
    long actualTs = actualTimescaleTsKvCompositeKey.getTs();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "TimescaleTsKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTs);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimescaleTsKvCompositeKey#TimescaleTsKvCompositeKey(UUID, int, long)}
   *   <li>{@link TimescaleTsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TimescaleTsKvCompositeKey#setKey(int)}
   *   <li>{@link TimescaleTsKvCompositeKey#setTs(long)}
   *   <li>{@link TimescaleTsKvCompositeKey#toString()}
   *   <li>{@link TimescaleTsKvCompositeKey#getEntityId()}
   *   <li>{@link TimescaleTsKvCompositeKey#getKey()}
   *   <li>{@link TimescaleTsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TimescaleTsKvCompositeKey.<init>()",
    "void TimescaleTsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TimescaleTsKvCompositeKey.getEntityId()",
    "int TimescaleTsKvCompositeKey.getKey()",
    "long TimescaleTsKvCompositeKey.getTs()",
    "void TimescaleTsKvCompositeKey.setEntityId(UUID)",
    "void TimescaleTsKvCompositeKey.setKey(int)",
    "void TimescaleTsKvCompositeKey.setTs(long)",
    "String TimescaleTsKvCompositeKey.toString()"
  })
  void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    TimescaleTsKvCompositeKey actualTimescaleTsKvCompositeKey =
        new TimescaleTsKvCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTimescaleTsKvCompositeKey.setEntityId(entityId);
    actualTimescaleTsKvCompositeKey.setKey(1);
    actualTimescaleTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTimescaleTsKvCompositeKey.toString();
    UUID actualEntityId = actualTimescaleTsKvCompositeKey.getEntityId();
    int actualKey = actualTimescaleTsKvCompositeKey.getKey();
    long actualTs = actualTimescaleTsKvCompositeKey.getTs();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "TimescaleTsKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTs);
    assertSame(entityId, actualEntityId);
  }
}
