package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundleWidget;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetsBundleWidgetEntityDiffblueTest {
  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link WidgetsBundleWidgetEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
    int expectedHashCodeResult = widgetsBundleWidgetEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link WidgetsBundleWidgetEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(null);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(null);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
    int expectedHashCodeResult = widgetsBundleWidgetEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link WidgetsBundleWidgetEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(null);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(null);

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
    int expectedHashCodeResult = widgetsBundleWidgetEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link WidgetsBundleWidgetEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity);
    int expectedHashCodeResult = widgetsBundleWidgetEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetEntity.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(null);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(2);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(null);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, null);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleWidgetEntity.equals(Object)", "int WidgetsBundleWidgetEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, "Different type to WidgetsBundleWidgetEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity()}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeOrder(int)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#toString()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeOrder()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleWidgetEntity.<init>()",
      "void WidgetsBundleWidgetEntity.<init>(UUID, UUID, int)", "UUID WidgetsBundleWidgetEntity.getWidgetTypeId()",
      "int WidgetsBundleWidgetEntity.getWidgetTypeOrder()", "UUID WidgetsBundleWidgetEntity.getWidgetsBundleId()",
      "void WidgetsBundleWidgetEntity.setWidgetTypeId(UUID)", "void WidgetsBundleWidgetEntity.setWidgetTypeOrder(int)",
      "void WidgetsBundleWidgetEntity.setWidgetsBundleId(UUID)", "String WidgetsBundleWidgetEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleWidgetEntity actualWidgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    UUID widgetTypeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetEntity.setWidgetTypeId(widgetTypeId);
    actualWidgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetEntity.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetEntity.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetEntity.getWidgetTypeId();
    int actualWidgetTypeOrder = actualWidgetsBundleWidgetEntity.getWidgetTypeOrder();
    UUID actualWidgetsBundleId = actualWidgetsBundleWidgetEntity.getWidgetsBundleId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetTypeId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetsBundleId.toString());
    assertEquals("WidgetsBundleWidgetEntity(widgetsBundleId=784f394c-42b6-435a-983c-b7beff2784f9, widgetTypeId=784f394c"
        + "-42b6-435a-983c-b7beff2784f9, widgetTypeOrder=1)", actualToStringResult);
    assertEquals(1, actualWidgetTypeOrder);
    assertSame(widgetTypeId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity(UUID, UUID, int)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeOrder(int)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#toString()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeOrder()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleWidgetEntity.<init>()",
      "void WidgetsBundleWidgetEntity.<init>(UUID, UUID, int)", "UUID WidgetsBundleWidgetEntity.getWidgetTypeId()",
      "int WidgetsBundleWidgetEntity.getWidgetTypeOrder()", "UUID WidgetsBundleWidgetEntity.getWidgetsBundleId()",
      "void WidgetsBundleWidgetEntity.setWidgetTypeId(UUID)", "void WidgetsBundleWidgetEntity.setWidgetTypeOrder(int)",
      "void WidgetsBundleWidgetEntity.setWidgetsBundleId(UUID)", "String WidgetsBundleWidgetEntity.toString()"})
  public void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID widgetsBundleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    WidgetsBundleWidgetEntity actualWidgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity(widgetsBundleId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);
    UUID widgetTypeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetEntity.setWidgetTypeId(widgetTypeId);
    actualWidgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    UUID widgetsBundleId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleWidgetEntity.setWidgetsBundleId(widgetsBundleId2);
    String actualToStringResult = actualWidgetsBundleWidgetEntity.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetEntity.getWidgetTypeId();
    int actualWidgetTypeOrder = actualWidgetsBundleWidgetEntity.getWidgetTypeOrder();
    UUID actualWidgetsBundleId = actualWidgetsBundleWidgetEntity.getWidgetsBundleId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetTypeId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualWidgetsBundleId.toString());
    assertEquals("WidgetsBundleWidgetEntity(widgetsBundleId=784f394c-42b6-435a-983c-b7beff2784f9, widgetTypeId=784f394c"
        + "-42b6-435a-983c-b7beff2784f9, widgetTypeOrder=1)", actualToStringResult);
    assertEquals(1, actualWidgetTypeOrder);
    assertSame(widgetTypeId, actualWidgetTypeId);
    assertSame(widgetsBundleId2, actualWidgetsBundleId);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity(WidgetsBundleWidget)}.
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity(WidgetsBundleWidget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleWidgetEntity.<init>(WidgetsBundleWidget)"})
  public void testNewWidgetsBundleWidgetEntity() {
    // Arrange
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(id), 1);
    widgetsBundleWidget.setWidgetsBundleId(new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Act
    WidgetsBundleWidgetEntity actualWidgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity(widgetsBundleWidget);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        actualWidgetsBundleWidgetEntity.getWidgetsBundleId().toString());
    UUID widgetTypeId = actualWidgetsBundleWidgetEntity.getWidgetTypeId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", widgetTypeId.toString());
    assertEquals(1, actualWidgetsBundleWidgetEntity.getWidgetTypeOrder());
    assertSame(id, widgetTypeId);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#toData()}.
   * <p>
   * Method under test: {@link WidgetsBundleWidgetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetsBundleWidget WidgetsBundleWidgetEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    WidgetsBundleWidget actualToDataResult = (new WidgetsBundleWidgetEntity()).toData();

    // Assert
    WidgetTypeId widgetTypeId = actualToDataResult.getWidgetTypeId();
    assertNull(widgetTypeId.getId());
    WidgetsBundleId widgetsBundleId = actualToDataResult.getWidgetsBundleId();
    assertNull(widgetsBundleId.getId());
    assertEquals(0, actualToDataResult.getWidgetTypeOrder());
    assertEquals(EntityType.WIDGETS_BUNDLE, widgetsBundleId.getEntityType());
    assertEquals(EntityType.WIDGET_TYPE, widgetTypeId.getEntityType());
    assertFalse(widgetTypeId.isNullUid());
    assertFalse(widgetsBundleId.isNullUid());
  }
}
