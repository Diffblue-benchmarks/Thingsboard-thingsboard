package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WidgetsBundleWidgetCompositeKeyDiffblueTest {
  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and {@link
   * WidgetsBundleWidgetCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 =
        new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and {@link
   * WidgetsBundleWidgetCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey(
            widgetsBundleId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID widgetsBundleId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 =
        new WidgetsBundleWidgetCompositeKey(
            widgetsBundleId2, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and {@link
   * WidgetsBundleWidgetCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey(
            widgetsBundleId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, new WidgetsBundleWidgetCompositeKey());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        widgetsBundleWidgetCompositeKey,
        new WidgetsBundleWidgetCompositeKey(
            widgetsBundleId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    widgetsBundleWidgetCompositeKey.setWidgetTypeId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, new WidgetsBundleWidgetCompositeKey());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();

    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 =
        new WidgetsBundleWidgetCompositeKey();
    widgetsBundleWidgetCompositeKey2.setWidgetTypeId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleWidgetCompositeKey(), null);
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new WidgetsBundleWidgetCompositeKey(), "Different type to WidgetsBundleWidgetCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#WidgetsBundleWidgetCompositeKey()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#toString()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void WidgetsBundleWidgetCompositeKey.<init>()",
    "void WidgetsBundleWidgetCompositeKey.<init>(UUID, UUID)",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetTypeId()",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetsBundleId()",
    "void WidgetsBundleWidgetCompositeKey.setWidgetTypeId(UUID)",
    "void WidgetsBundleWidgetCompositeKey.setWidgetsBundleId(UUID)",
    "String WidgetsBundleWidgetCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleWidgetCompositeKey actualWidgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    UUID widgetTypeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetCompositeKey.setWidgetTypeId(widgetTypeId);
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetCompositeKey.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetCompositeKey.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetCompositeKey.getWidgetTypeId();
    UUID actualWidgetsBundleId = actualWidgetsBundleWidgetCompositeKey.getWidgetsBundleId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetTypeId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetsBundleId.toString());
    assertEquals(
        "WidgetsBundleWidgetCompositeKey(widgetsBundleId=784f394c-42b6-435a-983c-b7beff2784f9, widgetTypeId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(widgetTypeId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleId);
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
   *   <li>{@link WidgetsBundleWidgetCompositeKey#WidgetsBundleWidgetCompositeKey(UUID, UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#toString()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void WidgetsBundleWidgetCompositeKey.<init>()",
    "void WidgetsBundleWidgetCompositeKey.<init>(UUID, UUID)",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetTypeId()",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetsBundleId()",
    "void WidgetsBundleWidgetCompositeKey.setWidgetTypeId(UUID)",
    "void WidgetsBundleWidgetCompositeKey.setWidgetsBundleId(UUID)",
    "String WidgetsBundleWidgetCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    WidgetsBundleWidgetCompositeKey actualWidgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey(
            widgetsBundleId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID widgetTypeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetCompositeKey.setWidgetTypeId(widgetTypeId);
    UUID widgetsBundleId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetCompositeKey.setWidgetsBundleId(widgetsBundleId2);
    String actualToStringResult = actualWidgetsBundleWidgetCompositeKey.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetCompositeKey.getWidgetTypeId();
    UUID actualWidgetsBundleId = actualWidgetsBundleWidgetCompositeKey.getWidgetsBundleId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetTypeId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetsBundleId.toString());
    assertEquals(
        "WidgetsBundleWidgetCompositeKey(widgetsBundleId=784f394c-42b6-435a-983c-b7beff2784f9, widgetTypeId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(widgetTypeId, actualWidgetTypeId);
    assertSame(widgetsBundleId2, actualWidgetsBundleId);
  }
}
