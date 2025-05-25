package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsKeyDiffblueTest {
  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsKey tsKey = new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);
    TsKey tsKey2 = new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);

    // Act and Assert
    assertEquals(tsKey, tsKey2);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey2.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsKey tsKey = new TsKey(null, 1);
    TsKey tsKey2 = new TsKey(null, 1);

    // Act and Assert
    assertEquals(tsKey, tsKey2);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey2.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}, and {@link TsKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#equals(Object)}
   *   <li>{@link TsKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsKey tsKey = new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);

    // Act and Assert
    assertEquals(tsKey, tsKey);
    int expectedHashCodeResult = tsKey.hashCode();
    assertEquals(expectedHashCodeResult, tsKey.hashCode());
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsKey tsKey = new TsKey(ModelConstants.NULL_UUID, 1);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKey tsKey = new TsKey(null, 1);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsKey tsKey = new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 3);

    // Act and Assert
    assertNotEquals(tsKey, new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1), null);
  }

  /**
   * Test {@link TsKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsKey.equals(Object)", "int TsKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsKey(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1), "Different type to TsKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsKey#TsKey(UUID, int)}
   *   <li>{@link TsKey#toString()}
   *   <li>{@link TsKey#getEntityId()}
   *   <li>{@link TsKey#getKey()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TsKey.<init>(UUID, int)", "UUID TsKey.getEntityId()", "int TsKey.getKey()",
      "String TsKey.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TsKey actualTsKey = new TsKey(entityId, 1);
    String actualToStringResult = actualTsKey.toString();
    UUID actualEntityId = actualTsKey.getEntityId();
    int actualKey = actualTsKey.getKey();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("TsKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, key=1)", actualToStringResult);
    assertEquals(1, actualKey);
    assertSame(entityId, actualEntityId);
  }
}
