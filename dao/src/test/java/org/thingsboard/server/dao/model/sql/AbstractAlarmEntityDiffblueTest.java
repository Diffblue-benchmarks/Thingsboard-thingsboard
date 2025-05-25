package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractAlarmEntityDiffblueTest {
  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}, and {@link AbstractAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmEntity.equals(Object)", "int AbstractAlarmEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    AlarmEntity alarmEntity2 = new AlarmEntity();

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity2);
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}, and {@link AbstractAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmEntity.equals(Object)", "int AbstractAlarmEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity);
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity.hashCode());
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmEntity.equals(Object)", "int AbstractAlarmEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), null);
  }

  /**
   * Test {@link AbstractAlarmEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmEntity.equals(Object)", "int AbstractAlarmEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmEntity(), "Different type to AbstractAlarmEntity");
  }
}
