package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractEdgeEntityDiffblueTest {
  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and {@link AbstractEdgeEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractEdgeEntity.equals(Object)", "int AbstractEdgeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and {@link AbstractEdgeEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractEdgeEntity.equals(Object)", "int AbstractEdgeEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractEdgeEntity.equals(Object)", "int AbstractEdgeEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), null);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractEdgeEntity.equals(Object)", "int AbstractEdgeEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), "Different type to AbstractEdgeEntity");
  }
}
