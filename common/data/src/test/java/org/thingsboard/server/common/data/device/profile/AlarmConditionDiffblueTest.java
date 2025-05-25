package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityKeyValueType;
import org.thingsboard.server.common.data.query.KeyFilterPredicate;

class AlarmConditionDiffblueTest {
  /**
   * Test {@link AlarmCondition#equals(Object)}, and {@link AlarmCondition#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCondition#equals(Object)}
   *   <li>{@link AlarmCondition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(null);

    AlarmCondition alarmCondition2 = new AlarmCondition();
    alarmCondition2.setCondition(new ArrayList<>());
    alarmCondition2.setSpec(null);

    // Act and Assert
    assertEquals(alarmCondition, alarmCondition2);
    int expectedHashCodeResult = alarmCondition.hashCode();
    assertEquals(expectedHashCodeResult, alarmCondition2.hashCode());
  }

  /**
   * Test {@link AlarmCondition#equals(Object)}, and {@link AlarmCondition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCondition#equals(Object)}
   *   <li>{@link AlarmCondition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertEquals(alarmCondition, alarmCondition);
    int expectedHashCodeResult = alarmCondition.hashCode();
    assertEquals(expectedHashCodeResult, alarmCondition.hashCode());
  }

  /**
   * Test {@link AlarmCondition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCondition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    AlarmCondition alarmCondition2 = new AlarmCondition();
    alarmCondition2.setCondition(new ArrayList<>());
    alarmCondition2.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertNotEquals(alarmCondition, alarmCondition2);
  }

  /**
   * Test {@link AlarmCondition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCondition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    AlarmCondition alarmCondition2 = new AlarmCondition();
    alarmCondition2.setCondition(new ArrayList<>());
    alarmCondition2.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertNotEquals(alarmCondition, alarmCondition2);
  }

  /**
   * Test {@link AlarmCondition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCondition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(null);

    AlarmCondition alarmCondition2 = new AlarmCondition();
    alarmCondition2.setCondition(new ArrayList<>());
    alarmCondition2.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertNotEquals(alarmCondition, alarmCondition2);
  }

  /**
   * Test {@link AlarmCondition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCondition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertNotEquals(alarmCondition, null);
  }

  /**
   * Test {@link AlarmCondition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCondition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCondition.equals(Object)", "int AlarmCondition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertNotEquals(alarmCondition, "Different type to AlarmCondition");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AlarmCondition}
   *   <li>{@link AlarmCondition#setCondition(List)}
   *   <li>{@link AlarmCondition#setSpec(AlarmConditionSpec)}
   *   <li>{@link AlarmCondition#toString()}
   *   <li>{@link AlarmCondition#getCondition()}
   *   <li>{@link AlarmCondition#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmCondition.<init>()", "List AlarmCondition.getCondition()",
      "AlarmConditionSpec AlarmCondition.getSpec()", "void AlarmCondition.setCondition(List)",
      "void AlarmCondition.setSpec(AlarmConditionSpec)", "java.lang.String AlarmCondition.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCondition actualAlarmCondition = new AlarmCondition();
    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    actualAlarmCondition.setCondition(condition);
    AlarmConditionSpec spec = mock(AlarmConditionSpec.class);
    actualAlarmCondition.setSpec(spec);
    actualAlarmCondition.toString();
    List<AlarmConditionFilter> actualCondition = actualAlarmCondition.getCondition();
    AlarmConditionSpec actualSpec = actualAlarmCondition.getSpec();

    // Assert
    assertTrue(actualCondition.isEmpty());
    assertSame(condition, actualCondition);
    assertSame(spec, actualSpec);
  }
}
