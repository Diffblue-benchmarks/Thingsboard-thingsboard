package org.thingsboard.server.dao.model.sqlts.latest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TsKvLatestCompositeKeyDiffblueTest {
  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}, and {@link
   * TsKvLatestCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#equals(Object)}
   *   <li>{@link TsKvLatestCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();
    TsKvLatestCompositeKey tsKvLatestCompositeKey2 = new TsKvLatestCompositeKey();

    // Act and Assert
    assertEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey2);
    int expectedHashCodeResult = tsKvLatestCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}, and {@link
   * TsKvLatestCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#equals(Object)}
   *   <li>{@link TsKvLatestCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey =
        new TsKvLatestCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);
    TsKvLatestCompositeKey tsKvLatestCompositeKey2 =
        new TsKvLatestCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);

    // Act and Assert
    assertEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey2);
    int expectedHashCodeResult = tsKvLatestCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestCompositeKey2.hashCode());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}, and {@link
   * TsKvLatestCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#equals(Object)}
   *   <li>{@link TsKvLatestCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();

    // Act and Assert
    assertEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey);
    int expectedHashCodeResult = tsKvLatestCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKvLatestCompositeKey.hashCode());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey =
        new TsKvLatestCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);

    // Act and Assert
    assertNotEquals(tsKvLatestCompositeKey, new TsKvLatestCompositeKey());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();
    tsKvLatestCompositeKey.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tsKvLatestCompositeKey, new TsKvLatestCompositeKey());
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKvLatestCompositeKey tsKvLatestCompositeKey = new TsKvLatestCompositeKey();

    TsKvLatestCompositeKey tsKvLatestCompositeKey2 = new TsKvLatestCompositeKey();
    tsKvLatestCompositeKey2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tsKvLatestCompositeKey, tsKvLatestCompositeKey2);
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestCompositeKey(), null);
  }

  /**
   * Test {@link TsKvLatestCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TsKvLatestCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TsKvLatestCompositeKey.equals(Object)",
    "int TsKvLatestCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKvLatestCompositeKey(), "Different type to TsKvLatestCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TsKvLatestCompositeKey#TsKvLatestCompositeKey()}
   *   <li>{@link TsKvLatestCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvLatestCompositeKey#setKey(int)}
   *   <li>{@link TsKvLatestCompositeKey#toString()}
   *   <li>{@link TsKvLatestCompositeKey#getEntityId()}
   *   <li>{@link TsKvLatestCompositeKey#getKey()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TsKvLatestCompositeKey.<init>()",
    "void TsKvLatestCompositeKey.<init>(UUID, int)",
    "UUID TsKvLatestCompositeKey.getEntityId()",
    "int TsKvLatestCompositeKey.getKey()",
    "void TsKvLatestCompositeKey.setEntityId(UUID)",
    "void TsKvLatestCompositeKey.setKey(int)",
    "String TsKvLatestCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TsKvLatestCompositeKey actualTsKvLatestCompositeKey = new TsKvLatestCompositeKey();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTsKvLatestCompositeKey.setEntityId(entityId);
    actualTsKvLatestCompositeKey.setKey(1);
    String actualToStringResult = actualTsKvLatestCompositeKey.toString();
    UUID actualEntityId = actualTsKvLatestCompositeKey.getEntityId();
    int actualKey = actualTsKvLatestCompositeKey.getKey();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "TsKvLatestCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
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
   *   <li>{@link TsKvLatestCompositeKey#TsKvLatestCompositeKey(UUID, int)}
   *   <li>{@link TsKvLatestCompositeKey#setEntityId(UUID)}
   *   <li>{@link TsKvLatestCompositeKey#setKey(int)}
   *   <li>{@link TsKvLatestCompositeKey#toString()}
   *   <li>{@link TsKvLatestCompositeKey#getEntityId()}
   *   <li>{@link TsKvLatestCompositeKey#getKey()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TsKvLatestCompositeKey.<init>()",
    "void TsKvLatestCompositeKey.<init>(UUID, int)",
    "UUID TsKvLatestCompositeKey.getEntityId()",
    "int TsKvLatestCompositeKey.getKey()",
    "void TsKvLatestCompositeKey.setEntityId(UUID)",
    "void TsKvLatestCompositeKey.setKey(int)",
    "String TsKvLatestCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    TsKvLatestCompositeKey actualTsKvLatestCompositeKey =
        new TsKvLatestCompositeKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTsKvLatestCompositeKey.setEntityId(entityId);
    actualTsKvLatestCompositeKey.setKey(1);
    String actualToStringResult = actualTsKvLatestCompositeKey.toString();
    UUID actualEntityId = actualTsKvLatestCompositeKey.getEntityId();
    int actualKey = actualTsKvLatestCompositeKey.getKey();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "TsKvLatestCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1)",
        actualToStringResult);
    assertEquals(1, actualKey);
    assertSame(entityId, actualEntityId);
  }
}
