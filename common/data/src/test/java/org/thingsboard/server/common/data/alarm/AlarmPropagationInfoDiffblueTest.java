package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.alarm.AlarmPropagationInfo.AlarmPropagationInfoBuilder;

@ContextConfiguration(classes = {AlarmPropagationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class AlarmPropagationInfoDiffblueTest {
  @Autowired private AlarmPropagationInfoBuilder alarmPropagationInfoBuilder;

  /**
   * Test AlarmPropagationInfoBuilder {@link AlarmPropagationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmPropagationInfoBuilder.<init>()",
    "AlarmPropagationInfo AlarmPropagationInfoBuilder.build()",
    "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagate(boolean)",
    "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagateRelationTypes(List)",
    "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagateToOwner(boolean)",
    "AlarmPropagationInfoBuilder AlarmPropagationInfoBuilder.propagateToTenant(boolean)",
    "String AlarmPropagationInfoBuilder.toString()"
  })
  void testAlarmPropagationInfoBuilderBuild() {
    // Arrange and Act
    AlarmPropagationInfoBuilder actualPropagateResult =
        AlarmPropagationInfo.builder().propagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    AlarmPropagationInfo actualAlarmPropagationInfo =
        actualPropagateResult
            .propagateRelationTypes(propagateRelationTypes)
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build();

    // Assert
    List<String> propagateRelationTypes2 = actualAlarmPropagationInfo.getPropagateRelationTypes();
    assertTrue(propagateRelationTypes2.isEmpty());
    assertTrue(actualAlarmPropagationInfo.isPropagate());
    assertTrue(actualAlarmPropagationInfo.isPropagateToOwner());
    assertTrue(actualAlarmPropagationInfo.isPropagateToTenant());
    assertSame(propagateRelationTypes, propagateRelationTypes2);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}, and {@link AlarmPropagationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmPropagationInfo#equals(Object)}
   *   <li>{@link AlarmPropagationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo alarmPropagationInfo =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build();

    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo alarmPropagationInfo2 =
        propagateResult2
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build();

    // Act and Assert
    assertEquals(alarmPropagationInfo, alarmPropagationInfo2);
    assertEquals(alarmPropagationInfo.hashCode(), alarmPropagationInfo2.hashCode());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}, and {@link AlarmPropagationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmPropagationInfo#equals(Object)}
   *   <li>{@link AlarmPropagationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo alarmPropagationInfo =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build();

    // Act and Assert
    assertEquals(alarmPropagationInfo, alarmPropagationInfo);
    int expectedHashCodeResult = alarmPropagationInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmPropagationInfo.hashCode());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(false);
    AlarmPropagationInfo alarmPropagationInfo =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build();

    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);

    // Act and Assert
    assertNotEquals(
        alarmPropagationInfo,
        propagateResult2
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");
    AlarmPropagationInfo alarmPropagationInfo =
        AlarmPropagationInfo.builder()
            .propagate(true)
            .propagateRelationTypes(propagateRelationTypes)
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build();

    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);

    // Act and Assert
    assertNotEquals(
        alarmPropagationInfo,
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo alarmPropagationInfo =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(false)
            .propagateToTenant(true)
            .build();

    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);

    // Act and Assert
    assertNotEquals(
        alarmPropagationInfo,
        propagateResult2
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);
    AlarmPropagationInfo alarmPropagationInfo =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(false)
            .build();

    AlarmPropagationInfoBuilder propagateResult2 = AlarmPropagationInfo.builder().propagate(true);

    // Act and Assert
    assertNotEquals(
        alarmPropagationInfo,
        propagateResult2
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build());
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);

    // Act and Assert
    assertNotEquals(
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build(),
        null);
  }

  /**
   * Test {@link AlarmPropagationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmPropagationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmPropagationInfo.equals(Object)",
    "int AlarmPropagationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmPropagationInfoBuilder propagateResult = AlarmPropagationInfo.builder().propagate(true);

    // Act and Assert
    assertNotEquals(
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .build(),
        "Different type to AlarmPropagationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmPropagationInfo.<init>(boolean, boolean, boolean, List)",
    "List AlarmPropagationInfo.getPropagateRelationTypes()",
    "boolean AlarmPropagationInfo.isPropagate()",
    "boolean AlarmPropagationInfo.isPropagateToOwner()",
    "boolean AlarmPropagationInfo.isPropagateToTenant()",
    "void AlarmPropagationInfo.setPropagate(boolean)",
    "void AlarmPropagationInfo.setPropagateRelationTypes(List)",
    "void AlarmPropagationInfo.setPropagateToOwner(boolean)",
    "void AlarmPropagationInfo.setPropagateToTenant(boolean)",
    "String AlarmPropagationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmPropagationInfo actualAlarmPropagationInfo =
        new AlarmPropagationInfo(true, true, true, new ArrayList<>());
    actualAlarmPropagationInfo.setPropagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    actualAlarmPropagationInfo.setPropagateRelationTypes(propagateRelationTypes);
    actualAlarmPropagationInfo.setPropagateToOwner(true);
    actualAlarmPropagationInfo.setPropagateToTenant(true);
    String actualToStringResult = actualAlarmPropagationInfo.toString();
    List<String> actualPropagateRelationTypes =
        actualAlarmPropagationInfo.getPropagateRelationTypes();
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
