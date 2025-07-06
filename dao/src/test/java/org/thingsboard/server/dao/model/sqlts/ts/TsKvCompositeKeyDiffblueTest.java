package org.thingsboard.server.dao.model.sqlts.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TsKvCompositeKeyDiffblueTest {
  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and {@link TsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey();

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey2);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and {@link TsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey =
        new TsKvCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);
    TsKvCompositeKey tsKvCompositeKey2 =
        new TsKvCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey2);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}, and {@link TsKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#equals(Object)}
   *   <li>{@link TsKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();

    // Act and Assert
    assertEquals(tsKvCompositeKey, tsKvCompositeKey);
    int expectedHashCodeResult = tsKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvCompositeKey.hashCode());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey =
        new TsKvCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    tsKvCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();
    tsKvCompositeKey.setTs(1L);

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, new TsKvCompositeKey());
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsKvCompositeKey tsKvCompositeKey = new TsKvCompositeKey();

    TsKvCompositeKey tsKvCompositeKey2 = new TsKvCompositeKey();
    tsKvCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tsKvCompositeKey, tsKvCompositeKey2);
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvCompositeKey(), null);
  }

  /**
   * Test {@link TsKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKvCompositeKey.equals(Object)", "int TsKvCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvCompositeKey(), "Different type to TsKvCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvCompositeKey#TsKvCompositeKey()}
   *   <li>{@link TsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvCompositeKey#setKey(int)}
   *   <li>{@link TsKvCompositeKey#setTs(long)}
   *   <li>{@link TsKvCompositeKey#toString()}
   *   <li>{@link TsKvCompositeKey#getEntityId()}
   *   <li>{@link TsKvCompositeKey#getKey()}
   *   <li>{@link TsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TsKvCompositeKey.<init>()",
    "void TsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TsKvCompositeKey.getEntityId()",
    "int TsKvCompositeKey.getKey()",
    "long TsKvCompositeKey.getTs()",
    "void TsKvCompositeKey.setEntityId(UUID)",
    "void TsKvCompositeKey.setKey(int)",
    "void TsKvCompositeKey.setTs(long)",
    "String TsKvCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TsKvCompositeKey actualTsKvCompositeKey = new TsKvCompositeKey();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTsKvCompositeKey.setEntityId(entityId);
    actualTsKvCompositeKey.setKey(1);
    actualTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTsKvCompositeKey.toString();
    UUID actualEntityId = actualTsKvCompositeKey.getEntityId();
    int actualKey = actualTsKvCompositeKey.getKey();
    long actualTs = actualTsKvCompositeKey.getTs();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "TsKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1, ts=1)",
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
   *   <li>{@link TsKvCompositeKey#TsKvCompositeKey(UUID, int, long)}
   *   <li>{@link TsKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvCompositeKey#setKey(int)}
   *   <li>{@link TsKvCompositeKey#setTs(long)}
   *   <li>{@link TsKvCompositeKey#toString()}
   *   <li>{@link TsKvCompositeKey#getEntityId()}
   *   <li>{@link TsKvCompositeKey#getKey()}
   *   <li>{@link TsKvCompositeKey#getTs()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TsKvCompositeKey.<init>()",
    "void TsKvCompositeKey.<init>(UUID, int, long)",
    "UUID TsKvCompositeKey.getEntityId()",
    "int TsKvCompositeKey.getKey()",
    "long TsKvCompositeKey.getTs()",
    "void TsKvCompositeKey.setEntityId(UUID)",
    "void TsKvCompositeKey.setKey(int)",
    "void TsKvCompositeKey.setTs(long)",
    "String TsKvCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    TsKvCompositeKey actualTsKvCompositeKey =
        new TsKvCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1, 1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTsKvCompositeKey.setEntityId(entityId);
    actualTsKvCompositeKey.setKey(1);
    actualTsKvCompositeKey.setTs(1L);
    String actualToStringResult = actualTsKvCompositeKey.toString();
    UUID actualEntityId = actualTsKvCompositeKey.getEntityId();
    int actualKey = actualTsKvCompositeKey.getKey();
    long actualTs = actualTsKvCompositeKey.getTs();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "TsKvCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1, ts=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertEquals(1L, actualTs);
    assertSame(entityId, actualEntityId);
  }
}
