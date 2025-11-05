package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.service.apiusage.BaseApiUsageState.StatsCalculationResult;
import org.thingsboard.server.service.apiusage.BaseApiUsageState.StatsCalculationResult.StatsCalculationResultBuilder;

@ContextConfiguration(classes = {StatsCalculationResultBuilder.class, CustomerApiUsageState.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BaseApiUsageStateDiffblueTest {
  @MockBean private ApiUsageState apiUsageState;

  @Autowired private BaseApiUsageState baseApiUsageState;

  @Autowired private StatsCalculationResultBuilder statsCalculationResultBuilder;



  /**
   * Test {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}.
   *
   * <ul>
   *   <li>When {@code TRANSPORT_MSG_COUNT}.
   *   <li>Then return HourlyValueChanged.
   * </ul>
   *
   * <p>Method under test: {@link BaseApiUsageState#calculate(ApiUsageRecordKey, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculate(ApiUsageRecordKey, long, String); when 'TRANSPORT_MSG_COUNT'; then return HourlyValueChanged")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StatsCalculationResult BaseApiUsageState.calculate(ApiUsageRecordKey, long, String)"
  })
  void testCalculate_whenTransportMsgCount_thenReturnHourlyValueChanged() {
    // Arrange and Act
    StatsCalculationResult actualCalculateResult =
        baseApiUsageState.calculate(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 42L, "42");

    // Assert
    assertTrue(actualCalculateResult.isHourlyValueChanged());
    assertTrue(actualCalculateResult.isValueChanged());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}, and {@link
   * StatsCalculationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult#equals(Object)}
   *   <li>{@link StatsCalculationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();
    StatsCalculationResult statsCalculationResult2 =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertEquals(statsCalculationResult, statsCalculationResult2);
    assertEquals(statsCalculationResult.hashCode(), statsCalculationResult2.hashCode());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}, and {@link
   * StatsCalculationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult#equals(Object)}
   *   <li>{@link StatsCalculationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertEquals(statsCalculationResult, statsCalculationResult);
    int expectedHashCodeResult = statsCalculationResult.hashCode();
    assertEquals(expectedHashCodeResult, statsCalculationResult.hashCode());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(false)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(
        statsCalculationResult,
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(1L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(
        statsCalculationResult,
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(1L)
            .valueChanged(true)
            .build();

    // Act and Assert
    assertNotEquals(
        statsCalculationResult,
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(false)
            .build();

    // Act and Assert
    assertNotEquals(
        statsCalculationResult,
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build(),
        null);
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatsCalculationResult#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StatsCalculationResult.equals(Object)",
    "int StatsCalculationResult.hashCode()"
  })
  void testStatsCalculationResultEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build(),
        "Different type to StatsCalculationResult");
  }

  /**
   * Test StatsCalculationResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult#toString()}
   *   <li>{@link StatsCalculationResult#getNewHourlyValue()}
   *   <li>{@link StatsCalculationResult#getNewValue()}
   *   <li>{@link StatsCalculationResult#isHourlyValueChanged()}
   *   <li>{@link StatsCalculationResult#isValueChanged()}
   * </ul>
   */
  @Test
  @DisplayName("Test StatsCalculationResult getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long StatsCalculationResult.getNewHourlyValue()",
    "long StatsCalculationResult.getNewValue()",
    "boolean StatsCalculationResult.isHourlyValueChanged()",
    "boolean StatsCalculationResult.isValueChanged()",
    "String StatsCalculationResult.toString()"
  })
  void testStatsCalculationResultGettersAndSetters() {
    // Arrange
    StatsCalculationResult statsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Act
    String actualToStringResult = statsCalculationResult.toString();
    long actualNewHourlyValue = statsCalculationResult.getNewHourlyValue();
    long actualNewValue = statsCalculationResult.getNewValue();
    boolean actualIsHourlyValueChangedResult = statsCalculationResult.isHourlyValueChanged();

    // Assert
    assertEquals(
        "BaseApiUsageState.StatsCalculationResult(newValue=42, valueChanged=true, newHourlyValue=42,"
            + " hourlyValueChanged=true)",
        actualToStringResult);
    assertEquals(42L, actualNewHourlyValue);
    assertEquals(42L, actualNewValue);
    assertTrue(actualIsHourlyValueChangedResult);
    assertTrue(statsCalculationResult.isValueChanged());
  }

  /**
   * Test StatsCalculationResult {@link StatsCalculationResult#StatsCalculationResult(long, boolean,
   * long, boolean)}.
   *
   * <p>Method under test: {@link StatsCalculationResult#StatsCalculationResult(long, boolean, long,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test StatsCalculationResult new StatsCalculationResult(long, boolean, long, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatsCalculationResult.<init>(long, boolean, long, boolean)"})
  void testStatsCalculationResultNewStatsCalculationResult() {
    // Arrange and Act
    StatsCalculationResult actualStatsCalculationResult =
        new StatsCalculationResult(42L, true, 42L, true);

    // Assert
    assertEquals(42L, actualStatsCalculationResult.getNewHourlyValue());
    assertEquals(42L, actualStatsCalculationResult.getNewValue());
    assertTrue(actualStatsCalculationResult.isHourlyValueChanged());
    assertTrue(actualStatsCalculationResult.isValueChanged());
  }

  /**
   * Test StatsCalculationResult_StatsCalculationResultBuilder {@link
   * StatsCalculationResult.StatsCalculationResultBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#build()}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#hourlyValueChanged(boolean)}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#newHourlyValue(long)}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#newValue(long)}
   *   <li>{@link StatsCalculationResult.StatsCalculationResultBuilder#valueChanged(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test StatsCalculationResult_StatsCalculationResultBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StatsCalculationResult.StatsCalculationResultBuilder.<init>()",
    "StatsCalculationResult StatsCalculationResult.StatsCalculationResultBuilder.build()",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.hourlyValueChanged(boolean)",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.newHourlyValue(long)",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.newValue(long)",
    "String StatsCalculationResult.StatsCalculationResultBuilder.toString()",
    "StatsCalculationResult.StatsCalculationResultBuilder StatsCalculationResult.StatsCalculationResultBuilder.valueChanged(boolean)"
  })
  void testStatsCalculationResult_StatsCalculationResultBuilderBuild() {
    // Arrange and Act
    StatsCalculationResult actualStatsCalculationResult =
        StatsCalculationResult.builder()
            .hourlyValueChanged(true)
            .newHourlyValue(42L)
            .newValue(42L)
            .valueChanged(true)
            .build();

    // Assert
    assertEquals(42L, actualStatsCalculationResult.getNewHourlyValue());
    assertEquals(42L, actualStatsCalculationResult.getNewValue());
    assertTrue(actualStatsCalculationResult.isHourlyValueChanged());
    assertTrue(actualStatsCalculationResult.isValueChanged());
  }
}
