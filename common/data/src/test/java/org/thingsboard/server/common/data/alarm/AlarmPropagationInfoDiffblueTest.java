package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.alarm.AlarmPropagationInfo.AlarmPropagationInfoBuilder;

@ContextConfiguration(classes = {AlarmPropagationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class AlarmPropagationInfoDiffblueTest {
  @Autowired
  private AlarmPropagationInfoBuilder alarmPropagationInfoBuilder;

  /**
   * Test AlarmPropagationInfoBuilder {@link AlarmPropagationInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfoBuilder#build()}
   *   <li>{@link AlarmPropagationInfoBuilder#propagate(boolean)}
   *   <li>{@link AlarmPropagationInfoBuilder#propagateRelationTypes(List)}
   *   <li>{@link AlarmPropagationInfoBuilder#propagateToOwner(boolean)}
   *   <li>{@link AlarmPropagationInfoBuilder#propagateToTenant(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmPropagationInfoBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmPropagationInfoBuilder.<init>()",
      "AlarmPropagationInfo AlarmPropagationInfoBuilder.build()",
      "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagate(boolean)",
      "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagateRelationTypes(List)",
      "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagateToOwner(boolean)",
      "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagateToTenant(boolean)",
      "String AlarmPropagationInfoBuilder.toString()"})
  void testAlarmPropagationInfoBuilderBuild() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();

    // Act
    AlarmPropagationInfo actualBuildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Assert
    List<String> propagateRelationTypes2 = actualBuildResult.getPropagateRelationTypes();
    assertTrue(propagateRelationTypes2.isEmpty());
    assertTrue(actualBuildResult.isPropagate());
    assertTrue(actualBuildResult.isPropagateToOwner());
    assertTrue(actualBuildResult.isPropagateToTenant());
    assertSame(propagateRelationTypes, propagateRelationTypes2);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}, and {@link AlarmPropagationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfo#equals(Object)}
   *   <li>{@link AlarmPropagationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}, and {@link AlarmPropagationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfo#equals(Object)}
   *   <li>{@link AlarmPropagationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagate(anyBoolean())).thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder.propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagate(anyBoolean())).thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder.propagate(true);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagateRelationTypes(Mockito.<List<String>>any()))
        .thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder2 = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder2.propagate(anyBoolean())).thenReturn(alarmPropagationInfoBuilder);
    AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder2.propagate(true);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder.propagateToOwner(anyBoolean())).thenReturn(AlarmPropagationInfo.builder());
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder2 = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder2.propagateRelationTypes(Mockito.<List<String>>any()))
        .thenReturn(alarmPropagationInfoBuilder);
    AlarmPropagationInfoBuilder alarmPropagationInfoBuilder3 = mock(AlarmPropagationInfoBuilder.class);
    when(alarmPropagationInfoBuilder3.propagate(anyBoolean())).thenReturn(alarmPropagationInfoBuilder2);
    AlarmPropagationInfoBuilder propagateResult = alarmPropagationInfoBuilder3.propagate(true);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(propagateRelationTypes)
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();
    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo buildResult2 = propagateResult2.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmPropagationInfo.equals(Object)", "int AlarmPropagationInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmPropagationInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmPropagationInfo#AlarmPropagationInfo(boolean, boolean, boolean, List)}
   *   <li>{@link AlarmPropagationInfo#setPropagate(boolean)}
   *   <li>{@link AlarmPropagationInfo#setPropagateRelationTypes(List)}
   *   <li>{@link AlarmPropagationInfo#setPropagateToOwner(boolean)}
   *   <li>{@link AlarmPropagationInfo#setPropagateToTenant(boolean)}
   *   <li>{@link AlarmPropagationInfo#toString()}
   *   <li>{@link AlarmPropagationInfo#getPropagateRelationTypes()}
   *   <li>{@link AlarmPropagationInfo#isPropagate()}
   *   <li>{@link AlarmPropagationInfo#isPropagateToOwner()}
   *   <li>{@link AlarmPropagationInfo#isPropagateToTenant()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmPropagationInfo.<init>(boolean, boolean, boolean, List)",
      "List AlarmPropagationInfo.getPropagateRelationTypes()", "boolean AlarmPropagationInfo.isPropagate()",
      "boolean AlarmPropagationInfo.isPropagateToOwner()", "boolean AlarmPropagationInfo.isPropagateToTenant()",
      "void AlarmPropagationInfo.setPropagate(boolean)", "void AlarmPropagationInfo.setPropagateRelationTypes(List)",
      "void AlarmPropagationInfo.setPropagateToOwner(boolean)",
      "void AlarmPropagationInfo.setPropagateToTenant(boolean)", "String AlarmPropagationInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmPropagationInfo actualAlarmPropagationInfo = new AlarmPropagationInfo(true, true, true, new ArrayList<>());
    actualAlarmPropagationInfo.setPropagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    actualAlarmPropagationInfo.setPropagateRelationTypes(propagateRelationTypes);
    actualAlarmPropagationInfo.setPropagateToOwner(true);
    actualAlarmPropagationInfo.setPropagateToTenant(true);
    String actualToStringResult = actualAlarmPropagationInfo.toString();
    List<String> actualPropagateRelationTypes = actualAlarmPropagationInfo.getPropagateRelationTypes();
    boolean actualIsPropagateResult = actualAlarmPropagationInfo.isPropagate();
    boolean actualIsPropagateToOwnerResult = actualAlarmPropagationInfo.isPropagateToOwner();
    boolean actualIsPropagateToTenantResult = actualAlarmPropagationInfo.isPropagateToTenant();

    // Assert
    assertEquals(
        "AlarmPropagationInfo(propagate=true, propagateToOwner=true, propagateToTenant=true, propagateRelationTypes"
            + "=[])",
        actualToStringResult);
    assertTrue(actualPropagateRelationTypes.isEmpty());
    assertTrue(actualIsPropagateResult);
    assertTrue(actualIsPropagateToOwnerResult);
    assertTrue(actualIsPropagateToTenantResult);
    assertSame(propagateRelationTypes, actualPropagateRelationTypes);
  }
}
