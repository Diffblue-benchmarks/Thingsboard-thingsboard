package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.Aggregation;

class AggKeyDiffblueTest {
  /**
   * Test {@link AggKey#equals(Object)}, and {@link AggKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggKey#equals(Object)}
   *   <li>{@link AggKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertEquals(aggKey, aggKey2);
    int expectedHashCodeResult = aggKey.hashCode();
    assertEquals(expectedHashCodeResult, aggKey2.hashCode());
  }

  /**
   * Test {@link AggKey#equals(Object)}, and {@link AggKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggKey#equals(Object)}
   *   <li>{@link AggKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(null);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(null);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertEquals(aggKey, aggKey2);
    int expectedHashCodeResult = aggKey.hashCode();
    assertEquals(expectedHashCodeResult, aggKey2.hashCode());
  }

  /**
   * Test {@link AggKey#equals(Object)}, and {@link AggKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggKey#equals(Object)}
   *   <li>{@link AggKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey(null);
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey(null);
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertEquals(aggKey, aggKey2);
    int expectedHashCodeResult = aggKey.hashCode();
    assertEquals(expectedHashCodeResult, aggKey2.hashCode());
  }

  /**
   * Test {@link AggKey#equals(Object)}, and {@link AggKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggKey#equals(Object)}
   *   <li>{@link AggKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(null);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(null);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertEquals(aggKey, aggKey2);
    int expectedHashCodeResult = aggKey.hashCode();
    assertEquals(expectedHashCodeResult, aggKey2.hashCode());
  }

  /**
   * Test {@link AggKey#equals(Object)}, and {@link AggKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AggKey#equals(Object)}
   *   <li>{@link AggKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    // Act and Assert
    assertEquals(aggKey, aggKey);
    int expectedHashCodeResult = aggKey.hashCode();
    assertEquals(expectedHashCodeResult, aggKey.hashCode());
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(null);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MAX);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(2);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey(null);
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("org.thingsboard.server.service.ws.telemetry.cmd.v2.AggKey");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(3L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(null);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(3L);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(null);
    aggKey.setPreviousValueOnly(true);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(false);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(null);

    AggKey aggKey2 = new AggKey();
    aggKey2.setAgg(Aggregation.MIN);
    aggKey2.setId(1);
    aggKey2.setKey("Key");
    aggKey2.setPreviousEndTs(1L);
    aggKey2.setPreviousStartTs(1L);
    aggKey2.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, aggKey2);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, null);
  }

  /**
   * Test {@link AggKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AggKey.equals(Object)", "int AggKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AggKey aggKey = new AggKey();
    aggKey.setAgg(Aggregation.MIN);
    aggKey.setId(1);
    aggKey.setKey("Key");
    aggKey.setPreviousEndTs(1L);
    aggKey.setPreviousStartTs(1L);
    aggKey.setPreviousValueOnly(true);

    // Act and Assert
    assertNotEquals(aggKey, "Different type to AggKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AggKey}
   *   <li>{@link AggKey#setAgg(Aggregation)}
   *   <li>{@link AggKey#setId(int)}
   *   <li>{@link AggKey#setKey(String)}
   *   <li>{@link AggKey#setPreviousEndTs(Long)}
   *   <li>{@link AggKey#setPreviousStartTs(Long)}
   *   <li>{@link AggKey#setPreviousValueOnly(Boolean)}
   *   <li>{@link AggKey#toString()}
   *   <li>{@link AggKey#getAgg()}
   *   <li>{@link AggKey#getId()}
   *   <li>{@link AggKey#getKey()}
   *   <li>{@link AggKey#getPreviousEndTs()}
   *   <li>{@link AggKey#getPreviousStartTs()}
   *   <li>{@link AggKey#getPreviousValueOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AggKey.<init>()", "Aggregation AggKey.getAgg()", "int AggKey.getId()",
      "String AggKey.getKey()", "Long AggKey.getPreviousEndTs()", "Long AggKey.getPreviousStartTs()",
      "Boolean AggKey.getPreviousValueOnly()", "void AggKey.setAgg(Aggregation)", "void AggKey.setId(int)",
      "void AggKey.setKey(String)", "void AggKey.setPreviousEndTs(Long)", "void AggKey.setPreviousStartTs(Long)",
      "void AggKey.setPreviousValueOnly(Boolean)", "String AggKey.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AggKey actualAggKey = new AggKey();
    actualAggKey.setAgg(Aggregation.MIN);
    actualAggKey.setId(1);
    actualAggKey.setKey("Key");
    actualAggKey.setPreviousEndTs(1L);
    actualAggKey.setPreviousStartTs(1L);
    actualAggKey.setPreviousValueOnly(true);
    String actualToStringResult = actualAggKey.toString();
    Aggregation actualAgg = actualAggKey.getAgg();
    int actualId = actualAggKey.getId();
    String actualKey = actualAggKey.getKey();
    Long actualPreviousEndTs = actualAggKey.getPreviousEndTs();
    Long actualPreviousStartTs = actualAggKey.getPreviousStartTs();
    Boolean actualPreviousValueOnly = actualAggKey.getPreviousValueOnly();

    // Assert
    assertEquals("AggKey(id=1, key=Key, agg=MIN, previousStartTs=1, previousEndTs=1, previousValueOnly=true)",
        actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(1, actualId);
    assertEquals(1L, actualPreviousEndTs.longValue());
    assertEquals(1L, actualPreviousStartTs.longValue());
    assertEquals(Aggregation.MIN, actualAgg);
    assertTrue(actualPreviousValueOnly);
  }
}
