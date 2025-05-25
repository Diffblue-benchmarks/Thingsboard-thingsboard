package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractAlarmCommentEntityDiffblueTest {
  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link AbstractAlarmCommentEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.equals(Object)", "int AbstractAlarmCommentEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link AbstractAlarmCommentEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.equals(Object)", "int AbstractAlarmCommentEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.equals(Object)", "int AbstractAlarmCommentEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), null);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.equals(Object)", "int AbstractAlarmCommentEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), "Different type to AbstractAlarmCommentEntity");
  }
}
